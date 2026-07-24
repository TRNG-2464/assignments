-- Query 1
SELECT product_name, unit_cost, unit_price, (unit_price - unit_cost) AS profit FROM Product;

-- Query 2
SELECT SUM(unit_cost * stock_quantity) FROM Product INNER JOIN Category ON Product.category_id = Category.category_id GROUP BY Category.category_id;

-- Query 3
SELECT unit_price * stock_quantity AS revenue_potential FROM Product;

-- Since profit features heavily in these upcoming queries, we'll create a view to store it
CREATE VIEW product_view AS 
    SELECT *, (unit_price - unit_cost) AS profit FROM Product;

-- Query 4
SELECT AVG(profit) FROM product_view;

-- Query 5
SELECT * from product_view WHERE profit > (SELECT AVG(profit) FROM product_view);

-- Since total sales feature heavily in the next queries, we'll create a view to add it to the previous view
CREATE VIEW sale_quantities AS
    SELECT product_view.*, sales_totals.total_sales FROM product_view 
    INNER JOIN (SELECT product_id, SUM(quantity_sold) AS total_sales FROM Sale GROUP BY product_id) AS sales_totals ON product_view.product_id = sales_totals.product_id;

-- Query 6
SELECT product_name, total_sales, total_sales * unit_cost AS total_cost, total_sales * unit_price AS total_price, total_sales * profit AS total_profit FROM sale_quantities;

-- Query 7
SELECT product_name, total_sales * profit AS total_profit FROM sale_quantities ORDER BY total_profit DESC LIMIT 3;

-- Query 8
SELECT * FROM Product ORDER BY LENGTH(product_name) DESC LIMIT 1;

-- Query 9
SELECT * FROM Product ORDER BY LENGTH(product_name) ASC LIMIT 1;

-- Query 10
SELECT * FROM Product WHERE product_name LIKE '% %';

-- Query 11
SELECT * FROM Category WHERE category_name LIKE 'E%';

-- Query 12
SELECT UPPER(Product.product_name), LOWER(Category.category_name) FROM Product INNER JOIN Category ON Product.category_id = Category.category_id;