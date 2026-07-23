CREATE TABLE Principal(
    principal_id SERIAL PRIMARY KEY,
    name VARCHAR(80),
    hire_date DATE,
    salary INTEGER
);

CREATE TABLE School(
    school_id SERIAL PRIMARY KEY,
    name VARCHAR(80),
    principal_id INTEGER,
    FOREIGN KEY(principal_id) REFERENCES Principal(principal_id)
);

CREATE TABLE Student(
    name VARCHAR(80),
    grade_level INTEGER,
    home_address VARCHAR(100),
    emergency_contact_phone VARCHAR(20),
    school_id INTEGER,

    FOREIGN KEY(school_id) REFERENCES School(school_id)
);
