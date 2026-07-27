--Anmoldeep Solution 18

/*
* Return each salesperson's name alongside their total revenue generated, ordered from highest to lowest. 
* (Hint: revenue = quantity × unit_price)
*/
SELECT sp.salesperson_name, SUM(s.quantity * p.unit_price) AS total_revenue
FROM Salesperson sp
JOIN Sale s
ON sp.salesperson_id = s.salesperson_id
JOIN Product p
ON s.product_id = p.product_id
GROUP BY sp.salesperson_name
ORDER BY total_revenue DESC;

--Return the top selling product overall by total units sold.
SELECT p.product_name,SUM(s.quantity) AS total_units_sold
FROM Product p
JOIN Sale s
ON p.product_id = s.product_id
GROUP BY p.product_name
ORDER BY total_units_sold DESC
LIMIT 1;

--For each product, return its name alongside its total revenue, total cost, and total profit. (Hint: profit = revenue - cost)
SELECT
    p.product_name,
    SUM(s.quantity * p.unit_price) AS total_revenue,
    SUM(s.quantity * p.unit_cost) AS total_cost,
    SUM(s.quantity * (p.unit_price - p.unit_cost)) AS total_profit
FROM Product p
JOIN Sale s
ON p.product_id = s.product_id
GROUP BY p.product_name;

--Return the single highest margin product. Margin should be calculated at the per-unit level. (Hint: margin = unit_price - unit_cost)
SELECT product_name,(unit_price - unit_cost) AS margin
FROM Product
ORDER BY margin DESC
LIMIT 1;

--Stretch Goal1
SELECT region_name,salesperson_name,total_revenue
FROM (
    SELECT
        r.region_name,sp.salesperson_name,
        SUM(s.quantity * p.unit_price) AS total_revenue,
        RANK() OVER (
            PARTITION BY r.region_name 
            ORDER BY SUM(s.quantity * p.unit_price) DESC
        ) AS ranking
    FROM Region r
    JOIN Salesperson sp
    ON r.region_id = sp.region_id
    JOIN Sale s
    ON sp.salesperson_id = s.salesperson_id
    JOIN Product p
    ON s.product_id = p.product_id
    GROUP BY r.region_name, sp.salesperson_name
) ranked_sales
WHERE ranking = 1;

