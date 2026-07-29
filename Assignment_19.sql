/*1*/
SELECT product_name, unit_cost, unit_price, (unit_price-unit_cost) AS profit_margin FROM Product;

/*2*/
SELECT Category.category_name,SUM(Product.unit_cost * Product.stock_quantity)
AS total_inventory_value FROM Category JOIN Product ON Product.category_id=Category.category_id
GROUP BY Category.category_name ORDER BY Category.category_name;

/*3*/
/*Gross Revenue  = price * quantity sold
*/
SELECT product_name, unit_price * stock_quantity
AS gross_revenue FROM Product;

/*4*/
/*average profit margin AVg((unit price -unit cost)/unit price)
get the avergage of a row then get the avg of a ll the rows using AVG()
*/
SELECT AVG((unit_price-unit_cost)/unit_price) AS Overall_profit_margin FROM Product;

/*5*/
SELECT product_name FROM Product WHERE (unit_price-unit_cost)/unit_price > (SELECT AVG((unit_price-unit_cost)/unit_price) FROM Product);

/*6
For Sales
revenue = price * quantity sold
Total cost = sum of (unit cost * quantity sold)
total profit = sum of(revenue - total_cost)
*/
SELECT Product.product_name, SUM(Sale.quantity_sold) AS Total_sold,
SUM(Product.unit_price * Sale.quantity_sold) AS Revenue,
SUM(Product.unit_cost*Sale.quantity_sold) AS Total_cost,
SUM(Product.unit_price * Sale.quantity_sold) - 
SUM(Product.unit_cost*Sale.quantity_sold) AS Total_profit
FROM Product JOIN Sale ON Product.product_id = Sale.product_id 
GROUP BY Product.product_name;

/*7 */
SELECT Product.product_name FROM Product 
JOIN Sale ON Product.product_id = Sale.product_id 
GROUP BY Product.product_name ORDER BY SUM(Product.unit_price * Sale.quantity_sold) - 
SUM(Product.unit_cost*Sale.quantity_sold) DESC LIMIT 3;

/*8*/ 
SELECT product_name FROM Product ORDER BY LENGTH(product_name) DESC LIMIT 1;

/*9*/ 
SELECT product_name FROM Product ORDER BY LENGTH(product_name) ASC LIMIT 1;

/*10*/ 
SELECT product_name FROM Product WHERE product_name LIKE '% %';

/*11*/ 
SELECT category_name FROM Category WHERE category_name LIKE 'E%';

/*12*/ 
SELECT UPPER(Product.product_name) AS product, LOWER(Category.category_name) AS Category
FROM Product JOIN Category ON Product.category_id = Category.category_id; 