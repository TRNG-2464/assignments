
/* Assignment 16 */
-- Drop tables if they already exist
drop table if exists Appointment, Doctor, Department cascade;

-- Create Department table
create table Department (
    department_id int primary key,
    department_name varchar(50),
    location varchar(50)
);

-- Create Doctor table
create table Doctor (
    doctor_id int primary key,
    department_id int,
    first_name varchar(50),
    last_name varchar(50),
    specialty varchar(50),
    phone varchar(20),

    constraint doctor_fk_department
        foreign key (department_id)
        references Department(department_id)
);

-- Create Appointment table
create table Appointment (
    appointment_id int primary key,
    patient_id int,
    doctor_id int,
    appointment_date date,
    appointment_time time,
    reason varchar(100),
    status varchar(20),

    constraint appointment_fk_doctor
        foreign key (doctor_id)
        references Doctor(doctor_id)
);


-- Populate Department
insert into Department values
(1, 'Cardiology', 'Building A'),
(2, 'Neurology', 'Building B'),
(3, 'Orthopedics', 'Building C'),
(4, 'Pediatrics', 'Building D');


-- Populate Doctor
insert into Doctor values
(1, 1, 'James', 'Mercer', 'Cardiologist', '555-1001'),
(2, 1, 'Sandra', 'Yue', 'Cardiologist', '555-1002'),
(3, 2, 'Omar', 'Haddad', 'Neurologist', '555-1003'),
(4, 2, 'Priya', 'Nair', 'Neurologist', '555-1004'),
(5, 3, 'Carlos', 'Reyes', 'Orthopedic Surgeon', '555-1005'),
(6, 4, 'Beth', 'Olsen', 'Pediatrician', '555-1006'),
(7, 4, 'Tom', 'Finch', 'Pediatrician', '555-1007');


-- Populate Appointment
insert into Appointment values
(101, 1, 1, '2025-03-10', '09:00', 'Chest pain', 'Completed'),
(102, 2, 3, '2025-03-11', '10:30', 'Migraines', 'Completed'),
(103, 3, 1, '2025-03-12', '14:00', 'Follow-up', 'Scheduled'),
(104, 4, 5, '2025-03-13', '11:00', 'Knee injury', 'Scheduled'),
(105, 5, 2, '2025-03-14', '09:30', 'Annual check', 'Scheduled'),
(106, 1, 4, '2025-03-15', '13:00', 'Headaches', 'Scheduled');




select distinct Doctor.first_name, Doctor.last_name
FROM Doctor
INNER JOIN Appointment
	ON Doctor.doctor_id = Appointment.doctor_id;

-- Stretch Goal
select distinct Doctor.first_name, Doctor.last_name
FROM Doctor
INNER JOIN Appointment
	ON Doctor.doctor_id = Appointment.doctor_id
where Appointment.status = 'Scheduled';



