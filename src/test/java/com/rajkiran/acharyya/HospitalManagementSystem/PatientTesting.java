package com.rajkiran.acharyya.HospitalManagementSystem;
import com.rajkiran.acharyya.HospitalManagementSystem.entity.Patient;
import com.rajkiran.acharyya.HospitalManagementSystem.repository.PatientRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;


@SpringBootTest
public class PatientTesting {

    @Autowired
    private PatientRepository patientRepository;

    @Test
    void addPatient() {
        Patient patient = Patient.builder()
                .age(25)
                .name("Unknown Testing Patient")
                .disease("Unknown")
                .email("unknown1@unknown.com")
                .gender("Male")
                .bloodGroup("AB-Positive")
                .birthDate(LocalDate.of(2020, 05, 07))
                .insurance(null)
                .build();

        patientRepository.save(patient);
    }

    @Test
    void removePatient() {
        patientRepository.deleteById(4);
    }

    @Test
    void showallpatient(){
        System.out.println(patientRepository.showAllPatientsRaw());
    }
}