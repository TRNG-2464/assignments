SELECT player_id, player_name
FROM Player P
JOIN Team T ON P.team_id = T.team_id
JOIN Sport S ON T.sport_id=S.sport_id
WHERE player_salary > 200000 AND sport_name='Foot Ball';
