# Exercise Four

Given the following information, create SQL scripts to create the three tables described.

Principles have a name, hire date, and salary.
Schools have a name, and a single principle
Students have a name, a grade level (7th, 8th, 9th, etc...), a home address, an emergency contact phone number, and a school

CREATE TABLE Principal (
    principal_id  INT PRIMARY KEY,
    name          VARCHAR(100) NOT NULL,
    hire_date     DATE,
    salary        DECIMAL(10, 2)
);

CREATE TABLE School (
    school_id     INT PRIMARY KEY,
    name          VARCHAR(100) NOT NULL,
    principal_id  INT,
    CONSTRAINT fk_school_principal
        FOREIGN KEY (principal_id) REFERENCES Principal(principal_id)
);

CREATE TABLE Student (
    student_id      INT PRIMARY KEY,
    name            VARCHAR(100) NOT NULL,
    grade_level     VARCHAR(10),
    home_address    VARCHAR(200),
    emergency_phone VARCHAR(20),
    school_id       INT,
    CONSTRAINT fk_student_school
        FOREIGN KEY (school_id) REFERENCES School(school_id)
);

with the help of Datagrip