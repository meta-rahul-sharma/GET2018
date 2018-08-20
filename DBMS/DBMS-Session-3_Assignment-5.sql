USE storefront;

/*
Create a view displaying the order information (Id, Title, Price, Shopper’s name, Email, Orderdate, Status) 
with latest ordered items should be displayed first for last 60 days.
*/
create view order_items_details as
    SELECT order_details.order_id, products.product_id, product_name, items_ordered.price, users.user_name, users.email, date_of_order, order_status
    FROM items_ordered INNER JOIN order_details INNER JOIN users INNER JOIN products ON
        order_details.email = users.email AND
        items_ordered.order_id = order_details.order_id AND
        products.product_id = items_ordered.product_id
    WHERE date_of_order BETWEEN DATE_SUB(NOW(), INTERVAL 60 DAY) AND NOW() 
    ORDER BY date_of_order DESC;

/*    
Use the above view to display the Products(Items) which are in ‘shipped’ state.
*/
SELECT product_id, product_name
FROM order_items_details
WHERE order_status = 'Shipped';

/*
Use the above view to display the top 5 most selling products.
*/
SELECT product_id, product_name
FROM order_items_details
GROUP BY product_id
ORDER BY COUNT(product_id) DESC;