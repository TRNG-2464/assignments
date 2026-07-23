/* Solutions to the sql assignments */

  /* Exercise One */

drop table if exists Writer, Books, Author;

create table Writer (
  writer_id int not null,
  writer_name varchar(50)
);

create table Books (
  book_id int generated always as identity,
  title varchar(50),
  author int,
  publication int,
  page_count int
);


  /* Exercise Two */

alter table Books rename column book_id to isbn_13;

  /* Exercise Three */

alter table Writer rename to Author;

alter table Author rename column writer_id to author_id;

alter table Author rename column writer_name to author_name;


/* Exercise Four */

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



/* Exercise Five */

drop table if exists Principals, Schools, Students;

create table Principals (
	name varchar(50) primary key,
	hire_date date,
	salary int
);

create table Schools (
	name varchar(50) primary key,
	principal varchar(50) not null,
	
	constraint schools_fk_principal
		foreign key(principal)
		references Principals(name)
);


create table Students (
	name varchar(50) primary key,
	grade_level varchar(5),
	home_address varchar(50),
	emergency_contact_phone_number varchar(50),
	school varchar(50) not null,
	
	constraint students_fk_school
		foreign key(school)
		references Schools(name)
);



/* Exercise Six */
insert into author (author_id, author_name) values (1006,'Cormac McCarthy');

/* Exercise Seven */

insert into books (
	title,
	author, 
	publication,
	page_count) 
values 	(
	'1984',
	(select author_id 
	from author 
	where author_name = 'George Orwell'),
	1949,
	325
);






