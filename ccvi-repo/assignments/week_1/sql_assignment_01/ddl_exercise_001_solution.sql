-- recreate the structure of the Writer and Books tables.

CREATE TABLE Writer (
    writer_id   INT PRIMARY KEY,
    writer_name VARCHAR(100) NOT NULL
);

CREATE TABLE Books (
    book_id     INT PRIMARY KEY,
    title       VARCHAR(200) NOT NULL,
    author      INT REFERENCES Writer(writer_id),
    publication INT,
    page_count  INT
);
