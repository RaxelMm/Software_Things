SHOW DATABASES ;
CREATE DATABASE empresa;
USE empresa;

CREATE TABLE Empleados (
    id_empleado INT AUTO_INCREMENT PRIMARY KEY,
    nombre_empleado VARCHAR(100)
);

INSERT INTO Empleados (nombre_empleado) VALUES
('Juan López'),
('María Martínez'),
('Pedro Fernández'),
('Lucía Díaz');

CREATE TABLE Proyectos (
    id_proyecto INT AUTO_INCREMENT PRIMARY KEY,
    nombre_proyecto VARCHAR(100)
);

INSERT INTO Proyectos (nombre_proyecto) VALUES
('Desarrollo Web'),
('Sistema ERP'),
('Aplicación Móvil');

CREATE TABLE Asignaciones (
    id_asignacion INT AUTO_INCREMENT PRIMARY KEY,
    id_empleado INT,
    id_proyecto INT,
    FOREIGN KEY (id_empleado) REFERENCES Empleados(id_empleado),
    FOREIGN KEY (id_proyecto) REFERENCES Proyectos(id_proyecto)
);

INSERT INTO Asignaciones (id_empleado, id_proyecto) VALUES
(1, 1),
(2, 1),
(3, 2);

SHOW TABLES;


SELECT
    p.id_proyecto,
    p.nombre_proyecto,
    e.id_empleado,
    e.nombre_empleado
FROM
    Proyectos p
LEFT JOIN
    Asignaciones a ON p.id_proyecto = a.id_proyecto
LEFT JOIN
    Empleados e ON a.id_empleado = e.id_empleado;











