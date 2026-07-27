-- Sales & Inventory Analysis

-- 1. Each salesperson's name and total revenue, highest to lowest.
SELECT sp.salesperson_name,
       SUM(s.quantity * p.unit_price) AS total_revenue
FROM Salesperson sp
JOIN Sale s ON s.salesperson_id = sp.salesperson_id
JOIN Product p ON p.product_id = s.product_id
GROUP BY sp.salesperson_id, sp.salesperson_name
ORDER BY total_revenue DESC;

-- 2. Top selling product overall by total units sold.
SELECT p.product_name,
       SUM(s.quantity) AS total_units_sold
FROM Product p
JOIN Sale s ON s.product_id = p.product_id
GROUP BY p.product_id, p.product_name
ORDER BY total_units_sold DESC
LIMIT 1;

-- 3. Per product: total revenue, total cost, and total profit.
SELECT p.product_name,
       SUM(s.quantity * p.unit_price) AS total_revenue,
       SUM(s.quantity * p.unit_cost)  AS total_cost,
       SUM(s.quantity * (p.unit_price - p.unit_cost)) AS total_profit
FROM Product p
JOIN Sale s ON s.product_id = p.product_id
GROUP BY p.product_id, p.product_name
ORDER BY total_profit DESC;

-- 4. The single highest margin product (per-unit margin).
SELECT product_name,
       unit_price - unit_cost AS margin
FROM Product
ORDER BY margin DESC
LIMIT 1;

-- Top revenue salesperson within each region.
-- A ranked CTE keeps the per-region totals and picks rank 1 in each region.
WITH region_revenue AS (
    SELECT r.region_name,
           sp.salesperson_name,
           SUM(s.quantity * p.unit_price) AS total_revenue,
           RANK() OVER (
               PARTITION BY r.region_id
               ORDER BY SUM(s.quantity * p.unit_price) DESC
           ) AS revenue_rank
    FROM Region r
    JOIN Salesperson sp ON sp.region_id = r.region_id
    JOIN Sale s ON s.salesperson_id = sp.salesperson_id
    JOIN Product p ON p.product_id = s.product_id
    GROUP BY r.region_id, r.region_name, sp.salesperson_id, sp.salesperson_name
)
SELECT region_name, salesperson_name, total_revenue
FROM region_revenue
WHERE revenue_rank = 1
ORDER BY region_name;

-- Top selling product in each region by total units sold.
WITH region_product_units AS (
    SELECT r.region_name,
           p.product_name,
           SUM(s.quantity) AS total_units_sold,
           RANK() OVER (
               PARTITION BY r.region_id
               ORDER BY SUM(s.quantity) DESC
           ) AS units_rank
    FROM Region r
    JOIN Salesperson sp ON sp.region_id = r.region_id
    JOIN Sale s ON s.salesperson_id = sp.salesperson_id
    JOIN Product p ON p.product_id = s.product_id
    GROUP BY r.region_id, r.region_name, p.product_id, p.product_name
)
SELECT region_name, product_name, total_units_sold
FROM region_product_units
WHERE units_rank = 1
ORDER BY region_name;
