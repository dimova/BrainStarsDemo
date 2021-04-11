DROP TABLE IF EXISTS products;

CREATE TABLE products
(
    id                 INT AUTO_INCREMENT PRIMARY KEY,
    name               VARCHAR(250) NOT NULL,
    category           VARCHAR(250) NOT NULL,
    description        VARCHAR(250) DEFAULT NULL,
    quantity           INT          DEFAULT 1,
    created_date       DATE,
    last_modified_date DATE
);

INSERT INTO products (id, name, category, description, quantity, created_date, last_modified_date)
VALUES (1001, 'Dell 5401', 'Laptop', 'Dell Description', 12, '2020-05-20', '2020-06-30');
INSERT INTO products (id, name, category, description, quantity, created_date, last_modified_date)
VALUES (1002, 'Dell U2413', 'Monitor', 'Dell Monitor', 15, '2020-05-20', '2020-06-30');
INSERT INTO products (id, name, category, description, quantity, created_date, last_modified_date)
VALUES (1003, 'Samsung', 'Monitor', 'Samsung Monitor', 9, '2020-06-30', '2020-07-15');

DROP TABLE IF EXISTS orders;

CREATE TABLE orders
(
    id                 INT AUTO_INCREMENT PRIMARY KEY,
    productId          INT,
    quantity           INT,
    created_date       DATE,
    last_modified_date DATE

);

INSERT INTO orders (id, productId, quantity, created_date, last_modified_date)
VALUES (1, 1003, 1, '2020-04-15', '2020-04-15');