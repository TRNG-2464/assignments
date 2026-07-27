-- Student Score Report: for the Introductory SQL test, show every
-- student's ID, name and score, masking the name with NULL when the score is
-- below that test's pass mark. Ordered from highest score to lowest.

SELECT st.student_id,
       CASE
           WHEN te.test_score >= tc.pass_mark THEN st.student_name
           ELSE NULL
       END AS student_name,
       te.test_score
FROM TestEvent te
JOIN Student st ON st.student_id = te.student_id
JOIN TestConfig tc ON tc.test_id = te.test_id
WHERE tc.test_name = 'Introductory SQL'
ORDER BY te.test_score DESC;

-- The same report for all tests and all attempts (30 rows),
-- comparing each score against the pass mark of its own test.

SELECT st.student_id,
       CASE
           WHEN te.test_score >= tc.pass_mark THEN st.student_name
           ELSE NULL
       END AS student_name,
       tc.test_name,
       te.test_score
FROM TestEvent te
JOIN Student st ON st.student_id = te.student_id
JOIN TestConfig tc ON tc.test_id = te.test_id
ORDER BY tc.test_name, te.test_score DESC;
