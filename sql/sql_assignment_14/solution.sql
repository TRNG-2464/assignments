/* Assignment 14 */

select sport_name
from sport
where
	sport_id = (

		select team.sport_id
		from player
		inner join team on player.team_id = team.team_id
		order by player_salary desc
		limit 1

	);
