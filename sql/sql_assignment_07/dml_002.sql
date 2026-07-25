-- Since Books uses serial for book_id, we don't need to specify the book_id
INSERT INTO Books (title, author, publication, page_count) VALUES ('1984 is the title of the book', 1002, 2026, 123);

-- If we wanted to specify the book_id, we could do:
-- INSERT INTO Books (book_id, title, author, publication, page_count) VALUES (3063, '1984 is the title of the book', 1002, 2026, 123);
-- This would override the serial value for book_id and set it to 3063.