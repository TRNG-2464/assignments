-- LIKE operator:

-- % The percent sign represents zero, one, or multiple characters
-- _ The underscore sign represents one, single character
SELECT player_name FROM Player WHERE player_name LIKE 'Jo%';
SELECT player_name FROM Player WHERE player_name LIKE '%a%e%';