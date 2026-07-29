SELECT Salesperson.salesperson_name, Sale.quantity * Product.unit_price AS revenue
FROM Salesperson JOIN Sale ON Salesperson.salesperson_id = Sale.salesperson_id
JOIN Product ON Sale.product_id = Product.product_id ORDER BY revenue DESC;

SELECT Product.product_name FROM Product JOIN Sale ON Product.product_id = Sale.product_id
GROUP BY Product.product_id, Product.product_name ORDER BY SUM(Sale.quantity) DESC
LIMIT 1;

SELECT Product.product_name, SUM(Sale.quantity * Product.unit_price) AS Revenue,
SUM(Sale.quantity * Product.unit_cost) AS total_cost, SUM((Sale.quantity * Product.unit_price) - (Sale.quantity * Product.unit_cost)) AS Total_Profit
FROM Product JOIN Sale ON Product.product_id = Sale.product_id
GROUP BY Product.product_id, Product.product_name;

SELECT product_name, unit_price-unit_cost AS Margin FROM Product ORDER BY margin DESC LIMIT 1;

SELECT Region.region_name, Salesperson.salesperson_name, SUM(Sale.quantity *Product.unit_price) AS revenue
FROM Region JOIN Salesperson ON Region.region_id = Salesperson.region_id 
JOIN Sale ON Salesperson.salesperson_id = Sale.salesperson_id JOIN Product ON Sale.product_id = Product.product_id 
GROUP BY Region.region_name, Salesperson.salesperson_name
ORDER BY Region.region_name, revenue DESC;

SELECT region_name,
       product_name,
       total_units
FROM (
    SELECT Region.region_name,
           Product.product_name,
           SUM(Sale.quantity) AS total_units,
           RANK() OVER (
               PARTITION BY Region.region_name 
               ORDER BY SUM(Sale.quantity) DESC
           ) AS ranking
    FROM Region
    JOIN Salesperson
    ON Region.region_id = Salesperson.region_id
JOIN Sale
    ON Salesperson.salesperson_id = Sale.salesperson_id
    JOIN Product 
        ON Sale.product_id = Product.product_id
    GROUP BY Region.region_name, Product.product_name
) AS ranked_products
WHERE ranking = 1;
