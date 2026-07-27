
/* Assignment Eight */

delete from books where author = (select author_id from author where author_name = 'Mark Twain');

