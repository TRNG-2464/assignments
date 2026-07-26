SELECT first_name, last_name
FROM Doctor 
WHERE doctor_id
NOT IN (
	SELECT DISTINCT  doctor_id
	FROM Appointment
);

SELECT first_name, last_name
FROM Doctor 
WHERE doctor_id
NOT IN (
	SELECT DISTINCT doctor_id
	FROM Appointment
	WHERE status = ‘Scheduled’
);