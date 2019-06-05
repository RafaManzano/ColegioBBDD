-- Mostrar alumnos de una asignatura
-- Nombre: mostrarAlumnosDeUnaAsignatura
-- Comentario: Este procedimiento nos permite mostrar los alumnos de una asignatura.
-- Cabecera: PROCEDURE mostrarAlumnosDeUnaAsignatura @nombre varchar(40)
-- Entrada: @nombre varchar(15)
-- Postcondiciones: El procedimiento muestra por pantalla los alumnos de una asignatura. 
CREATE PROCEDURE mostrarAlumnosDeUnaAsignatura @nombre varchar(40)
AS
BEGIN
	SELECT PA.nombre, PA.apellidos FROM PersonaAlumno AS [PA]
	INNER JOIN AlumnoAsignatura AS [AA] ON PA.numeroEstudiante = AA.numeroEstudiante
	INNER JOIN Asignatura AS [A] ON AA.identificadorAsignatura = A.identificador
	WHERE A.nombre = @nombre
END

EXECUTE mostrarAlumnosDeUnaAsignatura 'Programacion'
EXECUTE mostrarAlumnosDeUnaAsignatura 'Entornos de desarollo' --Falla con nombres con espacios
SELECT * FROM Asignatura
GO

-- Mostrar profesores de una asignatura
-- Nombre: mostrarProfesoresDeUnaAsignatura
-- Comentario: Este procedimiento nos permite mostrar los profesores de 
-- una asignatura por pantalla.
-- Cabecera: PROCEDURE mostrarProfesoresDeUnaAsignatura @nombre varchar(40)
-- Entrada: @nombre varchar(15)
-- Postcondiciones: EL procedimiento muestra por pantalla los profesores de una asignatura.
CREATE PROCEDURE mostrarProfesoresDeUnaAsignatura @nombre varchar(40)
AS
BEGIN
	SELECT PP.nombre, PP.apellidos FROM PersonaProfesor AS [PP]
	INNER JOIN ProfesorAsignatura AS [PA] ON PP.nrp = PA.nrp
	INNER JOIN Asignatura AS [A] ON PA.identificadorAsignatura = A.identificador
	WHERE A.nombre = @nombre
END

EXECUTE mostrarProfesoresDeUnaAsignatura 'Entornos de desarollo'
EXECUTE mostrarProfesoresDeUnaAsignatura 'Programacion'
GO
-- Mostrar alumnos
-- Nombre: mostrarAlumnos
-- Comentario: Este procedimiento nos permite mostrar los alumnos de la 
-- base de datos.
-- Cabecera: PROCEDURE mostrarAlumnos 
-- Postcondiciones: EL procedimiento muestra por pantalla los alumnos de la base de datos. 
CREATE PROCEDURE mostrarAlumnos 
AS
BEGIN
	SELECT nombre, apellidos FROM PersonaAlumno
END

EXECUTE mostrarAlumnos
GO
-- Mostrar profesores
-- Nombre: mostrarProfesores
-- Comentario: Este procedimiento nos permite mostrar por pantalla los profesores 
-- de la base de datos.
-- Postcondiciones: El procedimiento muestra por pantalla los profesores de la base de datos.
CREATE PROCEDURE mostrarProfesores 
AS
BEGIN
	SELECT nombre, apellidos FROM PersonaProfesor
END

EXECUTE mostrarProfesores
GO
-- Mostrar asignaturas
-- Nombre: mostrarAsignaturas
-- Comentario: Este procedimiento nos permite mostrar las asignaturas de la base de datos.
-- Cabecera: PROCEDURE mostrarAsignaturas
-- Postcondiciones: El procedimiento nos muestra las asignaturas de la base de datos.
CREATE PROCEDURE mostrarAsignaturas
AS
BEGIN
	SELECT identificador, nombre, numeroAula FROM Asignatura
END

EXECUTE mostrarAsignaturas
GO
-- Nombre: aliminarAlumno
-- Comentario: Este procedimiento nos permite eliminar un alumno de la base de datos, también se elimina todas las 
-- referencias de este alumno en la demás tablas.
-- Cabecera: PROCEDURE eliminarAlumno @numeroEstudiante smallint, @validez smallint OUTPUT
-- Entrada: @numeroEstudiante smallint
-- Salida: @validez smallint OUTPUT 
-- Postcondiciones: El procedimiento devuelve un número entero asociado al nombre, 0 si 
-- se ha eliminado el alumno o -1 si no se ha encontrado el alumno en la base de datos.
CREATE PROCEDURE eliminarAlumno @numeroEstudiante smallint, @validez smallint OUTPUT 
AS
BEGIN
	IF ((SELECT 1 FROM PersonaAlumno WHERE numeroEstudiante = @numeroEstudiante) = 1)
	BEGIN
		SET @validez = 0
		DELETE PersonaAlumno FROM PersonaAlumno WHERE numeroEstudiante = @numeroEstudiante 
	END
	ELSE
	BEGIN
		SET @validez = -1
	END
	RETURN
