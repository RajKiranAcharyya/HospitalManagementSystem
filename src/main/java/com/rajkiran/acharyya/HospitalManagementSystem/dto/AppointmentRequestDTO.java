package com.rajkiran.acharyya.HospitalManagementSystem.dto;

import com.rajkiran.acharyya.HospitalManagementSystem.entity.Doctor;
import com.rajkiran.acharyya.HospitalManagementSystem.entity.Patient;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
public class AppointmentRequestDTO {

    private LocalDateTime appointmentTime;

    private String reason;

    private String status;

    private Integer patientId;

    private Long doctorId;
}