--1
SELECT product_name, unit_cost, unit_price, unit_price - unit_cost AS margin
FROM Product;

--2
SELECT Category.category_name, SUM(Product.unit_cost * Product.stock_quantity) AS total_inv_value
FROM Category
JOIN Product ON Category.category_id = Product.category_id
GROUP BY Category.category_name;

--3
SELECT product_name, unit_price, stock_quantity, unit_price * stock_quantity AS gross_potential
FROM Product;

--4
SELECT AVG(unit_price - unit_cost) AS avg_margin
FROM Product;

--5
SELECT product_name, unit_cost, unit_price, unit_price - unit_cost AS margin
FROM Product
WHERE unit_price - unit_cost > (
    SELECT AVG(unit_price - unit_cost)
    FROM Product
);

--6
SELECT Product.product_name, 
SUM(Sale.quantity_sold) AS total_units_sold,
SUM(Product.unit_price * Sale.quantity_sold) AS total_revenue,
SUM(Product.unit_cost * Sale.quantity_sold) AS total_cost,
SUM(Sale.quantity_sold * (Product.unit_price - Product.unit_cost)) AS total_profit
FROM Product
JOIN Sale ON Product.product_id = Sale.product_id
GROUP BY Product.product_name;

--7
SELECT Product.product_name,
SUM(Sale.quantity_sold * (Product.unit_price - Product.unit_cost)) AS total_profit
FROM Product
JOIN Sale ON Product.product_id = Sale.product_id
GROUP BY Product.product_name
ORDER BY total_profit DESC
LIMIT 3;

--8
SELECT MAX(LENGTH(product_name)) AS max_product_name_length
FROM Product;

--9
SELECT MIN(LENGTH(product_name)) AS min_product_name_length
FROM Product;

--10
SELECT product_name
FROM Product
WHERE product_name LIKE '% %';

--11
SELECT product_name
FROM Product
WHERE product_name LIKE 'E%';

--12
SELECT UPPER(product_name) AS upper_product_name,
LOWER(category_name) AS lower_category_name
FROM Product
JOIN Category ON Product.category_id = Category.category_id;