SELECT author_name
FROM Author
WHERE author_id = (
	SELECT author
	FROM (
		SELECT author, AVG(page_count) as avg_page_count
		FROM Books
		GROUP BY author
		ORDER BY avg_page_count ASC
		LIMIT 1
	)
);