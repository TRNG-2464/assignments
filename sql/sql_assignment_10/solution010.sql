-- Solution

SELECT SUM(Books.page_count) AS TotalPageCount
FROM Author INNER JOIN Books ON Author.author_id = Books.author
WHERE Author.author_name = 'Stephen King';
