package com.rajkiran.acharyya.HospitalManagementSystem.dto;


import com.rajkiran.acharyya.HospitalManagementSystem.service.PatientService;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@ToString
@Builder
public class PatientDTO {
    private Integer id;
    private int age;
    private String name,disease,email,gender,bloodGroup;
    private LocalDate birthDate;
}