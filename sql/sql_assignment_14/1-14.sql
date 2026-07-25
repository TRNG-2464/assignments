-- SQL statement that will find which sport has the highest paid player.
SELECT s.sport_name
FROM Sport s 
JOIN Team t ON s.sport_id = t.sport_id 
JOIN Player p ON t.team_id = p.team_id 
WHERE p.player_salary = (SELECT MAX(p.player_salary)
FROM player p)
GROUP BY s.sport_name;