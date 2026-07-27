--Anmoldeep Solution 19

--1
SELECT product_name,unit_cost,unit_price,(unit_price - unit_cost) AS profit_margin
FROM Product;

--2
SELECT c.category_name,SUM(p.stock_quantity * p.unit_cost) AS total_inventory_value
FROM Category c
JOIN Product p
ON c.category_id = p.category_id
GROUP BY c.category_name;

--3
SELECT
    product_name,
    (stock_quantity * unit_price) AS gross_revenue_potential
FROM Product;

--4
SELECT 
    AVG(unit_price - unit_cost) AS average_profit_margin
FROM Product;

--5
SELECT product_name,(unit_price - unit_cost) AS profit_margin
FROM Product
WHERE (unit_price - unit_cost) >
(
    SELECT AVG(unit_price - unit_cost)
    FROM Product
);

--6
SELECT p.product_name,
    SUM(s.quantity_sold) AS total_units_sold,
    SUM(s.quantity_sold * p.unit_price) AS total_revenue,
    SUM(s.quantity_sold * p.unit_cost) AS total_cost,
    SUM(s.quantity_sold * (p.unit_price - p.unit_cost)) AS total_profit
FROM Product p
JOIN Sale s
ON p.product_id = s.product_id
GROUP BY p.product_name;

--7 
SELECT p.product_name,
    SUM(s.quantity_sold * (p.unit_price - p.unit_cost)) AS total_profit
FROM Product p
JOIN Sale s
ON p.product_id = s.product_id
GROUP BY p.product_name
ORDER BY total_profit DESC
LIMIT 3;

--8
SELECT product_name
FROM Product
ORDER BY LENGTH(product_name) DESC
LIMIT 1;

--9
SELECT product_name
FROM Product
ORDER BY LENGTH(product_name)
LIMIT 1;

--10
SELECT product_name
FROM Product
WHERE product_name LIKE '% %';

--11
SELECT category_name
FROM Category
WHERE category_name LIKE 'E%';

--12
SELECT
    UPPER(p.product_name) AS product_name_upper,
    LOWER(c.category_name) AS category_name_lower
FROM Product p
JOIN Category c
ON p.category_id = c.category_id;


