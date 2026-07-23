--Anmoldeep Sandhu (Solution 3)


Alter TABLE writer RENAME TO Author;

Select * FROM Author;

Alter TABLE author RENAME COLUMN writer_id TO author_id;
Alter TABLE author RENAME COLUMN writer_name TO author_name;