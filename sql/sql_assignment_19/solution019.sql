-- Solution 1

SELECT product_name, unit_cost, unit_price, unit_price - unit_cost AS profit_margin
FROM Product

-- Solution 2

SELECT Category.category_name, SUM(Product.unit_cost * Product.stock_quantity) AS inventory_value
FROM Category INNER JOIN Product ON Category.category_id = Product.category_id
GROUP BY Category.category_id, Category.category_name
ORDER BY Category.category_id;

-- Solution 3

SELECT product_name, SUM(unit_price * stock_quantity) - SUM(unit_cost * stock_quantity) AS revenue_potential
FROM Product
GROUP BY product_id;

-- Before continuing the solutions, I'll create a profit_margin view to simplify future queries
CREATE VIEW products_view AS
	SELECT *, unit_price - unit_cost AS profit_margin
	FROM Product;

-- Solution 4

SELECT AVG(profit_margin)
FROM products_view;

-- Solution 5

SELECT * 
FROM products_view
WHERE profit_margin > (SELECT AVG(profit_margin) FROM products_view);

-- Before continuing the solutions, I'll create a sales_info view to simplify future queries
CREATE VIEW sales_info AS
SELECT products_view.*, sales_quantities.total_sales 
FROM products_view INNER JOIN 
	(SELECT product_id, SUM(quantity_sold) AS total_sales 
  FROM Sale GROUP BY product_id) AS sales_quantities ON products_view.product_id = sales_quantities.product_id;

-- Solution 6

SELECT product_name, total_sales AS units_sold, 
  total_sales * unit_cost AS total_cost, 
  total_sales * unit_price AS total_revenue, 
  total_sales * profit_margin AS total_profit
FROM sales_info;

-- Solution 7

SELECT product_name, total_sales * profit_margin AS total_profit
FROM sales_info
ORDER BY total_profit DESC
LIMIT 3;

-- String Operations
-- Solution 1

SELECT * FROM Product
ORDER BY LENGTH(product_name) DESC
LIMIT 1;

-- Solution 2

SELECT * FROM Product
ORDER BY LENGTH(product_name) ASC
LIMIT 1;

--Solution 3

SELECT * FROM Product
WHERE product_name LIKE '% %';

-- Solution 4

SELECT * FROM Category
WHERE category_name LIKE 'E%';

--Solution 5

SELECT UPPER(Product.product_name), LOWER(Category.category_name)
FROM Category INNER JOIN Product ON Category.category_id = Product.category_id;
