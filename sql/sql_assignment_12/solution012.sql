-- Solution

/* Working out solution by steps:
*  Display Author Name
*  JOIN tables ON author_id = author
*  MIN(AVG page_count)
*  Alternatively, use GROUPBY, ORDERBY ASC and limit to 1 (Likely simpler)
*  The MIN(AVG) route would likely require nested SELECT statements
*/

SELECT Author.author_name, AVG(Books.page_count) AS AveragePageCount
FROM Author INNER JOIN Books ON Author.author_id = Books.author
GROUP BY Author.author_id, Author.author_name
ORDER BY AveragePageCount ASC
LIMIT 1;
