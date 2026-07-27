-- Part 1: players whose name starts with 'j' followed
-- immediately by 'o'. ILIKE makes the match case-insensitive so names
-- stored as 'Jojo', 'Jo', 'Jools' etc. are still found.

SELECT *
FROM Player
WHERE player_name ILIKE 'jo%';

-- Part 2: players whose name contains an 'e' at some point after an 'a'.

SELECT *
FROM Player
WHERE player_name ILIKE '%a%e%';
