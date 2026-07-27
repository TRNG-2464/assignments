-- find the author whose books have the lowest average page count.

-- approach using a view:
CREATE VIEW author_avg_pages AS
SELECT a.author_id,
       a.author_name,
       AVG(b.page_count) AS avg_page_count
FROM Author a
JOIN Books b ON b.author = a.author_id
GROUP BY a.author_id, a.author_name;

SELECT author_name, avg_page_count
FROM author_avg_pages
WHERE avg_page_count = (SELECT MIN(avg_page_count) FROM author_avg_pages);
