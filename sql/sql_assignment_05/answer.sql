CREATE TABLE Principal (
  principal_name VARCHAR(50) PRIMARY KEY,
  hire_date DATE,
  salary INT
);

CREATE TABLE School (
  school_name VARCHAR(50) PRIMARY KEY,
  principal_name VARCHAR(50),
  FOREIGN KEY (principal_name) REFERENCES Principal(principal_name)
);

CREATE TABLE Student (
  student_name VARCHAR(50) PRIMARY KEY,
  grade_level INT,
  address VARCHAR(200),
  emergency_contact_phone VARCHAR(50),
  school_name VARCHAR(50),
  FOREIGN KEY (school_name) REFERENCES School(school_name)
);