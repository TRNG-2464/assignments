CREATE TABLE Writer (
	writer_id INT PRIMARY KEY,
	writer_name VARCHAR(100)
);

CREATE TABLE Books (
	book_id INT PRIMARY KEY,
	title VARCHAR(100),
	author INT,
	publication INT,
	page_count INT
);
