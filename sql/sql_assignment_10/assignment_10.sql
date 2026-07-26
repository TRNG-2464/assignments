-- CREATE TABLE Author(
-- 	author_id INTEGER PRIMARY KEY,
-- 	author_name VARCHAR(255)
-- );

-- INSERT INTO Author (author_id, author_name)
-- VALUES (1005, 'Stephen King');

-- SELECT * FROM Author;

-- CREATE TABLE Books(
-- 	book_id INTEGER PRIMARY KEY,
-- 	title VARCHAR(255),
-- 	author INTEGER REFERENCES Author(author_id),
-- 	publication INTEGER,
-- 	page_count INTEGER
-- );

-- INSERT INTO Books (book_id, title, author, publication, page_count)
-- VALUES 
-- 	(1, 'Book A', 1005, 1950, 100),
-- 	(2, 'Book B', 1005, 1954, 150);

-- SELECT * FROM Books;

SELECT SUM(page_count) AS total_page_count FROM Books WHERE author = 1005;
	