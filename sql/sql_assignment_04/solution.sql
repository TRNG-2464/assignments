CREATE TABLE Department(
    department_id SERIAL PRIMARY KEY,
    department_name VARCHAR(20),
    location VARCHAR(100)
);

CREATE TABLE Doctor(
    doctor_id SERIAL PRIMARY KEY,
    department_id INTEGER,
    first_name VARCHAR(40),
    last_name VARCHAR(40),
    specialty VARCHAR(20),
    phone VARCHAR(20),

    FOREIGN KEY(department_id) REFERENCES Department(department_id)
);

CREATE TABLE Patient(
    patient_id SERIAL PRIMARY KEY,
    first_name VARCHAR(40),
    last_name VARCHAR(40),
    date_of_birth DATE,
    phone VARCHAR(20),
    address VARCHAR(80)
);


CREATE TABLE Appointment(
    appointment_id SERIAL PRIMARY KEY,
    patient_id INTEGER,
    doctor_id INTEGER,
    appointment_date DATE,
    appointment_time TIME,
    reason VARCHAR(100),
    status VARCHAR(20),

    FOREIGN KEY(patient_id) REFERENCES Patient(patient_id),
    FOREIGN KEY(doctor_id) REFERENCES Doctor(doctor_id)
);

CREATE TABLE Prescription(
    prescription_id SERIAL PRIMARY KEY,
    appointment_id INTEGER,
    medication_name VARCHAR(40),
    dosage VARCHAR(20),
    instructions VARCHAR(100),
    FOREIGN KEY(appointment_id) REFERENCES Appointment(appointment_id)
);

CREATE TABLE Room(
    room_id SERIAL PRIMARY KEY,
    department_id INTEGER,
    room_number VARCHAR(8),
    room_type VARCHAR(20),
    is_available BOOL,

    FOREIGN KEY(department_id) REFERENCES Department(department_id)
);
