-- Solution

-- A double join? Interesting Player -> Team -> Sport

SELECT Player.player_name 
FROM Player INNER JOIN Team ON Player.team_id = Team.team_id INNER JOIN Sport ON Team.sport_id = Sport.sport_id
WHERE Sport.sport_name = 'Foot Ball' AND Player.player_salary > 200000;
