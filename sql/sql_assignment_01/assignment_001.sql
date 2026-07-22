CREATE TABLE Writer (
    writer_id INT PRIMARY KEY,
    writer_name VARCHAR(50)
);

CREATE TABLE Books (
    book_id INT PRIMARY KEY,
    title VARCHAR(255),
    author INT,
    publication INT,
    page_count INT
    FOREIGN KEY (author) REFERENCES Writer(writer_id)
);