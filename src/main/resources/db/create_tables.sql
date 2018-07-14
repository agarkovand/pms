--  customer

CREATE TABLE IF NOT EXISTS customer
(
 id INT NOT NULL AUTO_INCREMENT,
 name VARCHAR(45) NOT NULL,
 address_line VARCHAR(255),
 city VARCHAR(100),
 region VARCHAR(100),
 country VARCHAR(100),
 zip_code VARCHAR(20),
 
PRIMARY KEY (id)
);

--  customer_phone

CREATE TABLE IF NOT EXISTS customer_phone
(
 customer_id INT NOT NULL,
 phone VARCHAR(20) NOT NULL,
 
PRIMARY KEY (customer_id,phone),
FOREIGN KEY (customer_id) REFERENCES customer(id)
);

--  customer_email

CREATE TABLE IF NOT EXISTS customer_email
(
 customer_id INT NOT NULL,
 email VARCHAR(20) NOT NULL,
 kind VARCHAR(20) NOT NULL,
 
PRIMARY KEY (customer_id,email,kind),
FOREIGN KEY (customer_id) REFERENCES customer(id)
);

--  project

CREATE TABLE IF NOT EXISTS project
(
 id             INT NOT NULL AUTO_INCREMENT,
 customer_id    INT NOT NULL,
 title          VARCHAR(45) NOT NULL,
 total_budget   DECIMAL(19,4),
 start_date     DATE,
 delivery_date  DATE,

PRIMARY KEY (id),
FOREIGN KEY (customer_id) REFERENCES customer (id)
);
