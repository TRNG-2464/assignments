-- Solution 1

-- If we do a LEFT JOIN instead of an INNER JOIN on this table, then only display NULL Doctors

SELECT Doctor.first_name, Doctor.last_name
FROM Doctor LEFT JOIN Appointment ON Doctor.doctor_id = Appointment.doctor_id
WHERE Appointment.doctor_id IS NULL;

-- Stretch Solution

-- Similar to previous solution I think, don't believe an OR clause would correctly filter...
-- Maybe adding an AND onto the JOIN statement? This should filter the rows being provided to the NULL check rather than after?

SELECT Doctor.first_name, Doctor.last_name
FROM Doctor LEFT JOIN Appointment ON Doctor.doctor_id = Appointment.doctor_id AND Appointment.status = 'Scheduled'
WHERE Appointment.doctor_id IS NULL;
