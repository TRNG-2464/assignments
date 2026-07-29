-- 1. Department
CREATE TABLE Department(
	department_id INTEGER PRIMARY KEY,
	department_name VARCHAR(255),
	location VARCHAR(255)
);

-- 2. Doctor
CREATE TABLE Doctor(
	doctor_id INTEGER PRIMARY KEY,
	department_id INTEGER REFERENCES Department(department_id),
	first_name VARCHAR(255),
	last_name VARCHAR(255),
	specialty VARCHAR(255),
	phone VARCHAR(255)
);

-- 3. Patient
CREATE TABLE Patient(
	patient_id INTEGER PRIMARY KEY,
	first_name VARCHAR(255),
	last_name VARCHAR(255),
	date_of_birth DATE,
	phone VARCHAR(255),
	address VARCHAR(255)
);

-- 4. Appointment
CREATE TABLE Appointment(
	appointment_id INTEGER PRIMARY KEY,
	patient_id INTEGER REFERENCES Patient(patient_id),
	doctor_id INTEGER REFERENCES Doctor(doctor_id),
	appointment_date DATE,
	appointment_time TIME,
	reason VARCHAR(255),
	status VARCHAR(255)
);

-- 5. Prescription
CREATE TABLE Prescription(
	prescription_id INTEGER PRIMARY KEY,
	appointment_id INTEGER REFERENCES Appointment(appointment_id),
	medication_name VARCHAR(255),
	dosage VARCHAR(255),
	instructions VARCHAR(255)
);

-- 6. Room
CREATE TABLE Room(
	room_id INTEGER PRIMARY KEY,
	department_id INTEGER REFERENCES Department(department_id),
	room_number VARCHAR(255),
	room_type VARCHAR(255),
	is_available BOOL
);
