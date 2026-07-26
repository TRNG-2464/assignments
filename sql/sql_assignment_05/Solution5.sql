--Anmoldeep Solution 5

-- Table Principal
CREATE TABLE Principal (
    principal_id INT PRIMARY KEY,
    name VARCHAR(100),
    hire_date DATE,
    salary DECIMAL(10,2)
);

-- Table School
CREATE TABLE School (
    school_id INT PRIMARY KEY,
    name VARCHAR(100),
    principal_id INT REFERENCES Principal(principal_id)
);

-- Table Student
CREATE TABLE Student (
    student_id INT PRIMARY KEY,
    school_id INT REFERENCES School(school_id),
    name VARCHAR(100),
    grade_level VARCHAR(10),
    home_address VARCHAR(200),
    emergency_contact_phone VARCHAR(20)
);