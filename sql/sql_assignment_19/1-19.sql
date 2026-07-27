CREATE OR REPLACE VIEW gross_values AS 
SELECT p.product_name, (p.unit_price * p.stock_quantity) AS gross_revenue, 
	   (p.unit_cost * p.stock_quantity) AS gross_cost, p.product_id
FROM product p;

SELECT * FROM gross_values;

CREATE OR REPLACE VIEW sales_values AS 
SELECT p.product_id,
	   SUM(s.quantity_sold) AS total_units_sold, 
	   SUM(s.quantity_sold) * p.unit_price  AS total_revenue_sales, 
	   SUM(s.quantity_sold) * p.unit_cost AS total_cost_sales,
	   (SUM(s.quantity_sold) * p.unit_price) - (SUM(s.quantity_sold) * p.unit_cost) AS total_profit_sales
FROM product p
JOIN sale s ON p.product_id = s.product_id 
GROUP BY p.product_id, s.product_id, p.unit_price, p.unit_cost
ORDER BY p.product_id ASC;

SELECT * FROM sales_values;

-- 1. Return each product's name, unit cost, unit price, and per-unit profit margin.

SELECT product_name, unit_cost, unit_price, (unit_price - unit_cost) AS profit_margin
FROM product;


-- 2. Return the total inventory value per category — that is, the total cost of all 
--    stock currently on hand across all products in each category.

SELECT p.category_id, SUM(p.stock_quantity) AS total_category_inventory 
FROM product p 
JOIN category c ON p.category_id = c.category_id
GROUP BY p.category_id
ORDER BY p.category_id ASC;

-- 3. Return the gross revenue potential per product — the revenue that would be 
--    generated if all remaining stock were sold at the current unit price.

SELECT product_name, gross_revenue
FROM gross_values;

-- 4. Return the overall average profit margin across all products.

SELECT (SUM(gross_revenue) - SUM(gross_cost)) / COUNT(product_name) AS avg_profit_margin
FROM gross_values;

-- 5. Return all products whose per-unit profit margin exceeds the overall average 
--    profit margin.

SELECT p.product_name 
FROM product p 
WHERE (p.unit_price - p.unit_cost) * p.stock_quantity > 
	(SELECT (SUM(gross_revenue) - SUM(gross_cost)) / COUNT(product_name) FROM gross_values);

-- 6. Return the total units sold, total revenue, total cost, and total profit per 
--    product across all sales.

SELECT total_units_sold, total_revenue_sales, total_cost_sales, total_profit_sales 
FROM sales_values;

-- 7. Return the top 3 most profitable products by total profit generated from sales.

SELECT p.product_name, sv.total_profit_sales 
FROM product p 
JOIN sales_values sv ON p.product_id = sv.product_id 
ORDER BY sv.total_profit_sales DESC
LIMIT 3;

-- 8. Return the product with the longest name.
SELECT product_id, product_name, LENGTH(product_name) AS name_length
FROM product
ORDER BY LENGTH(product_name) DESC
LIMIT 1;

-- 9. Return the product with the shortest name.
SELECT product_id, product_name, LENGTH(product_name) AS name_length
FROM product
ORDER BY LENGTH(product_name) ASC
LIMIT 1;

-- 10. Return all products whose name contains more than one word. ("more than one word" means the product name contains a space)
SELECT product_id, product_name
FROM product 
WHERE product_name LIKE '% %';

-- 11. Return all categories whose name starts with the letter E.
SELECT category_id, category_name
FROM category 
WHERE category_name LIKE 'E%';

-- 12. Return each product name in uppercase alongside its category name in lowercase.

SELECT 
    UPPER(p.product_name) AS product_name_upper,
    LOWER(c.category_name) AS category_name_lower
FROM product p
JOIN category c ON p.category_id = c.category_id
ORDER BY p.product_id;