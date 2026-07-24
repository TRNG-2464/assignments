# Exercise — Product & Sales Analysis

*The schema for this exercise is provided in the accompanying file `dql_exercise_aggregate_002_schema.sql`. You do not need to modify that file — simply run it to set up your database before attempting the queries below.*

*You may find that creating one or more **views** will be helpful for this activity, rather than rewriting the same logic across multiple queries. If you use any views, include the SQL statements used to create them in your submission.*

*Note: if you are not using PostgreSQL, make sure to check the documentation of your chosen dialect specific function names.*

---

## Schema Reference

Category
| column | type | constraints |
|-|-|-|
| category_id | INT | PRIMARY KEY |
| category_name | VARCHAR | NOT NULL |

Product
| column | type | constraints |
|-|-|-|
| product_id | INT | PRIMARY KEY |
| category_id | INT | NOT NULL, FK → Category |
| product_name | VARCHAR | NOT NULL |
| unit_cost | NUMERIC(10,2) | NOT NULL |
| unit_price | NUMERIC(10,2) | NOT NULL |
| stock_quantity | INT | NOT NULL |

Sale
| column | type | constraints |
|-|-|-|
| sale_id | INT | PRIMARY KEY |
| product_id | INT | NOT NULL, FK → Product |
| quantity_sold | INT | NOT NULL |
| sale_date | DATE | NOT NULL |

---

## Queries

Write a SQL query for each of the following. Where a query builds on the result of a previous one, consider whether a view would simplify your solution.

**Arithmetic & Aggregate**

1. Return each product's name, unit cost, unit price, and per-unit profit margin.

SELECT product_name, unit_cost, unit_price, unit_price - unit_cost AS profit_margin FROM product;

Wireless Mouse,12.00,29.99,17.99
USB-C Hub,18.50,49.99,31.49
Mechanical Keyboard,42.00,99.99,57.99
Webcam HD,28.00,74.99,46.99
Bluetooth Numpad,14.00,34.99,20.99
Gel Pen Set,3.50,9.99,6.49
Sticky Notes Multipack,2.00,5.99,3.99
Desk Organiser,6.00,18.99,12.99
Whiteboard Markers,4.00,11.99,7.99
A4 Notebook,2.50,7.49,4.99
Ergonomic Wrist Rest,7.50,22.99,15.49
Laptop Stand,15.00,39.99,24.99
Monitor Arm,32.00,79.99,47.99
Adjustable Footrest,18.00,44.99,26.99
Portable SSD 1TB,55.00,129.99,74.99
Cable Management Kit,4.00,12.99,8.99
USB Flash Drive 64GB,5.50,14.99,9.49
SD Card Reader,6.00,16.99,10.99
Monitor Light Bar,9.50,34.99,25.49
LED Desk Lamp,14.00,38.99,24.99




2. Return the total inventory value per category — that is, the total cost of all stock currently on hand across all products in each category.

SELECT category_name, SUM(stock_quantity * unit_cost) as inventory_value FROM product INNER JOIN category ON product.category_id = category.category_id GROUP BY category_name;

Electronics,7772.50
Office Supplies,3065.00
Ergonomics,3995.00
Storage,4420.00
Lighting,1812.50



3. Return the gross revenue potential per product — the revenue that would be generated if all remaining stock were sold at the current unit price.

SELECT product_name, stock_quantity * unit_price as gross_revenue_potential FROM product;

Wireless Mouse,3598.80
USB-C Hub,4249.15
Mechanical Keyboard,5999.40
Webcam HD,3374.55
Bluetooth Numpad,2449.30
Gel Pen Set,1998.00
Sticky Notes Multipack,1797.00
Desk Organiser,1709.10
Whiteboard Markers,1798.50
A4 Notebook,1872.50
Ergonomic Wrist Rest,1839.20
Laptop Stand,2999.25
Monitor Arm,3199.60
Adjustable Footrest,2474.45
Portable SSD 1TB,3899.70
Cable Management Kit,2338.20
USB Flash Drive 64GB,3297.80
SD Card Reader,2378.60
Monitor Light Bar,3324.05
LED Desk Lamp,2534.35


