SELECT Salesperson.salesperson_name, SUM(Sale.quantity * Product.unit_price) AS total_revenue
FROM Salesperson
JOIN Sale
ON Salesperson.salesperson_id = Sale.salesperson_ID
JOIN Product 
ON Product.product_id = Sale.product_id
GROUP BY Salesperson.salesperson_name
ORDER BY total_revenue DESC;

SELECT product_name
FROM Product
WHERE product_id = (
	SELECT product_id 
	FROM Sale
	GROUP BY product_id
	ORDER BY SUM(quantity) DESC
	LIMIT 1
);

SELECT Product.product_name, SUM(Sale.quantity * Product.unit_price) AS total_revenue, SUM(Sale.quantity * Product.unit_cost) AS total_cost, SUM(Sale.quantity * Product.unit_price) - SUM(Sale.quantity * Product.unit_cost) AS profit
FROM Product
JOIN Sale 
ON Product.product_id = Sale.product_id
GROUP BY Product.produce_name;

SELECT product_name 
FROM (
	SELECT product_name, unit_price - unit_cost as margin 
	FROM Product
	ORDER BY margin DESC
	LIMIT 1
) AS margins;

CREATE TABLE TopSalespeople AS
SELECT Salesperson.salesperson_name, SUM(Sale.quantity * Product.unit_price) AS total_revenue, Region.region_name
FROM Sale
JOIN Salesperson on Salesperson.salesperson_id = Sale.salesperson_id
JOIN Product on Product.product_id = Sale.product_id
JOIN Region on Salesperson.region_id = Region.region_id
GROUP BY Salesperson.salesperson_name, Region.region_name;

SELECT region_name, salesperson_name 
FROM TopSalespeople 
WHERE total_revenue IN ( SELECT MAX(total_revenue)FROM TopSalespeople GROUP BY region );

CREATE TABLE TopProducts AS
SELECT Region.region_name, Product.product_name, COUNT(Sale.product_id) as num_sales
FROM Product
JOIN Sale on Sale.product_id = Product.product_id
JOIN Salesperson on Sale.salesperson_id = Salesperson.salesperson_id
JOIN Region on region.region_id = Salesperson.region_id
GROUP BY Product.product_name;

SELECT region, FROM TopProducts WHERE num_sales IN ( SELECT MAX(num_sales)FROM TopProducts GROUP BY region );