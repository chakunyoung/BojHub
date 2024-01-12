-- 코드를 입력하세요
SELECT m.member_name, r.review_text, date_format(r.review_date, '%Y-%m-%d') as review_date
from member_profile m
join rest_review r
on m.member_id = r.member_id
where r.member_id in (select r11.member_id
                    from rest_review r11
                    group by r11.member_id
                    having count(r11.member_id) = 
                    (select max(r3.counted) as maxValue1
                        from
                            (select r2.member_id, 
                            count(r2.member_id) as counted 
                            from rest_review r2 
                            group by r2.member_id) r3) )

 order by r.review_date asc, r.review_text asc;