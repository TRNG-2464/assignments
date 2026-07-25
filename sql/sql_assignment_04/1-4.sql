CREATE TABLE IF NOT EXISTS Department (
	department_id INTEGER PRIMARY KEY,
	department_name VARCHAR(50),
	location VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS Doctor (
	doctor_id integer PRIMARY KEY,
	department_id integer REFERENCES Department(department_id),
	first_name varchar(50),
	last_name varchar(50),
	specialty varchar(50),
	phone varchar(50)
);

CREATE TABLE IF NOT EXISTS Patient (
	patient_id integer PRIMARY KEY,
	first_name varchar(50),
	last_name varchar(50),
	date_of_birth date,
	phone varchar(50),
	address varchar(50)
);

CREATE TABLE IF NOT EXISTS Appointment (
	appointment_id integer PRIMARY KEY,
	patient_id integer REFERENCES Patient(patient_id),
	doctor_id integer REFERENCES Doctor(doctor_id),
	appointment_date date,
	appointment_time time,
	reason varchar(200),
	status varchar(50)
);

CREATE TABLE IF NOT EXISTS Prescription (
	prescription_id integer PRIMARY KEY,
	appointment_id integer REFERENCES Appointment(appointment_id),
	medication_name varchar(50),
	dosage varchar(50),
	instructions varchar(200)
);

CREATE TABLE IF NOT EXISTS Room (
	room_id integer PRIMARY KEY,
	department_id integer REFERENCES Department(department_id),
	room_number varchar(50),
	room_type varchar(50),
	is_available boolean
);