-- create tables for Principles, Schools and Students.
-- A school has a single principle; each student belongs to a school.

CREATE TABLE Principle (
    principle_id   SERIAL PRIMARY KEY,
    principle_name VARCHAR(100) NOT NULL,
    hire_date      DATE,
    salary         NUMERIC(10,2)
);

CREATE TABLE School (
    school_id    SERIAL PRIMARY KEY,
    school_name  VARCHAR(100) NOT NULL,
    principle_id INT UNIQUE REFERENCES Principle(principle_id)
);

CREATE TABLE Student (
    student_id              SERIAL PRIMARY KEY,
    student_name            VARCHAR(100) NOT NULL,
    grade_level             VARCHAR(10),
    home_address            VARCHAR(200),
    emergency_contact_phone VARCHAR(20),
    school_id               INT REFERENCES School(school_id)
);
