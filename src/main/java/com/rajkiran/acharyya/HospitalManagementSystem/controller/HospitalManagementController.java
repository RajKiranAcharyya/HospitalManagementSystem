package com.rajkiran.acharyya.HospitalManagementSystem.controller;

import com.rajkiran.acharyya.HospitalManagementSystem.dto.*;
import com.rajkiran.acharyya.HospitalManagementSystem.service.AppointmentService;
import com.rajkiran.acharyya.HospitalManagementSystem.service.DoctorService;
import com.rajkiran.acharyya.HospitalManagementSystem.service.InsuranceService;
import com.rajkiran.acharyya.HospitalManagementSystem.service.PatientService;
import lombok.RequiredArgsConstructor;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class HospitalManagementController {

    private final AppointmentService appointmentService;
    private final DoctorService doctorService;
    private final InsuranceService insuranceService;
    private final PatientService patientService;

    @GetMapping("/")
    public ResponseEntity<String> hello() {
        return ResponseEntity.status(HttpStatus.OK).body("Welcome To Raj's Hospital Management System");
    }
    @PostMapping("/doctors/add")
    public ResponseEntity<DoctorDTO> addADoctor(@RequestBody @Valid DoctorRequestDTO doctorRequestDTO) {
        DoctorDTO newDoctorDTO = doctorService.addDoctor(doctorRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newDoctorDTO);
    }

    @PostMapping("/patients/add")
    public ResponseEntity<PatientDTO> addAPatient(@RequestBody @Valid PatientRequestDTO patientRequestDTO) {
        PatientDTO newPatientDTO = patientService.addAPatient(patientRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newPatientDTO);
    }

    @PostMapping("/appointments/addappointments")
    public ResponseEntity<AppointmentDTO> addAPatient(@RequestBody @Valid AppointmentRequestDTO appointmentRequestDTO) {
        AppointmentDTO newAppointmentDTO = appointmentService.CreateAppoinmentsPOSTMAN(appointmentRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(newAppointmentDTO);
    }

    @GetMapping("/appointments/allappointments")
    public ResponseEntity<List<AppointmentDTO>> showAllAppointments() {
        List<AppointmentDTO> allAppointmentDTOs = appointmentService.allAppointmentDTOs();
        return ResponseEntity.status(HttpStatus.OK).body(allAppointmentDTOs);
    }

    @GetMapping("/patients/{id}")
    public ResponseEntity<PatientDTO> watchThePatient(@PathVariable Integer id) {
        PatientDTO patientDTO = patientService.getpatientbyid_POSTMAN(id);
        return ResponseEntity.status(HttpStatus.OK).body(patientDTO);
    }
}