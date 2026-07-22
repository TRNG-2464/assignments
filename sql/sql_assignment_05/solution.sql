CREATE TABLE Principal(principal_id INT PRIMARY KEY, name VARCHAR, hire_date DATE, salary INT);
CREATE TABLE School(school_id INT PRIMARY KEY, principal_id INT REFERENCES Principal(principal_id), name VARCHAR);
CREATE TABLE Student(student_id INT PRIMARY KEY, school_id INT REFERENCES School(school_id), name VARCHAR, grade INT, home_address VARCHAR, emergency_contact VARCHAR);