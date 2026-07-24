-- Solution 1

ALTER TABLE Writer RENAME TO Author;

-- Solution 2

ALTER TABLE Author RENAME COLUMN writer_id TO author_id;
ALTER TABLE Author RENAME COLUMN writer_name TO author_name;
