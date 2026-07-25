CREATE TABLE exercise.Writer(
    writer_id INTEGER PRIMARY KEY,
    writer_name VARCHAR(200)
);

CREATE TABLE exercise.Books(
    book_id INTEGER PRIMARY KEY,
    title VARCHAR(200),
    author INTEGER REFERENCES exercise.Writer(writer_id),
    publication INTEGER,
    page_count INTEGER
);