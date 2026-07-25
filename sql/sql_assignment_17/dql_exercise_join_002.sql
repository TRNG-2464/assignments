SELECT m.musician_id, m.musician_name, b.band_name, g.genre_name
FROM Musician m
INNER JOIN Band b ON m.band_id = b.band_id
INNER JOIN Genre g ON b.genre_id = g.genre_id;

SELECT m.musician_name
FROM Musician m
INNER JOIN Band b ON m.band_id = b.band_id
INNER JOIN Genre g ON b.genre_id = g.genre_id
WHERE g.genre_name = 'Rock';