CREATE TABLE exercise.Principle(
    principle_id INTEGER PRIMARY KEY,
    name VARCHAR(255),
    hire_date DATE,
    salary NUMERIC
);

CREATE TABLE exercise.School(
    school_id INTEGER PRIMARY KEY,
    name VARCHAR(255),
    principle INTEGER REFERENCES exercise.Principle(principle_id)
);

CREATE TABLE exercise.Student(
    student_id INTEGER PRIMARY KEY,
    name VARCHAR(255),
    grade_level SMALLINT CHECK (grade_level BETWEEN 0 and 12),
    home_address VARCHAR(255),
    emergency_contact_phone_number VARCHAR(255),
    school INTEGER REFERENCES exercise.School(school_id)
);