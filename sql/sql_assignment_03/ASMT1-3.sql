ALTER TABLE Writer RENAME TO Author;
ALTER TABLE Author RENAME COLUMN writer_id to author_id;
ALTER TABLE Author RENAME COLUMN writer_name TO author_name;