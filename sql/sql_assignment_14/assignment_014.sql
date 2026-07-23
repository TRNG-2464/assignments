SELECT Player.player_name, Player.player_salary, Sport.sport_name
FROM Player
JOIN Team ON Player.team_id = Team.team_id
JOIN Sport ON Team.sport_id = Sport.sport_id
ORDER BY Player.player_salary DESC
LIMIT 1;