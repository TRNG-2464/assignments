
/*
 * Given the following tables, produce a result that shows each musician 
 * alongside the band they play in and what genre that band performs.
 * 
 * Stretch Goal: Write a second query that returns only musicians who play 
 * in a Rock band. Note: consider which table holds the genre name you want 
 * to filter on.
*/

SELECT m.musician_name, b.band_name, g.genre_name
FROM Musician m 
JOIN Band b ON m.band_id = b.band_id 
JOIN Genre g ON g.genre_id = b.genre_id;

SELECT m.musician_name
FROM Musician m 
JOIN Band b ON m.band_id = b.band_id 
JOIN Genre g ON g.genre_id = b.genre_id
WHERE g.genre_name LIKE 'Rock';



