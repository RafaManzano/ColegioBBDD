USE Colegio
GO
-- Mostrar alumnos de una asignatura
-- Nombre: mostrarAlumnosDeUnaAsignatura
-- Comentario: Este procedimiento nos permite mostrar los alumnos de una asignatura.
-- Cabecera: PROCEDURE mostrarAlumnosDeUnaAsignatura @identificador smallint
-- Entrada: @identificador smallint
-- Postcondiciones: El procedimiento muestra por pantalla los alumnos de una asignatura.
CREATE PROCEDURE mostrarAlumnosDeUnaAsignatura @identificador smallint
AS
BEGIN
	SELECT PA.nombre, PA.apellidos FROM PersonaAlumno AS [PA]
	INNER JOIN AlumnoAsignatura AS [AA] ON PA.numeroEstudiante = AA.numeroEstudiante
	INNER JOIN Asignatura AS [A] ON AA.identificadorAsignatura = A.identificador
	WHERE A.identificador = @identificador
END

GO
-- Mostrar profesores de una asignatura
-- Nombre: mostrarProfesoresDeUnaAsignatura
-- Comentario: Este procedimiento nos permite mostrar los profesores de 
-- una asignatura por pantalla.
-- Cabecera: PROCEDURE mostrarProfesoresDeUnaAsignatura @identificador smallint
-- Entrada: @identificador smallint
-- Postcondiciones: EL procedimiento muestra por pantalla los profesores de una asignatura.
CREATE PROCEDURE mostrarProfesoresDeUnaAsignatura @identificador smallint
AS
BEGIN
	SELECT PP.nombre, PP.apellidos FROM PersonaProfesor AS [PP]
	INNER JOIN ProfesorAsignatura AS [PA] ON PP.nrp = PA.nrp
	INNER JOIN Asignatura AS [A] ON PA.identificadorAsignatura = A.identificador
	WHERE A.identificador = @identificador
END
GO

GO
-- Nombre: eliminarAlumno
-- Comentario: Este procedimiento nos permite eliminar un alumno de la base de datos, tambi�n se elimina todas las 
-- referencias de este alumno en la dem�s tablas.
-- Cabecera: PROCEDURE eliminarAlumno @numeroEstudiante smallint, @validez smallint OUTPUT
-- Entrada: @numeroEstudiante smallint
-- Salida: @validez smallint OUTPUT 
-- Postcondiciones: El procedimiento devuelve un n�mero entero asociado al nombre, 0 si 
-- se ha eliminado el alumno o -1 si no se ha encontrado el alumno en la base de datos.
CREATE PROCEDURE eliminarAlumno @numeroEstudiante smallint, @validez smallint OUTPUT 
AS
BEGIN
	IF (EXISTS(SELECT * FROM PersonaAlumno WHERE numeroEstudiante = @numeroEstudiante))
	BEGIN
		SET @validez = 0 --Todo correcto
		DELETE PersonaAlumno FROM PersonaAlumno WHERE numeroEstudiante = @numeroEstudiante 
	END
	ELSE
	BEGIN
		SET @validez = -1 --El alumno no se encuentra en la bbdd
	END
	RETURN
END
GO

GO
-- Nombre: eliminarProfesor
-- Comentario: Este procedimiento nos permite eliminar un profesor de la base de datos, tambi�n se elimina todas las 
-- referencias de este profesor en la dem�s tablas.
-- Cabecera: PROCEDURE eliminarProfesor @nrp char(16), @validez smallint OUTPUT 
-- Entrada: @nrp char(16)
-- Salida: @validez smallint OUTPUT 
-- Postcondiciones: El procedimiento devuelve un n�mero entero asociado al nombre, 0 si
-- se ha conseguido eliminar el profesor o -1 si este no se encuentra en la base de datos.
CREATE PROCEDURE eliminarProfesor @nrp char(16), @validez smallint OUTPUT 
AS
BEGIN
	IF (EXISTS(SELECT * FROM PersonaProfesor WHERE nrp = @nrp))
	BEGIN
		SET @validez = 0; --Todo correcto
		DELETE FROM PersonaProfesor WHERE nrp = @nrp
	END
	ELSE
	BEGIN
		SET @validez = -1; --El profesor no se encuentra en la bbdd
	END