END
DECLARE @resultado smallint
EXECUTE eliminarAlumno 3, @validez = @resultado OUTPUT
PRINT @resultado

SELECT * FROM AlumnoAsignatura--Prueba
SELECT * FROM AlumnoProfesor--Prueba
EXECUTE mostrarAlumnos--Prueba
GO
-- Nombre: eliminarProfesor
-- Comentario: Este procedimiento nos permite eliminar un profesor de la base de datos, también se elimina todas las 
-- referencias de este profesor en la demás tablas.
-- Cabecera: PROCEDURE eliminarProfesor @nrp char(16), @validez smallint OUTPUT 
-- Entrada: @nrp char(16)
-- Salida: @validez smallint OUTPUT 
-- Postcondiciones: El procedimiento devuelve un número entero asociado al nombre, 0 si
-- se ha conseguido eliminar el profesor o -1 si este no se encuentra en la base de datos.
CREATE PROCEDURE eliminarProfesor @nrp char(16), @validez smallint OUTPUT 
AS
BEGIN
	IF ((SELECT 1 FROM PersonaProfesor WHERE nrp = @nrp) = 1)
	BEGIN
		SET @validez = 0;
		DELETE FROM PersonaProfesor WHERE nrp = @nrp
	END
	ELSE
	BEGIN
		SET @validez = -1;
	END
END

DECLARE @resultado smallint
EXECUTE eliminarProfesor 5, @validez = @resultado OUTPUT
PRINT @resultado

SELECT * FROM PersonaProfesor
SELECT * FROM AlumnoProfesor
Select * FROm ProfesorAsignatura
GO
-- Nombre: eliminarAsignatura
-- Comentario: Este procedimiento nos permite eliminar un profesor de la base de datos, también se elimina todas las 
-- referencias de este profesor en la demás tablas.
-- Cabecera: PROCEDURE eliminarAsignatura @identificador smallint, @validez smallint OUTPUT 
-- Entrada: @identificador smallint
-- Salida: @validez smallint OUTPUT 
-- Postcondiciones: El procedimiento devuelve un número entero asociado al nombre, 0 si se 
-- ha eliminado la asignatura o -1 si no se ha encontrado la asignatura en la base de datos.
CREATE PROCEDURE eliminarAsignatura @identificador smallint, @validez smallint OUTPUT 
AS
BEGIN
	IF ((SELECT 1 FROM Asignatura WHERE identificador = @identificador) = 1)
	BEGIN
		SET @validez = 0;
		DELETE FROM Asignatura WHERE identificador = @identificador
	END
	ELSE
	BEGIN
		SET @validez = -1;
	END
END

DECLARE @resultado smallint
EXECUTE eliminarAsignatura 5, @validez = @resultado OUTPUT
PRINT @resultado

SELECT * FROM AlumnoAsignatura
SELECT * FROM Asignatura
Select * FROm ProfesorAsignatura
GO 
-- Nombre: addAlumno
-- Comentario: Este procedimiento nos permite añadir un alumno a la base de datos.
-- Cabecera: PROCEDURE addAlumno @dni char(9), @nombre varchar(15), @apellidos varchar(30), 
-- @edad tinyint, @telefono char(9), @numeroEstudiante smallint, @validez smallint OUTPUT
-- Entrada: @dni char(9), @nombre varchar(15), @apellidos varchar(30), @edad tinyint, @telefono char(9), @numeroEstudiante smallint
-- Salida: @validez smallint OUTPUT
-- Postcondiciones: El procedimiento devuelve un número entero asociado al nombre, 0 si se ha conseguido insertar
-- el nuevo alumno, -1 si ya existía un alumno con el mismo número de estudiante en la base de datos o -2 si ya
-- existía un estudiante con el mismo dni.
CREATE PROCEDURE addAlumno @dni char(9), @nombre varchar(15), @apellidos varchar(30), @edad tinyint, @telefono char(9), @numeroEstudiante smallint, @validez smallint OUTPUT
AS
BEGIN
	IF ((SELECT 1 FROM PersonaAlumno WHERE numeroEstudiante = @numeroEstudiante) = 1) 
	BEGIN
		SET @validez = -1;
	END
	ELSE
	BEGIN
		IF ((SELECT 1 FROM PersonaAlumno WHERE dni = @dni) = 1)
		BEGIN
			SET @validez = -2;
		END
		ELSE
		BEGIN
			SET @validez = 0;
			INSERT INTO PersonaAlumno VALUES(@dni, @nombre, @apellidos, @edad, @telefono, @numeroEstudiante)
		END
	END
