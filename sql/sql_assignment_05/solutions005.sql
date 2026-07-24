-- Solution

/*
* Worth noting, I would not normally set up the tables in this way
* I would add IDs as primary keys, but tried to follow the exercise as closely as possible
*/

CREATE TABLE Principle (
  principle_name VARCHAR PRIMARY KEY,
  hire_date DATE,
  salary INT
);

CREATE TABLE School (
  school_name VARCHAR PRIMARY KEY,
  principle_name VARCHAR REFERENCES Principle(principle_name)
);

CREATE TABLE Student (
  student_name VARCHAR PRIMARY KEY,
  grade_level VARCHAR,
  home_address VARCHAR,
  emergency_contact VARCHAR,
  school_name VARCHAR REFERENCES School(school_name)
);
