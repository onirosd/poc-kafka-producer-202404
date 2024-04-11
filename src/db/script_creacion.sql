DROP TABLE Clientes


CREATE TABLE Clientes (
    id NVARCHAR(50) PRIMARY KEY,
    nombre NVARCHAR(100) NOT NULL,
    apellidop NVARCHAR(100),
    apellidom NVARCHAR(100),
    edad INT,
    sexo NVARCHAR(10),
    fecha_insercion DATETIME2,
    fecha_modificacion DATETIME2
);



INSERT INTO Clientes (id, nombre, apellidop, apellidom, edad, sexo, fecha_insercion , fecha_modificacion) VALUES
('1', 'Juan', 'Pérez', 'García', 30, 'M',  CONVERT(DATETIME, SYSDATETIMEOFFSET() AT TIME ZONE 'SA Pacific Standard Time'), CONVERT(DATETIME, SYSDATETIMEOFFSET() AT TIME ZONE 'SA Pacific Standard Time')),
('2', 'Ana', 'López', 'Martínez', 25, 'F',  CONVERT(DATETIME, SYSDATETIMEOFFSET() AT TIME ZONE 'SA Pacific Standard Time'), CONVERT(DATETIME, SYSDATETIMEOFFSET() AT TIME ZONE 'SA Pacific Standard Time')),
('3', 'Carlos', 'Gómez', 'Díaz', 28, 'M',  CONVERT(DATETIME, SYSDATETIMEOFFSET() AT TIME ZONE 'SA Pacific Standard Time'), CONVERT(DATETIME, SYSDATETIMEOFFSET() AT TIME ZONE 'SA Pacific Standard Time')),
('4', 'Laura', 'Moreno', 'Jiménez', 32, 'F',  CONVERT(DATETIME, SYSDATETIMEOFFSET() AT TIME ZONE 'SA Pacific Standard Time'), CONVERT(DATETIME, SYSDATETIMEOFFSET() AT TIME ZONE 'SA Pacific Standard Time')),
('5', 'Sergio', 'Muñoz', 'Alonso', 35, 'M',  CONVERT(DATETIME, SYSDATETIMEOFFSET() AT TIME ZONE 'SA Pacific Standard Time'), CONVERT(DATETIME, SYSDATETIMEOFFSET() AT TIME ZONE 'SA Pacific Standard Time')),
('6', 'Marta', 'Alvarez', 'Gutiérrez', 22, 'F',  CONVERT(DATETIME, SYSDATETIMEOFFSET() AT TIME ZONE 'SA Pacific Standard Time'), CONVERT(DATETIME, SYSDATETIMEOFFSET() AT TIME ZONE 'SA Pacific Standard Time')),
('7', 'Fernando', 'Romero', 'Navarro', 29, 'M',  CONVERT(DATETIME, SYSDATETIMEOFFSET() AT TIME ZONE 'SA Pacific Standard Time'), CONVERT(DATETIME, SYSDATETIMEOFFSET() AT TIME ZONE 'SA Pacific Standard Time')),
('8', 'Lucía', 'Sánchez', 'Torres', 27, 'F',  CONVERT(DATETIME, SYSDATETIMEOFFSET() AT TIME ZONE 'SA Pacific Standard Time'), CONVERT(DATETIME, SYSDATETIMEOFFSET() AT TIME ZONE 'SA Pacific Standard Time')),
('9', 'David', 'Díaz', 'Castillo', 33, 'M',  CONVERT(DATETIME, SYSDATETIMEOFFSET() AT TIME ZONE 'SA Pacific Standard Time'), CONVERT(DATETIME, SYSDATETIMEOFFSET() AT TIME ZONE 'SA Pacific Standard Time')),
('10', 'Sofía', 'Gil', 'López', 26, 'F',  CONVERT(DATETIME, SYSDATETIMEOFFSET() AT TIME ZONE 'SA Pacific Standard Time'), CONVERT(DATETIME, SYSDATETIMEOFFSET() AT TIME ZONE 'SA Pacific Standard Time'));



INSERT INTO Clientes (id, nombre, apellidop, apellidom, edad, sexo, fecha_insercion, fecha_modificacion) VALUES
('16', 'Diego', 'Fernando', 'García', 30, 'M', CONVERT(DATETIME, SYSDATETIMEOFFSET() AT TIME ZONE 'SA Pacific Standard Time'), CONVERT(DATETIME, SYSDATETIMEOFFSET() AT TIME ZONE 'SA Pacific Standard Time'))



INSERT INTO Clientes (id, nombre, apellidop, apellidom, edad, sexo, fecha_insercion , fecha_modificacion) VALUES
('17', 'Juan', 'Pérez', 'García', 30, 'M',  CONVERT(DATETIME, SYSDATETIMEOFFSET() AT TIME ZONE 'SA Pacific Standard Time'), CONVERT(DATETIME, SYSDATETIMEOFFSET() AT TIME ZONE 'SA Pacific Standard Time')),
('18', 'Ana', 'López', 'Martínez', 25, 'F',  CONVERT(DATETIME, SYSDATETIMEOFFSET() AT TIME ZONE 'SA Pacific Standard Time'), CONVERT(DATETIME, SYSDATETIMEOFFSET() AT TIME ZONE 'SA Pacific Standard Time')),
('19', 'Ana', 'López', 'Martínez', 25, 'F',  CONVERT(DATETIME, SYSDATETIMEOFFSET() AT TIME ZONE 'SA Pacific Standard Time'), CONVERT(DATETIME, SYSDATETIMEOFFSET() AT TIME ZONE 'SA Pacific Standard Time'))



select * from Clientes

delete from Clientes where id in (7, 9)