END

DECLARE @resultado smallint
--EXECUTE addAlumno '72970888F', 'Paco', 'Garcia', 20, '666777888', 67, @resultado OUTPUT
--EXECUTE addAlumno '00000000T', 'Paco', 'Garcia', 20, '666777888', 1, @resultado OUTPUT
--EXECUTE addAlumno '72970888F', 'Paco', 'Garcia', 20, '666777888', 1, @resultado OUTPUT
EXECUTE addAlumno '00000000T', 'Paco', 'Garcia', 20, '666777888', 67, @resultado OUTPUT
PRINT @resultado

SELECT * FROM AlumnoAsignatura
SELECT * FROM AlumnoProfesor
Select * FROm PersonaAlumno
GO

-- Nombre: addProfesor
-- Comentario: Este procedimiento nos permite añadir un profesor a la base de datos.
-- Cabecera: PROCEDURE addProfesor @dni char(9), @nombre varchar(15), @apellidos varchar(30), 
-- @edad tinyint, @telefono char(9), @nrp smallint, @validez smallint OUTPUT
-- Entrada: @dni char(9), @nombre varchar(15), @apellidos varchar(30), @edad tinyint, @telefono char(9), @nrp smallint
-- Salida: @validez smallint OUTPUT
-- Postcondiciones: El procedimiento devuelve un número entero asociado al nombre, 0 si se ha conseguido insertar
-- el nuevo profesor, -1 si ya existía un profesor con el mismo nrp en la base de datos o -2 si ya
-- existía un profesor con el mismo dni.
CREATE PROCEDURE addProfesor @dni char(9), @nombre varchar(15), @apellidos varchar(30), @edad tinyint, @telefono char(9), @nrp char(16), @validez smallint OUTPUT
AS
BEGIN
	IF ((SELECT 1 FROM PersonaProfesor WHERE nrp = @nrp) = 1) 
	BEGIN
		SET @validez = -1;
	END
	ELSE
	BEGIN
		IF ((SELECT 1 FROM PersonaProfesor WHERE dni = @dni) = 1)
		BEGIN
			SET @validez = -2;
		END
		ELSE
		BEGIN
			SET @validez = 0;
			INSERT INTO PersonaProfesor VALUES(@dni, @nombre, @apellidos, @edad, @telefono, @nrp)
		END
	END
END

DECLARE @resultado smallint
--EXECUTE addProfesor '48949896P', 'Carmen', 'Martinez', 50, '642390109', 10, @resultado OUTPUT
--EXECUTE addProfesor '00000000T', 'Paco', 'Garcia', 20, '666777888', 5, @resultado OUTPUT
--EXECUTE addProfesor '48949896P', 'Paco', 'Garcia', 20, '666777888', 3, @resultado OUTPUT
EXECUTE addProfesor '00000001T', 'Paco', 'Garcia', 20, '666777888', 32, @resultado OUTPUT
PRINT @resultado

SELECT * FROM ProfesorAsignatura
SELECT * FROM AlumnoProfesor
Select * FROm PersonaProfesor
GO
-- Nombre: addAsignatura
-- Comentario: Este procedimiento nos permite añadir una asignatura a la base de datos.
-- Cabecera: PROCEDURE addAsignatura @identificador smallint, @nombre varchar(15), @numeroAula smallint, @validez smallint OUTPUT
-- Entrada: @identificador smallint, @nombre varchar(15), @numeroAula smallint
-- Salida: @validez smallint OUTPUT
-- Postcondiciones: El procedimiento devuelve un número entero asociado al nombre, 0 si se ha conseguido insertar
-- la nuevo asignatura, -1 si ya existía una asignatura con el mismo identificador en la base de datos o -2 si ya
-- existía una asignatura con el mismo nombre.
CREATE PROCEDURE addAsignatura @identificador smallint, @nombre varchar(15), @numeroAula smallint, @validez smallint OUTPUT
AS
BEGIN
	IF ((SELECT 1 FROM Asignatura WHERE identificador = @identificador) = 1) 
	BEGIN
		SET @validez = -1;
	END
	ELSE
	BEGIN
		IF ((SELECT 1 FROM Asignatura WHERE nombre = @nombre) = 1)
		BEGIN
			SET @validez = -2;
		END
		ELSE
		BEGIN
			SET @validez = 0;
			INSERT INTO Asignatura VALUES(@identificador, @nombre, @numeroAula)
		END
	END
END


