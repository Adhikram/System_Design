-- Solution:
with cte as (
    select *,
        row_number() over() as rn
    from src_dest_distance
)
select t1.source,
    t1.destination,
    t1.distance
from cte t1
    join cte t2 on t1.rn < t2.rn
    and t1.source = t2.destination
    and t1.destination = t2.source;