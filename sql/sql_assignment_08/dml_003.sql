DELETE FROM Books where author=1004;

-- Below are examples of how to do this with subqueries, but I know that subqueries are not the best way to do this. I just wanted to give myself an example of how to do it.

-- -- How it would look like if we used a subquery, but a weak example since you're searching within the same table 
-- DELETE FROM Books where author IN (
--   SELECT Author FROM Books where author=1004
-- );

-- -- This is a better example since we're using a subquery since we're searching within the Author table
-- DELETE FROM Books WHERE author = (
--   SELECT author_id
--   FROM Author
--   WHERE author_name = 'Mark Twain'
-- );