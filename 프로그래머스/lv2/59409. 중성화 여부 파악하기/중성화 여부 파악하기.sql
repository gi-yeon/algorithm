-- 코드를 입력하세요
SELECT animal_id, name, if(instr(sex_upon_intake,'neutered') or instr(sex_upon_intake,'spayed'),'O','X') from animal_ins 