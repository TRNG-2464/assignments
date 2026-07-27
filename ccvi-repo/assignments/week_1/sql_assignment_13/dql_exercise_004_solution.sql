-- players who play football with a salary over 200000.

SELECT p.player_name, p.player_salary, t.team_name, s.sport_name
FROM Player p
JOIN Team t ON p.team_id = t.team_id
JOIN Sport s ON t.sport_id = s.sport_id
WHERE s.sport_name = 'Foot Ball'
  AND p.player_salary > 200000;
