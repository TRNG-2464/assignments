-- Solution 1
CREATE TABLE Writer (
  writer_id INT PRIMARY KEY,
  writer_name VARCHAR
);

--Solution 2
CREATE TABLE Books (
  book_id INT PRIMARY KEY,
  title VARCHAR,
  author INT REFERENCES Writer(writer_id),
  publication INT,
  page_count INT
);
