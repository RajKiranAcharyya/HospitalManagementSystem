package com.rajkiran.acharyya.HospitalManagementSystem.dto;


import com.rajkiran.acharyya.HospitalManagementSystem.entity.Appointment;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
public class DoctorDTO {
    private Long id;

    private String name;

    private String specialization;

    private String email;
}