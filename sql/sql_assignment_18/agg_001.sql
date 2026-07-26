-- Return each salesperson's name alongside their total revenue generated, ordered from highest to lowest. (Hint: revenue = quantity × unit_price)

SELECT sp.salesperson_name, SUM(s.quantity * p.unit_price) AS total_revenue
FROM Salesperson sp
JOIN Sale s ON sp.salesperson_id = s.salesperson_id JOIN Product p ON s.product_id = p.product_id
GROUP BY sp.salesperson_id
ORDER BY total_revenue DESC;

-- Return the top selling product overall by total units sold.
SELECT p.product_name FROM Product p JOIN Sale s ON p.product_id=s.product_id GROUP BY p.product_id ORDER BY SUM(s.quantity) Desc limit 1;
-- Doesn't work bc we have to consider that a product can have multiple salespersons. therefore we need to group by product_id and sum the quantity sold by each salesperson taking the sum of the products
-- SELECT p.product_name FROM Product p JOIN Sale s ON p.id=s.id ORDER BY s.quantity Desc limit 1



-- For each product, return its name alongside its total revenue, total cost, and total profit. (Hint: profit = revenue - cost)
SELECT p.product_name, SUM(s.quantity*p.unit_price) AS revenue, SUM(s.quantity*p.unit_cost) AS cost, SUM(s.quantity*p.unit_price) - SUM(s.quantity*p.unit_cost) AS profit FROM
Product p JOIN Sale s ON s.product_id=p.product_id
GROUP BY p.product_id;

-- This doesn't work because you can’t use the aliases revenue and cost in the same SELECT.
-- SELECT p.product_name, SUM(s.quantity*p.unit_price) AS revenue, SUM(s.quantity*p.unit_cost) AS cost, SUM(revenue - cost) AS profit FROM
-- Product p JOIN Sale s ON s.product_id=p.product_id
-- GROUP BY p.product_id;

-- Return the single highest margin product. Margin should be calculated at the per-unit level. (Hint: margin = unit_price - unit_cost)
SELECT product_name FROM Product ORDER BY (unit_price - unit_cost) DESC LIMIT 1;