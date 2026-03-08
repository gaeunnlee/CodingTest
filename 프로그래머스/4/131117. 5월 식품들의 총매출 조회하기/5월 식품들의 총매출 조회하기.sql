SELECT
    o.product_id, p.product_name, SUM(p.price * o.amount) as total_sales
FROM food_order o
JOIN food_product p
    ON o.product_id = p.product_id
WHERE SUBSTR(o.produce_date, 1, 7) = '2022-05'
GROUP BY o.product_id
ORDER BY total_sales DESC, o.product_id