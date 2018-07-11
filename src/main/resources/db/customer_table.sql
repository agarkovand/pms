--  customer

CREATE TABLE IF NOT EXISTS customer
(
 customer_id INT NOT NULL AUTO_INCREMENT,
 name VARCHAR(45) NOT NULL,
 address_line VARCHAR(255),
 city VARCHAR(100),
 region VARCHAR(100),
 country VARCHAR(100),
 zip_code VARCHAR(20),
 email VARCHAR(100),
 phone VARCHAR(20),
 
PRIMARY KEY (customer_id),
CONSTRAINT email UNIQUE (email),
CONSTRAINT phone UNIQUE (phone)
);