DECLARE @resultado smallint
--EXECUTE addAsignatura 1, 'Geografía', 106, @resultado OUTPUT
--EXECUTE addAsignatura 33,'Entornos de desarrollo',104, @resultado OUTPUT
--EXECUTE addAsignatura 1,'Entornos de desarollo',104, @resultado OUTPUT
EXECUTE addAsignatura 33,'Geografía',104, @resultado OUTPUT
PRINT @resultado

SELECT * FROM ProfesorAsignatura
SELECT * FROM AlumnoAsignatura
Select * FROm Asignatura
GO

-- Nombre: asignarAlumnoConAsignatura	--Error no funcionan los !=
-- Comentario: Este procedimiento nos permite relacionar a un alumno con una asignatura.
-- Cabecera: PROCEDURE asignarAlumnoConAsignatura @numeroEstudiante smallint, @identificadorAsignatura smallint, @validez smallint OUTPUT
-- Entrada: @numeroEstudiante smallint, @identificadorAsignatura smallint
-- Salida: @validez smallint OUTPUT
-- Postcondiciones: El procedimiento devuelve un número entero asociado al nombre, 0 si se ha conseguido relacionar el alumno con la asignatura, 
-- -1 si ya se encuentran relacionados, -2 si el alumno no existe o -3 si la asignatura no existe en la base de datos.
ALTER PROCEDURE asignarAlumnoConAsignatura @numeroEstudiante smallint, @identificadorAsignatura smallint, @validez smallint OUTPUT
AS
BEGIN
	IF ((SELECT 1 FROM AlumnoAsignatura WHERE numeroEstudiante = @numeroEstudiante AND identificadorAsignatura = @identificadorAsignatura) = 1)
	BEGIN
		SET @validez = -1
	END
	ELSE
	BEGIN
		IF ((SELECT 1 FROM PersonaAlumno WHERE numeroEstudiante = @numeroEstudiante) != 1)
		BEGIN
			SET @validez = -2
		END
		ELSE
		BEGIN
			IF ((SELECT 1 FROM Asignatura WHERE identificador = @identificadorAsignatura) != 1)
			BEGIN
				SET @validez = -3
			END
			ELSE
			BEGIN
				SET @validez = 0;
				INSERT INTO AlumnoAsignatura VALUES(@numeroEstudiante, @identificadorAsignatura)
			END
		END
	END
END

DECLARE @resultado smallint
EXECUTE asignarAlumnoConAsignatura 1, 3, @resultado OUTPUT
--EXECUTE asignarAlumnoConAsignatura 6, 1, @resultado OUTPUT
--EXECUTE asignarAlumnoConAsignatura 6, 1, @resultado OUTPUT
PRINT @resultado
SELECT * FROM ProfesorAsignatura
GO
-- Nombre: asignarProfesorConAsignatura
-- Comentario: Este procedimiento nos permite relacionar a un profesor con una asignatura.
-- Cabecera: PROCEDURE asignarProfesorConAsignatura @nrp char(16), @identificadorAsignatura smallint, @validez smallint OUTPUT
-- Entrada: @nrp char(16), @identificadorAsignatura smallint
-- Salida: @validez smallint OUTPUT
-- Postcondiciones: El procedimiento devuelve un número entero asociado al nombre, 0 si se ha conseguido relacionar el profesor con la asignatura, 
-- -1 si ya se encuentran relacionados, -2 si el profesor no existe o -3 si la asignatura no existe en la base de datos.
CREATE PROCEDURE asignarProfesorConAsignatura @nrp char(16), @identificadorAsignatura smallint, @validez smallint OUTPUT
AS
BEGIN
	IF ((SELECT 1 FROM ProfesorAsignatura WHERE nrp = @nrp AND identificadorAsignatura = @identificadorAsignatura) = 1)
	BEGIN
		SET @validez = -1
	END
	ELSE
	BEGIN
		IF ((SELECT 1 FROM PersonaProfesor WHERE nrp = @nrp) != 1)
		BEGIN
			SET @validez = -2
		END
		ELSE
		BEGIN
			IF ((SELECT 1 FROM Asignatura WHERE identificador = @identificadorAsignatura) != 1)
			BEGIN
				SET @validez = -3
			END
			ELSE
			BEGIN
				SET @validez = 0;
				INSERT INTO ProfesorAsignatura VALUES(@nrp, @identificadorAsignatura)
			END
		END
	END
END

EXECUTE asignarProfesorConAsignatura '10101010AS9865WE', 1
SELECT * FROM ProfesorAsignatura
GO
--asignarAlumnoConProfesor
CREATE PROCEDURE asignarAlumnoConProfesor @numeroAlumno smallint, @nrp char(16)
AS
BEGIN
	INSERT INTO AlumnoProfesor VALUES(@numeroAlumno, @nrp)
END

EXECUTE asignarAlumnoConProfesor 67, '10101010AS9865WE'