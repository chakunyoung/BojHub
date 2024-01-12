-- 코드를 입력하세요
SELECT fp.product_id, fp.product_name, fp.price * sum(amount) as total_sales
from food_product fp
join food_order fo
on fp.product_id = fo.product_id
where month(PRODUCE_DATE) = '05'
group by fp.product_id
order by total_sales desc, fp.product_id asc;