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
AplicarDto 		boolean			NOT NULL,

PRIMARY KEY (Id)
);

CREATE TABLE TIPO (
Id			INT,		
nombre		varchar(50)	
);