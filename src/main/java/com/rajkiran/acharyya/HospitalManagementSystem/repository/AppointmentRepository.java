package com.rajkiran.acharyya.HospitalManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rajkiran.acharyya.HospitalManagementSystem.entity.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Long> {

}