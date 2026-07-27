-- Product & Sales Analysis

-- View used by queries 1, 4 and 5: per-unit profit margin for each product.
CREATE VIEW product_margin AS
SELECT product_id,
       product_name,
       unit_cost,
       unit_price,
       unit_price - unit_cost AS profit_margin
FROM Product;

-- View used by queries 6 and 7: sales totals per product.
CREATE VIEW product_sales AS
SELECT p.product_id,
       p.product_name,
       SUM(s.quantity_sold) AS total_units_sold,
       SUM(s.quantity_sold * p.unit_price) AS total_revenue,
       SUM(s.quantity_sold * p.unit_cost)  AS total_cost,
       SUM(s.quantity_sold * (p.unit_price - p.unit_cost)) AS total_profit
FROM Product p
JOIN Sale s ON s.product_id = p.product_id
GROUP BY p.product_id, p.product_name;

-- Arithmetic & Aggregate --

-- 1. Each product's name, unit cost, unit price, and per-unit profit margin.
SELECT product_name, unit_cost, unit_price, profit_margin
FROM product_margin;

-- 2. Total inventory value per category (cost of all stock on hand).
SELECT c.category_name,
       SUM(p.unit_cost * p.stock_quantity) AS total_inventory_value
FROM Category c
JOIN Product p ON p.category_id = c.category_id
GROUP BY c.category_id, c.category_name;

-- 3. Gross revenue potential per product (all remaining stock sold at price).
SELECT product_name,
       unit_price * stock_quantity AS gross_revenue_potential
FROM Product;

-- 4. Overall average profit margin across all products.
SELECT AVG(profit_margin) AS avg_profit_margin
FROM product_margin;

-- 5. Products whose per-unit margin exceeds the overall average margin.
SELECT product_name, profit_margin
FROM product_margin
WHERE profit_margin > (SELECT AVG(profit_margin) FROM product_margin);

-- 6. Total units sold, revenue, cost, and profit per product.
SELECT product_name, total_units_sold, total_revenue, total_cost, total_profit
FROM product_sales;

-- 7. Top 3 most profitable products by total profit from sales.
SELECT product_name, total_profit
FROM product_sales
ORDER BY total_profit DESC
LIMIT 3;

-- String Operations --

-- 8. The product with the longest name.
SELECT product_name, LENGTH(product_name) AS name_length
FROM Product
ORDER BY LENGTH(product_name) DESC
LIMIT 1;

-- 9. The product with the shortest name.
SELECT product_name, LENGTH(product_name) AS name_length
FROM Product
ORDER BY LENGTH(product_name) ASC
LIMIT 1;

-- 10. Products whose name contains more than one word (i.e. has a space).
SELECT product_name
FROM Product
WHERE product_name LIKE '% %';

-- 11. Categories whose name starts with the letter E.
SELECT category_name
FROM Category
WHERE category_name LIKE 'E%';

-- 12. Product names in uppercase alongside category names in lowercase.
SELECT UPPER(p.product_name) AS product_name,
       LOWER(c.category_name) AS category_name
FROM Product p
JOIN Category c ON c.category_id = p.category_id;
