-- find which sport has the highest paid player.

SELECT s.sport_name, p.player_name, p.player_salary
FROM Player p
JOIN Team t ON p.team_id = t.team_id
JOIN Sport s ON t.sport_id = s.sport_id
ORDER BY p.player_salary DESC
LIMIT 1;
