SELECT SUM(page_count)
FROM Books
WHERE author = (
    SELECT author_id FROM Author WHERE author_name='Stephen King'
);
