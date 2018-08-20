CREATE DATABASE StoreFront;

USE StoreFront;

CREATE TABLE users(email VARCHAR(30) PRIMARY KEY,
	user_name VARCHAR(20) NOT NULL,
    phone_no VARCHAR(10) NOT NULL,
    account_password VARCHAR(15) NOT NULL,
    dob DATE NOT NULL,
    type_of_user varchar(1) NOT NULL CHECK(type_of_user IN ('S', 'A')));
    
CREATE TABLE address(address_id INTEGER PRIMARY KEY AUTO_INCREMENT, 
    street VARCHAR(25) NOT NULL,  
    city VARCHAR(20) NOT NULL, 
    state VARCHAR(20) NOT NULL, 
    country VARCHAR(15) NOT NULL, 
    pincode VARCHAR(10) NOT NULL, 
    email VARCHAR(30), 
    FOREIGN KEY (email) REFERENCES users(email) ON DELETE CASCADE ON UPDATE CASCADE);
    
CREATE TABLE products(product_id INT PRIMARY KEY AUTO_INCREMENT, 
    product_name VARCHAR(30) NOT NULL, 
    quantity INT NOT NULL CHECK(quantity >= 0), 
    price FLOAT NOT NULL, 
    product_issue_date DATE NOT NULL); 
    
CREATE TABLE images(product_id INT,
    image_url VARCHAR(50), 
    PRIMARY KEY(product_id, image_url),
    FOREIGN KEY (product_id) REFERENCES products(product_id) ON DELETE CASCADE ON UPDATE CASCADE);
    
CREATE TABLE categories(category_name VARCHAR(15) NOT NULL, 
    category_id INT PRIMARY KEY AUTO_INCREMENT, 
    parent_id INT, 
    FOREIGN KEY (parent_id) REFERENCES categories(category_id) ON DELETE CASCADE ON UPDATE CASCADE); 
    
CREATE TABLE categorylink(product_id INT, 
    category_id INT, 
    PRIMARY KEY(product_id, category_id),
    FOREIGN KEY (product_id) REFERENCES products(product_id) ON DELETE CASCADE ON UPDATE CASCADE, 
    FOREIGN KEY (category_id) REFERENCES categories(category_id) ON DELETE CASCADE ON UPDATE CASCADE);
      
CREATE TABLE order_details(order_id INT PRIMARY KEY AUTO_INCREMENT,
    email VARCHAR(25) NOT NULL,
    total_price FLOAT NOT NULL, 
    date_of_order DATE NOT NULL,
    FOREIGN KEY (email) REFERENCES users(email) ON DELETE CASCADE ON UPDATE CASCADE);
    
CREATE TABLE items_ordered(order_id INT, 
    product_id INT, 
    quantity INT NOT NULL CHECK(quantity > 0), 
    price FLOAT, 
	order_status VARCHAR(20) CHECK(order_status IN ('Shipped', 'Cancelled', 'Returned')),
    PRIMARY KEY (order_id, product_id), 
    FOREIGN KEY (order_id) REFERENCES order_details(order_id) ON DELETE CASCADE ON UPDATE CASCADE, 
    FOREIGN KEY (product_id) REFERENCES products(product_id) ON DELETE CASCADE ON UPDATE CASCADE);

SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE products;
SET FOREIGN_KEY_CHECKS = 1;

CREATE TABLE products(product_id INT PRIMARY KEY AUTO_INCREMENT, 
    product_name VARCHAR(30) NOT NULL, 
    quantity INT NOT NULL CHECK(quantity >= 0), 
    price FLOAT NOT NULL, 
    product_issue_date DATE NOT NULL); 