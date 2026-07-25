-- Creating the Writer table.
CREATE TABLE if not exists Writer (
    writer_id INT,
    writer_name VARCHAR(100)
);

-- Creating the Books table.
CREATE TABLE IF NOT EXISTS Books (
	book_id int,
	title varchar(100),
	author int,
	publication int,
	page_count int
);