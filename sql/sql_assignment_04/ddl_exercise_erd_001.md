# Exercise — Hospital Schema

Given the following ERD, provide SQL statements that will create each of the six tables depicted. Ensure that all primary key and foreign key relationships shown in the diagram are reflected in your table definitions.

![Hospital ERD](ddl_exercise_erd_001_hospital_erd.png)

**Tables to create:** Department, Doctor, Patient, Appointment, Prescription, Room

**ERD Relationship Summary**

| Relationship | Type |
|-|-|
| Department → Doctor | One-to-many |
| Department → Room | One-to-many |
| Doctor → Appointment | One-to-many |
| Patient → Appointment | One-to-many |
| Appointment → Prescription | One-to-many |

**Column Reference**

Department
| column | type |
|-|-|
| department_id | int |
| department_name | varchar |
| location | varchar |

Doctor
| column | type |
|-|-|
| doctor_id | int |
| department_id | int (FK → Department) |
| first_name | varchar |
| last_name | varchar |
| specialty | varchar |
| phone | varchar |

Patient
| column | type |
|-|-|
| patient_id | int |
| first_name | varchar |
| last_name | varchar |
| date_of_birth | date |
| phone | varchar |
| address | varchar |

Appointment
| column | type |
|-|-|
| appointment_id | int |
| patient_id | int (FK → Patient) |
| doctor_id | int (FK → Doctor) |
| appointment_date | date |
| appointment_time | time |
| reason | varchar |
| status | varchar |

Prescription
| column | type |
|-|-|
| prescription_id | int |
| appointment_id | int (FK → Appointment) |
| medication_name | varchar |
| dosage | varchar |
| instructions | varchar |

Room
| column | type |
|-|-|
| room_id | int |
| department_id | int (FK → Department) |
| room_number | varchar |
| room_type | varchar |
| is_available | boolean |


CREATE TABLE Department (
    department_id   INT PRIMARY KEY,
    department_name VARCHAR(100) NOT NULL,
    location        VARCHAR(100)
);

CREATE TABLE Doctor (
    doctor_id       INT PRIMARY KEY,
    department_id   INT,
    first_name      VARCHAR(50) NOT NULL,
    last_name       VARCHAR(50) NOT NULL,
    specialty       VARCHAR(100),
    phone           VARCHAR(20),
    CONSTRAINT fk_doctor_department
        FOREIGN KEY (department_id) REFERENCES Department(department_id)
);

CREATE TABLE Patient (
    patient_id      INT PRIMARY KEY,
    first_name      VARCHAR(50) NOT NULL,
    last_name       VARCHAR(50) NOT NULL,
    date_of_birth   DATE,
    phone           VARCHAR(20),
    address         VARCHAR(200)
);

CREATE TABLE Appointment (
    appointment_id    INT PRIMARY KEY,
    patient_id        INT,
    doctor_id         INT,
    appointment_date  DATE,
    appointment_time  TIME,
    reason            VARCHAR(200),
    status            VARCHAR(20),
    CONSTRAINT fk_appointment_patient
        FOREIGN KEY (patient_id) REFERENCES Patient(patient_id),
    CONSTRAINT fk_appointment_doctor
        FOREIGN KEY (doctor_id) REFERENCES Doctor(doctor_id)
);

CREATE TABLE Prescription (
    prescription_id  INT PRIMARY KEY,
    appointment_id   INT,
    medication_name  VARCHAR(100) NOT NULL,
    dosage           VARCHAR(50),
    instructions     VARCHAR(200),
    CONSTRAINT fk_prescription_appointment
        FOREIGN KEY (appointment_id) REFERENCES Appointment(appointment_id)
);

CREATE TABLE Room (
    room_id        INT PRIMARY KEY,
    department_id  INT,
    room_number    VARCHAR(10),
    room_type      VARCHAR(50),
    is_available   BOOLEAN,
    CONSTRAINT fk_room_department
        FOREIGN KEY (department_id) REFERENCES Department(department_id)
);

with the help of Datagrip