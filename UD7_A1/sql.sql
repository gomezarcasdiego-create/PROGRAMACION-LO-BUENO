DROP DATABASE IF EXISTS inventario;
CREATE DATABASE IF NOT EXISTS inventario;
USE inventario;

CREATE TABLE productos (
Id 				INT 			NOT NULL,
Referencia 		varchar(50)   	NOT NULL,
Nombre 			varchar(50)		NOT NULL,
Descripción 	varchar(100)	NOT NULL,
Tipo 			varchar(20)	    NOT NULL,
Cantidad 		INT				NOT NULL,
Precio 			double			NOT NULL,
Descuento		INT				NOT NULL,
IVA 			INT				NOT NULL,
AplicarDto 		boolean			NOT NULL
);

CREATE TABLE tipo (
Id			INT,		
nombre		varchar(50)	
);

ALTER TABLE tipo ADD PRIMARY KEY (Id);

ALTER TABLE productos ADD TipoId INT;

ALTER TABLE productos ADD CONSTRAINT fk_tipo FOREIGN KEY (TipoId) REFERENCES tipo(Id);

INSERT INTO tipo (Id, nombre) VALUES
(1, 'Electrónica'),
(2, 'Ropa'),
(3, 'Alimentación');

INSERT INTO productos 
(Id, Referencia, Nombre, Descripción, Tipo, Cantidad, Precio, Descuento, IVA, AplicarDto, TipoId)
VALUES
(1, 'REF001', 'Laptop', 'Portátil 16GB RAM', 'Electrónica', 10, 900.50, 10, 21, true, 1),
(2, 'REF002', 'Camiseta', 'Camiseta algodón', 'Ropa', 50, 15.99, 5, 21, true, 2),
(3, 'REF003', 'Pan', 'Pan integral', 'Alimentación', 100, 1.20, 0, 4, false, 3);

UPDATE productos 
SET Precio = 850.00 
WHERE Id = 1;

UPDATE productos 
SET Cantidad = Cantidad + 20 
WHERE Id = 2;

UPDATE productos 
SET Descuento = 15 
WHERE TipoId = 1;

UPDATE productos 
SET TipoId = 2 
WHERE Id = 1;