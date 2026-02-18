SELECT 
    a.car_id, a.car_type, FLOOR(a.daily_fee * 30 * (100 - c.discount_rate) / 100) as fee
FROM car_rental_company_car a

JOIN car_rental_company_discount_plan c
    ON a.car_type = c.car_type AND c.duration_type = '30일 이상'

# 해당 차가 11월 대여 기록이 있다면 제외함
WHERE
    NOT EXISTS (
        SELECT 1
        FROM car_rental_company_rental_history b
        WHERE a.car_id = b.car_id
          AND b.start_date <= '2022-11-30'
          AND b.end_date   >= '2022-11-01'
    ) 
    AND a.car_type IN ('세단', 'SUV')
    AND FLOOR(a.daily_fee * 30 * (100 - c.discount_rate) / 100) >= 500000
    AND FLOOR(a.daily_fee * 30 * (100 - c.discount_rate) / 100) < 2000000
ORDER BY fee DESC, car_type ASC, car_id DESC
;

