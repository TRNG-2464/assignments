-- 1. Return each salesperson's name alongside their total revenue generated, ordered from highest to lowest. *(Hint: revenue = quantity × unit_price)*

SELECT sp.salesperson_name, SUM(p.unit_price * s.quantity) AS total_revenue
FROM Salesperson sp
INNER JOIN Sale s ON sp.salesperson_id = s.salesperson_id
INNER JOIN Product p ON s.product_id  = p.product_id
GROUP BY sp.salesperson_id
ORDER BY total_revenue DESC;


-- 2. Return the top selling product overall by total units sold.
SELECT p.product_name, SUM(s.quantity) as units_sold
FROM Sale s
INNER JOIN Product p ON s.product_id = p.product_id
GROUP BY p.product_id
ORDER BY units_sold DESC
LIMIT 1;

-- 3. For each product, return its name alongside its total revenue, total cost, and total profit. *(Hint: profit = revenue - cost)*
SELECT p.product_name,
SUM (p.unit_price  * s.quantity) AS total_revenue, 
SUM (p.unit_cost * s.quantity )AS total_cost, 
SUM (s.quantity * (p.unit_price - p.unit_cost)) AS total_profit
FROM Product p
INNER JOIN Sale s ON p.product_id = s.product_id
GROUP BY p.product_name;

--4. Return the single highest margin product. Margin should be calculated at the per-unit level. *(Hint: margin = unit_price - unit_cost)*
SELECT product_name as "Highest Margin Product" FROM Product
WHERE unit_price - unit_cost = (SELECT MAX(unit_price - unit_cost) FROM Product);

-- **Stretch Goal 1:** Return the salesperson who generated the most revenue within each region. Your result should show the region name, the salesperson's name, and their total revenue for that region.
SELECT region_name, salesperson_name, total_revenue
FROM
(SELECT r.region_name,
 sp.salesperson_name,
 SUM(p.unit_price * s.quantity) AS total_revenue,
 RANK() OVER(
    PARTITION BY r.region_id
    ORDER BY SUM(p.unit_price * s.quantity) DESC
 ) AS ranking
FROM Region r
INNER JOIN Salesperson sp ON r.region_id = sp.region_id
INNER JOIN Sale s ON sp.salesperson_id = s.salesperson_id
INNER JOIN Product p ON s.product_id = p.product_id
GROUP BY r.region_id, sp.salesperson_id) AS ranked_salespeople
WHERE ranking = 1;

-- **Stretch Goal 2 *(Advanced)*:** Return the top selling product in each region by total units sold. *Note: this is significantly more challenging than the questions above and may require a subquery or window function.*
SELECT region_name, product_name, total_units_sold 
FROM
(SELECT r.region_name, p.product_name, SUM(s.quantity) AS total_units_sold,
RANK() OVER(
    PARTITION BY r.region_id
    ORDER BY SUM(s.quantity) DESC
) AS ranking
FROM Region r
INNER JOIN Salesperson sp ON r.region_id = sp.region_id 
INNER JOIN Sale s ON sp.salesperson_id = s.salesperson_id
INNER JOIN Product p ON s.product_id = p.product_id
GROUP BY r.region_id, p.product_id) AS ranked_products
WHERE ranking = 1;