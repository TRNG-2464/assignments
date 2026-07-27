
/* Assignment Four */

drop table if exists Department, Doctor, Patient, Room, Appointment, Prescription;

create table Department (
  department_id int not null,
  department_name varchar(50),
  location varchar(50),
  primary key (department_id)
);

create table Doctor (
  doctor_id int not null,
  department_id int not null, -- Foreign key not optional
  first_name varchar(50),
  last_name varchar(50),
  specialty varchar(50),
  phone varchar(50),

  primary key(doctor_id),

  constraint doctor_fk_department
    foreign key (department_id)
    references Department(department_id)
);

create table Room (
	room_id int not null,
	department_id int not null, -- Foreign key not optional
	room_number varchar(50),
	room_type varchar(50),
	is_available boolean,

	primary key (room_id),

	constraint room_fk_department
		foreign key (department_id)
		references Department(department_id)
);

create table Patient (
	patient_id int not null,
	first_name varchar(50),
	last_name varchar(50),
	date_of_birth varchar(50),
	phone varchar(50),
	address varchar(50),

	primary key (patient_id)
);

create table Appointment (
	appointment_id int not null,
	patient_id int, -- Optional foreign key
	doctor_id int not null, -- Foreign key not optional
	appointment_data date,
	appointment_time time,
	reason varchar(300),
	status varchar(50),

	primary key (appointment_id),
	constraint appointment_fk_patient
		foreign key (patient_id)
		references Patient(patient_id),

	constraint appointment_fk_doctor
		foreign key (doctor_id)
		references Doctor(doctor_id)
);

create table Prescription(
	prescription_id int not null,
	appointment_id int,
	medication_name varchar(50),
	dosage varchar(50),
	instructions varchar(50),

	constraint prescription_fk_appointment
		foreign key (appointment_id)
		references Appointment(appointment_id)
);


