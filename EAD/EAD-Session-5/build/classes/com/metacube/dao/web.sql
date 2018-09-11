CREATE DATABASE web;

USE web;

create table category (category_id integer Primary Key auto_increment, category_name varchar(25));

create table advertisement
(adv_id integer Primary key auto_increment,
title varchar(25), 
description varchar(30),
category_id integer,
foreign key(category_id) references category(category_id));

SELECT * FROM web.category;

select * from web.advertisement;
