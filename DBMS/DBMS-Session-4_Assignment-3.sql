/*
Identify the columns require indexing in order, product, category tables and create indexes.
*/
ALTER TABLE products ADD INDEX productIndex(product_name, product_issue_date);

ALTER TABLE order_details ADD INDEX orderIndex(email);

ALTER TABLE categories ADD INDEX categoryIndex(category_name);