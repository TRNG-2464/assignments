-- 1
SELECT * FROM Doctor d
LEFT JOIN Appointment a ON d.doctor_id = a.doctor_id
WHERE a.appointment_id IS NULL;

-- Stretch Goal
SELECT * FROM Doctor d
LEFT JOIN Appointment a ON d.doctor_id = a.doctor_id AND a.status = 'Scheduled'
WHERE a.appointment_id IS NULL;