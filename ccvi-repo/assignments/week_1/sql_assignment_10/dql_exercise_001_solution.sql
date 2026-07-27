-- total page count of all books written by Stephen King.

SELECT SUM(b.page_count) AS total_page_count
FROM Books b
JOIN Author a ON b.author = a.author_id
WHERE a.author_name = 'Stephen King';
