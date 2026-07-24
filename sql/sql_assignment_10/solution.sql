/* Assignment Ten */

select count(page_count) from books where author = (
select author_id from author where author_name = 'Stephen King');
