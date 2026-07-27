SELECT d.first_name, d.last_name
FROM Doctor d
LEFT JOIN Appointment a
    ON d.doctor_id = a.doctor_id
WHERE a.doctor_id IS NULL;

SELECT d.first_name, d.last_name
FROM Doctor d
WHERE d.doctor_id NOT IN (
    SELECT doctor_id
    FROM Appointment
    WHERE status = 'Scheduled'
);