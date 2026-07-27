-- 1.
SELECT d.first_name, d.last_name
FROM Doctor AS d
LEFT JOIN Appointment AS a ON d.doctor_id = a.doctor_id
WHERE a.appointment_id IS NULL;

-- 2.
SELECT d.doctor_id, d.first_name, d.last_name
FROM Doctor AS d
WHERE d.doctor_id NOT IN (
	SELECT doctor_id 
	FROM Appointment 
	WHERE status = 'Scheduled'
)