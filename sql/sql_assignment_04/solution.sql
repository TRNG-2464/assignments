-- First create the tables that don't have foreign keys and can stand alone.

CREATE TABLE Patient(patient_id INT PRIMARY KEY, first_name VARCHAR, last_name VARCHAR, date_of_birth DATE, phone VARCHAR, address VARCHAR);
CREATE TABLE Department(department_id INT PRIMARY KEY, department_name VARCHAR, location VARCHAR);

-- Now that we have Department set up, we can create Room and Doctor.
CREATE TABLE Room(room_id INT PRIMARY KEY, department_id INT REFERENCES Department(department_id), room_number VARCHAR, room_type VARCHAR, is_available BOOL);
CREATE TABLE Doctor(doctor_id INT PRIMARY KEY, department_id INT REFERENCES Department(department_id), first_name VARCHAR, last_name VARCHAR, specialty VARCHAR, phone VARCHAR);

-- Appointment depends on Patient and Doctor. Now that we've created them, we can create it as well.
CREATE TABLE Appointment(appointment_id INT PRIMARY KEY, patient_id INT REFERENCES Patient(patient_id), doctor_id INT REFERENCES Doctor(doctor_id), appointment_date DATE, appointment_time TIME, reason VARCHAR, status VARCHAR);

-- Finally we can create Prescription which depends on Appointment.
CREATE TABLE Prescription(prescription_id INT PRIMARY KEY, appointment_id INT REFERENCES Appointment(appointment_id), medication_name VARCHAR, dosage VARCHAR, instructions VARCHAR);