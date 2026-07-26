SELECT sport_name
FROM Sport
WHERE sport_id = (
	SELECT Team.sport_id
	FROM Team
	JOIN Player 
	ON Team.team_id = Player.team_id
	WHERE Player.player_Salary = (
		SELECT MAX(player_Salary)
		FROM Player
	)
);