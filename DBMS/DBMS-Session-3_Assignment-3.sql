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
+---------------------------+--------------+------------+--------------------+
| email                     | user_name    | phone_no   | COUNT(users.email) |
+---------------------------+--------------+------------+--------------------+
| chirag10march@gmail.com   | Chirag Jain  | 7737596610 |                  1 |
| innovativemohit@gmail.com | Mohit Sharma | 7877235269 |                  1 |
| tanumittal@gmail.com      | Tanu Mittal  | 1234567893 |                  2 |
+---------------------------+--------------+------------+--------------------+
*/


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
+---------------------------+--------------+------------+-------------------+
| email                     | user_name    | phone_no   | revenue_generated |
+---------------------------+--------------+------------+-------------------+
| tanumittal@gmail.com      | Tanu Mittal  | 1234567893 |            199000 |
| innovativemohit@gmail.com | Mohit Sharma | 7877235269 |             18000 |
| chirag10march@gmail.com   | Chirag Jain  | 7737596610 |              1000 |
+---------------------------+--------------+------------+-------------------+
*/


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
+------------+--------------------+----------------+
| product_id | product_name       | no_of_products |
+------------+--------------------+----------------+
|         12 | Peter England Suit |              3 |
|          9 | Timex Analog Watch |              2 |
|          6 | Kingston 16GB      |              1 |
|          7 | HP 64Gb            |              1 |
|          1 | Redmi 3s Prime     |              1 |
+------------+--------------------+----------------+
*/

/*
Display Monthly sales revenue of the StoreFront for last 6 months. It should display each month’s sale.
*/
SELECT MONTH(date_of_order) as month, SUM(price) as months_sale
FROM items_ordered, order_details
WHERE date_of_order BETWEEN DATE_SUB(NOW(), INTERVAL 6 MONTH) AND NOW()
AND items_ordered.order_id = order_details.order_id
GROUP BY MONTH(date_of_order);

/*
+-------+-------------+
| month | months_sale |
+-------+-------------+
|     8 |       49820 |
|     6 |      108400 |
|     5 |       10350 |
+-------+-------------+
*/


/*
Mark the products as Inactive which are not ordered in last 90 days
*/
SELECT * FROM products;

UPDATE products
SET quantity = 0
WHERE product_id
NOT IN( SELECT * FROM(SELECT products.product_id 
		FROM products
		INNER JOIN items_ordered ON products.product_id = items_ordered.product_id
		INNER JOIN order_details ON items_ordered.order_id = order_details.order_id
		WHERE date_of_order BETWEEN DATE_SUB(NOW(), INTERVAL 90 DAY) AND NOW()) temp) AND product_id <> 0;

SELECT * FROM products;

/*
+------------+------------------------------+----------+-------+--------------------+
| product_id | product_name                 | quantity | price | product_issue_date |
+------------+------------------------------+----------+-------+--------------------+
|          1 | Redmi 3s Prime               |       10 |  9000 | 2016-07-01         |
|          2 | Redmi Note 4                 |        0 | 12500 | 2017-08-01         |
|          3 | Dell Inspiron 4Ti6xy         |       25 | 40000 | 2018-07-01         |
|          4 | Sony Vostro Glide            |       35 | 90400 | 2017-01-01         |
|          5 | Dell Inspiron 5Ti3fa         |        0 | 50000 | 2017-09-23         |
|          6 | Kingston 16GB                |      100 |   900 | 2016-12-12         |
|          7 | HP 64Gb                      |       10 |  2000 | 2018-08-01         |
|          8 | Fastrack Digital Watch 4hy7e |        0 |  2000 | 2016-12-01         |
|          9 | Timex Analog Watch           |       10 |  5000 | 2018-01-01         |
|         10 | Van Heusen Shirt             |        0 |  1500 | 2017-11-11         |
|         11 | Van Heusen Trouser           |        0 |  2000 | 2016-07-01         |
|         12 | Peter England Suit           |       15 | 10000 | 2014-02-12         |
+------------+------------------------------+----------+-------+--------------------+
*/


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
+-------------+----------------+
| category_id | product_name   |
+-------------+----------------+
|           4 | Redmi 3s Prime |
|           4 | Redmi Note 4   |
|           7 | Redmi 3s Prime |
|           7 | Redmi Note 4   |
|           8 | Redmi 3s Prime |
|           8 | Redmi Note 4   |
+-------------+----------------+
*/


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

/*
+------------+-------------------+-------------------+
| product_id | product_name      | cancellation_time |
+------------+-------------------+-------------------+
|          4 | Sony Vostro Glide |                 2 |
|          1 | Redmi 3s Prime    |                 1 |
+------------+-------------------+-------------------+
*/