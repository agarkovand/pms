--  customer_phone

CREATE TABLE IF NOT EXISTS customer_phone
(
 customer_id INT NOT NULL,
 phone VARCHAR(20) NOT NULL,
 
PRIMARY KEY (customer_id,phone),
FOREIGN KEY (customer_id) REFERENCES customer(customer_id)
);