END
GO

GO
-- Nombre: eliminarAsignatura
-- Comentario: Este procedimiento nos permite eliminar un profesor de la base de datos, tambi�n se elimina todas las 
-- referencias de este profesor en la dem�s tablas.
-- Cabecera: PROCEDURE eliminarAsignatura @identificador smallint, @validez smallint OUTPUT 
-- Entrada: @identificador smallint
-- Salida: @validez smallint OUTPUT 
-- Postcondiciones: El procedimiento devuelve un n�mero entero asociado al nombre, 0 si se 
-- ha eliminado la asignatura o -1 si no se ha encontrado la asignatura en la base de datos.
CREATE PROCEDURE eliminarAsignatura @identificador smallint, @validez smallint OUTPUT 
AS
BEGIN
	IF (EXISTS(SELECT * FROM Asignatura WHERE identificador = @identificador))
	BEGIN
		SET @validez = 0; --Todo correcto
		DELETE FROM Asignatura WHERE identificador = @identificador
	END
	ELSE
	BEGIN
		SET @validez = -1; --La asignatura no se encuentra en la bbdd
	END
END
GO 

GO
-- Nombre: addAlumno
-- Comentario: Este procedimiento nos permite a�adir un alumno a la base de datos.
-- Cabecera: PROCEDURE addAlumno @dni char(9), @nombre varchar(20), @apellidos varchar(40), 
-- @edad tinyint, @telefono char(9), @numeroEstudiante smallint, @validez smallint OUTPUT
-- Entrada: @dni char(9), @nombre varchar(20), @apellidos varchar(40), @edad tinyint, @telefono char(9), @numeroEstudiante smallint
-- Salida: @validez smallint OUTPUT
-- Postcondiciones: El procedimiento devuelve un n�mero entero asociado al nombre, 0 si se ha conseguido insertar
-- el nuevo alumno, -1 si ya exist�a un alumno con el mismo n�mero de estudiante en la base de datos o -2 si ya
-- exist�a un estudiante con el mismo dni.
CREATE PROCEDURE addAlumno @dni char(9), @nombre varchar(20), @apellidos varchar(40), @edad tinyint, @telefono char(9), @numeroEstudiante smallint, @validez smallint OUTPUT
AS
BEGIN
	IF (EXISTS(SELECT * FROM PersonaAlumno WHERE numeroEstudiante = @numeroEstudiante)) 
	BEGIN
		SET @validez = -1; --Un alumno no puede tener el mismo numero de estudiante que otro
	END
	ELSE
	BEGIN
		IF (EXISTS(SELECT * FROM PersonaAlumno WHERE dni = @dni))
		BEGIN
			SET @validez = -2; --Un alumno no puede tener el mismo DNI que otro
		END
		ELSE
		BEGIN
			SET @validez = 0; --Todo correcto
			INSERT INTO PersonaAlumno VALUES(@dni, @nombre, @apellidos, @edad, @telefono, @numeroEstudiante)
		END
	END
END
GO

