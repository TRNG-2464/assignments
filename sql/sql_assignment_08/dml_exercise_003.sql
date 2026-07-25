DELETE FROM exercise.Books WHERE author = 1004;


-- Alternatively, I could've done this below
-- DELETE FROM exercise.Books WHERE author = (SELECT author_id FROM exercise.Author WHERE author_name = 'Mark Twain');