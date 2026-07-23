SELECT Author.author_name, AVG(Books.page_count) AS avg_page_count
FROM Books
JOIN Author ON Books.author = Author.author_id
GROUP BY Author.author_name
ORDER BY avg_page_count ASC
LIMIT 1;