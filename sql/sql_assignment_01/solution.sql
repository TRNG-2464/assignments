/* Assignment One */
drop view if exists min_average_author;

drop table if exists Writer, Books, Author;

create table Writer (
  writer_id int not null,
  writer_name varchar(50)
);

create table Books (
  book_id int,
  title varchar(50),
  author int,
  publication int,
  page_count int
);
