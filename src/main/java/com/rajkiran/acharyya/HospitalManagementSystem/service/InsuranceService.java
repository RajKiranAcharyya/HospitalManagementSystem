package com.rajkiran.acharyya.HospitalManagementSystem.service;
import com.rajkiran.acharyya.HospitalManagementSystem.entity.Insurance;
import com.rajkiran.acharyya.HospitalManagementSystem.entity.Patient;
import com.rajkiran.acharyya.HospitalManagementSystem.repository.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {
    private final InsuranceRepository insurancerepository;
    private final PatientRepository patientrepository;

    @Transactional
    public Patient InsuranceAssignment(Insurance insurance,Integer patientId){
        Patient patient= patientrepository.findById(patientId).orElseThrow(()->new IllegalArgumentException("No Patient matched with this id: "+patientId));

        patient.setInsurance(insurance);
        insurance.setPatient(patient);

        patientrepository.save(patient);
        return patient;
    }

    @Transactional
    public Patient disassociateInsuranceFromPatient(Integer patientId){
        Patient patient= patientrepository.findById(patientId).orElseThrow(()->new IllegalArgumentException("No Patient matched with this id: "+patientId));
        System.out.println("Before Removal: "+patient);
        patient.setInsurance(null);
        patientrepository.save(patient);
        System.out.println("After Removal: ");
        return patient;
    }
}