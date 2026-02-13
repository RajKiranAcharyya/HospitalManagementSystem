package com.rajkiran.acharyya.HospitalManagementSystem.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
public class AppointmentDTO{
    private Long id;
    private LocalDateTime appointmentTime;
    private String reason;
    private String status;

    private PatientDTO patientDTO;
    private DoctorDTO doctorDTO;
}