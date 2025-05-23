SHOW DATABASES ;
USE vendedores;
SHOW TABLES ;


SELECT
    c.cust_name AS cliente,
    c.city AS ciudad,
    o.ord_no AS numero_pedido,
    o.ord_date AS fecha_pedido,
    o.purch_amt AS importe,
    s.name AS vendedor,
    s.commission AS comision
FROM customers c
LEFT JOIN orders o ON c.customer_id = o.customer_id
LEFT JOIN salesmen s ON o.salesman_id = s.salesman_id;

SELECT * FROM salesmen;







