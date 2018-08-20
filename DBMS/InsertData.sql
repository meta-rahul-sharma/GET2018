INSERT INTO users(email, user_name, phone_no, account_password, dob, type_of_user) VALUES
('rsbhatra98@gmail.com', 'rahul sharma', '8947804883', '1234', '1997-10-25', 'A'),
('rs98@gmail.com', 'rahul jangid', '8947804889', '123412', '1998-10-25', 'S'),
('chirag10march@gmail.com', 'chirag jain', '7737596610', '12342742', '1997-03-10', 'S'),
('tanumittal@gmail.com', 'tanu mittal', '1234567893', '4321', '1995-03-31', 'S'),
('innovativemohit@gmail.com', 'mohit sharma', '7877235269', 'asjkfh', '1997-12-25', 'S'),
('prakalpa@gmail.com', 'prakalpa rathore', '9878654512', 'adress', '1996-09-22', 'S');

INSERT INTO address (street, city, state, country, pincode, email) VALUES
('plot no. 605', 'jaipur', 'rajasthan', 'india', '302039', 'rsbhatra98@gmail.com'),
('MBM HOSTEL', 'JODHPUR', 'rajasthan', 'india', '342011', 'rsbhatra98@gmail.com'),
('JUHU BEACH', 'GOA', 'GOA', 'india', '393231', 'rsbhatra98@gmail.com'),
('NEAR GANESH MANDIR', 'jaipur', 'rajasthan', 'india', '302031', 'innovativemohit@gmail.com'),
('HALDI GHATI MARG', 'jaipur', 'rajasthan', 'india', '302001', 'chirag10march@gmail.com'),
('UDAPURIA', 'UDAIPUR', 'rajasthan', 'india', '382001', 'chirag10march@gmail.com'),
('RAM MARG', 'JAISALMAIR', 'rajasthan', 'india', '339401', 'tanumittal@gmail.com'),
('RANA SANGA MARG', 'HALDI GHATI', 'PRATAP NAGAR', 'india', '339401', 'tanumittal@gmail.com'),
('BAPU NAGAR', 'JAIPUR', 'rajasthan', 'india', '302013', 'prakalpa@gmail.com');

INSERT INTO products(product_name, quantity, price, product_issue_date) VALUES
    ('Redmi 3s Prime', 10, 9000.00, '2016/07/01'),
    ('Redmi Note 4', 50, 12499.99, '2017/08/01'),
    ('Dell Inspiron 4Ti6xy', 25, 40000.00, '2018/07/01'),
    ('Sony Vostro Glide', 35, 90399.99, '2017/01/01'),
    ('Dell Inspiron 5Ti3fa', 5, 50000.00, '2017/09/23'),
    ('Kingston 16GB', 100, 900.00, '2016/12/12'),
    ('HP 64Gb', 10, 2000.00, '2018/08/01'),
    ('Fastrack Digital Watch 4hy7e', 30, 2000.00, '2016/12/01'),
    ('Timex Analog Watch', 10, 5000.00, '2018/01/01'),
    ('Van Heusen Shirt', 20, 1500.00, '2017/11/11'),
    ('Van Heusen Trouser', 20, 2000.00, '2016/07/01'),
    ('Peter England Suit', 15, 10000.00, '2014/02/12');

INSERT INTO categories(category_name, parent_id) VALUES
    ('Electronics', NULL),
    ('Accessories', NULL),
    ('Fashion Styling', NULL),
    ('Mobile', 1),
    ('Laptop', 1),
    ('USB', 1),
    ('Redmi', 4),
    ('Dell', 5),
    ('Sony', 5),
    ('Kingston', 6),
    ('HP', 6),
    ('Watch', 2),
    ('Fastrack', 12),
    ('Timex', 12),
    ('Shirt', 3),
    ('Trouser', 3),
    ('Suit', 3),
    ('Van Heusen', 15),
    ('Van Heusen', 16),
    ('Peter England', 17);

INSERT INTO categorylink(product_id, category_id) VALUES
    (1,7),
    (2,7),
    (3,8),
    (4,9),
    (5,8),
    (6,10),
    (7,11),
    (8,13),
    (9,14),
    (10,18),
    (11,19),
    (12,20);
    
INSERT INTO order_details(email, total_price, date_of_order) VALUES
	('rsbhatra98@gmail.com', 30000.00, '2018/08/15'),
    ('innovativemohit@gmail.com', 99400.00, '2017/08/15'),
    ('chirag10march@gmail.com', 1000.00, '2018/08/01');
    
INSERT INTO items_ordered(order_id, product_id, quantity, order_status) VALUES
	(1,12,2,20000.00, 'Shipped'),
    (1,9,2,10000.00, 'Shipped'),
    (2,4,1,90400.00, 'Cancelled'),
    (2,1,1,9000.00, 'Shipped'),
    (3,6,1,900.00, 'Returned');


INSERT INTO images(product_id, image_url) VALUES
	(1, 'Redmi3sPrime.jpg'),
    (1, 'Redmi3sPrime1.jpg'),
    (1, 'Redmi3sPrime2.jpg'),
    (1, 'Redmi3sPrime3.jpg'),
    (1, 'Redmi3sPrime4.jpg'),
    (2, 'RedmiNote4.jpg'),
    (2, 'RedmiNote4_1.jpg'),
    (3, 'DellInspiron5Ti3fa.jpg'),
    (4, 'SonyVostroGlide.jpg'),
    (5, 'DellInspiron5Ti3fa.jpg'),
    (6, 'Kingston16GB.jpg'),
    (7, 'HP64Gb.jpg'),
    (7, 'HP64Gb1.jpg'),
    (8, 'FastrackDigitalWatch4hy7e.jpg'),
    (8, 'FastrackDigitalWatch4hy7e1.jpg'),
    (8, 'FastrackDigitalWatch4hy7e2.jpg'),
    (10, 'VanHeusenShirt.jpg'),
    (10, 'VanHeusenShirt1.jpg');
    