4. Return the overall average profit margin across all products.

SELECT AVG(unit_price - unit_cost) as overall_avg_profit_margin FROM product;

24.115000

5. Return all products whose per-unit profit margin exceeds the overall average profit margin.

SELECT product_name FROM product WHERE unit_price - unit_cost > (SELECT AVG(unit_price - unit_cost) as overall_avg_profit_margin FROM product);

USB-C Hub
Mechanical Keyboard
Webcam HD
Laptop Stand
Monitor Arm
Adjustable Footrest
Portable SSD 1TB
Monitor Light Bar
LED Desk Lamp

6. Return the total units sold, total revenue, total cost, and total profit per product across all sales.

SELECT quantity_sold, quantity_sold * unit_price as revenue, quantity_sold * unit_cost as total_cost, quantity_sold * (unit_price - unit_cost) as total_profit, product_name, sale_date  FROM sale INNER JOIN product ON sale.product_id = product.product_id ORDER BY sale_date;

12,359.88,215.88,144.00,Wireless Mouse,2024-01-05
40,399.60,259.60,140.00,Gel Pen Set,2024-01-06
22,769.78,560.78,209.00,Monitor Light Bar,2024-01-07
3,389.97,224.97,165.00,Portable SSD 1TB,2024-01-08
6,299.94,188.94,111.00,USB-C Hub,2024-01-09
55,329.45,219.45,110.00,Sticky Notes Multipack,2024-01-10
14,545.86,349.86,196.00,LED Desk Lamp,2024-01-12
16,367.84,247.84,120.00,Ergonomic Wrist Rest,2024-01-14
6,449.94,281.94,168.00,Webcam HD,2024-01-15
35,454.65,314.65,140.00,Cable Management Kit,2024-01-17
8,239.92,143.92,96.00,Wireless Mouse,2024-01-18
14,265.86,181.86,84.00,Desk Organiser,2024-01-19
3,299.97,173.97,126.00,Mechanical Keyboard,2024-01-22
50,749.50,474.50,275.00,USB Flash Drive 64GB,2024-01-23
9,359.91,224.91,135.00,Laptop Stand,2024-01-25
11,384.89,230.89,154.00,Bluetooth Numpad,2024-01-28
20,339.80,219.80,120.00,SD Card Reader,2024-01-29
22,263.78,175.78,88.00,Whiteboard Markers,2024-01-30
8,359.92,215.92,144.00,Adjustable Footrest,2024-01-31
15,449.85,269.85,180.00,Wireless Mouse,2024-02-03
48,287.52,191.52,96.00,Sticky Notes Multipack,2024-02-05
30,224.70,149.70,75.00,A4 Notebook,2024-02-08
8,599.92,375.92,224.00,Webcam HD,2024-02-09
45,674.55,427.05,247.50,USB Flash Drive 64GB,2024-02-11
4,199.96,125.96,74.00,USB-C Hub,2024-02-12
35,349.65,227.15,122.50,Gel Pen Set,2024-02-14
18,629.82,458.82,171.00,Monitor Light Bar,2024-02-16
5,399.95,239.95,160.00,Monitor Arm,2024-02-17
2,259.98,149.98,110.00,Portable SSD 1TB,2024-02-19
12,275.88,185.88,90.00,Ergonomic Wrist Rest,2024-02-20
10,299.90,179.90,120.00,Wireless Mouse,2024-02-21
6,269.94,161.94,108.00,Adjustable Footrest,2024-02-22
42,545.58,377.58,168.00,Cable Management Kit,2024-02-24
18,341.82,233.82,108.00,Desk Organiser,2024-02-26
11,428.89,274.89,154.00,LED Desk Lamp,2024-02-27
5,499.95,289.95,210.00,Mechanical Keyboard,2024-02-28
9,314.91,188.91,126.00,Bluetooth Numpad,2024-03-01
52,779.48,493.48,286.00,USB Flash Drive 64GB,2024-03-04
7,279.93,174.93,105.00,Laptop Stand,2024-03-06
7,349.93,220.43,129.50,USB-C Hub,2024-03-08
16,623.84,399.84,224.00,LED Desk Lamp,2024-03-09
19,227.81,151.81,76.00,Whiteboard Markers,2024-03-11
4,519.96,299.96,220.00,Portable SSD 1TB,2024-03-13
9,269.91,161.91,108.00,Wireless Mouse,2024-03-14
17,288.83,186.83,102.00,SD Card Reader,2024-03-16
60,359.40,239.40,120.00,Sticky Notes Multipack,2024-03-17
4,399.96,231.96,168.00,Mechanical Keyboard,2024-03-19
38,493.62,341.62,152.00,Cable Management Kit,2024-03-20
28,279.72,181.72,98.00,Gel Pen Set,2024-03-22
25,874.75,637.25,237.50,Monitor Light Bar,2024-03-23
25,187.25,124.75,62.50,A4 Notebook,2024-03-25
4,319.96,191.96,128.00,Monitor Arm,2024-03-29


