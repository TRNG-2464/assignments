SELECT Player.player_name, Player.player_salary
FROM Player
JOIN Team ON Player.team_id = Team.team_id
JOIN Sport ON Team.sport_id = Sport.sport_id
WHERE Sport.sport_name = 'Foot Ball'
AND Player.player_salary > 200000;