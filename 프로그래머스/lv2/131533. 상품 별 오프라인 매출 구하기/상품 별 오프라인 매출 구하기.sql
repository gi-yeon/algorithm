select product_code, sum(sales_amount*price) as sales
from product
join offline_sale
on product.product_id=offline_sale.product_id
group by product_code
order by 2 desc, 1 asc