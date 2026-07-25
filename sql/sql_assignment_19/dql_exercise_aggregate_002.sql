/*
**Arithmetic & Aggregate**

1. Return each product's name, unit cost, unit price, and per-unit profit margin.

2. Return the total inventory value per category — that is, the total cost of all stock currently on hand across all products in each category.

3. Return the gross revenue potential per product — the revenue that would be generated if all remaining stock were sold at the current unit price.

4. Return the overall average profit margin across all products.

5. Return all products whose per-unit profit margin exceeds the overall average profit margin.

6. Return the total units sold, total revenue, total cost, and total profit per product across all sales.

7. Return the top 3 most profitable products by total profit generated from sales.
*/

-- 1
SELECT product_name, unit_cost, unit_price, unit_price - unit_cost AS per_unit_profit_margin FROM Product;

-- 2 
SELECT c.category_name, SUM(p.stock_quantity * unit cost) AS total_inventory_value
FROM Category c
INNER JOIN Product p on c.category_id = p.category_id
GROUP BY c.category_name;

--3
SELECT c.category_name, SUM(p.stock_quantity * unit price) AS gross_revenue_potential
FROM Category c
INNER JOIN Product p on c.category_id = p.category_id
GROUP BY c.category_name;

-- 4 
SELECT product_name, AVG(unit_price - unit_cost) AS overall_average_profit_margin FROM Product;

-- 5
SELECT product_name FROM Product
WHERE unit_price - unit_cost > (AVG(unit_price-unit_cost));

-- 6 
SELECT SUM(s.quantity_sold) AS total_units_sold, 
SUM(s.quantity_sold * p.unit_price) AS total_revenue,
SUM(s.quantity_sold * p.unit_cost) AS total_cost,
total_revenue - total_cost AS total_profit,
FROM Product p
INNER JOIN Sale s on p.product_id = s.product_id
GROUP BY product_id;

-- 7
SELECT SUM(s.quantity_sold) AS total_units_sold,
SUM(s.quantity_sold * p.unit_price) - SUM(s.quantity_sold * p.unit_cost) AS total_profit,
FROM Product p
INNER JOIN Sale s on p.product_id = s.product_id
GROUP BY product_id
ORDER BY total_profit DESC LIMIT 3;

/*
**String Operations**

8. Return the product with the longest name. 

9. Return the product with the shortest name.

10. Return all products whose name contains more than one word. ("more than one word" means the product name contains a space)

11. Return all categories whose name starts with the letter `E`.

12. Return each product name in uppercase alongside its category name in lowercase.
*/

-- 8 
SELECT product_name
FROM Product
ORDER BY LENGTH(product_name) DESC
LIMIT 1;

-- 9
SELECT product_name
FROM PRODUCT 
ORDER BY LENGTH(product_name)
LIMIT 1;

-- 10
SELECT * FROM Product WHERE Like '% %';

--11
SELECT * FROM Category WHERE Like 'E%';

--12
SELECT LOWER(p.product_name), UPPER(c.category_name)
FROM Product p
INNER JOIN Category c ON p.category_id = c.category_id;
