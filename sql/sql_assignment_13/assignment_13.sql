SELECT p.player_name, t.team_name, p.player_salary, s.sport_name
FROM Player AS p
JOIN Team AS t on p.team_id = t.team_id
JOIN Sport AS s on t.sport_id = s.sport_id
WHERE s.sport_name = 'Foot Ball' 
AND p.player_salary > 200000;