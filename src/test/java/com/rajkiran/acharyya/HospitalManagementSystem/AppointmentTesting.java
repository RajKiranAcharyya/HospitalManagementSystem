package com.rajkiran.acharyya.HospitalManagementSystem;

import com.rajkiran.acharyya.HospitalManagementSystem.entity.Appointment;
import com.rajkiran.acharyya.HospitalManagementSystem.service.AppointmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class AppointmentTesting {
    @Autowired
    private AppointmentService appointmentService;
    @Test
    public void assignAppointment(){
        Appointment appointment1=Appointment.builder()
                .appointmentTime(LocalDateTime.of(2026,03,10,14,20,45))
                .reason("Secret1")
                .build();

        System.out.println(appointmentService.CreateAppoinments(appointment1,2,1L));

        Appointment appointment2=Appointment.builder()
                .appointmentTime(LocalDateTime.of(2026,04,10,15,20,45))
                .reason("Secret2")
                .build();

        System.out.println(appointmentService.CreateAppoinments(appointment2,2,2L));


        System.out.println(appointmentService.CreateAppoinments(Appointment.builder()
                .appointmentTime(LocalDateTime.of(2026,05,10,16,20,45))
                .reason("Secret2")
                .build(),2,3L));
    }

    @Test
    public void reAssignAppointment(){
        System.out.println(appointmentService.AppointmentReassignment(2L,3L));
    }
}