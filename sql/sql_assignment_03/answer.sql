ALTER TABLE Writer RENAME TO Author;
ALTER TABLE Author RENAME COLUMN writer_id TO author_id;
ALTER TABLE Author RENAME COLUMN writer_name TO author_name;

--For some reason I get errors if I try to put multiple alter commands in one, so they all had to be separate.