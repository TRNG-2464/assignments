SELECT Doctor.first_name, Doctor.last_name FROM Doctor LEFT JOIN Appointment ON Doctor.doctor_id = Appointment.doctor_id WHERE Appointment.appointment_id IS NULL;

-- Stretch Goal

SELECT Doctor.first_name, Doctor.last_name FROM Doctor LEFT JOIN Appointment ON Doctor.doctor_id = Appointment.doctor_id AND Appointment.status = 'Scheduled' WHERE Appointment.appointment_id IS NULL;