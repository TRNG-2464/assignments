CREATE TABLE Author(
    author_id SERIAL PRIMARY KEY,
    author_name VARCHAR(100)
);

CREATE TABLE Books(
    book_id SERIAL PRIMARY KEY,
    title VARCHAR(80),
    author INTEGER,
    publication INTEGER,
    page_count INTEGER,

    FOREIGN KEY(author) REFERENCES Author(author_id)
);
