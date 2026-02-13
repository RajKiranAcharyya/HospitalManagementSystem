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
src/main/java/com/rajkiran/acharyya/HospitalManagementSystem/
├── controller/    # REST Controllers (API Endpoints)
├── dto/           # Data Transfer Objects (Request/Response models)
├── entity/        # JPA Entities (Database Tables)
├── repository/    # Data Access Layer (Interfaces)
└── service/       # Business Logic
