CREATE DATABASE Colegio
GO
USE Colegio
GO

--DROP DATABASE Colegio
CREATE TABLE PersonaAlumno(
dni char(9) Not null, 
nombre varChar(20) Not null,
apellidos varChar(40) Not null, 
edad tinyint Null, 
telefono char(9) Null, 
numeroEstudiante smallint Not null, 
Constraint PK_Alumno primary key (numeroEstudiante)
)

CREATE TABLE PersonaProfesor(
dni char(9) Not null, 
nombre varChar(20) Not null,
apellidos varChar(40) Not null, 
edad tinyint Null, 
telefono char(9) Null, 
nrp char(16) Not null, 
Constraint PK_Profesor primary key (nrp)
)

CREATE TABLE Asignatura(
identificador smallint Not null,
nombre varchar(40) Not null, 
numeroAula smallint null, 
Constraint PK_Asignatura primary key (identificador)
)

CREATE TABLE ProfesorAsignatura(
nrp char(16) Not null, 
identificadorAsignatura smallint Not null,
Constraint PK_ProfesorAsignatura primary key
(nrp, identificadorAsignatura), 
Constraint FK_ProfesorAsignatura_nrp foreign key
(nrp) references PersonaProfesor(nrp) on
delete cascade on update cascade, 
Constraint FK_ProfesorAsignatura_identificadorAsignatura foreign key
(identificadorAsignatura) references Asignatura(identificador) on
delete cascade on update cascade
)

CREATE TABLE AlumnoAsignatura(
numeroEstudiante smallint Not null, 
identificadorAsignatura smallint Not null,
Constraint PK_AlumnoAsignatura primary key
(numeroEstudiante, identificadorAsignatura), 
Constraint FK_AlumnosAsignatura_numeroEstudiante foreign key
(numeroEstudiante) references PersonaAlumno(numeroEstudiante) on
delete cascade on update cascade,
Constraint FK_AlumnosAsignatura_identificadorAsignatura foreign key
(identificadorAsignatura) references Asignatura(identificador) on
delete cascade on update cascade
)

CREATE TABLE AlumnoProfesor(
numeroEstudiante smallint Not null, 
nrp char(16) Not null, 
Constraint PK_AlumnoProfesor primary key
(numeroEstudiante, nrp),
Constraint FK_AlumnoProfesor_numeroEstudiante foreign key
(numeroEstudiante) references PersonaAlumno(numeroEstudiante) on
delete cascade on update cascade,
Constraint FK_AlumnoProfesor_nrp foreign key 
(nrp) references PersonaProfesor(nrp) on
delete cascade on update cascade
)


INSERT INTO PersonaAlumno
VALUES ('18037139X', 'Jaime', 'Albarran Montero', 20, '602398102', 1),
	('18171468L', 'Francisco Javier', 'Aviles Fernandez', 20, '615398102', 2),
	('72973803R', 'Manuel', 'Caballero Leiva', 19, '605392192', 3),
	('72982671Z', 'Yeray Manuel', 'Campanario Fernandez', 21, '610089102', 4),
	('25185486A', 'Octavio Juan', 'Cortazar Rodriguez', 25, '702398102', 5),
	('28813322A', 'Carlos', 'Echarri Morejon', 22, '609703102', 6),
	('48934518V', 'Guillermo', 'Galvez Lucena', 20, '672328272', 7),
	('25484446D', 'Alejandro', 'Gata Barros', 21, '722302102', 8),
	('72970888F', 'Abraham', 'Gomez Reyes', 24, '619598427', 9),
	('72989971T', 'Raquel', 'Gonzalez Trujillo', 24, '752398197', 10),
	('28965138L', 'Daniel', 'Gordillo Rodriguez', 19, '605098184', 11),
	('74679948Y', 'Rafael', 'Manzano Medina', 23, '682397200', 12),
	('73259286P', 'Ivan', 'Moreno Romero', 22, '712358103', 13),
	('17759227F', 'David', 'Ortega Infantes', 21, '689390308', 14),
	('37256280Y', 'Victor Manuel', 'Perez Lobato', 21, '733398125', 15),
	('18052014G', 'Pablo', 'Prat Jimenez', 20, '696969698', 16),
	('72995082M', 'Antonio', 'Quevedo Garcia', 19, '608042102', 17),
	('29111158N', 'Juan Antonio', 'Quintero Gomez', 22, '703398102', 18),
	('72973803R', 'Alberto', 'Ramirez Aguilar', 23, '702998196', 19),
	('25484446D', 'Ignacio', 'Ramirez Alvarez', 21, '608098789', 20),
	('18027678W', 'Antonio Jesus', 'Ramirez Pachon', 23, '619798100', 21),
	('17763777A', 'Alejandro', 'Ruiz Campos', 22, '602398033', 22),
	('25181662C', 'Javier', 'Ruiz Rodriguez', 19, '681098023', 23),
	('17764684J', 'Manuel', 'Sanchez Delgado', 21, '790398156', 24),
	('14615027E', 'Alejandro', 'Segura Garcia', 22, '790298188', 25),
	('18040660N', 'Angela', 'Vazquez Dominguez', 22, '699398190', 26),
	('18042008A', 'Luis', 'Vergara Castro', 20, '612207102', 27),
	('18051889V', 'Nzhdeh', 'Yeghiazaryan', 26, '609048196', 28)

INSERT INTO PersonaProfesor
VALUES ('76922034Y', 'Asuncion', 'Criado', 50, '702998152', 1),
	('18054101K', 'Miguel Angel', 'Casado', 32, '690323902', 2),
	('52587829P', 'Fernando', 'Galiana', 40, '690392302', 3),
	('29135787P', 'Leopoldo', 'Acal', 45, '760082172', 4),
	('48949896P', 'Rosario', 'Martinez', 50, '642390109', 5)

INSERT INTO Asignatura
VALUES(1, 'Entornos de desarollo', 106),
	(2, 'Sistemas Informaticos', 106),
	(3, 'Programacion', 106),
	(4, 'Bases de datos', 106),
	(5, 'Lenguaje de Marcas', 106),
	(6, 'Formacion y orientacion laboral', 106)

INSERT INTO ProfesorAsignatura
VALUES(1,3),
	(2,1),
	(3,2),
	(4,4),
	(4,5),
	(5,6)

INSERT INTO AlumnoAsignatura
VALUES(1,3),
	(2,1),
	(3,2),
	(4,4),
	(4,5),
	(5,6),
	(10,3),
	(21,1),
	(12,2),
	(8,4),
	(26,5),
	(28,6)



--USE Colegio
--SELECT * FROM PersonaAlumno