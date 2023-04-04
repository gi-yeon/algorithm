-- 코드를 입력하세요
SELECT i.name, i.datetime
from animal_ins as i
where not exists (select i.name, i.datetime from animal_outs as o where i.animal_id=o.animal_id)
order by datetime asc
limit 3