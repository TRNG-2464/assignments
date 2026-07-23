UPDATE Books
SET page_count = 220
WHERE book_id = (
    SELECT book_id
    FROM Books
    WHERE title = 'Slaughterhouse-Five'
);
