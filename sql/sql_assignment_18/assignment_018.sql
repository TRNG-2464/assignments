SELECT Salesperson.salesperson_name, SUM(Product.unit_price * Sale.quantity) AS revenue
FROM Salesperson
JOIN Sale ON Salesperson.salesperson_id = Sale.salesperson_id
JOIN Product ON Sale.product_id = Product.product_id
GROUP BY Salesperson.salesperson_name
ORDER BY revenue DESC;

SELECT Product.product_name, SUM(Sale.quantity) AS total_quantity
FROM Product
JOIN Sale ON Product.product_id = Sale.product_id
GROUP BY Product.product_name
ORDER BY total_quantity DESC
LIMIT 1;

SELECT Product.product_name, 
SUM(Product.unit_price * Sale.quantity) AS revenue, 
SUM(Product.unit_cost * Sale.quantity) AS total_cost, 
SUM(Product.unit_price * Sale.quantity) - SUM(Product.unit_cost * Sale.quantity) AS profit
FROM Product
JOIN Sale ON Product.product_id = Sale.product_id
GROUP BY Product.product_name
ORDER BY profit DESC;

SELECT Product.product_name, Product.unit_price - Product.unit_cost AS margin
FROM Product
ORDER BY margin DESC
LIMIT 1;

WITH SalesRevenue AS(
    SELECT Region.region_name, Salesperson.salesperson_name, 
    SUM(Product.unit_price * Sale.quantity) AS revenue,
    ROW_NUMBER() OVER(
        PARTITION BY Region.region_name
        ORDER BY SUM(Product.unit_price * Sale.quantity) DESC
    ) AS rank
    FROM Region
    JOIN Salesperson ON Region.region_id = Salesperson.region_id
    JOIN Sale ON Salesperson.salesperson_id = Sale.salesperson_id
    JOIN Product ON Sale.product_id = Product.product_id
    GROUP BY Region.region_name, Salesperson.salesperson_name
)
SELECT region_name, salesperson_name, revenue
FROM SalesRevenue
WHERE rank = 1
ORDER BY revenue DESC;

WITH ProductSales AS (
    SELECT Region.region_name, Product.product_name, 
    SUM(Sale.quantity) AS total_units,
    ROW_NUMBER() OVER(
        PARTITION BY Region.region_name
        ORDER BY SUM(Sale.quantity) DESC
    ) AS rank
    FROM Region
    JOIN Salesperson ON Region.region_id = Salesperson.region_id
    JOIN Sale ON Salesperson.salesperson_id = Sale.salesperson_id
    JOIN Product ON Sale.product_id = Product.product_id
    GROUP BY Region.region_name, Product.product_name
)
SELECT region_name, product_name, total_units
FROM ProductSales
WHERE rank = 1
ORDER BY region_name;