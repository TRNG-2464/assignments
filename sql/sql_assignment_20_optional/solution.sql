SELECT s.student_id,
CASE
    WHEN t.test_score < 60 THEN NULL
    ELSE s.student_name
END AS name,
t.test_score
FROM Student s
JOIN TestEvent t ON s.student_id = t.student_id
JOIN TestConfig c ON t.test_id=c.test_id AND c.test_name='Introductory SQL'
ORDER BY t.test_score DESC;


SELECT s.student_id, 
CASE
    WHEN e.test_score < c.pass_mark THEN NULL
    ELSE s.student_name
END AS name,
e.test_score
FROM Student s
JOIN TestEvent e ON e.student_id = s.student_id
JOIN TestConfig c ON e.test_id = c.test_id
ORDER BY c.test_name, test_score DESC;
