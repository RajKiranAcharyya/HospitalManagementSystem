# 🏥 Hospital Management System

A robust backend application built with **Spring Boot** and **Java** to streamline hospital operations. This system manages patients, doctors, appointments, and insurance records efficiently using a RESTful API architecture.

## 🚀 Features

* **Patient Management**: Register new patients and retrieve patient details by ID.
* **Doctor Management**: Onboard new doctors with their specialization and contact info.
* **Appointment Scheduling**: Book appointments linking patients to doctors.
* **Appointment Tracking**: View all scheduled appointments and their status.
* **Insurance Integration**: Link insurance policies to patient records.
* **Database Integration**: Persistent storage using MySQL with Hibernate/JPA relationships (One-to-One, One-to-Many).


## 🚀 Info
* **Patients**: Add 'em, track 'em, manage 'em.
* **Doctors**: Onboard specialists and keep their info handy.
* **Appointments**: Schedule visits and link patients to docs.
* **Insurance**: Attach policies to patient records (One-to-One mapping).
* **Data Seeding**: Comes with pre-loaded dummy data (`data.sql`) so you can test immediately.
* **Database**: All data is safe and sound in MySQL.

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

```

---

## ⚙️ Let's Get It Running

### Prerequisites
Before you start, make sure you have these installed:
* **JDK 21**
* **Maven**
* **MySQL Server** (Up and running!)

### 1. Clone the Repo
Grab the code and jump into the folder:
```bash
git clone [https://github.com/RajKiranAcharyya/HospitalManagementSystem.git](https://github.com/RajKiranAcharyya/HospitalManagementSystem.git)
cd HospitalManagementSystem
```

### 2. Config the Database 🗄️
Open up src/main/resources/application.properties.
Update the MySQL settings to match your local setup. By default, it looks for a database named hospitaldb.
```bash
spring.datasource.url=jdbc:mysql://localhost:3306/hospitaldb
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD
```
Note: The app will automatically update the table schema for you (ddl-auto=update).


### 3. Fire It Up 🔥
Run this command to start the server:
```bash
./mvnw spring-boot:run
```
Once it started, the Base URL is:
```bash
http://localhost:8080/hospitalmanagementsystembyraj
```

## 🔌 API Endpoints & Payloads

Here are the routes you can hit. Since we use a custom context path, make sure you include it.

---

### 1. Check Server Status

@GetMapping("/")

Response
```
Welcome To Raj's Hospital Management System
```

---

### 2. Add a Doctor

@PostMapping("/doctors/add")

Request Body (JSON)
```json
{
  "name": "Dr. Strange",
  "specialization": "Neurology",
  "email": "strange@marvel.com"
}
```

---

### 3. Add a Patient

@PostMapping("/patients/add")

Request Body (JSON)
```json
{
  "name": "Tony Stark",
  "age": 45,
  "disease": "Heart Shrapnel",
  "email": "tony@stark.com",
  "gender": "Male",
  "bloodGroup": "A+",
  "birthDate": "1970-05-29"
}
```

---

### 4. Book an Appointment

@PostMapping("/appointments/addappointments")

Request Body (JSON)
```json
{
  "appointmentTime": "2026-03-10T14:30:00",
  "reason": "Chest Pain",
  "status": "Scheduled",
  "patientId": 1,
  "doctorId": 1
}
```

---

### 5. View Information

@GetMapping("/appointments/allappointments")

@GetMapping("/patients/{id}")

---

## 🧪 Testing

JUnit tests are located in src/test/java

AppointmentTesting.java  
InsuranceTesting.java  
PatientTesting.java  

Run tests
```bash
./mvnw test
```

---

## 👤 Author

Raj Kiran Acharyya  
GitHub: RajKiranAcharyya
