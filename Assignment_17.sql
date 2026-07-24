SELECT Musician.musician_name, Band.band_name, Genre.genre_name
FROM Musician JOIN BAND ON Musician.band_id = Band.band_id 
JOIN Genre ON Band.genre_id = Genre.genre_id;

SELECT Musician.musician_name
FROM Musician JOIN BAND ON Musician.band_id = Band.band_id 
JOIN Genre ON Band.genre_id = Genre.genre_id WHERE Genre.genre_id=1;