CREATE VIEW profit_margins AS 
SELECT product_name, unit_cost, unit_price, unit_price - unit_cost AS profit_margin
FROM Product;

SELECT * 
FROM profit_margins;

SELECT Category.category_name, SUM(Product.unit_cost * stock_quantity) AS total_inventory_value
FROM Product
JOIN Category 
ON Category.category_id = Product.category_id;

SELECT product_name, stock_quantity * unit_price AS revenue_potential
FROM Product;

CREATE VIEW avg_profit_margin AS
SELECT AVG(profit_margin)
FROM profit_margins;

SELECT * 
FROM avg_profit_margin;

SELECT product_name 
FROM profit_margins
WHERE profit_margin > avg_profit_margin;

CREATE VIEW summary_table AS
SELECT Product.product_name, SUM(Sales.quantity_sold) AS units_sold, SUM(Sales.quantity_sold * Product.unit_price) AS total_revenue, SUM(Sales.quantity_sold * Product.unit_cost) AS total_cost, SUM(Sales.quantity_sold * (Product.unit_price - Product.unit_cost)) AS total_profit
FROM Product
JOIN Sale
ON Product.product_id = Sale.product_id
GROUP BY Product.product_name;

SELECT * 
FROM summary_table;

SELECT product_name
FROM summary_table
ORDER BY total_profit DESC
LIMIT 3; 

SELECT product_name
FROM Product
ORDER BY LENGTH(product_name) DESC
LIMIT 1;

SELECT product_name
FROM Product
ORDER BY LENGTH(product_name) ASC
LIMIT 1;

SELECT product_name
FROM Product
WHERE product_name LIKE ‘% %’;

SELECT category_name
FROM Category
WHERE category_name LIKE ‘E%’;

SELECT UPPER(Product.product_name), LOWER(Category.category_name)
FROM Product
JOIN Category on Product.category_id = Category.category_id;