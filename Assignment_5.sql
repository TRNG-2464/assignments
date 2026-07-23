CREATE TABLE PRINCIPLE(
	principle_name varchar(50) PRIMARY KEY,
	hire_date DATE NOT NULL,
	salary INT NOT NULL
);

CREATE TABLE SCHOOLS(
	school_name varchar(100) PRIMARY KEY,
	principle_name varchar(50),
	FOREIGN KEY (principle_name) REFERENCES PRINCIPLE(principle_name)
);

CREATE TABLE STUDENTS(
	student_name varchar(50) PRIMARY KEY,
	grade_level varchar(10) NOT NULL,
	home_address varchar(100) NOT NULL,
	emergency_contact varchar(20),
	school_name varchar(100),
	FOREIGN KEY (school_name) REFERENCES SCHOOLS(school_name)
);