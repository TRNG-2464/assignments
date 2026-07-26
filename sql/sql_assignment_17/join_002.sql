-- musician and band and genre
SELECT musician_name, band_name, genre_name FROM Musician M JOIN Band B ON M.band_id = B.band_id JOIN Genre G ON B.genre_id = G.genre_id;
-- Note: if multiple tables had the same column name, we'd need to use the table name to disambiguate like this: M.musician_name, B.band_name, G.genre_name

-- Each join needs an ON condition, otherewise syntax error
-- SELECT musician_name, band_name, genre_name FROM Musician JOIN Band JOIN Genre;