package com.rajkiran.acharyya.HospitalManagementSystem.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DoctorRequestDTO {
    private String name;
    private String specialization;
    private String email;
}