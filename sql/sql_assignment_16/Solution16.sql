--Anmoldeep Solution 16

SELECT d.first_name, d.last_name
FROM Doctor d
LEFT JOIN Appointment a
ON d.doctor_id = a.doctor_id
WHERE a.appointment_id IS NULL;

SELECT d.first_name, d.last_name
FROM Doctor d
LEFT JOIN Appointment a
ON d.doctor_id = a.doctor_id
AND a.status = 'Scheduled'
WHERE a.appointment_id IS NULL;