SELECT first_name, last_name FROM Doctor Doc LEFT JOIN Appointment A ON doc.doctor_id = A.doctor_id WHERE A.doctor_id IS NULL;


-- SELECT (first_name, last_name) FROM Doctor Doc LEFT JOIN Appointment A ON doc.doctor_id = A.doctor_id WHERE Doc.doctor_id IS NULL;
-- Use A.doctor)id instead of Doc.doctor_id to check if the doctor_id is in the Appointment table