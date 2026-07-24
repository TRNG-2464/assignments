/* Assignment Seven */

insert into books (
	title,
	author,
	publication,
	page_count)
values 	(
	'1984',
	(select author_id
	from author
	where author_name = 'George Orwell'),
	1949,
	325
);
