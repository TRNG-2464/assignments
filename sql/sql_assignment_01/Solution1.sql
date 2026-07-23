--Anmoldeep Sandhu (7/22/26)

CREATE TABLE Writer (
	writer_id INT PRIMARY KEY,
	writer_name VARCHAR(150)
);

CREATE TABLE Books (
	book_id INT PRIMARY KEY,
	title VARCHAR(255),
	author INT REFRENCES Writer(writer_id),
	publication INT,
	page_count INT,
);