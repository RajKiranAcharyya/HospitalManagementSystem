# 🏥 Hospital Management System

A robust backend application built with **Spring Boot** and **Java** to streamline hospital operations. This system manages patients, doctors, appointments, and insurance records efficiently using a RESTful API architecture.

## 🚀 Features

* **Patient Management**: Register new patients and retrieve patient details by ID.
* **Doctor Management**: Onboard new doctors with their specialization and contact info.
* **Appointment Scheduling**: Book appointments linking patients to doctors.
* **Appointment Tracking**: View all scheduled appointments and their status.
* **Insurance Integration**: Link insurance policies to patient records.
* **Database Integration**: Persistent storage using MySQL with Hibernate/JPA relationships (One-to-One, One-to-Many).

## 🛠️ Tech Stack

* **Language**: Java 21
* **Framework**: Spring Boot 3
* **Build Tool**: Maven
* **Database**: MySQL
* **ORM**: Spring Data JPA (Hibernate)
* **Utilities**: Lombok (for boilerplate code reduction)

## 📂 Project Structure

```text
HospitalManagementSystem
├── .gitignore
├── mvnw
├── mvnw.cmd
├── pom.xml
├── .mvn
│   └── wrapper
│       └── maven-wrapper.properties
└── src
    ├── main
    │   ├── java
    │   │   └── com
    │   │       └── rajkiran
    │   │           └── acharyya
    │   │               └── HospitalManagementSystem
    │   │                   ├── HospitalManagementSystemApplication.java
    │   │                   ├── controller
    │   │                   │   └── HospitalManagementController.java
    │   │                   ├── dto
    │   │                   │   ├── AppointmentDTO.java
    │   │                   │   ├── AppointmentRequestDTO.java
    │   │                   │   ├── DoctorDTO.java
    │   │                   │   ├── DoctorRequestDTO.java
    │   │                   │   ├── PatientDTO.java
    │   │                   │   └── PatientRequestDTO.java
    │   │                   ├── entity
    │   │                   │   ├── Appointment.java
    │   │                   │   ├── Doctor.java
    │   │                   │   ├── Insurance.java
    │   │                   │   └── Patient.java
    │   │                   ├── repository
    │   │                   │   ├── AppointmentRepository.java
    │   │                   │   ├── DoctorRepository.java
    │   │                   │   ├── InsuranceRepository.java
    │   │                   │   └── PatientRepository.java
    │   │                   └── service
    │   │                       ├── AppointmentService.java
    │   │                       ├── DoctorService.java
    │   │                       ├── InsuranceService.java
    │   │                       └── PatientService.java
    │   └── resources
    │       ├── application.properties
    │       ├── data.sql
    │       ├── static
    │       └── templates
    └── test
        └── java
            └── com
                └── rajkiran
                    └── acharyya
                        └── HospitalManagementSystem
                            ├── AppointmentTesting.java
                            ├── HospitalManagementSystemApplicationTests.java
                            ├── InsuranceTesting.java
                            └── PatientTesting.java

