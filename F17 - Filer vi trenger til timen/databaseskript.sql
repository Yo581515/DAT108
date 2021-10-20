DROP SCHEMA IF EXISTS f17 CASCADE;
CREATE SCHEMA f17;
SET search_path = f17;

CREATE TABLE klasse 
(
   kode     CHARACTER VARYING (10),
   program  CHARACTER VARYING (40),
   PRIMARY KEY (kode)
);

CREATE TABLE student 
(
   id           CHARACTER (6),
   navn         CHARACTER VARYING (40),
   klasse_kode  CHARACTER VARYING (10),
   PRIMARY KEY (id),
   FOREIGN KEY (klasse_kode) REFERENCES klasse (kode)
);

INSERT INTO klasse VALUES 
	('DATA_h20', 'Dataingeniør'),
	('INF_h20', 'Informasjonsteknologi');
	
INSERT INTO student VALUES
	('123456', 'Arne', 'DATA_h20'),
	('123457', 'Brit', 'DATA_h20'),
	('123458', 'Carl', 'INF_h20'),
	('123459', 'Dina', 'INF_h20'),
	('123460', 'Erik', 'INF_h20');
	






