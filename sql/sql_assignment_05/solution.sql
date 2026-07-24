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
