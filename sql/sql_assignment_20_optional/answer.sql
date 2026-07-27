--Question 1
SELECT
    s.student_id,
    CASE
        WHEN te.test_score < 60 THEN NULL
        ELSE s.student_name
    END AS student_name,
    te.test_score
FROM Student s
JOIN TestEvent te
    ON s.student_id = te.student_id
WHERE te.test_id = 1
ORDER BY te.test_score DESC;

--Stretch Goal
SELECT
    s.student_id,
    CASE
        WHEN te.test_score < tc.pass_mark THEN NULL
        ELSE s.student_name
    END AS student_name,
    tc.test_name,
    te.test_score
FROM Student s
JOIN TestEvent te
    ON s.student_id = te.student_id
JOIN TestConfig tc
    ON te.test_id = tc.test_id
ORDER BY
    tc.test_name,
    te.test_score DESC;