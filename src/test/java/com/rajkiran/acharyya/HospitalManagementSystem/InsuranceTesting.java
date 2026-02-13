package com.rajkiran.acharyya.HospitalManagementSystem;
import com.rajkiran.acharyya.HospitalManagementSystem.entity.Insurance;
import com.rajkiran.acharyya.HospitalManagementSystem.entity.Patient;
import com.rajkiran.acharyya.HospitalManagementSystem.service.InsuranceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class InsuranceTesting {

    @Autowired
    private InsuranceService insuranceService;

    @Test
    public void AssignInsurance(){
        Insurance insurance=Insurance.builder()
                .policyNumber("HDFC-1234")
                .provider("HDFC")
                .validUntil(LocalDate.of(2026,02,20))
                .build();

        Patient patient=insuranceService.InsuranceAssignment(insurance,1);
        System.out.println(patient);
    }

    @Test
    public void DessignInsurance(){
        Patient patient=insuranceService.disassociateInsuranceFromPatient(1);
        System.out.println(patient);
    }
}