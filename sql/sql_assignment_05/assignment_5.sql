-- 1. Principle
CREATE TABLE Principle(
	principle_id SERIAL PRIMARY KEY,
	name VARCHAR(255),
	hire_date DATE,
	salary DECIMAL
);

-- 2. School
CREATE TABLE School(
	school_id SERIAL PRIMARY KEY,
	name VARCHAR(255),
	principle_id INTEGER REFERENCES Principle(principle_id)
);

-- 3. Student
CREATE TABLE Student(
	student_id SERIAL PRIMARY KEY,
	name VARCHAR(255),
	grade_level VARCHAR(255),	-- could be integer
	home_address VARCHAR(255),
	emergency_contact_phone_number VARCHAR(255),
	school_id INTEGER REFERENCES School(school_id)
);