GO
-- Nombre: addProfesor
-- Comentario: Este procedimiento nos permite a�adir un profesor a la base de datos.
-- Cabecera: PROCEDURE addProfesor @dni char(9), @nombre varchar(20), @apellidos varchar(40), 
-- @edad tinyint, @telefono char(9), @nrp smallint, @validez smallint OUTPUT
-- Entrada: @dni char(9), @nombre varchar(20), @apellidos varchar(40), @edad tinyint, @telefono char(9), @nrp smallint
-- Salida: @validez smallint OUTPUT
-- Postcondiciones: El procedimiento devuelve un n�mero entero asociado al nombre, 0 si se ha conseguido insertar
-- el nuevo profesor, -1 si ya exist�a un profesor con el mismo nrp en la base de datos o -2 si ya
-- exist�a un profesor con el mismo dni.
CREATE PROCEDURE addProfesor @dni char(9), @nombre varchar(20), @apellidos varchar(40), @edad tinyint, @telefono char(9), @nrp char(16), @validez smallint OUTPUT
AS
BEGIN
	IF (EXISTS(SELECT * FROM PersonaProfesor WHERE nrp = @nrp)) 
	BEGIN
		SET @validez = -1; --NRP no puede repetirse
	END
	ELSE
	BEGIN
		IF (EXISTS(SELECT * FROM PersonaProfesor WHERE dni = @dni))
		BEGIN
			SET @validez = -2; --Un profesor no puede tener el mismo DNI que otro
		END
		ELSE
		BEGIN
			SET @validez = 0; --Todo correcto
			INSERT INTO PersonaProfesor VALUES(@dni, @nombre, @apellidos, @edad, @telefono, @nrp)
		END
	END
END
GO

GO
-- Nombre: addAsignatura
-- Comentario: Este procedimiento nos permite a�adir una asignatura a la base de datos.
-- Cabecera: PROCEDURE addAsignatura @identificador smallint, @nombre varchar(40), @numeroAula smallint, @validez smallint OUTPUT
-- Entrada: @identificador smallint, @nombre varchar(40), @numeroAula smallint
-- Salida: @validez smallint OUTPUT
-- Postcondiciones: El procedimiento devuelve un n�mero entero asociado al nombre, 0 si se ha conseguido insertar
-- la nuevo asignatura, -1 si ya exist�a una asignatura con el mismo identificador en la base de datos o -2 si ya
-- exist�a una asignatura con el mismo nombre.
CREATE PROCEDURE addAsignatura @identificador smallint, @nombre varchar(40), @numeroAula smallint, @validez smallint OUTPUT
AS
BEGIN
	IF (EXISTS(SELECT * FROM Asignatura WHERE identificador = @identificador)) 
	BEGIN
		SET @validez = -1; --Identificador ya existente 
	END
	ELSE
	BEGIN
		IF (EXISTS(SELECT * FROM Asignatura WHERE nombre = @nombre))
		BEGIN
			SET @validez = -2; --La asignatura no puede tener el mismo nombre
		END
		ELSE
		BEGIN
			SET @validez = 0; --Todo Correcto
			INSERT INTO Asignatura VALUES(@identificador, @nombre, @numeroAula)
		END
	END
END
GO

GO
-- Nombre: asignarAlumnoConAsignatura	--Error no funcionan los !=
-- Comentario: Este procedimiento nos permite relacionar a un alumno con una asignatura.
-- Cabecera: PROCEDURE asignarAlumnoConAsignatura @numeroEstudiante smallint, @identificadorAsignatura smallint, @validez smallint OUTPUT
-- Entrada: @numeroEstudiante smallint, @identificadorAsignatura smallint
-- Salida: @validez smallint OUTPUT
-- Postcondiciones: El procedimiento devuelve un n�mero entero asociado al nombre, 0 si se ha conseguido relacionar el alumno con la asignatura, 
-- -1 si ya se encuentran relacionados, -2 si el alumno no existe o -3 si la asignatura no existe en la base de datos.
CREATE PROCEDURE asignarAlumnoConAsignatura @numeroEstudiante smallint, @identificadorAsignatura smallint, @validez smallint OUTPUT
AS
BEGIN
	IF (EXISTS(SELECT * FROM AlumnoAsignatura WHERE numeroEstudiante = @numeroEstudiante AND identificadorAsignatura = @identificadorAsignatura))
	BEGIN
		SET @validez = -1 --Ya esta asignado
	END
	ELSE
	BEGIN
		IF (NOT EXISTS(SELECT * FROM PersonaAlumno WHERE numeroEstudiante = @numeroEstudiante))
		BEGIN
			SET @validez = -2 --No existe alumno
		END
		ELSE
		BEGIN
			IF (NOT EXISTS(SELECT * FROM Asignatura WHERE identificador = @identificadorAsignatura))
			BEGIN
				SET @validez = -3 --No existe asignatura
			END
			ELSE
			BEGIN
				SET @validez = 0; --Todo correcto
				INSERT INTO AlumnoAsignatura VALUES(@numeroEstudiante, @identificadorAsignatura)
			END
		END
	END
