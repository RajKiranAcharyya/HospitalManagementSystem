package com.rajkiran.acharyya.HospitalManagementSystem.service;


import com.rajkiran.acharyya.HospitalManagementSystem.dto.PatientDTO;
import com.rajkiran.acharyya.HospitalManagementSystem.dto.PatientRequestDTO;
import com.rajkiran.acharyya.HospitalManagementSystem.entity.Patient;
import com.rajkiran.acharyya.HospitalManagementSystem.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;
    public Patient getpatientbyid(int id){
        Patient p1=patientRepository.findById(id).orElseThrow(()-> new RuntimeException("No data found"));
        Patient p2=patientRepository.findById(id).orElseThrow();
        return p1;
    }

    public PatientDTO getpatientbyid_POSTMAN(Integer patientid){
        Patient p1=patientRepository.findById(patientid).orElseThrow(()-> new RuntimeException("No data found"));
        return PatientDTO.builder()
                .id(p1.getId())
                .age(p1.getAge())
                .name(p1.getName())
                .disease(p1.getDisease())
                .email(p1.getEmail())
                .gender(p1.getGender())
                .bloodGroup(p1.getBloodGroup())
                .birthDate(p1.getBirthDate())
                .build();
    }

    public PatientDTO addAPatient(PatientRequestDTO patientRequestDTO){
        Patient patient=Patient.builder()
                .age(patientRequestDTO.getAge())
                .name(patientRequestDTO.getName())
                .disease(patientRequestDTO.getDisease())
                .email(patientRequestDTO.getEmail())
                .gender(patientRequestDTO.getGender())
                .bloodGroup(patientRequestDTO.getBloodGroup())
                .birthDate(patientRequestDTO.getBirthDate())
                .build();

        Patient newPatient=patientRepository.save(patient);

        return PatientDTO.builder().id(newPatient.getId())
                .age(newPatient.getAge())
                .name(newPatient.getName())
                .disease(newPatient.getDisease())
                .email(newPatient.getEmail())
                .gender(newPatient.getGender())
                .bloodGroup(newPatient.getBloodGroup())
                .birthDate(newPatient.getBirthDate()).build();
    }
}