SHOW DATABASES;
USE vendedores;

SELECT
    c.cust_name AS cliente,
    c.city AS ciudad,
    o.ord_no AS numero_pedido,
    o.ord_date AS fecha_pedido,
    o.purch_amt AS importe
FROM customers c
JOIN orders o ON c.customer_id = o.customer_id
WHERE
    (c.grade IS NOT NULL) -- clientes con calificación
    OR
    (c.grade IS NULL);    -- clientes sin calificación (también cumplen)
