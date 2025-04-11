CREATE DATABASE XD;
SHOW DATABASES ;
USE XD;

CREATE TABLE Empleados (
  id_empleado INT PRIMARY KEY,
  nombre_empleado VARCHAR(100),
  departamento VARCHAR(50)
);

CREATE TABLE Proyectos (
  id_proyecto INT PRIMARY KEY,
  nombre_proyecto VARCHAR(100),
  presupuesto DECIMAL(10,2)
);

CREATE TABLE Asignaciones (
  id_asignacion INT PRIMARY KEY,
  id_empleado INT,
  id_proyecto INT,
  fecha_asignacion DATE,
  FOREIGN KEY (id_empleado) REFERENCES Empleados(id_empleado),
  FOREIGN KEY (id_proyecto) REFERENCES Proyectos(id_proyecto)
);

SHOW TABLES;


INSERT INTO Empleados VALUES
(1, 'Ana Gómez', 'Desarrollo'),
(2, 'Carlos Pérez', 'Desarrollo'),
(3, 'Lucía Díaz', 'Recursos Humanos'),
(4, 'Pedro Sánchez', 'Desarrollo'),
(5, 'Marta López', 'Recursos Humanos');

INSERT INTO Proyectos VALUES
(1, 'Sistema de Gestión', 50000.00),
(2, 'Aplicación Móvil', 30000.00),
(3, 'Rediseño del Sitio Web', 20000.00);

INSERT INTO Asignaciones VALUES
(1, 1, 1, '2024-01-01'),
(2, 2, 1, '2024-01-05'),
(3, 3, 2, '2024-02-01');

SELECT * FROM proyectos

SELECT
  e.id_empleado,
  e.nombre_empleado,
  e.departamento,
  p.nombre_proyecto
FROM Empleados e
LEFT JOIN Asignaciones a ON e.id_empleado = a.id_empleado
LEFT JOIN Proyectos p ON a.id_proyecto = p.id_proyecto;


SELECT
  p.id_proyecto,
  p.nombre_proyecto,
  p.presupuesto,
  e.nombre_empleado,
  e.departamento
FROM Proyectos p
LEFT JOIN Asignaciones a ON p.id_proyecto = a.id_proyecto
LEFT JOIN Empleados e ON a.id_empleado = e.id_empleado;


-- Empleados sin proyecto
SELECT
  e.nombre_empleado,
  e.departamento,
  p.nombre_proyecto
FROM Empleados e
LEFT JOIN Asignaciones a ON e.id_empleado = a.id_empleado
LEFT JOIN Proyectos p ON a.id_proyecto = p.id_proyecto
WHERE a.id_empleado IS NULL

UNION

-- Proyectos sin empleados
SELECT
  e.nombre_empleado,
  e.departamento,
  p.nombre_proyecto
FROM Proyectos p
LEFT JOIN Asignaciones a ON p.id_proyecto = a.id_proyecto
LEFT JOIN Empleados e ON a.id_empleado = e.id_empleado
WHERE a.id_proyecto IS NULL;

















