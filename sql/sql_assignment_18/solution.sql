-- Query 1
SELECT Salesperson.salesperson_name, SUM(Sale.quantity * Product.unit_price) AS total_revenue FROM Salesperson 
    INNER JOIN Sale ON Salesperson.salesperson_id = Sale.salesperson_id 
    INNER JOIN Product ON Sale.product_id = Product.product_id 
    GROUP BY Salesperson.salesperson_id ORDER BY total_revenue DESC;

-- Query 2
SELECT Product.product_name, SUM(Sale.quantity) AS total_sold FROM Product
    INNER JOIN Sale ON Product.product_id = Sale.product_id 
    GROUP BY Product.product_id ORDER BY total_sold DESC LIMIT 1;

-- Query 3
SELECT Product.product_name, SUM(Sale.quantity * Product.unit_price) AS total_revenue,
    SUM(Sale.quantity * Product.unit_cost) AS total_cost, 
    SUM(Sale.quantity * (Product.unit_price - Product.unit_cost)) AS total_profit FROM Product
    INNER JOIN Sale ON Product.product_id = Sale.product_id
    GROUP BY Product.product_id;

-- Query 4
SELECT Product.product_name, (Product.unit_price - Product.unit_cost) AS margin FROM Product ORDER BY margin DESC LIMIT 1;

-- Stretch Goal 1
SELECT DISTINCT ON (Region.region_id) Region.region_name, Salesperson.salesperson_name, SUM(Sale.quantity * Product.unit_price) AS total_revenue FROM Region
    INNER JOIN Salesperson ON Region.region_id = Salesperson.region_id
    INNER JOIN Sale ON Salesperson.salesperson_id = Sale.salesperson_id
    INNER JOIN Product ON Sale.product_id = Product.product_id
    GROUP BY Region.region_id, Salesperson.salesperson_id ORDER BY Region.region_id, total_revenue DESC;

-- Stretch Goal 2. Is this significantly more challenging than Stretch Goal 1? It's basically the same thing, just counting up a different value.
-- if there's a simpler solution for Stretch Goal 1, I'd like to see it.

SELECT DISTINCT ON (Region.region_id) Region.region_name, Product.product_name, SUM(Sale.quantity) AS total_sold FROM Region
    INNER JOIN Salesperson ON Region.region_id = Salesperson.region_id
    INNER JOIN Sale ON Salesperson.salesperson_id = Sale.salesperson_id
    INNER JOIN Product ON Sale.product_id = Product.product_id
    GROUP BY Region.region_id, Product.product_id ORDER BY Region.region_id, total_sold DESC;