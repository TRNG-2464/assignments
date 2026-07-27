SELECT author_name	-- ['George Orwell', 'Kurt Vonnegut']
FROM Author
JOIN (-- [1002, 1003]
	SELECT author
	FROM Books 
	GROUP BY author
	HAVING AVG(page_count) = (-- [220]
		SELECT MIN(avg_page_count) AS min_avg_page_count
		FROM (-- [[1001, 272], [1002, 220], [1003, 220], [1004, 320], [1005, 600]]
			SELECT author, AVG(page_count) AS avg_page_count 
			FROM Books 
			GROUP BY author
		)
	)
) 
ON Author.author_id = author;