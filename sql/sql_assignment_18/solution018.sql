-- Solution 1

-- Aliasing the revenue formula in the SELECT query
-- GROUP BY salesperson, the ORDER BY revenue

SELECT Salesperson.salesperson_name, SUM(Product.unit_price * Sale.quantity) AS revenue
FROM Salesperson INNER JOIN Sale ON Salesperson.salesperson_id = Sale.salesperson_id INNER JOIN Product ON Sale.product_id = Product.product_id
GROUP BY Salesperson.salesperson_name, Salesperson.salesperson_id
ORDER BY revenue DESC;

-- Solution 2

SELECT Product.product_name AS top_selling_product, SUM(Sale.quantity) AS number_sold
FROM Sale INNER JOIN Product ON Sale.product_id = Product.product_id
GROUP BY Product.product_name, Product.product_id
ORDER BY top_selling_product DESC
LIMIT 1;

-- Solution 3

-- I would've like to use the Aliased definitions of total_revenue and total_cost for total_prfit, but had an error when running the query

SELECT Product.product_name, SUM(Product.unit_price * Sale.quantity) AS total_revenue, 
  SUM(Product.unit_cost * Sale.quantity) AS total_cost, 
  SUM(Product.unit_price * Sale.quantity) - SUM(Product.unit_cost * Sale.quantity) AS total_profit
FROM Sale INNER JOIN Product ON Sale.product_id = Product.product_id
GROUP BY Product.product_name, Product.product_id
ORDER BY total_profit DESC;

-- Solution 4

SELECT Product.product_name, Product.unit_price - Product.unit_cost AS margin
FROM Product
ORDER BY margin DESC
LIMIT 1;

-- Stretch Solution 1

-- I got as far as designating the region, though I imagine a window function is needed to separate only one salesperson per region?

SELECT Region.region_name, Salesperson.salesperson_name, SUM(Product.unit_price * Sale.quantity) AS revenue
FROM Region INNER JOIN Salesperson ON Region.region_id = Salesperson.region_id INNER JOIN Sale ON Salesperson.salesperson_id = Sale.salesperson_id INNER JOIN Product ON Sale.product_id = Product.product_id
GROUP BY Salesperson.salesperson_name, Salesperson.salesperson_id, Region.region_id
ORDER BY Region.region_id, revenue DESC;
