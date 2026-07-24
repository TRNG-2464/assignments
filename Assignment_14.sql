SELECT SPORT.sport_name FROM SPORT JOIN TEAM ON SPORT.sport_id = TEAM.sport_id
JOIN PLAYER ON TEAM.team_id = PLAYER.team_id ORDER BY PLAYER.player_salary DESC LIMIT 1;