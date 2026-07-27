
/* Assignment 19 */

-- Arithmetic and Aggregate

-- 1. 
drop view if exists per_unit_profit_margin;
create view per_unit_profit_margin as 
select 
	Product.prduct_id as id,

	Product.product_name as name,
	Product.unit_cost as cost,
	Product.unit_price as price,
	
	-- Profit margin
	Product.unit_price - Product.unit_cost as profit_margin,
	
	
	Product.stock_quantity as stock_quantity,
	Product.category_id as category_id
	
from Product;

select 
	name, cost, price, profit_margin
from per_unit_profit_margin;


-- 2. 
select 
	sum(cost*stock_quantity), category_id
from per_unit_profit_margin
group by category_id;

-- 3. 

select 
	price * stock_quantity as gross_revenue_potential_per_product
from per_unit_profit_margin;


-- 4.
select AVG(profit_margin) from per_unit_profit_margin;


-- 5.
select 
	name
from per_unit_profit_margin
where profit_margin > (
	select avg(profit_margin) 
	from per_unit_profit_margin);

-- 6. 
drop view if exists sum_across_all_products;
create view sum_across_all_products as 
select 
	product_name,
	sum(quantity_sold) as total_sold,
	sum(quantity_sold * unit_price) as total_revenue,
	sum(quantity_sold * unit_cost) as total_cost,
	sum((quantity_sold * unit_price) - (quantity_sold * unit_cost)) as total_profit
from Product
join Sale
on Product.product_id = Sale.product_id
group by Product.product_id;

select * from sum_across_all_products;

-- 7.
select * 
from sum_across_all_products
order by total_profit desc
limit 3;

	

-- String operations

-- 8.
select product_name
from Product
order by length(product_name) desc
limit 1;

-- 9.
select product_name
from Product
order by length(product_name) asc
limit 1;

-- 10.
select product_name
from product
where product_name like '% %';

-- 11.
select category_name
from category
where lower(category_name) like 'e%';

-- 12.
select
	upper(product_name),
	lower(category_name)
from Product
join Category
on Product.category_id = Category.category_id;
	
