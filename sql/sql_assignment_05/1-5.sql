CREATE TABLE IF NOT EXISTS Principals (
	principal_id integer PRIMARY KEY,
	name varchar(50),
	hire_date date,
	salary integer
);

CREATE TABLE Schools (
	school_id integer PRIMARY KEY,
	name varchar(50),
	principal_id integer REFERENCES Principals(principal_id)
);

CREATE TABLE Students (
	name varchar(50),
	grade_level integer,
	home_address varchar(50),
	emergency_contact_phone varchar(50),
	school_id integer REFERENCES Schools(school_id)
);