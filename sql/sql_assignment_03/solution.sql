  /* Assignment Three */

alter table Writer rename to Author;

alter table Author rename column writer_id to author_id;

alter table Author rename column writer_name to author_name;
