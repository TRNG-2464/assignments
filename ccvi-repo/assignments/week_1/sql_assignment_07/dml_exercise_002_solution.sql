-- add a new book written by George Orwell (author_id 1002).
-- book_id is SERIAL, so it is omitted and generated automatically.

INSERT INTO Books (isbn_13, title, author, publication, page_count)
VALUES (3063, 'Homage to Catalonia', 1002, 1938, 232);
