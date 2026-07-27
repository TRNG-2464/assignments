

/* Assignment 17 */

-- Drop tables if they already exist
drop table if exists Musician;
drop table if exists Band;
drop table if exists Genre;


-- Create Genre table
create table Genre (
    genre_id int primary key,
    genre_name varchar(50)
);


-- Create Band table
create table Band (
    band_id int primary key,
    genre_id int,
    band_name varchar(100),

    constraint band_fk_genre
        foreign key (genre_id)
        references Genre(genre_id)
);


-- Create Musician table
create table Musician (
    musician_id int primary key,
    band_id int,
    musician_name varchar(100),
    instrument varchar(50),

    constraint musician_fk_band
        foreign key (band_id)
        references Band(band_id)
);


-- Insert Genre data
insert into Genre values
(1, 'Rock'),
(2, 'Jazz'),
(3, 'Pop'),
(4, 'Folk');


-- Insert Band data
insert into Band values
(1, 1, 'The Midnight Echo'),
(2, 2, 'Blue Ember Quartet'),
(3, 3, 'Neon Parade'),
(4, 1, 'Hollow Crown'),
(5, 4, 'Cedar & Pine');


-- Insert Musician data
insert into Musician values
(1, 1, 'Dana Reeves', 'Guitar'),
(2, 1, 'Leo Marsh', 'Drums'),
(3, 2, 'Priya Anand', 'Saxophone'),
(4, 2, 'Sam Okafor', 'Piano'),
(5, 3, 'Cleo Vance', 'Vocals'),
(6, 4, 'Jordan Hale', 'Bass'),
(7, 5, 'Mia Sorrel', 'Acoustic Guitar'),
(8, 5, 'Finn Calloway', 'Violin');


select 
	musician_name, band_name, genre_name
from Musician
join Band
	on Musician.band_id = Band.band_id
join Genre
	on Band.genre_id = Genre.genre_id;

-- Stretch Goal: 
select 
	musician_name, band_name, genre_name
from Musician
join Band
	on Musician.band_id = Band.band_id
join Genre
	on Band.genre_id = Genre.genre_id
where 
	genre_name = 'Rock';
	