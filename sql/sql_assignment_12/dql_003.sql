SELECT author_name FROM Author WHERE author_id = --can delete this line if name isn't required
(SELECT author FROM Books
GROUP BY author
ORDER BY AVG(page_count) ASC LIMIT 1)

-- while the question asked for an author, what if there were multiple authors with the lowest average page count?
