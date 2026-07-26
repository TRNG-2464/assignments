/* Solutions to the sql assignments */

  /* Assignment One */
drop view if exists min_average_author;

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

-- View version

create view min_average_author as 
select 
	avg(books.page_count) as avg_pg_count,
	author.author_name
from books 
inner join author on books.author = author.author_id
group by(author.author_name);

select MIN(avg_pg_count) from min_average_author;

-- Single statement

select min(avg_pg_count) 
from (
	select 
		avg(books.page_count) as avg_pg_count
	from books 
	inner join author on books.author = author.author_id
	group by(author.author_name)
	);


/* Assignment Thirteen */

-- Drop tables if they already exist 
drop table if exists Player;
drop table if exists Team;
drop table if exists State;
drop table if exists Sport;


-- Create State table
create table State (
    state_id int primary key,
    state_name varchar(50) not null
);


-- Create Sport table
create table Sport (
    sport_id int primary key,
    sport_name varchar(50) not null
);


-- Create Team table
create table Team (
    team_id int primary key,
    team_name varchar(100) not null,
    state_id int not null,
    sport_id int not null,

    constraint team_fk_state
        foreign key (state_id)
        references State(state_id),

    constraint team_fk_sport
        foreign key (sport_id)
        references Sport(sport_id)
);


-- Create Player table
create table Player (
    player_id int primary key,
    team_id int not null,
    player_name varchar(100) not null,
    player_salary int not null,

    constraint player_fk_team
        foreign key (team_id)
        references Team(team_id)
);


-- Insert State data
insert into State values
(10001, 'New York'),
(10002, 'Texas'),
(10003, 'Colorado'),
(10004, 'Florida'),
(10005, 'California');


-- Insert Sport data
insert into Sport values
(40001, 'Foot Ball'),
(40002, 'Basket Ball');


-- Insert Team data
insert into Team values
(20001, 'Los Angeles Clippers', 10005, 40002),
(20002, 'Denver Broncos', 10003, 40001),
(20003, 'New York Knicks', 10001, 40002),
(20004, 'Miami Dolphins', 10004, 40001),
(20005, 'Denver Nuggets', 10003, 40002),
(20006, 'Dallas Mavericks', 10002, 40002),
(20007, 'Dallas Cowboys', 10002, 40001),
(20008, 'San Francisco 49ers', 10005, 40001),
(20009, 'Miami Heat', 10004, 40002),
(20010, 'Buffalo Bills', 10001, 40001);


-- Insert Player data
insert into Player values
(30001, 20006, 'Terry Lennie', 185000),
(30002, 20002, 'Ellis Sidney', 101000),
(30003, 20001, 'Alex Meredith', 236000),
(30004, 20003, 'Parker Lindsay', 240000),
(30005, 20008, 'Lindsey Darian', 241000),
(30006, 20007, 'Kit Stacy', 220000),
(30007, 20003, 'Sammie Hadley', 112000),
(30008, 20005, 'Tracey Bailey', 128000),
(30009, 20002, 'Addison Garnet', 105000),
(30010, 20005, 'Esme Stace', 146000),
(30011, 20009, 'Kennedy Meredith', 236000),
(30012, 20004, 'Cortney Harper', 168000),
(30013, 20002, 'Loren Addison', 189000),
(30014, 20009, 'Jojo Noel', 233000),
(30015, 20010, 'Syd Hilary', 132000),
(30016, 20006, 'Jools Francis', 204000),
(30017, 20001, 'Beverly Terry', 210000),
(30018, 20007, 'Sidney Raven', 157000),
(30019, 20006, 'Page Ricki', 247000),
(30020, 20003, 'Palmer Beau', 104000),
(30021, 20008, 'Hadley Lindsey', 133000),
(30022, 20008, 'Yancy Cameron', 220000),
(30023, 20010, 'Jo Jools', 140000),
(30024, 20001, 'Raleigh Ricki', 170000),
(30025, 20004, 'Tibby Ronnie', 138000),
(30026, 20009, 'Jules Evelyn', 175000),
(30027, 20007, 'Lesley Izzy', 179000),
(30028, 20005, 'Eddie Peyton', 129000),
(30029, 20010, 'Alpha Jocelyn', 215000),
(30030, 20004, 'Parker Emery', 202000);



select * from Player where player_salary > 200000;


/* Assignment 14 */

select sport_name
from sport
where 
	sport_id = (
		
		select team.sport_id
		from player
		inner join team on player.team_id = team.team_id
		order by player_salary desc 
		limit 1
		
	);

