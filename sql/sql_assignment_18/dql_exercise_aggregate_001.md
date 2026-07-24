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

2. Return the top selling product overall by total units sold.

3. For each product, return its name alongside its total revenue, total cost, and total profit. *(Hint: profit = revenue - cost)*

4. Return the single highest margin product. Margin should be calculated at the per-unit level. *(Hint: margin = unit_price - unit_cost)*

**Stretch Goal 1:** Return the salesperson who generated the most revenue within each region. Your result should show the region name, the salesperson's name, and their total revenue for that region.

**Stretch Goal 2 *(Advanced)*:** Return the top selling product in each region by total units sold. *Note: this is significantly more challenging than the questions above and may require a subquery or window function.*
