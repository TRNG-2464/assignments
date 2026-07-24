-- Solution

SELECT Sport.sport_name
FROM Sport INNER JOIN Team ON Sport.sport_id = Team.sport_id INNER JOIN Player ON Team.team_id = Player.team_id
ORDER BY Player.player_salary DESC
LIMIT 1;
