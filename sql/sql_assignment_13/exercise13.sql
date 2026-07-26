SELECT player_name
FROM Player
WHERE player_Salary > 200000 
AND team_id IN (
	SELECT team_id
	FROM Team
	WHERE sport_id = 40001
);