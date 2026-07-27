-- 1
SELECT s.student_id, 
CASE
	WHEN e.test_score < c.pass_mark THEN NULL
ELSE
	s.student_name
END,
e.test_score
FROM Student AS s
JOIN TestEvent AS e ON s.student_id = e.student_id
JOIN TestConfig AS c on e.test_id = c.test_id
WHERE c.test_id = (
	SELECT test_id
	FROM TestConfig
	WHERE test_name = 'Introductory SQL'
)
ORDER BY test_score DESC;

-- 2.
SELECT s.student_id, 
CASE
	WHEN e.test_score < c.pass_mark THEN NULL
ELSE
	s.student_name
END AS student_name,
c.test_name, e.test_score
FROM Student AS s
JOIN TestEvent AS e ON s.student_id = e.student_id
JOIN TestConfig AS c on e.test_id = c.test_id
ORDER BY c.test_name, e.test_score DESC