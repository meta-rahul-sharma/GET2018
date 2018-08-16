/*
Display Id, Title, Category Title, Price of the products which are Active and recently added products should be at top.
*/
SELECT 	products.product_id, product_name, category_name, price 
FROM products, categories, categorylink 
where products.product_id = categorylink.product_id 
AND categories.category_id = categorylink.category_id
ORDER BY product_issue_date;


/*
Display the list of products which don't have any images.
*/
SELECT DISTINCT products.product_id, product_name, quantity, price 
FROM products 
WHERE NOT EXISTS (SELECT images.product_id 
				  FROM images 
				  WHERE images.product_id = products.product_id);


/*
Display all Id, Title and Parent Category Title for all the Categories listed,
sorted by Parent Category Title and then Category Title. 
(If Category is top category then Parent Category Title column should display “Top Category” as value.)
*/
SELECT child.category_id, child.category_name, 
IFNULL(parent.category_name, 'Top Category') as parent_name
FROM categories child
LEFT JOIN categories parent
ON child.parent_id = parent.category_id
ORDER BY parent_name, child.category_name;

/*
Display Id, Title, Parent Category Title of all the leaf Categories 
(categories which are not parent of any other category)
*/
SELECT leaf.category_id, leaf.category_name, parent.category_name as parent_category_name
FROM categories leaf, categories parent
WHERE parent.category_id = leaf.parent_id AND NOT EXISTS(SELECT * 
														 FROM categories child 
                                                         WHERE leaf.category_id = child.parent_id);

/*
Display Product Title, Price & Description which falls into particular category Title (i.e. “Mobile”)
*/
SELECT product_name, price, category_name
FROM products, categories, categorylink
where products.product_id = categorylink.product_id 
AND categories.category_id = categorylink.category_id;

/*
Display the list of Products whose Quantity on hand (Inventory) is under 50.
*/
SELECT product_id, product_name, quantity, price 
FROM products 
WHERE quantity < 50;

/*
Increase the Inventory of all the products by 100.
*/
UPDATE products 
SET quantity = quantity + 100 
WHERE product_id > 0;