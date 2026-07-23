CREATE TABLE Writer (
    writer_id SERIAL PRIMARY KEY,
    writer_name VARCHAR(20)
);

CREATE TABLE Books (
    book_id SERIAL PRIMARY KEY,
    title VARCHAR(20),
    author INTEGER,
    publication INTEGER,
    page_count INTEGER,

    FOREIGN KEY(author) REFERENCES Writer(writer_id)
);
