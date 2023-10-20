select ii.FLAVOR
from icecream_info ii
join FIRST_HALF fh
on ii.FLAVOR = fh.FLAVOR
where fh.total_order > 3000
and ingredient_type = 'fruit_based'
order by fh.total_order desc;