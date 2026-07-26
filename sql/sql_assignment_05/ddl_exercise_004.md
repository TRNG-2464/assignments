# Exercise Four

Given the following information, create SQL scripts to create the three tables described.

Principles have a name, hire date, and salary.
Schools have a name, and a single principle
Students have a name, a grade level (7th, 8th, 9th, etc...), a home address, an emergency contact phone number, and a school


==============  Soluation 5 ========

CREATE TABLE Principal(
principal_id INT PRIMARY KEY,
principal_name varchar(50),
hire_date      date,
salary DECIMAL(10,2)  
);


CREATE TABLE School(
school_id INT PRIMARY KEY,
principal_id INT,
school_name varchar(50),
FOREIGN KEY (principal_id)
 REFERENCES Principal (principal_id) 
);

CREATE TABLE Student(
student_id INT PRIMARY KEY,
school_id  INT,
student_name varchar(50),
grade_level VARCHAR(10),
home_address VARCHAR(200),
emergency_phone varchar(10),

FOREIGN KEY (school_id) 
REFERENCES School(school_id)
);

