-- Anmoldeep Solution 14

SELECT s.sport_name, p.player_name, p.salary
FROM Player p
JOIN Team t
ON p.team_id = t.team_id
JOIN Sport s
ON t.sport_id = s.sport_id
WHERE p.salary = (
    SELECT MAX(salary)
    FROM Player
);