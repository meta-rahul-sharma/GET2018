CREATE DATABASE user;

USE user;

CREATE TABLE user_details(
first_name VARCHAR(20) NOT NULL,
last_name VARCHAR(20),
dob DATE,
contact VARCHAR(20),
email VARCHAR(25) PRIMARY KEY, 
password VARCHAR(25) NOT NULL, 
organization VARCHAR(20));