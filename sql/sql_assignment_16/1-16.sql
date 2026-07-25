/*
 * Given the following tables, provide an SQL statement that returns the names 
 * of all doctors who have no appointments at all in the Appointment table.
 * (Beth and Tom)
 * Note: for this query, treat any row in the Appointment table as an appointment 
 * regardless of its status.
 *
 * Stretch Goal: Add a second query that returns the names of all doctors who have 
 * no currently scheduled appointments. Note: this will require filtering on status.
 */

SELECT CONCAT(d.first_name, ' ', d.last_name) AS full_name 
FROM appointment a
RIGHT JOIN doctor d ON a.doctor_id = d.doctor_id
WHERE a.appointment_date IS NULL;

SELECT CONCAT(d.first_name, ' ', d.last_name) AS full_name 
FROM appointment a
RIGHT JOIN doctor d ON a.doctor_id = d.doctor_id
WHERE a.status NOT LIKE 'Scheduled' OR a.appointment_date IS NULL;