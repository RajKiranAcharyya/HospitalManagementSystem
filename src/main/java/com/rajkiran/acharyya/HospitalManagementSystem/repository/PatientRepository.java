package com.rajkiran.acharyya.HospitalManagementSystem.repository;

import com.rajkiran.acharyya.HospitalManagementSystem.entity.Patient;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Repository
public interface PatientRepository extends JpaRepository<Patient,Integer> {
    Patient findByName(String name);
    Patient findByDiseaseAndAge(String disease, int age);
    List<Patient> findByNameContaining(String query);
    List<Patient> findByBirthDateOrderByIdDesc(LocalDate birthDate);
    List<Patient> findByGender(String gender);  //By_JPQL

    @Query(value = "SELECT * FROM Patient WHERE gender = ?1",nativeQuery = true)
    List<Patient> findByGender_By_Me(String gender);

    List<Patient> findByBirthDateAfter(LocalDate ld);

    @Query(value = "SELECT blood_group,count(*) from patient group by blood_group",nativeQuery = true)
    List<Object[]> countbybloodgroup();


    @Modifying
    @Transactional
    @Query(
            value = "UPDATE patient SET name = :name WHERE id = :id",
            nativeQuery = true
    )
    int updateName(@Param("id") Integer id,
                   @Param("name") String name);

    @Query(value = "SELECT * FROM Patient ", nativeQuery = true)
    Page<Patient> findAllPatient(Pageable pageable);

    @Query(value = """
    SELECT 
        p.id AS patient_id, 
        p.name AS patient_name, 
        p.age AS patient_age,
        
        a.id AS appointment_id, 
        a.reason AS appointment_reason,
        a.appointment_time,
        
        d.id AS doctor_id, 
        d.name AS doctor_name, 
        d.specialization
    FROM patient p
    LEFT JOIN appointment a ON p.id = a.patient_id
    LEFT JOIN doctor d ON a.doctor_id = d.id
    """, nativeQuery = true)
    List<Map<String, Object>> showAllPatientsRaw();
}