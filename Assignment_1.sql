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