# -- 코드를 입력하세요
SELECT animal_id, name
from animal_outs
where not exists (select animal_id, name from animal_ins where animal_outs.animal_id=animal_ins.animal_id)
order by animal_id asc, name asc
# (select a.animal_id, a.name from animal_outs as a, animal_ins as b where a.animal_id=b.animal_id) 