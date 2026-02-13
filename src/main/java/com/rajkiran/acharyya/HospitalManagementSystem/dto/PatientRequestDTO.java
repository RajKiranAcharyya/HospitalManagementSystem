package com.rajkiran.acharyya.HospitalManagementSystem.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class PatientRequestDTO {
    private int age;
    private String name,disease,email,gender,bloodGroup;
    private LocalDate birthDate;
}