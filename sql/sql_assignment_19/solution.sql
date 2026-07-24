-- 1
SELECT product_name, unit_cost, unit_price, (unit_price - unit_cost) AS profit_margin
FROM Product;

-- 2
SELECT c.category_id, SUM(p.unit_cost * p.stock_quantity) AS inventory_value
FROM Category c
LEFT JOIN Product p ON c.category_id=p.category_id
GROUP BY c.category_id;

-- 3
SELECT product_id, unit_price * stock_quantity AS gross_revenue
FROM Product;

-- 4
SELECT product_id, AVG(unit_price - unit_cost) AS overall_profit_margin
FROM Product;

-- 5
SELECT product_id
FROM Product
WHERE (unit_price - unit_cost) > (
    SELECT AVG(p1.unit_price - p1.unit_cost)
    FROM Product p1
);

-- 6
SELECT p.product_id, SUM(s.quantity_sold) AS units_sold, SUM(s.quantity_sold * p.unit_price) AS total_revenue, SUM(p.unit_cost * s.quantity_sold) AS total_cost, SUM(p.unit_price * s.quantity_sold) - SUM(p.unit_cost * s.quantity_sold) AS total_profit
FROM Product p
LEFT JOIN Sale s ON p.product_id = s.product_id
GROUP BY p.product_id;

-- 7
SELECT p.product_id, SUM((p.unit_price - p.unit_cost) * s.quantity_sold) AS profit
FROM Product p
LEFT JOIN Sale s ON s.product_id = p.product_id
GROUP BY p.product_id
ORDER BY profit DESC
LIMIT 3;

-- 8
SELECT *
FROM Product
ORDER BY LENGTH(product_name) DESC
LIMIT 1;

-- 9
SELECT *
FROM Product
ORDER BY LENGTH(product_name) ASC
LIMIT 1;

-- 10
SELECT *
FROM Product
WHERE product_name LIKE '% %';

-- 11
SELECT *
FROM Category
WHERE category_name LIKE 'E%';

-- 12
SELECT UPPER(p.product_name), LOWER(c.category_name)
FROM Product p
JOIN Category c ON p.category_id = c.category_id;
