ALTER TABLE Writer
RENAME TO Author;

ALTER TABLE Writer
RENAME COLUMN writer_id to author_id;

ALTER TABLE Writer
RENAME COLUMN writer_name to author_name;