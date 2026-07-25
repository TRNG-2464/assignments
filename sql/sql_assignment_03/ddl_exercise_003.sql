ALTER TABLE exercise.Writer RENAME TO Author;

ALTER TABLE exercise.Author RENAME COLUMN writer_id TO author_id;

ALTER TABLE exercise.Author RENAME COLUMN writer_name TO author_name;