-- 1.
SELECT sp.salesperson_name, SUM(s.quantity * p.unit_price) AS total_revenue
FROM Salesperson AS sp
JOIN Sale AS s ON sp.salesperson_id = s.salesperson_id
JOIN Product AS p ON s.product_id = p.product_id
GROUP BY sp.salesperson_id, sp.salesperson_name
ORDER BY total_revenue DESC;

-- 2.
SELECT product_name, total_units_sold
FROM (
	SELECT p.product_name, SUM(s.quantity) AS total_units_sold
	FROM Sale AS s
	JOIN Product AS p ON s.product_id = p.product_id
	GROUP BY p.product_id, p.product_name
) AS grouped_total_units_sold_a
WHERE total_units_sold = (
	SELECT MAX(total_units_sold)
	FROM (
		SELECT p.product_name, SUM(s.quantity) AS total_units_sold
		FROM Sale AS s
		JOIN Product AS p ON s.product_id = p.product_id
		GROUP BY p.product_id, p.product_name
	) AS grouped_total_units_sold_b
)

-- 3.
SELECT 
	p.product_name,
	SUM(s.quantity * p.unit_price) AS total_revenue,
	SUM(s.quantity * p.unit_cost) AS total_cost,
	(SUM(s.quantity * p.unit_price) - SUM(s.quantity * p.unit_cost)) AS total_profit
FROM Product AS p
JOIN Sale AS s ON p.product_id = s.product_id
GROUP BY p.product_id, p.product_name


-- 4.
SELECT product_name, unit_price, unit_cost, (unit_price - unit_cost) AS margin
FROM Product
WHERE (unit_price - unit_cost) = (
	SELECT MAX(unit_price - unit_cost) as highest_margin
	FROM Product
);
