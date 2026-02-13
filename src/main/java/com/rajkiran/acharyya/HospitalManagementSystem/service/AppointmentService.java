package com.rajkiran.acharyya.HospitalManagementSystem.service;

import com.rajkiran.acharyya.HospitalManagementSystem.dto.AppointmentDTO;
import com.rajkiran.acharyya.HospitalManagementSystem.dto.AppointmentRequestDTO;
import com.rajkiran.acharyya.HospitalManagementSystem.dto.DoctorDTO;
import com.rajkiran.acharyya.HospitalManagementSystem.dto.PatientDTO;
import com.rajkiran.acharyya.HospitalManagementSystem.entity.Appointment;
import com.rajkiran.acharyya.HospitalManagementSystem.entity.Doctor;
import com.rajkiran.acharyya.HospitalManagementSystem.entity.Patient;
import com.rajkiran.acharyya.HospitalManagementSystem.repository.AppointmentRepository;
import com.rajkiran.acharyya.HospitalManagementSystem.repository.DoctorRepository;
import com.rajkiran.acharyya.HospitalManagementSystem.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    @Transactional
    public Appointment CreateAppoinments(Appointment appointment,Integer PatientId,Long DoctorId){

        if(appointment.getId() != null){
            throw new RuntimeException("Appoinment Exists...Otherwise there will be no Id");
        }

        Doctor doctor=doctorRepository.findById(DoctorId).orElseThrow(()->new IllegalArgumentException("No doctor found with this Id: "+DoctorId));
        Patient patient= patientRepository.findById(PatientId).orElseThrow(()->new IllegalArgumentException("No Patient matched with this id: "+ PatientId));

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        patient.getAppointments().add(appointment);
        doctor.getAppointments().add(appointment);

        return appointment;
    }

    @Transactional
    public AppointmentDTO CreateAppoinmentsPOSTMAN(AppointmentRequestDTO appointmentRequestDTO){

        Doctor appointedDoctor=doctorRepository.findById(appointmentRequestDTO.getDoctorId()).orElseThrow(()->new IllegalArgumentException("No doctor found with this Id: "+ appointmentRequestDTO.getDoctorId()));
        Patient appoinmentPatient = patientRepository.findById(appointmentRequestDTO.getPatientId()).orElseThrow(()->new IllegalArgumentException("No Patient matched with this id: "+ appointmentRequestDTO.getPatientId()));

        Appointment appointment=Appointment.builder().
                appointmentTime(appointmentRequestDTO.getAppointmentTime())
                .reason(appointmentRequestDTO.getReason())
                .status(appointmentRequestDTO.getStatus())
                .patient(appoinmentPatient)
                .doctor(appointedDoctor).build();


        Appointment savedAppointment=appointmentRepository.save(appointment);

        PatientDTO ptDTO=PatientDTO.builder()
                .id(savedAppointment.getPatient().getId())
                .age(savedAppointment.getPatient().getAge())
                .name(savedAppointment.getPatient().getName())
                .disease(savedAppointment.getPatient().getDisease())
                .email(savedAppointment.getPatient().getEmail())
                .gender(savedAppointment.getPatient().getGender())
                .bloodGroup(savedAppointment.getPatient().getBloodGroup())
                .birthDate(savedAppointment.getPatient().getBirthDate()).build();

        DoctorDTO dtDTO=DoctorDTO.builder()
                .id(appointedDoctor.getId())
                .name(appointedDoctor.getName())
                .specialization(appointedDoctor.getSpecialization())
                .email(appointedDoctor.getEmail()).build();

        return AppointmentDTO.builder().id(savedAppointment.getId())
                .appointmentTime(savedAppointment.getAppointmentTime())
                .reason(savedAppointment.getReason())
                .status(savedAppointment.getStatus())
                .patientDTO(ptDTO)
                .doctorDTO(dtDTO)
                .build();
    }

    @Transactional
    public Appointment AppointmentReassignment(Long appointmentId,Long newDoctorId){

        Appointment appointment1=appointmentRepository.findById(appointmentId).orElseThrow(()->new RuntimeException("Appoinment does not exist...Otherwise there will be no Id"));
        Doctor doctorOld=appointment1.getDoctor();
        Doctor doctorNew=doctorRepository.findById(newDoctorId).orElseThrow(()->new IllegalArgumentException("No doctor found with this Id: "+newDoctorId));

        appointment1.setDoctor(doctorNew);
        doctorOld.getAppointments().remove(appointment1);
        doctorNew.getAppointments().add(appointment1);

        appointmentRepository.save(appointment1);
        doctorRepository.save(doctorNew);
        doctorRepository.save(doctorOld);

        return appointment1;
    }

    public List<AppointmentDTO> allAppointmentDTOs(){
        List<Appointment> allAppointments=appointmentRepository.findAll();
        List<AppointmentDTO> allAppDTOs=new ArrayList<>();
        for(Appointment ap:allAppointments) {
            allAppDTOs.add(AppointmentDTO.builder()
                    .id(ap.getId())
                    .appointmentTime(ap.getAppointmentTime())
                    .reason(ap.getReason())
                    .status(ap.getStatus())
                    .patientDTO(PatientDTO.builder()
                            .id(ap.getPatient().getId())
                            .age(ap.getPatient().getAge())
                            .name(ap.getPatient().getName())
                            .disease(ap.getPatient().getDisease())
                            .email(ap.getPatient().getEmail())
                            .gender(ap.getPatient().getGender())
                            .bloodGroup(ap.getPatient().getBloodGroup())
                            .birthDate(ap.getPatient().getBirthDate())
                            .build())
                    .doctorDTO(DoctorDTO.builder()
                            .id(ap.getDoctor().getId())
                            .name(ap.getDoctor().getName())
                            .specialization(ap.getDoctor().getSpecialization())
                            .email(ap.getDoctor().getEmail())
                            .build())
                    .build());
        }
        return allAppDTOs;
    }
}