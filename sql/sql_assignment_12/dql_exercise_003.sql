SELECT * FROM exercise.Author WHERE author_id = (SELECT author FROM exercise.Books GROUP BY author ORDER BY AVG(page_count) LIMIT 1);

