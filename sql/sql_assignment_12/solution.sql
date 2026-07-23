SELECT author_id, author_name
FROM Author JOIN (
    SELECT author
    FROM Books
    GROUP BY author
    ORDER BY AVG(page_count) ASC
    LIMIT 1
) AS A
ON A.author=author_id
;
