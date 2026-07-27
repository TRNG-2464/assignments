--Create Tables
CREATE TABLE Writer (
  writer_id INT PRIMARY KEY,
  writer_name TEXT NOT NULL
);

CREATE TABLE Books (
  book_id INT PRIMARY KEY,
  title TEXT NOT NULL,
  author INT REFERENCES Writer(writer_id),
  publication INT,
  page_count INT
);

--Test Insert
INSERT INTO Writer VALUES (1001, 'Agatha Christie');
INSERT INTO Books VALUES (3050, 'Murder on the Orient Express', 1001, 1934, 256);

--Test Fetch
SELECT * FROM Writer;
SELECT * FROM Books;