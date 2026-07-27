-- 1.
SELECT product_name, unit_price, unit_cost, (unit_price - unit_cost) AS margin
FROM Product

-- 2.
SELECT c.category_name, SUM(p.unit_cost * p.stock_quantity) AS total_stock_cost
FROM Category AS c
JOIN Product AS p ON c.category_id = p.category_id
GROUP BY c.category_id, c.category_name

-- 3. 
SELECT product_name, (unit_price * stock_quantity) AS potential_total_revenue
FROM Product;

-- 4. 
SELECT AVG(unit_price - unit_cost) AS avg_profit_margin
FROM Product;

-- 5.
SELECT product_name, (unit_price - unit_cost) AS avg_profit_margin
FROM Product
WHERE (unit_price - unit_cost) > (
	SELECT AVG(unit_price - unit_cost) AS avg_profit_margin
	FROM Product
);

-- 6.
CREATE VIEW ProductSaleTotal AS
SELECT p.product_name,
	SUM(s.quantity_sold) AS total_units_sold,
	SUM(p.unit_price * s.quantity_sold) AS total_revenue, 
	SUM(p.unit_cost * s.quantity_sold) AS total_cost,
	SUM((p.unit_price - p.unit_cost) * s.quantity_sold) AS total_profit
FROM Product AS p
JOIN Sale AS s ON p.product_id = s.product_id
GROUP BY p.product_id, p.product_name

-- 7. 
SELECT * FROM ProductSaleTotal
ORDER BY total_profit DESC
LIMIT 3

-- 8.
SELECT product_name
FROM Product
WHERE LENGTH(product_name) = (
	SELECT MAX(LENGTH(product_name))
	FROM Product
)

-- 9.
SELECT product_name
FROM Product
WHERE LENGTH(product_name) = (
	SELECT MIN(LENGTH(product_name))
	FROM Product
)

-- 10.
SELECT product_name
FROM Product
WHERE product_name LIKE '% %';

-- 11.
SELECT category_name
FROM Category
WHERE category_name LIKE 'E%';

-- 12.
SELECT UPPER(p.product_name), LOWER(c.category_name)
FROM Product AS p
JOIN Category AS c ON p.category_id = c.category_id