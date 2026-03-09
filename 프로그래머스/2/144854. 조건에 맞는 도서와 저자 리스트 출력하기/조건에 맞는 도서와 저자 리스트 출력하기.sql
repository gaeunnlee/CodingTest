SELECT 
    book_id, author_name, SUBSTR(published_date, 1, 10) AS published_date
FROM book b
JOIN author a
    ON b.author_id = a.author_id
WHERE b.category = '경제'
ORDER BY published_date