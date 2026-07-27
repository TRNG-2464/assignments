# Exercise — Musicians, Bands, and Genres

Given the following tables, produce a result that shows each musician alongside the band they play in and what genre that band performs.

**Stretch Goal:** Write a second query that returns only musicians who play in a Rock band. *Note: consider which table holds the genre name you want to filter on.*

Genre
|genre_id|genre_name|
|-|-|
|1|Rock|
|2|Jazz|
|3|Pop|
|4|Folk|

Band
|band_id|genre_id|band_name|
|-|-|-|
|1|1|The Midnight Echo|
|2|2|Blue Ember Quartet|
|3|3|Neon Parade|
|4|1|Hollow Crown|
|5|4|Cedar & Pine|

Musician
|musician_id|band_id|musician_name|instrument|
|-|-|-|-|
|1|1|Dana Reeves|Guitar|
|2|1|Leo Marsh|Drums|
|3|2|Priya Anand|Saxophone|
|4|2|Sam Okafor|Piano|
|5|3|Cleo Vance|Vocals|
|6|4|Jordan Hale|Bass|
|7|5|Mia Sorrel|Acoustic Guitar|
|8|5|Finn Calloway|Violin|

======SOLUATION=====
// 1


SELECT 
M.musician_name,
B.band_name,
G.genre_name
FROM Musician M
JOIN Band B 
ON M.band_id=B.band_id
JOIN Genre G 
ON B.genre_id=G.genre_id;

// 2
 

SELECT 
M.musician_name,
B.band_name,
G.genre_name
FROM Musician M
JOIN Band B 
ON M.band_id=B.band_id
JOIN Genre G 
ON B.genre_id=G.genre_id
WHERE 
G.genre_name ='Rock';