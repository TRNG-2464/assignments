-- Anmoldeep Solution 12

SELECT author, AVG(page_count) AS avg_page_count
FROM Books
GROUP BY author;