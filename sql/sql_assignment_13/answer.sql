
SELECT player_name, player_salary
FROM Player
WHERE player_salary > 200000
  AND team_id IN (20002, 20004, 20007, 20008, 20010);