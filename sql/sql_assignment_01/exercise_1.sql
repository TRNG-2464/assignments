CREATE TABLE writers (
	writer_id SERIAL PRIMARY KEY,
	writer_name VARCHAR(255)
);

CREATE TABLE books (
	book_id SERIAL PRIMARY KEY,
	title VARCHAR(255),
	author INTEGER REFERENCES writers(writer_id),
	publication integer,
	page_count integer
)

-- CREATE TABLE writers (
-- 	writer_id SERIAL PRIMARY KEY,
-- 	writer_name VARCHAR(255)
-- );

-- -- INSERT INTO writers (writer_name)
-- -- VALUES ('Agatha Christie');

-- INSERT INTO writers(writer_name)
-- VALUES 
-- 	('George Orwell'),
-- 	('Kurt Vonnegut'),
-- 	('Mark Twain');

-- SELECT * FROM writers;

-- CREATE TABLE books (
-- 	book_id SERIAL PRIMARY KEY,
-- 	title VARCHAR(255),
-- 	author INTEGER REFERENCES writers(writer_id),
-- 	publication integer,
-- 	page_count integer
-- )

-- INSERT INTO books(title, author, publication, page_count)
-- VALUES
-- 	('Murder on the Orient Express', 1, 1934, 256);

-- INSERT INTO books(title, author, publication, page_count)
-- VALUES ('And Then There Were None', 1, 1939, 272),

SELECT * FROM books;

-- SELECT writers.writer_name, books.title
-- FROM writers -- default to INNER JOIN
-- JOIN books ON writers.writer_id = books.author;
