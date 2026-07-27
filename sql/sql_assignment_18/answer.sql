-- Question 1
SELECT
    sp.salesperson_name,
    SUM(s.quantity * p.unit_price) AS total_revenue
FROM Salesperson sp
JOIN Sale s
    ON sp.salesperson_id = s.salesperson_id
JOIN Product p
    ON s.product_id = p.product_id
GROUP BY sp.salesperson_name
ORDER BY total_revenue DESC;


--Question 2
SELECT
    p.product_name,
    SUM(s.quantity) AS total_units_sold
FROM Product p
JOIN Sale s
    ON p.product_id = s.product_id
GROUP BY p.product_name
ORDER BY total_units_sold DESC
LIMIT 1;


--Question 3
SELECT
    p.product_name,
    SUM(s.quantity * p.unit_price) AS total_revenue,
    SUM(s.quantity * p.unit_cost) AS total_cost,
    SUM(s.quantity * (p.unit_price - p.unit_cost)) AS total_profit
FROM Product p
JOIN Sale s
    ON p.product_id = s.product_id
GROUP BY p.product_name
ORDER BY total_profit DESC;


--Question 4
SELECT
    product_name,
    (unit_price - unit_cost) AS unit_margin
FROM Product
ORDER BY unit_margin DESC
LIMIT 1;


--Stretch Goal 1
SELECT
    region_name,
    salesperson_name,
    total_revenue
FROM (
    SELECT
        r.region_name,
        sp.salesperson_name,
        SUM(s.quantity * p.unit_price) AS total_revenue
    FROM Region r
    JOIN Salesperson sp
        ON r.region_id = sp.region_id
    JOIN Sale s
        ON sp.salesperson_id = s.salesperson_id
    JOIN Product p
        ON s.product_id = p.product_id
    GROUP BY
        r.region_name,
        sp.salesperson_name
) AS SalespersonTotals
WHERE total_revenue = (
    SELECT MAX(total_revenue)
    FROM (
        SELECT
            r2.region_id,
            sp2.salesperson_id,
            SUM(s2.quantity * p2.unit_price) AS total_revenue
        FROM Region r2
        JOIN Salesperson sp2
            ON r2.region_id = sp2.region_id
        JOIN Sale s2
            ON sp2.salesperson_id = s2.salesperson_id
        JOIN Product p2
            ON s2.product_id = p2.product_id
        GROUP BY
            r2.region_id,
            sp2.salesperson_id
    ) AS RegionSales
    WHERE RegionSales.region_id = (
        SELECT region_id
        FROM Region
        WHERE region_name = SalespersonTotals.region_name
    )
);

--Stretch Goal 2
SELECT
    region_name,
    product_name,
    total_units_sold
FROM (
    SELECT
        r.region_name,
        p.product_name,
        SUM(s.quantity) AS total_units_sold
    FROM Region r
    JOIN Salesperson sp
        ON r.region_id = sp.region_id
    JOIN Sale s
        ON sp.salesperson_id = s.salesperson_id
    JOIN Product p
        ON s.product_id = p.product_id
    GROUP BY
        r.region_name,
        p.product_name
) AS ProductTotals
WHERE total_units_sold = (
    SELECT MAX(total_units_sold)
    FROM (
        SELECT
            r2.region_name,
            p2.product_name,
            SUM(s2.quantity) AS total_units_sold
        FROM Region r2
        JOIN Salesperson sp2
            ON r2.region_id = sp2.region_id
        JOIN Sale s2
            ON sp2.salesperson_id = s2.salesperson_id
        JOIN Product p2
            ON s2.product_id = p2.product_id
        GROUP BY
            r2.region_name,
            p2.product_name
    ) AS RegionProducts
    WHERE RegionProducts.region_name = ProductTotals.region_name
);