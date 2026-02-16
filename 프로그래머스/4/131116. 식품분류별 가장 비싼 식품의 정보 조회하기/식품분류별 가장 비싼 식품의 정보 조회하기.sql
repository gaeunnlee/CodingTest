SELECT  f.category, max_price, product_name
    FROM food_product f

    LEFT JOIN (
        SELECT category, MAX(price) as max_price
            FROM food_product
            GROUP BY category
    ) k
    ON k.category = f.category

    WHERE f.category IN ('과자', '국', '김치', '식용유') AND f.price = k.max_price
    ORDER BY f.price DESC
    