END
GO

GO
-- Nombre: asignarProfesorConAsignatura
-- Comentario: Este procedimiento nos permite relacionar a un profesor con una asignatura.
-- Cabecera: PROCEDURE asignarProfesorConAsignatura @nrp char(16), @identificadorAsignatura smallint, @validez smallint OUTPUT
-- Entrada: @nrp char(16), @identificadorAsignatura smallint
-- Salida: @validez smallint OUTPUT
-- Postcondiciones: El procedimiento devuelve un n�mero entero asociado al nombre, 0 si se ha conseguido relacionar el profesor con la asignatura, 
-- -1 si ya se encuentran relacionados, -2 si el profesor no existe o -3 si la asignatura no existe en la base de datos.
CREATE PROCEDURE asignarProfesorConAsignatura @nrp char(16), @identificadorAsignatura smallint, @validez smallint OUTPUT
AS
BEGIN
	IF (EXISTS(SELECT * FROM ProfesorAsignatura WHERE nrp = @nrp AND identificadorAsignatura = @identificadorAsignatura))
	BEGIN
		SET @validez = -1 --Ya esta asignado
	END 
	ELSE
	BEGIN
		IF (NOT EXISTS(SELECT * FROM PersonaProfesor WHERE nrp = @nrp))
		BEGIN
			SET @validez = -2 --No existe profesor
		END
		ELSE
		BEGIN
			IF (NOT EXISTS(SELECT * FROM Asignatura WHERE identificador = @identificadorAsignatura))
			BEGIN
				SET @validez = -3 --No existe asignatura
			END
			ELSE
			BEGIN
				SET @validez = 0; --Todo correcto
				INSERT INTO ProfesorAsignatura VALUES(@nrp, @identificadorAsignatura)
			END
		END
	END
END
GO

GO
-- Nombre: asignarAlumnoConProfesor
-- Comentario: Este procedimiento nos permite relacionar a un profesor con un alumno.
-- Cabecera: PROCEDURE asignarAlumnoConProfesor @nrp char(16), @numeroEstudiante smallint, @validez smallint OUTPUT
-- Entrada: @nrp char(16), @numeroEstudiante smallint
-- Salida: @validez smallint OUTPUT
-- Postcondiciones: El procedimiento devuelve un n�mero entero asociado al nombre, 0 si se ha conseguido relacionar el profesor con el alumno, 
-- -1 si ya se encuentran relacionados, -2 si el profesor no existe o -3 si el alumno no existe en la base de datos.
CREATE PROCEDURE asignarAlumnoConProfesor @numeroEstudiante smallint, @nrp char(16), @validez smallint OUTPUT
AS
BEGIN
	IF (EXISTS(SELECT * FROM AlumnoProfesor WHERE nrp = @nrp AND numeroEstudiante = @numeroEstudiante))
	BEGIN
		SET @validez = -1 --Ya esta asignado
	END
	ELSE
	BEGIN
		IF (NOT EXISTS(SELECT * FROM PersonaProfesor WHERE nrp = @nrp))
		BEGIN
			SET @validez = -2 --No existe profesor
		END
		ELSE
		BEGIN
			IF (NOT EXISTS(SELECT * FROM PersonaAlumno WHERE numeroEstudiante = @numeroEstudiante))
			BEGIN
				SET @validez = -3 --No existe alumno
			END
			ELSE
			BEGIN
				SET @validez = 0; --Todo correcto
				INSERT INTO AlumnoProfesor VALUES(@numeroEstudiante, @nrp)
			END
		END
	END
END
GO

/*
Las funciones estan en el archivo de instrucciones, si conseguimos introducirlo en Java, se pondran a continuacion
*/