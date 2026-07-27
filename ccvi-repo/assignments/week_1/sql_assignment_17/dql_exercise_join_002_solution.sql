-- Musicians, Bands, and Genres: each musician with their band
-- and the genre that band performs.

SELECT m.musician_name, m.instrument, b.band_name, g.genre_name
FROM Musician m
JOIN Band b ON m.band_id = b.band_id
JOIN Genre g ON b.genre_id = g.genre_id;

-- Only musicians who play in a Rock band.

SELECT m.musician_name, m.instrument, b.band_name, g.genre_name
FROM Musician m
JOIN Band b ON m.band_id = b.band_id
JOIN Genre g ON b.genre_id = g.genre_id
WHERE g.genre_name = 'Rock';
