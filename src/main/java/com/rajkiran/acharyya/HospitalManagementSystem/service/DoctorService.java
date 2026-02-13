package com.rajkiran.acharyya.HospitalManagementSystem.service;

import com.rajkiran.acharyya.HospitalManagementSystem.dto.DoctorDTO;
import com.rajkiran.acharyya.HospitalManagementSystem.dto.DoctorRequestDTO;
import com.rajkiran.acharyya.HospitalManagementSystem.entity.Doctor;
import com.rajkiran.acharyya.HospitalManagementSystem.repository.DoctorRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@Service
@RequiredArgsConstructor
public class DoctorService {
    private final DoctorRepository doctorRepository;

    @Transactional
    public DoctorDTO addDoctor(DoctorRequestDTO doctorRequestDTO){
        Doctor newDoctor=Doctor.builder()
                .name(doctorRequestDTO.getName())
                .specialization(doctorRequestDTO.getSpecialization())
                .email(doctorRequestDTO.getEmail())
                .build();

        Doctor savedDoctor=doctorRepository.save(newDoctor);

        return DoctorDTO.builder().id(savedDoctor.getId())
                .name(savedDoctor.getName())
                .specialization(savedDoctor.getSpecialization())
                .email(savedDoctor.getEmail()).build();
    }
}
