SELECT p.player_id, t.team_id, sp.sport_id, p.player_name, p.player_salary FROM
exercise.Player p
INNER JOIN exercise.Team t ON  p.team_id = t.team_id
INNER JOIN exercise.Sport sp ON t.sport_id = sp.sport_id
WHERE p.player_salary > 200000 AND sp.sport_name = 'Foot Ball';