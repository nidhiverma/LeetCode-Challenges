# NIDHI
SELECT a.player_id, a.device_id
FROM Activity a 
JOIN (
    SELECT MIN(event_date) as 'event_date', player_id
    FROM Activity
    GROUP BY player_id
) t1
ON a.player_id = t1.player_id AND a.event_date = t1.event_date



