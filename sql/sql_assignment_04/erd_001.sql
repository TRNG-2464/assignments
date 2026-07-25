create table Department (
    department_id int PRIMARY KEY,
    department_name varchar(255) not null,
    location VARCHAR(255) not null
);
create table Room(
    room_id int primary key,
    department_id int NOT NULL,  -- column must exist
    foreign key (department_id) references Department (department_id),
    room_number varchar(255) not null,
    room_type varchar(255) not null,
    is_available boolean not null
    -- combines lines 8 and 9:department_id int NOT NULL REFERENCES Department (department_id)
);

create table Doctor(
    doctor_id int primary key,
    department_id int not null references Department (department_id),
    first_name varchar(255) not null,
    last_name varchar(255) not null,
    specialty varchar(255) not null,
    phone varchar(255) not null
);

-- Note: Order of creation matters here. Patient must be created before Appointment.
-- This is because Appointment references Patient.
create table Patient(
    patient_id int primary key,
    first_name varchar(255) not null,
    last_name varchar(255) not null,
    date_of_birth date not null,
    phone varchar(255) not null,
    address varchar(255) not null
);

create table Appointment(
    appointment_id int primary key,
    patient_id int not null references Patient (patient_id),
    doctor_id int not null references Doctor (doctor_id),
    appointment_date date not null,
    appointment_time time not null,
    reason varchar(255) not null,
    status varchar(255) not null
);

create table Prescription(
    prescription_id int primary key,
    appointment_id int not null references Appointment (appointment_id),
    medication_name varchar(255) not null,
    dosage varchar(255) not null,
    instructions varchar(255) not null
);

