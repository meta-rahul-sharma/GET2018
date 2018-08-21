/*
Identify the columns require indexing in order, product, category tables and create indexes.
*/
ALTER TABLE products ADD INDEX productIndex(product_id);

ALTER TABLE order_details ADD INDEX orderIndex(order_id);

ALTER TABLE categories ADD INDEX categoryIndex(category_id);