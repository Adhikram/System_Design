--- Q6 : IPL Matches --- 
-- Solution for 1: Each team plays with every other team JUST ONCE.
WITH matches AS (
    SELECT row_number() over(
            order by team_name
        ) AS id,
        t.*
    FROM teams t
)
SELECT team.team_name AS team,
    opponent.team_name AS opponent
FROM matches team
    JOIN matches opponent ON team.id < opponent.id
ORDER BY team;

-- Solution for 2: Each team plays with every other team TWICE.
WITH matches AS (
    SELECT row_number() over(
            order by team_name
        ) AS id,
        t.*
    FROM teams t
)
SELECT team.team_name AS team,
    opponent.team_name AS opponent
FROM matches team
    JOIN matches opponent ON team.id <> opponent.id
ORDER BY team;