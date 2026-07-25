player to team to sport

SELECT sport_name FROM Sport where sport_id = (
    SELECT sport_id FROM Team WHERE team_id = (
        SELECT team_id FROM Player ORDER BY "player Salary" DESC LIMIT 1
    )
);