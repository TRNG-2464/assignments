
/* Assignment 18 */

select * from salesperson;


-- Query one
select 
	Salesperson.salesperson_name, 
	Sale.quantity * Product.unit_price as Revenue
from Salesperson
join Sale
	on Salesperson.salesperson_id = Sale.salesperson_id
join Product
	on Sale.product_id = Product.product_id
order by revenue desc;
	

-- Query two
select product_name
from Product
where product_id =
	(select 	
		Sale.product_id
	from Sale
	group by Sale.product_id
	order by count(Sale.quantity) desc
	limit 1);


-- Query three
select 
	Product.product_name,
	Sale.quantity * Product.unit_price as revenue,
	Product.unit_cost * Sale.quantity as cost,
	(Sale.quantity * Product.unit_price) - 
	(Product.unit_cost * Sale.quantity) as profit

from Product
join Sale 
on Product.product_id = Sale.product_id;
	

-- Query four
select
	product_name, 
	unit_price - unit_cost as margin
from Product
order by margin desc 
limit 1;



-- Stretch Goal 1

-- Stretch Goal 2

