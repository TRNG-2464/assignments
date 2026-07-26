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

-- TODO: Look into window functions

-- SG 1
CREATE VIEW v_salesperson_revenue AS
SELECT sp.salesperson_id, sp.salesperson_name, SUM(p.unit_price * s.quantity) AS revenue, sp.region_id
FROM Salesperson sp
JOIN Sale s ON sp.salesperson_id = s.salesperson_id
JOIN Product p ON s.product_id = p.product_id
GROUP BY sp.salesperson_id;

CREATE VIEW v_max_region_revenue AS
SELECT r.region_id, MAX(revenue) AS max_revenue
FROM Region r
JOIN v_salesperson_revenue sr ON sr.region_id =  r.region_id
GROUP BY r.region_id;

SELECT r.region_name, sr.salesperson_name, mr.max_revenue
FROM v_salesperson_revenue sr
JOIN Region r ON sr.region_id = r.region_id
JOIN v_max_region_revenue mr ON r.region_id = mr.region_id
WHERE mr.max_revenue = sr.revenue;

-- SG 2
CREATE VIEW v_units_sold AS
SELECT r.region_id, p.product_id, SUM(s.quantity) AS total_units
FROM Region r
JOIN Salesperson sp ON r.region_id = sp.region_id
JOIN Sale s ON sp.salesperson_id = s.salesperson_id
JOIN Product p ON s.product_id = p.product_id
GROUP BY r.region_id, p.product_id;

CREATE VIEW v_max_sold AS
SELECT us.region_id, MAX(us.total_units) AS max_units
FROM v_units_sold us
GROUP BY us.region_id;

SELECT us.region_id, p.product_name, ms.max_units
FROM v_units_sold us
JOIN Product p ON us.product_id = p.product_id
JOIN v_max_sold ms ON us.region_id = ms.region_id
WHERE us.total_units = ms.max_units;
