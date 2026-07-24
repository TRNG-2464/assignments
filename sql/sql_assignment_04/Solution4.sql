--Anmoldeep Sandhu (Solution 4)

--Table Department
CREATE TABLE Department (
	department_id INT PRIMARY KEY,
	department_name VARCHAR(100),
	location VARCHAR(100)
);

--Table Doctor
CREATE Table Doctor (
	doctor_id INT PRIMARY KEY,
	department_id INT REFERENCES Department(department_id),
	first_name VARCHAR(100),
	last_name VARCHAR(100),
	specialty VARCHAR(100),
	phone VARCHAR(100)
);

--Table Room
CREATE Table Room (
	room_id INT PRIMARY KEY,
	department_id INT REFERENCES Department(department_id),
	room_number VARCHAR(100),
	room_type VARCHAR(100),
	is_available BOOLEAN
);

-- Table Patient 
CREATE Table Patient (
	patient_id INT PRIMARY KEY,
	first_name VARCHAR(100),
	last_name VARCHAR(100),
	date_of_birth DATE,
	phone VARCHAR(100),
	address VARCHAR(100)
);


-- Table Appointment
CREATE Table Appointment (
	appointment_id INT PRIMARY KEY,
	patient_id INT REFERENCES Patient(patient_id),
	doctor_id INT REFERENCES Doctor(doctor_id),
	appointment_date DATE,
	appointment_time TIME,
	reason VARCHAR(100),
	status VARCHAR(100)
);



-- Table Prescription
CREATE Table Prescription (
	prescription_id INT PRIMARY KEY,
	appointment_id INT REFERENCES Appointment(appointment_id),
	medication_name VARCHAR(100),
	dosage VARCHAR(100),
	instructions VARCHAR(100)
);
