CREATE OR REPLACE VIEW Averages AS
SELECT AVG(page_count), author
FROM Books
GROUP BY author;

SELECT author FROM Averages WHERE avg = (SELECT MIN(avg) FROM Averages);