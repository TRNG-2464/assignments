-- Solution 1

-- A neat thing I found while looking into casing is rather than using UPPER or LOWER
-- PostgreSQL actually has a case insensitive LIKE keyword, ILIKE

SELECT * FROM Player
WHERE player_name ILIKE 'jo%';

-- Solution 2

SELECT * FROM Player
WHERE player_name ILIKE '%a%e%';
