SELECT sp.sport_name
FROM exercise.Player p
INNER JOIN exercise.Team t ON p.team_id = t.team_id
INNER JOIN exercise.Sport sp ON t.sport_id = sp.sport_id
WHERE p.player_salary = (SELECT MAX(player_salary) FROM exercise.Player);