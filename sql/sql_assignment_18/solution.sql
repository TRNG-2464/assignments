-- 1
SELECT salesperson_name, SUM(p.unit_price * s.quantity) AS revenue
FROM Salesperson sp
LEFT JOIN Sale s ON sp.salesperson_id = s.salesperson_id
LEFT JOIN Product p ON s.product_id = p.product_id
GROUP BY sp.salesperson_id
ORDER BY revenue DESC;

-- 2
SELECT p.product_name, SUM(s.quantity) AS units_sold
FROM Product p
LEFT JOIN Sale s ON p.product_id = s.product_id
GROUP BY p.product_id
ORDER BY units_sold DESC
LIMIT 1;

-- 3
SELECT p.product_name, SUM(p.unit_price * s.quantity) AS total_revenue,  SUM(p.unit_cost * s.quantity) AS total_cost, SUM(p.unit_price * s.quantity) - SUM(p.unit_cost * s.quantity) AS total_profit
FROM Product p
LEFT JOIN Sale s ON p.product_id = s.product_id
GROUP BY p.product_id;

-- 4
SELECT product_name, (unit_price - unit_cost) AS margin
FROM Product
ORDER BY margin DESC
LIMIT 1;

-- SG 1

