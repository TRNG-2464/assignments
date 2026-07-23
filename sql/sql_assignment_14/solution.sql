SELECT sport_name
FROM Player P
JOIN Team T ON P.team_id = T.team_id
JOIN Sport S ON S.sport_id = T.sport_id
ORDER BY player_salary DESC
LIMIT 1;
