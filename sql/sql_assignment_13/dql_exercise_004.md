# Exercise Four

Given the following tables, provide an SQL statement that will find players who play football with a salary over 200000.

State
|state_id|state_name| 
|-|-|
|10001|New York|
|10002|Texas|
|10003|Colorado|
|10004|Florida|
|10005|California|

Team
|team_id|team_name|state_id|sport_id|
|-|-|-|-|
|20001|Los Angeles Clippers|10005|40002|
|20002|Denver Broncos|10003|40001|
|20003|New York Knicks|10001|40002|
|20004|Miami Dolphins|10004|40001|
|20005|Denver Nuggets|10003|40002|
|20006|Dallas Mavericks|10002|40002|
|20007|Dallas Cowboys|10002|40001|
|20008|San Francisco 49ers|10005|40001|
|20009|Miami Heat|10004|40002|
|20010|Buffalo Bills|10001|40001|



Player
|player_id|team_id|player_name|player Salary|
|-|-|-|-|
|30001|20006|Terry Lennie|185000|
|30002|20002|Ellis Sidney|101000|
|30003|20001|Alex Meredith|236000|
|30004|20003|Parker Lindsay|240000|
|30005|20008|Lindsey Darian|241000|
|30006|20007|Kit Stacy|220000|
|30007|20003|Sammie Hadley|112000|
|30008|20005|Tracey Bailey|128000|
|30009|20002|Addison Garnet|105000|
|30010|20005|Esme Stace|146000|
|30011|20009|Kennedy Meredith|236000|
|30012|20004|Cortney Harper|168000|
|30013|20002|Loren Addison|189000|
|30014|20009|Jojo Noel|233000|
|30015|20010|Syd Hilary|132000|
|30016|20006|Jools Francis|204000|
|30017|20001|Beverly Terry|210000|
|30018|20007|Sidney Raven|157000|
|30019|20006|Page Ricki|247000|
|30020|20003|Palmer Beau|104000|
|30021|20008|Hadley Lindsey|133000|
|30022|20008|Yancy Cameron|220000|
|30023|20010|Jo Jools|140000|
|30024|20001|Raleigh Ricki|170000|
|30025|20004|Tibby Ronnie|138000|
|30026|20009|Jules Evelyn|175000|
|30027|20007|Lesley Izzy|179000|
|30028|20005|Eddie Peyton|129000|
|30029|20010|Alpha Jocelyn|215000|
|30030|20004|Parker Emery|202000|

Sport
|sport_id|sport_name|
|-|-|
|40001|Foot Ball|
|40002|Basket Ball|

====== Soluation 13====== 

<!-- // 1- one hard solution to read  sub

 -->
 SELECT player_name,player_Salary
 FROM Player
 where 
 player_Salary >200000
 AND 
 team_id IN (
    SELECT team_id
    FROM Team
    WHERE sport_id = (
            
            SELECT sport_id
            FROM Sport
          WHERE sport_name ='Foot Ball'

        )
  );
 


 <!-- by Join is better and clear -->

Select Player.Player_id,
Player.player_name,
Player.player Salary,
Sport.sport_name
from Player 
join Team
on Player.team_id = Team.team_id
join Sport
on Sport.sport_id =Team.sport_id
where Sport.sport_name = 'Foot Ball' 
And
Player.player_Salary > 200000;

<!-- with Alias  -->
Select p.Player_id,
       p.player_name,
       p.player Salary,
       s.sport_name
from Player p
join Team t
on p.team_id = t.team_id
join Sport s
on t.sport_id =s.sport_id
where s.sport_name = 'Foot Ball' 
And
p.player_Salary > 200000;