package com.rajkiran.acharyya.HospitalManagementSystem.repository;

import com.rajkiran.acharyya.HospitalManagementSystem.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor,Long> {
    Doctor getDoctorById(Long id);
}