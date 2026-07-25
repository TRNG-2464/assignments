-- 1. Return each salesperson's name alongside their total revenue generated, 
-- ordered from highest to lowest. (Hint: revenue = quantity × unit_price)

SELECT sp.salesperson_name, SUM(s.quantity * p.unit_price) AS revenue
FROM salesperson sp 
JOIN sale s ON sp.salesperson_id = s.salesperson_id 
JOIN product p ON s.product_id = p.product_id
GROUP BY sp.salesperson_name
ORDER BY revenue DESC;


-- 2. Return the top selling product overall by total units sold.

SELECT p.product_name, SUM(s.quantity) 
FROM sale s 
JOIN product p ON s.product_id = p.product_id
GROUP BY p.product_id, p.product_name  
ORDER BY p.product_name ASC;


-- 3. For each product, return its name alongside its total revenue, 
-- total cost, and total profit. (Hint: profit = revenue - cost)

SELECT p.product_name, SUM(s.quantity * p.unit_price) AS total_revenue, 
	   SUM(p.unit_cost * s.quantity) AS total_cost, 
	   SUM((s.quantity * p.unit_price) - (p.unit_cost * s.quantity)) AS total_profit 
FROM sale s 
JOIN product p ON s.product_id = p.product_id
GROUP BY p.product_id, p.product_name  
ORDER BY p.product_name ASC;


-- 4. Return the single highest margin product. Margin should be calculated 
-- at the per-unit level. (Hint: margin = unit_price - unit_cost)

SELECT product_name 
FROM product
WHERE unit_price - unit_cost = (
	SELECT MAX(unit_price - unit_cost) AS highest_margin FROM Product
);