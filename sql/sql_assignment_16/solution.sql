SELECT D.first_name, D.last_name
FROM Doctor D
LEFT JOIN Appointment A ON D.doctor_id = A.doctor_id
GROUP BY D.doctor_id
HAVING COUNT(A.appointment_id) = 0;

SELECT D.first_name, D.last_name
FROM Doctor D
LEFT JOIN Appointment A ON D.doctor_id = A.doctor_id AND A.status = 'Scheduled'
GROUP BY D.doctor_id
HAVING COUNT(A.appointment_id) = 0;

-- subquery practice
-- SELECT D.first_name, D.last_name
-- FROM Doctor D
-- LEFT JOIN (
--     SELECT A.appointment_id, A.doctor_id
--     FROM Appointment A
--     WHERE A.status='Scheduled'
-- ) AS S
-- ON D.doctor_id = S.doctor_id
-- GROUP BY D.doctor_id
-- HAVING COUNT(S.appointment_id) = 0;
