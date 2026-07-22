CREATE TABLE Principal(
    principal_id INT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    hire_date DATE,
    salary INT
);

CREATE TABLE School(
    school_id INT PRIMARY KEY,
    name VARCHAR(255),
    principal_id INT,
    FOREIGN KEY (principal_id) REFERENCES Principal(principal_id)
);

CREATE TABLE Student(
    student_id INT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    grade_level INT,
    home_address VARCHAR(255),
    emergency_contact INT,
    school_id INT,
    FOREIGN KEY (school_id) REFERENCES School(school_id)
);