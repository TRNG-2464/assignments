# Exercise — Doctors Without Appointments

Given the following tables, provide an SQL statement that returns the names of all doctors who have no appointments at all in the Appointment table.

*Note: for this query, treat any row in the Appointment table as an appointment regardless of its status.*

**Stretch Goal:** Add a second query that returns the names of all doctors who have no **currently scheduled** appointments. *Note: this will require filtering on `status`.*

Department
|department_id|department_name|location|
|-|-|-|
|1|Cardiology|Building A|
|2|Neurology|Building B|
|3|Orthopedics|Building C|
|4|Pediatrics|Building D|

Doctor
|doctor_id|department_id|first_name|last_name|specialty|phone|
|-|-|-|-|-|-|
|1|1|James|Mercer|Cardiologist|555-1001|
|2|1|Sandra|Yue|Cardiologist|555-1002|
|3|2|Omar|Haddad|Neurologist|555-1003|
|4|2|Priya|Nair|Neurologist|555-1004|
|5|3|Carlos|Reyes|Orthopedic Surgeon|555-1005|
|6|4|Beth|Olsen|Pediatrician|555-1006|
|7|4|Tom|Finch|Pediatrician|555-1007|

Appointment
|appointment_id|patient_id|doctor_id|appointment_date|appointment_time|reason|status|
|-|-|-|-|-|-|-|
|101|1|1|2025-03-10|09:00|Chest pain|Completed|
|102|2|3|2025-03-11|10:30|Migraines|Completed|
|103|3|1|2025-03-12|14:00|Follow-up|Scheduled|
|104|4|5|2025-03-13|11:00|Knee injury|Scheduled|
|105|5|2|2025-03-14|09:30|Annual check|Scheduled|
|106|1|4|2025-03-15|13:00|Headaches|Scheduled|


====SOLUATION ======

// 1 
SELECT 
D.first_name,
D.last_name
FROM Doctor D
LEFT JOIN Appointment A
ON  D.doctor_id = A.doctor_id
WHERE A.appointment_id IS NULL ;

// 2

SELECT 
D.first_name,
D.last_name
FROM Doctor D
LEFT JOIN Appointment A
ON  D.doctor_id = A.doctor_id
AND A.status = 'Scheduled'
WHERE A.appointment_id IS NULL ;