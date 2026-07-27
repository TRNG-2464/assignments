SELECT s.student_id,
CASE
    WHEN te.test_score >= tc.pass_mark THEN s.student_name
    ELSE NULL
END AS student_name,
te.test_score
FROM Student s
INNER JOIN TestEvent te ON s.student_id = te.student_id,
INNER JOIN TestConfig tc ON te.test_id = tc.test_id
WHERE tc.test_name = 'Introductory SQL'
ORDER BY te.test_score DESC;