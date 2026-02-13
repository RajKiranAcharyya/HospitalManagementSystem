package com.rajkiran.acharyya.HospitalManagementSystem.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
@Builder
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(length = 100)
    private String specialization;

    @Column(unique = true, length = 100)
    private String email;

    @OneToMany(mappedBy = "doctor",fetch = FetchType.EAGER)
    @ToString.Exclude
    private List<Appointment> appointments=new ArrayList<>();
}