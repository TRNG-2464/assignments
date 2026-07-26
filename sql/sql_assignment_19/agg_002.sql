-- Arithmetic & Aggregate

-- Return each product's name, unit cost, unit price, and per-unit profit margin.
SELECT product_name, unit_cost, unit_price, unit_price - unit_cost FROM Product;
-- Return the total inventory value per category — that is, the total cost of all stock currently on hand across all products in each category.
SELECT category_id, SUM(stock_quantity*unit_cost) FROM Product GROUP BY category_id;

-- Return the gross revenue potential per product — the revenue that would be generated if all remaining stock were sold at the current unit price.
SELECT product_id, stock_quantity*unit_price FROM Product;

-- Return the overall average profit margin across all products.
SELECT AVG(unit_price-unit_cost) FROM Product;

-- Return all products whose per-unit profit margin exceeds the overall average profit margin.
SELECT product_id FROM Product WHERE unit_price-unit_cost > (SELECT AVG(unit_price-unit_cost) FROM Product);

-- Return the total units sold, total revenue, total cost, and total profit per product across all sales.
SELECT 
p.product_name,
SUM(s.quantity_sold) AS total_units, 
SUM(s.quantity_sold*p.unit_price) AS total_revenue, 
SUM(s.quantity_sold*p.unit_cost) AS total_cost, 
SUM(s.quantity_sold*p.unit_price) -  SUM(s.quantity_sold*p.unit_cost) AS total_profit
FROM Sale s JOIN Product p ON s.product_id=p.product_id GROUP BY p.product_id;

-- Return the top 3 most profitable products by total profit generated from sales.
SELECT p.product_name, SUM(s.quantity_sold*p.unit_price) -  SUM(s.quantity_sold*p.unit_cost) AS total_profit
FROM Sale s JOIN Product p ON s.product_id=p.product_id GROUP BY p.product_id ORDER BY total_profit DESC LIMIT 3;

-- String Operations:

-- Return the product with the longest name.
SELECT product_name FROM Product ORDER BY LENGTH(product_name) DESC LIMIT 1;

-- Return the product with the shortest name.
SELECT product_name FROM Product ORDER BY LENGTH(product_name) ASC LIMIT 1;

-- Return all products whose name contains more than one word. ("more than one word" means the product name contains a space)
SELECT product_name FROM Product WHERE product_name LIKE '% %';

-- Return all categories whose name starts with the letter E.
SELECT category_name FROM Category WHERE category_name LIKE 'E%';

-- Return each product name in uppercase alongside its category name in lowercase.
SELECT UPPER(p.product_name), LOWER(c.category_name) FROM Product p JOIN Category c ON p.category_id=c.category_id;
-- Adding a WHERE p.category_id=c.category_id would be redundant since it's the same as ON here.