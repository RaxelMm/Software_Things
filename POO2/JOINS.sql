SHOW DATABASES;
CREATE DATABASE vendedores;
USE vendedores;
CREATE TABLE customers (
    customer_id INT PRIMARY KEY,
    cust_name VARCHAR(100),
    city VARCHAR(50),
    grade INT,
    salesman_id INT
);
SELECT * FROM customers;

CREATE TABLE salesmen (
    salesman_id INT PRIMARY KEY,
    name VARCHAR(100),
    city VARCHAR(50),
    commission DECIMAL(5,2)
);

CREATE TABLE orders (
    ord_no INT PRIMARY KEY,
    purch_amt DECIMAL(10,2),
    ord_date DATE,
    customer_id INT,
    salesman_id INT
);

INSERT INTO salesmen (salesman_id, name, city, commission) VALUES
(5001, 'Carlos Gómez', 'Ciudad de México', 0.15),
(5002, 'Laura Torres', 'Monterrey', 0.12),
(5003, 'Diego Rivera', 'Guadalajara', 0.10);

INSERT INTO customers (customer_id, cust_name, city, grade, salesman_id) VALUES
(3001, 'Ana Martínez', 'Ciudad de México', 100, 5001),
(3002, 'Luis Herrera', 'Monterrey', 200, 5002),
(3003, 'María López', 'Guadalajara', 300, 5003),
(3004, 'Pedro Pérez', 'Ciudad de México', 100, 5001);

INSERT INTO orders (ord_no, purch_amt, ord_date, customer_id, salesman_id) VALUES
(7001, 1500.00, '2025-04-01', 3001, 5001),
(7002, 2200.00, '2025-04-02', 3002, 5002),
(7003, 1800.00, '2025-04-03', 3003, 5003),
(7004, 2100.00, '2025-04-04', 3004, 5001);

SELECT
    s.name AS vendedor,
    c.cust_name AS cliente,
    c.city AS ciudad,
    c.grade AS grado,
    o.ord_no AS numero_pedido,
    o.ord_date AS fecha_pedido,
    o.purch_amt AS importe
FROM salesmen s
LEFT JOIN customers c ON s.salesman_id = c.salesman_id
LEFT JOIN orders o ON c.customer_id = o.customer_id;
