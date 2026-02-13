package com.rajkiran.acharyya.HospitalManagementSystem.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private int age;

    private String name,disease,email,gender,bloodGroup;

    private LocalDate birthDate;

    @OneToOne(cascade = {CascadeType.ALL}, orphanRemoval = true)    //owning side
    @ToString.Exclude
    private Insurance insurance;

    @OneToMany(mappedBy = "patient",cascade = {CascadeType.ALL},orphanRemoval = true,fetch=FetchType.EAGER)
    @ToString.Exclude
    private List<Appointment> appointments=new ArrayList<>();
}