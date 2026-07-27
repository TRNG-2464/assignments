SELECT s.sport_name
FROM Player AS p
JOIN Team AS t ON p.team_id = t.team_id
JOIN Sport AS s ON t.sport_id = s.sport_id
WHERE p.player_salary = (SELECT MAX(player_salary) FROM Player)
