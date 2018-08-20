USE storefront;
/*
Display the list of products (Id, Title, Count of Categories) which fall in more than one Categories.
*/
SELECT products.product_id, products.product_name, COUNT(categorylink.category_id) count_of_categories
FROM products INNER JOIN categorylink ON
    products.product_id = categorylink.product_id
GROUP BY categorylink.product_id
HAVING COUNT(categorylink.category_id) > 1;

/*
Display Count of products as per below price range 0-1000,1001-5000,Above 5000
*/
SELECT price_range, count(*) no_of_products
FROM (SELECT CASE
                WHEN price >= 0 AND price <= 1000 THEN '0-1000'
                WHEN price >= 1001 AND price <= 5000 THEN '1001-5000'
                ELSE 'Above 5000'
            END as price_range
      FROM products) as count_of_products
GROUP BY price_range;


/*
Display the Categories along with number of products under each category.
*/
SELECT * 
FROM categories;


SELECT parent.category_id, parent.category_name, COUNT(link.product_id) as number_of_product_in_category
FROM categories child , categories parent, categorylink link
WHERE (parent.category_id = child.parent_id OR parent.category_id = child.category_id)
AND child.category_id = link.category_id
GROUP BY parent.category_id;