7. Return the top 3 most profitable products by total profit generated from sales.

SELECT product_name FROM (SELECT SUM(quantity_sold * (unit_price - unit_cost)) as total_profit, product_name  FROM sale INNER JOIN product ON sale.product_id = product.product_id GROUP BY product_name ORDER BY total_profit DESC LIMIT 3) a;

Monitor Light Bar
USB Flash Drive 64GB
Cable Management Kit


**String Operations**

8. Return the product with the longest name. 

SELECT product_name FROM product ORDER BY LENGTH(product_name) DESC LIMIT 1;

Sticky Notes Multipack

9. Return the product with the shortest name.

SELECT product_name FROM product ORDER BY LENGTH(product_name) LIMIT 1;

USB-C Hub

10. Return all products whose name contains more than one word. ("more than one word" means the product name contains a space)

SELECT product_name FROM product WHERE product_name LIKE '% %';

Wireless Mouse
USB-C Hub
Mechanical Keyboard
Webcam HD
Bluetooth Numpad
Gel Pen Set
Sticky Notes Multipack
Desk Organiser
Whiteboard Markers
A4 Notebook
Ergonomic Wrist Rest
Laptop Stand
Monitor Arm
Adjustable Footrest
Portable SSD 1TB
Cable Management Kit
USB Flash Drive 64GB
SD Card Reader
Monitor Light Bar
LED Desk Lamp

11. Return all categories whose name starts with the letter `E`.

SELECT category_name FROM category WHERE category_name LIKE 'E%';

Electronics
Ergonomics


12. Return each product name in uppercase alongside its category name in lowercase.

SELECT CONCAT(UPPER(product_name), ' ', LOWER(category_name)) FROM product INNER JOIN category ON product.category_id = category.category_id;

WIRELESS MOUSE electronics
USB-C HUB electronics
MECHANICAL KEYBOARD electronics
WEBCAM HD electronics
BLUETOOTH NUMPAD electronics
GEL PEN SET office supplies
STICKY NOTES MULTIPACK office supplies
DESK ORGANISER office supplies
WHITEBOARD MARKERS office supplies
A4 NOTEBOOK office supplies
ERGONOMIC WRIST REST ergonomics
LAPTOP STAND ergonomics
MONITOR ARM ergonomics
ADJUSTABLE FOOTREST ergonomics
PORTABLE SSD 1TB storage
CABLE MANAGEMENT KIT storage
USB FLASH DRIVE 64GB storage
SD CARD READER storage
MONITOR LIGHT BAR lighting
LED DESK LAMP lighting