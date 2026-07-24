SELECT Student.student_id, TestEvent.test_score AS score,
    CASE
        WHEN TestEvent.test_score < 60 THEN NULL
        ELSE Student.student_name
    END
    FROM Student INNER JOIN TestEvent ON Student.student_id = TestEvent.student_id  INNER JOIN TestConfig ON TestEvent.test_id = TestConfig.test_id
    WHERE TestConfig.test_name = 'Introductory SQL' ORDER BY score DESC;

-- Stretch Goal - can't use the hardcoded literal this time

SELECT Student.student_id, TestEvent.test_score AS score, TestConfig.test_name AS test,
    CASE
        WHEN TestEvent.test_score < TestConfig.pass_mark THEN NULL
        ELSE Student.student_name
    END
    FROM Student INNER JOIN TestEvent ON Student.student_id = TestEvent.student_id  INNER JOIN TestConfig ON TestEvent.test_id = TestConfig.test_id
    ORDER BY test DESC, score DESC;
