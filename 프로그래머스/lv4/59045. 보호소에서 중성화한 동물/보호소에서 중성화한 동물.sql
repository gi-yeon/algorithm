-- 코드를 입력하세요
SELECT i.animal_id, i.animal_type, i.name
from animal_ins as i
join animal_outs as o
on i.animal_id=o.animal_id and i.sex_upon_intake like "intact%" and (o.sex_upon_outcome like "neutered%" or o.sex_upon_outcome like "spayed%")
order by animal_id asc
