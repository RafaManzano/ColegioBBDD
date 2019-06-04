CREATE DATABASE Colegio
GO
USE Colegio
GO

CREATE TABLE Persona(
dni char(9) Not null, 
nombre varChar(10) Not null,
apellidos varChar(20) Not null, 
edad tinyint Null, 
telefono char(9) Null, 
Constraint PK_Persona primary key (dni),
Constraint UNI_Persona UNIQUE (dni, nombre, apellidos, edad, telefono)
)

CREATE TABLE Alumno(
dni char(9) Not null, 
nombre varChar(10) Not null,
apellidos varChar(20) Not null, 
edad tinyint Null, 
telefono char(9) Null, 
numeroEstudiante smallint Not null, 
Constraint PK_Alumno primary key (numeroEstudiante),
Constraint FK_Alumno_Persona foreign key
(dni, nombre, apellidos, edad, telefono) references 
Persona(dni, nombre, apellidos, edad, telefono)
)

CREATE TABLE Profesor(
dni char(9) Not null, 
nombre varChar(10) Not null,
apellidos varChar(20) Not null, 
edad tinyint Null, 
telefono char(9) Null, 
nrp char(16) Not null, 
Constraint PK_Profesor primary key (nrp),
Constraint FK_Profesor_Persona foreign key
(dni, nombre, apellidos, edad, telefono) references 
Persona(dni, nombre, apellidos, edad, telefono)
)

CREATE TABLE Asignatura(
identificador smallint Not null,
nombre varchar(15) Not null, 
numeroAula smallint null, 
Constraint PK_Asignatura primary key (identificador)
)

CREATE TABLE ProfesorAsignatura(
nrp char(16) Not null, 
identificadorAsignatura smallint Not null,
Constraint PK_ProfesorAsignatura primary key
(nrp, identificadorAsignatura), 
Constraint FK_ProfesorAsignatura_nrp foreign key
(nrp) references Profesor(nrp), 
Constraint FK_ProfesorAsignatura_identificadorAsignatura foreign key
(identificadorAsignatura) references Asignatura(identificador) on
delete no action on update cascade
)

CREATE TABLE AlumnoAsignatura(
numeroEstudiante smallint Not null, 
identificadorAsignatura smallint Not null,
Constraint PK_AlumnoAsignatura primary key
(numeroEstudiante, identificadorAsignatura), 
Constraint FK_AlumnosAsignatura_numeroEstudiante foreign key
(numeroEstudiante) references Alumno(numeroEstudiante),
Constraint FK_AlumnosAsignatura_identificadorAsignatura foreign key
(identificadorAsignatura) references Asignatura(identificador) on
delete no action on update cascade
)

CREATE TABLE AlumnoProfesor(
numeroEstudiante smallint Not null, 
nrp char(16) Not null, 
Constraint PK_AlumnoProfesor primary key
(numeroEstudiante, nrp),
Constraint FK_AlumnoProfesor_numeroEstudiante foreign key
(numeroEstudiante) references Alumno(numeroEstudiante),
Constraint FK_AlumnoProfesor_nrp foreign key 
(nrp) references Profesor(nrp) on
delete no action on update cascade
)
