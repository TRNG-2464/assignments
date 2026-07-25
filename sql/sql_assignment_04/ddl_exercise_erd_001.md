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


================== Soluation4 ===============

CREATE TABLE Department (
department_id  INT  PRIMARY KEY,
department_name varchar(100) NOT NULL,
location varchar (100)
);

CREATE TABLE Doctor (
doctor_id INT PRIMARY KEY,
department_id  INT NOT NULL,

first_name varchar(50),
last_name varchar(50) NOT NULL,
specialty varchar(100) NOT NULL,
phone varchar(10),
FOREIGN KEY (department_id)
 REFERENCES Department(department_id)
 
);

CREATE TABLE Patient ( 
patient_id INT PRIMARY KEY,
first_name varchar(50) NOT NULL,
last_name varchar(50) NOT NULL,
date_of_birth date NOT NULL,
phone varchar(20),
address varchar(200)
);
CREATE TABLE Appointment (
appointment_id INT PRIMARY KEY,
patient_id  INT NOT NULL,
doctor_id INT NOT NULL,
appointment_date date NOT NULL,
appointment_time time NOT NULL,
reason varchar(200),
status varchar(50),
FOREIGN KEY(patient_id)
 REFERENCES Patient(patient_id),
 
FOREIGN KEY (doctor_id) 
REFERENCES  Doctor(doctor_id)

);
CREATE TABLE ROOM (
room_id INT PRIMARY KEY,
department_id INT,
room_number varchar(50),
room_type varchar(50),
is_available boolean ,
FOREIGN KEY (department_id) 
REFERENCES Department(department_id)
);
CREATE TABLE  Prescription(
 prescription_id INT PRIMARY KEY,
 appointment_id INT NOT NULL,
 medication_name varchar(50),
 dosage          varchar(50),
 instructions    varchar(100),
 FOREIGN KEY (appointment_id) 
 REFERENCES Appointment(appointment_id)
);