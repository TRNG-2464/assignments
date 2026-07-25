SELECT p.player_name, p.player_salary 
FROM Player AS p 
JOIN Team AS t ON p.team_id  = t.team_id 
JOIN Sport AS s ON t.sport_id  = s.sport_id 
WHERE s.sport_name = 'Football' AND p.player_salary > 200000
GROUP BY p.player_name, p.player_salary;