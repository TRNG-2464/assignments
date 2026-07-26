CREATE TABLE Principles (
	principle_id INT PRIMARY KEY,
	name VARCHAR(100),	
	hire_date DATE,
	salary INT
);

CREATE TABLE Schools (
	school_id INT PRIMARY KEY,
	name VARCHAR(100),
	principle_id INT,
	FOREIGN KEY (principle_id) REFERENCES Principles(principle_id)
);

CREATE TABLE Students (
	student_id INT PRIMARY KEY,
	name VARCHAR(100),
	grade VARCHAR(100),
	address VARCHAR(250),
	emergency_contact VARCHAR(100),
	school_id INT,
	FOREIGN KEY (school_id) REFERENCES Schools(school_id)
);