/*
Display Shopper’s information along with
number of orders he/she placed during last 30 days.
*/
SELECT users.email, user_name, phone_no, COUNT(users.email)
FROM users, order_details
WHERE type_of_user = 's' AND date_of_order BETWEEN DATE_SUB(NOW(), INTERVAL 30 DAY) AND NOW()
AND users.email = order_details.email
GROUP BY users.email; 


/*
Display the top 10 Shoppers who generated
maximum number of revenue in last 30 days.
*/
SELECT users.email, user_name, phone_no, SUM(total_price) as revenue_generated
FROM users, order_details
WHERE type_of_user = 's' AND date_of_order BETWEEN DATE_SUB(NOW(), INTERVAL 30 DAY) AND NOW()
AND users.email = order_details.email
GROUP BY users.email
ORDER BY SUM(total_price) DESC
LIMIT 10; 


/*
Display top 20 Products which are ordered most in last 60 days along with numbers.
*/
SELECT products.product_id, product_name, SUM(items_ordered.quantity) as product_numbers
FROM products, items_ordered, order_details
WHERE date_of_order BETWEEN DATE_SUB(NOW(), INTERVAL 60 DAY) AND NOW()
AND items_ordered.order_id = order_details.order_id
AND items_ordered.product_id = products.product_id
GROUP BY products.product_id
ORDER BY SUM(items_ordered.quantity) DESC
LIMIT 20;

/*
Display Monthly sales revenue of the StoreFront for last 6 months. It should display each month’s sale.
*/
SELECT MONTH(date_of_order) as month, SUM(price) as months_sale
FROM items_ordered, order_details
WHERE date_of_order BETWEEN DATE_SUB(NOW(), INTERVAL 6 MONTH) AND NOW()
AND items_ordered.order_id = order_details.order_id
GROUP BY MONTH(date_of_order);


/*
Mark the products as Inactive which are not ordered in last 90 days
*/
SELECT * FROM products;

UPDATE products
SET product_state = 'I'
WHERE product_id
NOT IN( SELECT * FROM(SELECT products.product_id 
		FROM products
		INNER JOIN items_ordered ON products.product_id = items_ordered.product_id
		INNER JOIN order_details ON items_ordered.order_id = order_details.order_id
		WHERE date_of_order BETWEEN DATE_SUB(NOW(), INTERVAL 90 DAY) AND NOW()) temp) AND product_id <> 0;

SELECT * FROM products;


/*
Given a category search keyword, display all the Products present in this category/categories.
*/
SELECT child.category_id, products.product_name
FROM categories child , products, categorylink link, (SELECT *
						 FROM categories
						 WHERE category_name like 'm%') temp
WHERE (temp.category_id = child.parent_id OR temp.category_id = child.category_id)
AND child.category_id = link.category_id
AND link.product_id = products.product_id;

/*
Display top 10 Items which were cancelled most.
*/
SELECT products.product_id, product_name, COUNT(products.product_id) as cancellation_time
FROM products, items_ordered, order_details
WHERE items_ordered.order_id = order_details.order_id
AND items_ordered.product_id = products.product_id
AND order_status = 'Cancelled'
GROUP BY products.product_id
ORDER BY COUNT(products.product_id) DESC
LIMIT 10;