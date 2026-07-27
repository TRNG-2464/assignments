CREATE VIEW AuthorAverages AS
SELECT author, AVG(page_count) AS avg_page_count
FROM Books
GROUP BY author;

SELECT author_name, avg_page_count
FROM Author
JOIN AuthorAverages 
    ON author_id = author
WHERE avg_page_count = (
    SELECT MIN(avg_page_count)
    FROM AuthorAverages
);