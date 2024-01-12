select p.product_code, p.price * sum(sales_amount) as sales
from product p
inner join offline_sale os
on p.product_id = os.product_id
group by os.product_id
order by sales desc, p.product_code asc;