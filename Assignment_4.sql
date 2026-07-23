CREATE SCHEMA Hospital_Schema;

CREATE TABLE DEPARTMENT(
	department_id INT PRIMARY KEY,
	department_name varchar(50),
	"location" varchar(50)
);

CREATE TABLE DOCTOR(
	doctor_id INT PRIMARY KEY,
	department_id INT NOT NULL,
	first_name varchar(50) NOT NULL,
	last_name varchar(50) NOT NULL,
	specialty varchar(50),
	phone varchar(50),
	FOREIGN KEY (department_id) REFERENCES DEPARTMENT(department_id)
);

CREATE TABLE PATIENT(
	patient_id INT PRIMARY KEY,
	first_name varchar(50) NOT NULL,
	last_name varchar(50) NOT NULL,
	date_of_birth DATE NOT NULL,
	phone varchar(20),
	address varchar(50)
);

CREATE TABLE APPOINTMENT(
	appointment_id INT PRIMARY KEY,
	patient_id INT NOT NULL,
	doctor_id INT NOT NULL,
	appointment_date DATE NOT NULL,
	appointment_time TIME NOT NULL,
	reason varchar(100),
	status varchar(50),
	FOREIGN KEY (patient_id) REFERENCES PATIENT(patient_id),
	FOREIGN KEY (doctor_id) REFERENCES DOCTOR(doctor_id)
);

CREATE TABLE PRESCRIPTION(
	prescription_id INT PRIMARY KEY,
	appointment_id INT NOT NULL,
	medication_name varchar(50) NOT NULL,
	dosage varchar(50),
	instructions varchar(255),
	FOREIGN KEY (appointment_id) REFERENCES APPOINTMENT(appointment_id)
);

CREATE TABLE ROOM(
	room_id int PRIMARY KEY,
	department_id INT NOT NULL,
	room_number varchar(255) NOT NULL,
	room_type varchar(255) NOT NULL,
	is_available boolean NOT NULL DEFAULT TRUE,
	FOREIGN KEY (department_id) REFERENCES DEPARTMENT(department_id)
);