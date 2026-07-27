-- Doctors Without Appointments: doctors with no rows at all
-- in the Appointment table, using a LEFT JOIN anti-pattern.

SELECT d.first_name, d.last_name
FROM Doctor d
LEFT JOIN Appointment a ON a.doctor_id = d.doctor_id
WHERE a.appointment_id IS NULL;

-- Doctors with no currently scheduled appointments.
-- The status filter must live in the join condition (not the WHERE clause),
-- otherwise doctors whose only appointments are completed would be lost.

SELECT d.first_name, d.last_name
FROM Doctor d
LEFT JOIN Appointment a
       ON a.doctor_id = d.doctor_id
      AND a.status = 'Scheduled'
WHERE a.appointment_id IS NULL;
