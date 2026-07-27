-- rename the Writer table to Author, then rename its columns.

ALTER TABLE Writer RENAME TO Author;

ALTER TABLE Author RENAME COLUMN writer_id TO author_id;

ALTER TABLE Author RENAME COLUMN writer_name TO author_name;
