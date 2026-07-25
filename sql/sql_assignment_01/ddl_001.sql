CREATE TABLE Writer (
    writer_id int PRIMARY KEY,
    writer_name varchar(255) not null
);
create table Books (
    book_id int PRIMARY KEY,
    title varchar(255) not null,
    author int not null,
    publication int not null,
    page_count int not null
    -- foreign key (author) references Writer (writer_id)
    -- if you wanted there to be relational integrity
);