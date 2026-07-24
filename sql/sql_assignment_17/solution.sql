SELECT M.musician_name, B.band_name, G.genre_name
FROM Musician M
JOIN Band B ON M.band_id = B.band_id
JOIN Genre G ON B.genre_id = G.genre_id;

SELECT musician_id
FROM Musician M
JOIN Band B ON M.band_id = B.band_id
JOIN Genre G ON B.genre_id = G.genre_id 
WHERE G.genre_name='Rock';
