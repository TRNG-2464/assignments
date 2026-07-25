CREATE TABLE exercise.Department (
    department_id INTEGER PRIMARY KEY,
    department_name VARCHAR(255),
    location VARCHAR(255)
);

CREATE TABLE exercise.Patient(
    patient_id INTEGER PRIMARY KEY,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    date_of_birth DATE,
    phone VARCHAR(255),
    address VARCHAR(255)
);

CREATE TABLE exercise.Room(
    room_id INTEGER PRIMARY KEY,
    department_id INTEGER REFERENCES exercise.Department(department_id),
    room_number VARCHAR(255),
    room_type VARCHAR(255),
    is_available BOOLEAN
);

CREATE TABLE exercise.Doctor(
    doctor_id INTEGER PRIMARY KEY,
    department_id INTEGER REFERENCES exercise.Department(department_id),
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    specialty VARCHAR(255),
    phone VARCHAR(255)
);

CREATE TABLE exercise.Appointment(
    appointment_id INTEGER PRIMARY KEY,
    patient_id INTEGER REFERENCES exercise.Patient(patient_id),
    doctor_id INTEGER REFERENCES exercise.Doctor(doctor_id),
    appointment_date DATE,
    appointment_time TIME,
    reason VARCHAR(255),
    status VARCHAR(255)
);

CREATE TABLE exercise.Prescription(
    prescription_id INTEGER PRIMARY KEY,
    appointment_id INTEGER REFERENCES exercise.Appointment(appointment_id),
    medication_name VARCHAR(255),
    dosage VARCHAR(255),
    instructions VARCHAR(255)
);