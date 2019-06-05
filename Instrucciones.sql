-- Mostrar alumnos de una asignatura
-- Nombre: mostrarAlumnosDeUnaAsignatura
-- Comentario: Este procedimiento nos permite mostrar los alumnos de una asignatura.
-- Cabecera: PROCEDURE mostrarAlumnosDeUnaAsignatura @nombre varchar(15)
-- Entrada: @nombre varchar(15)
-- Postcondiciones: El procedimiento muestra por pantalla los alumnos de una asignatura. 
CREATE PROCEDURE mostrarAlumnosDeUnaAsignatura @nombre varchar(15)
AS
BEGIN
	SELECT PA.nombre, PA.apellidos FROM PersonaAlumno AS [PA]
	INNER JOIN AlumnoAsignatura AS [AA] ON PA.numeroEstudiante = AA.numeroEstudiante
	INNER JOIN Asignatura AS [A] ON AA.identificadorAsignatura = A.identificador
	WHERE A.nombre = @nombre
END

EXECUTE mostrarAlumnosDeUnaAsignatura 'Lengua'
GO

-- Mostrar profesores de una asignatura
-- Nombre: mostrarProfesoresDeUnaAsignatura
-- Comentario: Este procedimiento nos permite mostrar los profesores de 
-- una asignatura por pantalla.
-- Cabecera: PROCEDURE mostrarProfesoresDeUnaAsignatura @nombre varchar(15)
-- Entrada: @nombre varchar(15)
-- Postcondiciones: EL procedimiento muestra por pantalla los profesores de una asignatura.
CREATE PROCEDURE mostrarProfesoresDeUnaAsignatura @nombre varchar(15)
AS
BEGIN
	SELECT PP.nombre, PP.apellidos FROM PersonaProfesor AS [PP]
	INNER JOIN ProfesorAsignatura AS [PA] ON PP.nrp = PA.nrp
	INNER JOIN Asignatura AS [A] ON PA.identificadorAsignatura = A.identificador
	WHERE A.nombre = @nombre
END

EXECUTE mostrarProfesoresDeUnaAsignatura 'Lengua'
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
-- Cabecera: PROCEDURE eliminarAlumno @numeroEstudiante smallint
-- Entrada: @numeroEstudiante smallint
-- Postcondiciones: El procedimiento elimina un estudiante de la base de datos.
CREATE PROCEDURE eliminarAlumno @numeroEstudiante smallint
AS
BEGIN
	DELETE PersonaAlumno FROM PersonaAlumno WHERE numeroEstudiante = @numeroEstudiante 
END

EXECUTE eliminarAlumno 67

SELECT * FROM AlumnoAsignatura--Prueba
SELECT * FROM AlumnoProfesor--Prueba
EXECUTE mostrarAlumnos--Prueba
GO
-- eliminarProfesor
-- Comentario: Este procedimiento nos permite eliminar un profesor de la base de datos, también se elimina todas las 
-- referencias de este profesor en la demás tablas.
CREATE PROCEDURE eliminarProfesor @nrp char(16)
AS
BEGIN
	DELETE FROM ProfesorAsignatura WHERE nrp = @nrp
	DELETE FROM AlumnoProfesor WHERE nrp = @nrp
	DELETE FROM PersonaProfesor WHERE nrp = @nrp
END

EXECUTE eliminarProfesor '10101010AS9865WE'
GO
-- eliminarAsignatura
-- Comentario: Este procedimiento nos permite eliminar un profesor de la base de datos, también se elimina todas las 
-- referencias de este profesor en la demás tablas.
CREATE PROCEDURE eliminarAsignatura @identificador smallint
AS
BEGIN
	DELETE FROM ProfesorAsignatura WHERE identificadorAsignatura = @identificador
	DELETE FROM ProfesorAsignatura WHERE identificadorAsignatura = @identificador
	DELETE FROM Asignatura WHERE identificador = @identificador
END


EXECUTE eliminarAsignatura 1
GO 
-- Añadir Alumno
CREATE PROCEDURE addAlumno @dni char(9), @nombre varchar(15), @apellidos varchar(30), @edad tinyint, @telefono char(9), @numeroEstudiante smallint
AS
BEGIN
	INSERT INTO PersonaAlumno VALUES(@dni, @nombre, @apellidos, @edad, @telefono, @numeroEstudiante)
END


EXECUTE addAlumno '00000000T', 'Paco', 'Garcia', 20, '666777888', 67
GO

-- Añadir Profesor
CREATE PROCEDURE addProfesor @dni char(9), @nombre varchar(15), @apellidos varchar(30), @edad tinyint, @telefono char(9), @nrp char(16)
AS
BEGIN
	INSERT INTO PersonaProfesor VALUES(@dni, @nombre, @apellidos, @edad, @telefono, @nrp)
END

EXECUTE addProfesor '10101010X', 'Pedro', 'Salvat', 31, '686890777', '10101010AS9865WE'

GO
-- Añadir Asignatura
CREATE PROCEDURE addAsignatura @identificador smallint, @nombre varchar(15), @numeroAula smallint
AS
BEGIN
	INSERT INTO Asignatura VALUES(@identificador, @nombre, @numeroAula)
END

EXECUTE addAsignatura 1, 'Lengua', 34
GO

--asignarAlumnoConAsignatura
CREATE PROCEDURE asignarAlumnoConAsignatura @numeroEstudiante smallint, @identificadorAsignatura smallint
AS
BEGIN
	INSERT INTO AlumnoAsignatura VALUES(@numeroEstudiante, @identificadorAsignatura)
END

EXECUTE asignarAlumnoConAsignatura 67, 1
GO
--asignarProfesorConAsignatura
CREATE PROCEDURE asignarProfesorConAsignatura @nrp char(16), @identificadorAsignatura smallint
AS
BEGIN
	INSERT INTO ProfesorAsignatura VALUES(@nrp, @identificadorAsignatura)
END

EXECUTE asignarProfesorConAsignatura '10101010AS9865WE', 1
GO
--asignarAlumnoConProfesor
CREATE PROCEDURE asignarAlumnoConProfesor @numeroAlumno smallint, @nrp char(16)
AS
BEGIN
	INSERT INTO AlumnoProfesor VALUES(@numeroAlumno, @nrp)
END

EXECUTE asignarAlumnoConProfesor 67, '10101010AS9865WE'
