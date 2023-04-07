-- 코드를 입력하세요
SELECT date_format(datetime,"%k") as hour, count(datetime) from animal_outs
where date_format(datetime,"%k") >= 9 and date_format(datetime,"%k") <= 19
group by hour
order by length(hour) asc, hour asc