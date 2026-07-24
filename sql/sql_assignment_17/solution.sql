SELECT Musician.musician_name, Band.band_name, Genre.genre_name FROM Musician INNER JOIN Band ON Musician.band_id = Band.band_id INNER JOIN Genre ON Band.genre_id = Genre.genre_id;

-- Stretch Goal Query

SELECT Musician.musician_name FROM Musician INNER JOIN Band ON Musician.band_id = Band.band_id INNER JOIN Genre ON Band.genre_id = Genre.genre_id WHERE Genre.genre_name = 'Rock';