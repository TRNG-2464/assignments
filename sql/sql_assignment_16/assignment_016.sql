SELECT Doctor.first_name, Doctor.last_name
FROM Doctor LEFT JOIN Appointment 
ON Doctor.doctor_id = Appointment.doctor_id
WHERE Appointment.doctor_id IS NULL;

SELECT Doctor.first_name, Doctor.last_name
FROM Doctor LEFT JOIN Appointment
ON Doctor.doctor_id = Appointment.doctor_id
AND Appointment.status = 'Scheduled'
WHERE Appointment.doctor_id IS NULL;