-- 코드를 입력하세요
SELECT b.book_id, a.author_name, date_format(b.published_date,"%Y-%m-%d") as date
from author as a
join book as b
on b.author_id=a.author_id and b.category="경제"
order by date asc