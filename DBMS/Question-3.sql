USE storefront;

/*
Display Recent 50 Orders placed (Id, Order Date, Order Total).
*/
SELECT order_id, date_of_order, total_price
FROM order_details
ORDER BY date_of_order DESC
LIMIT 50;

/*
Display 10 most expensive Orders.
*/
SELECT *
FROM order_details
ORDER BY total_price DESC
LIMIT 10;

/*
Display all the Orders which are placed more than 10 days old 
and one or more items from those orders are still not shipped.
*/
SELECT * 
FROM order_details
WHERE date_of_order NOT BETWEEN DATE_SUB(NOW(), INTERVAL 10 DAY) AND NOW()
	AND order_id IN (SELECT order_id
					 FROM items_ordered
                     WHERE order_status = 'Not Shipped');

/*
Display list of shoppers which haven't ordered anything since last month.
*/
SELECT user_name, email
FROM users
WHERE type_of_user = 'S'
	AND email NOT IN (SELECT email
					  FROM order_details
                      WHERE MONTH(date_of_order) < MONTH(CURDATE()) AND
							YEAR(date_of_order) <= YEAR(CURDATE()));

/*
Display list of shopper along with orders placed by them in last 15 days.
*/
SELECT u.user_name, u.email, i.order_id, i.product_id
FROM users u INNER JOIN order_details o INNER JOIN items_ordered i
ON u.email = o.email AND i.order_id = o.order_id
WHERE date_of_order BETWEEN DATE_SUB(NOW(), INTERVAL 15 DAY) AND NOW();

/*
Display list of order items which are in “shipped” state for particular Order Id (i.e.: 1020))
*/
SELECT product_name, product_id
FROM products
WHERE product_id IN (SELECT product_id
					 FROM items_ordered i
					 WHERE order_id = 2 AND
						order_status = 'Shipped'); 
 
/*
Display list of order items along with order placed date which fall between Rs 2000 to Rs 5000 price.
*/
SELECT product_name, product_id, date_of_order, price
FROM products, order_details
WHERE price BETWEEN 2000 AND 5000 AND
	(product_id, order_id) IN (SELECT product_id, order_id
				   FROM items_ordered);

/*
Update first 20 Order items status to “Shipped” which are placed today.
*/
UPDATE items_ordered
SET order_status = 'Shipped'
WHERE order_id IN (SELECT order_id
				   FROM order_details
                   WHERE date_of_order = CURDATE());
SELECT * 
FROM items_ordered;