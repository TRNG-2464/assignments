/* Solutions to the sql assignments */

  /* Assignment One */

drop table if exists Writer, Books, Author;

create table Writer (
  writer_id int not null,
  writer_name varchar(50)
);

create table Books (
  book_id int,
  title varchar(50),
  author int,
  publication int,
  page_count int
);


  /* Assignment Two */

alter table Books rename column book_id to isbn_13;

  /* Assignment Three */

alter table Writer rename to Author;

alter table Author rename column writer_id to author_id;

alter table Author rename column writer_name to author_name;


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



/* Assignment Five */

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



/* Assignment Six */
insert into author (author_id, author_name) values (1006,'Cormac McCarthy');

/* Assignment Seven */

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


/* Assignment Eight */

delete from books where author = (select author_id from author where author_name = 'Mark Twain');


/* Assignment Nine */

update Books set page_count = 220 where title = 'Slaughterhouse-Five';

/* Assignment Ten */

select count(page_count) from books where author = (
select author_id from author where author_name = 'Stephen King');

/* Assignment Eleven */

select * 
from books 
where publication
between 1900 and 1950;


/* Assignment Twelve */


/* Initial Data Inserts */

insert into Author (author_id, author_name) values
(1001, 'Agatha Christie'),
(1002, 'George Orwell'),
(1003, 'Kurt Vonnegut'),
(1004, 'Mark Twain'),
(1005, 'Stephen King');


insert into Books (isbn_13, title, author, publication, page_count) values
(3050, 'Murder on the Orient Express', 1001, 1934, 256),
(3051, 'It', 1005, 1986, 1138),
(3052, 'And Then There Were None', 1001, 1939, 272),
(3053, 'Pet Sematary', 1005, 1983, 373),
(3054, 'Slaughterhouse-Five', 1003, 1969, 215),
(3055, 'Nineteen Eighty-Four', 1002, 1949, 328),
(3056, 'Adventures of Huckleberry Finn', 1004, 1884, 366),
(3057, 'Death on the Nile', 1001, 1937, 288),
(3058, 'Animal Farm', 1002, 1945, 112),
(3059, 'The Adventures of Tom Sawyer', 1004, 1876, 274),
(3060, 'The Shining', 1005, 1977, 447),
(3061, 'Salem''s Lot', 1005, 1975, 439),
(3062, 'Cat''s Cradle', 1003, 1963, 304);





