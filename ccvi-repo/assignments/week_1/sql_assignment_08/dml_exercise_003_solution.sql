-- remove all books written by Mark Twain.

DELETE FROM Books
WHERE author = (
    SELECT author_id
    FROM Author
    WHERE author_name = 'Mark Twain'
);
