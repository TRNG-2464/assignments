# Exercise — Sales & Inventory Analysis

*The schema for this exercise is provided in the accompanying file `dql_exercise_aggregate_001_schema.sql`. You do not need to modify that file — simply run it to set up your database before attempting the queries below.*

---

## Schema Reference

The database contains four tables with the following structure and relationships.

Region
| column | type | constraints |
|-|-|-|
| region_id | INT | PRIMARY KEY |
| region_name | VARCHAR | NOT NULL |

Salesperson
| column | type | constraints |
|-|-|-|
| salesperson_id | INT | PRIMARY KEY |
| region_id | INT | NOT NULL, FK → Region |
| salesperson_name | VARCHAR | NOT NULL |

Product
| column | type | constraints |
|-|-|-|
| product_id | INT | PRIMARY KEY |
| product_name | VARCHAR | NOT NULL |
| unit_cost | NUMERIC(10,2) | NOT NULL |
| unit_price | NUMERIC(10,2) | NOT NULL |

Sale
| column | type | constraints |
|-|-|-|
| sale_id | INT | PRIMARY KEY |
| salesperson_id | INT | NOT NULL, FK → Salesperson |
| product_id | INT | NOT NULL, FK → Product |
| quantity | INT | NOT NULL |
| sale_date | DATE | NOT NULL |

---

## Queries

Using the schema above, write an SQL query for each of the following:

1. Return each salesperson's name alongside their total revenue generated, ordered from highest to lowest. *(Hint: revenue = quantity × unit_price)*

SELECT salesperson_name, SUM(quantity * unit_price) as revenue FROM salesperson INNER JOIN product INNER JOIN sale ON salesperson.salesperson_id = sale.salesperson_id AND product.product_id = sale.product_id GROUP BY salesperson_name ORDER BY revenue DESC;


Priya Anand,1170.66
Mia Sorrel,1116.71
Jordan Hale,1069.67
Dana Reeves,1020.67
Sam Okafor,1006.71
Leo Marsh,902.66
Finn Calloway,880.74
Cleo Vance,879.71


2. Return the top selling product overall by total units sold.

SELECT product_name FROM (SELECT product_name, SUM(quantity) q FROM product INNER JOIN sale ON product.product_id = sale.product_id GROUP BY product_name ORDER BY q DESC LIMIT 1) a;

Wireless Mouse

3. For each product, return its name alongside its total revenue, total cost, and total profit. *(Hint: profit = revenue - cost)*

SELECT product_name, SUM(quantity * unit_price) revenue, SUM(quantity * unit_cost) total_cost, SUM(quantity * (unit_price - unit_cost)) profit FROM product INNER JOIN sale ON product.product_id = sale.product_id GROUP BY product_name;

Wireless Mouse,1889.37,756.00,1133.37
USB-C Hub,699.86,259.00,440.86
Mechanical Keyboard,1299.87,546.00,753.87
Laptop Stand,879.78,330.00,549.78
Monitor Light Bar,1154.67,313.50,841.17
Desk Organiser,911.52,288.00,623.52
Cable Management Kit,454.65,140.00,314.65
Ergonomic Wrist Rest,367.84,120.00,247.84
Portable SSD 1TB,389.97,165.00,224.97


4. Return the single highest margin product. Margin should be calculated at the per-unit level. *(Hint: margin = unit_price - unit_cost)*

SELECT product_name FROM (SELECT product_name, unit_price - unit_cost margin FROM product ORDER BY margin DESC LIMIT 1) a;

Portable SSD 1TB

**Stretch Goal 1:** Return the salesperson who generated the most revenue within each region. Your result should show the region name, the salesperson's name, and their total revenue for that region.

**Stretch Goal 2 *(Advanced)*:** Return the top selling product in each region by total units sold. *Note: this is significantly more challenging than the questions above and may require a subquery or window function.*