/* Assignment 15 */
	
	
select player_name from player where lower(player_name) like 'jo%';

select player_name from player where lower(player_name) like '%a%e%';



/* Assignment 16 */
-- Drop tables if they already exist
drop table if exists Appointment, Doctor, Department cascade;

-- Create Department table
create table Department (
    department_id int primary key,
    department_name varchar(50),
    location varchar(50)
);

-- Create Doctor table
create table Doctor (
    doctor_id int primary key,
    department_id int,
    first_name varchar(50),
    last_name varchar(50),
    specialty varchar(50),
    phone varchar(20),

    constraint doctor_fk_department
        foreign key (department_id)
        references Department(department_id)
);

-- Create Appointment table
create table Appointment (
    appointment_id int primary key,
    patient_id int,
    doctor_id int,
    appointment_date date,
    appointment_time time,
    reason varchar(100),
    status varchar(20),

    constraint appointment_fk_doctor
        foreign key (doctor_id)
        references Doctor(doctor_id)
);


-- Populate Department
insert into Department values
(1, 'Cardiology', 'Building A'),
(2, 'Neurology', 'Building B'),
(3, 'Orthopedics', 'Building C'),
(4, 'Pediatrics', 'Building D');


-- Populate Doctor
insert into Doctor values
(1, 1, 'James', 'Mercer', 'Cardiologist', '555-1001'),
(2, 1, 'Sandra', 'Yue', 'Cardiologist', '555-1002'),
(3, 2, 'Omar', 'Haddad', 'Neurologist', '555-1003'),
(4, 2, 'Priya', 'Nair', 'Neurologist', '555-1004'),
(5, 3, 'Carlos', 'Reyes', 'Orthopedic Surgeon', '555-1005'),
(6, 4, 'Beth', 'Olsen', 'Pediatrician', '555-1006'),
(7, 4, 'Tom', 'Finch', 'Pediatrician', '555-1007');


-- Populate Appointment
insert into Appointment values
(101, 1, 1, '2025-03-10', '09:00', 'Chest pain', 'Completed'),
(102, 2, 3, '2025-03-11', '10:30', 'Migraines', 'Completed'),
(103, 3, 1, '2025-03-12', '14:00', 'Follow-up', 'Scheduled'),
(104, 4, 5, '2025-03-13', '11:00', 'Knee injury', 'Scheduled'),
(105, 5, 2, '2025-03-14', '09:30', 'Annual check', 'Scheduled'),
(106, 1, 4, '2025-03-15', '13:00', 'Headaches', 'Scheduled');
	



select distinct Doctor.first_name, Doctor.last_name 
FROM Doctor
INNER JOIN Appointment 
	ON Doctor.doctor_id = Appointment.doctor_id;

-- Stretch Goal
select distinct Doctor.first_name, Doctor.last_name 
FROM Doctor
INNER JOIN Appointment 
	ON Doctor.doctor_id = Appointment.doctor_id
where Appointment.status = 'Scheduled';




/* Assignment 17 */

-- Drop tables if they already exist
drop table if exists Musician;
drop table if exists Band;
drop table if exists Genre;


-- Create Genre table
create table Genre (
    genre_id int primary key,
    genre_name varchar(50)
);


-- Create Band table
create table Band (
    band_id int primary key,
    genre_id int,
    band_name varchar(100),

    constraint band_fk_genre
        foreign key (genre_id)
        references Genre(genre_id)
);


-- Create Musician table
create table Musician (
    musician_id int primary key,
    band_id int,
    musician_name varchar(100),
    instrument varchar(50),

    constraint musician_fk_band
        foreign key (band_id)
        references Band(band_id)
);


-- Insert Genre data
insert into Genre values
(1, 'Rock'),
(2, 'Jazz'),
(3, 'Pop'),
(4, 'Folk');


-- Insert Band data
insert into Band values
(1, 1, 'The Midnight Echo'),
(2, 2, 'Blue Ember Quartet'),
(3, 3, 'Neon Parade'),
(4, 1, 'Hollow Crown'),
(5, 4, 'Cedar & Pine');


-- Insert Musician data
insert into Musician values
(1, 1, 'Dana Reeves', 'Guitar'),
(2, 1, 'Leo Marsh', 'Drums'),
(3, 2, 'Priya Anand', 'Saxophone'),
(4, 2, 'Sam Okafor', 'Piano'),
(5, 3, 'Cleo Vance', 'Vocals'),
(6, 4, 'Jordan Hale', 'Bass'),
(7, 5, 'Mia Sorrel', 'Acoustic Guitar'),
(8, 5, 'Finn Calloway', 'Violin');




































