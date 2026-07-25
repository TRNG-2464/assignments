/*
 * Given the following tables, provide an SQL statement that will find all 
 * players whose name starts with the letter the letter 'j' followed 
 * immediately by the letter 'o'.
 * 
 * Provide a second altered version which finds players whose name contains 
 * the letter 'e' at some point after the letter 'a'.
*/
SELECT player_name
FROM Player
WHERE player_name ILIKE 'jo%';

SELECT player_name
FROM Player 
WHERE player_name ILIKE '%a%e';