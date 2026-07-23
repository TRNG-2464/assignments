CREATE TABLE WRITER (
	writer_id INT PRIMARY KEY,
	writer_name VARCHAR(50) NOT NULL
);

CREATE TABLE BOOKS(
	book_id INT PRIMARY KEY,
	title VARCHAR(255) NOT NULL,
	author INT,
	"publication" INT,
	page_count INT,
	FOREIGN KEY (author) REFERENCES WRITER(writer_id)
);

ALTER TABLE BOOKS RENAME COLUMN book_id TO isbn_13;

ALTER TABLE WRITER RENAME TO AUTHOR; 
ALTER TABLE AUTHOR RENAME COLUMN writer_id to author_id;
ALTER TABLE AUTHOR RENAME COLUMN writer_name to author_name;