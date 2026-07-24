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

2. Return the total inventory value per category — that is, the total cost of all stock currently on hand across all products in each category.

3. Return the gross revenue potential per product — the revenue that would be generated if all remaining stock were sold at the current unit price.

4. Return the overall average profit margin across all products.

5. Return all products whose per-unit profit margin exceeds the overall average profit margin.

6. Return the total units sold, total revenue, total cost, and total profit per product across all sales.

7. Return the top 3 most profitable products by total profit generated from sales.

**String Operations**

8. Return the product with the longest name. 

9. Return the product with the shortest name.

10. Return all products whose name contains more than one word. ("more than one word" means the product name contains a space)

11. Return all categories whose name starts with the letter `E`.

12. Return each product name in uppercase alongside its category name in lowercase.
