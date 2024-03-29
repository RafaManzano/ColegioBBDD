package com.company.resguardos;

import com.company.clases.Alumno;
import com.company.clases.AsignaturaImp;
import com.company.clases.Profesor;

import java.sql.*;

public class resguardoColegio {
    /*
    Interfaz
    Nombre: mostrarConsultaAlumno
    Comentario: Este subprograma muestra la consulta de los alumnos introducida por parametros
    Cabecera: public void mostrarConsultaAlumno(ResultSet consulta)
    Precondiciones: No hay
    Entrada: - ResultSet consulta //Es la consulta de la que se desea mostrar
    Salida: No hay
    E/S: No hay
    Postcondiciones: Solo muestra los datos de la consulta
    */

    public void mostrarConsultaAlumno(ResultSet consulta) {
        System.out.println("En resguardo");
    }

    /*
    Interfaz
    Nombre: mostrarConsultaProfesor
    Comentario: Este subprograma muestra la consulta de los profesores introducida por parametros
    Cabecera: public void mostrarConsultaProfesor(ResultSet consulta)
    Precondiciones: No hay
    Entrada: - ResultSet consulta //Es la consulta de la que se desea mostrar
    Salida: No hay
    E/S: No hay
    Postcondiciones: Solo muestra los datos de la consulta
    */

    public void mostrarConsultaProfesor(ResultSet consulta) {
        System.out.println("En resguardo");
    }

    /*
    Interfaz
    Nombre: mostrarConsultaAsignatura
    Comentario: Este subprograma muestra la consulta de las asignaturas introducida por parametros
    Cabecera: public void mostrarConsultaAsignatura(ResultSet consulta)
    Precondiciones: No hay
    Entrada: - ResultSet consulta //Es la consulta de la que se desea mostrar
    Salida: No hay
    E/S: No hay
    Postcondiciones: Solo muestra los datos de la consulta
    */

    public void mostrarConsultaAsignatura(ResultSet consulta) {
        System.out.println("En resguardo");
    }

    /*
    Interfaz
    Nombre: asignarAlumnoConAsignatura
    Comentario: Este subprograma llama al procedimiento almacenado de la base de datos y devuelve la validez
    Cabecera: public int asignarAlumnoConAsignatura(Connection conn, int numeroEstudiante, int identificador)
    Precondiciones: No hay
    Entrada: - Connection conn //Es la conexion con la bbdd
             - int numeroEstudiante //El numero del alumno
             - int identificador //El identificador de la asignatura
    Salida: - int validez //0 Es correcto
                          //-1 Ya se ha asignado
                          //-2 No existe el alumno
                          //-3 No existe la asignatura
                          //-4 El procedimiento almacenado esta erroneo
    E/S: No hay
    Postcondiciones: Asociado al nombre, depende del numero de la validez (0 Es correcto, -1 Ya se ha asignado, -2 No existe el alumno, -3 No existe la asignatura, -4 El procedimiento almacenado esta erroneo)
     */
    public int asignarAlumnoConAsignatura(Connection conn, int numeroEstudiante, int identificador) {
        int validez = -4;
        System.out.println("En resguardo");
        return validez;
    }


    /*
    Interfaz
    Nombre: asignarProfesorConAsignatura
    Comentario: Este subprograma llama al procedimiento almacenado de la base de datos y devuelve la validez
    Cabecera: public int asignarProfesorConAsignatura(Connection conn, String nrp, int identificador)
    Precondiciones: No hay
    Entrada: - Connection conn //Es la conexion con la bbdd
             - String nrp //El nrp del profesor
             - int identificador //El identificador de la asignatura
    Salida: - int validez //0 Es correcto
                          //-1 Ya se ha asignado
                          //-2 No existe el alumno
                          //-3 No existe la asignatura
                          //-4 El procedimiento almacenado esta erroneo
    E/S: No hay
    Postcondiciones: Asociado al nombre, depende del numero de la validez (0 Es correcto, -1 Ya se ha asignado, -2 No existe el profesor, -3 No existe la asignatura, -4 El procedimiento almacenado esta erroneo)
     */
    public int asignarProfesorConAsignatura(Connection conn, String nrp, int identificador) {
        int validez = -4;
        System.out.println("En resguardo");
        return validez;
    }

    /*
    Interfaz
    Nombre: asignarAlumnoConProfesor
    Comentario: Este subprograma llama al procedimiento almacenado de la base de datos y devuelve la validez
    Cabecera: public int asignarAlumnoConProfesor(Connection conn, int numeroEstudiante, String nrp)
    Precondiciones: No hay
    Entrada: - Connection conn //Es la conexion con la bbdd
             - int numeroEstudiante //El numero del alumno
             - String nrp //El nrp del profesor
    Salida: - int validez //0 Es correcto
                          //-1 Ya se ha asignado
                          //-2 No existe el alumno
                          //-3 No existe la asignatura
                          //-4 El procedimiento almacenado esta erroneo
    E/S: No hay
    Postcondiciones: Asociado al nombre, depende del numero de la validez (0 Es correcto, -1 Ya se ha asignado, -2 No existe el alumno, -3 No existe el profesor, -4 El procedimiento almacenado esta erroneo)
    */

    public int asignarAlumnoConProfesor(Connection conn, int numeroEstudiante, String nrp) {
        int validez = -4;
        System.out.println("En resguardo");
        return validez;
    }

   /*
    Interfaz
    Nombre: AlumnosDeUnaAsignatura
    Comentario: Este subprograma llama al procedimiento almacenado de la base de datos y devuelve la lista de alumnos de la asignatura introducida por parametro
    Cabecera: public ResultSet alumnosDeUnaAsignatura(Connection conn, int asignatura)
    Precondiciones: No hay
    Entrada: - Connection conn //Es la conexion con la bbdd
             - int asignatura //El nombre de la asignatura
    Salida: - ResultSet alumnos //Es el select de alumnos
    E/S: No hay
    Postcondiciones: Asociado al nombre, es la consulta de alumnos de la asignatura, si da null significa que hay algun tipo de error
    */

    public ResultSet alumnosDeUnaAsignatura(Connection conn, int asignatura) {
        ResultSet alumnos = null;
        System.out.println("En resguardo");
        return alumnos;
    }

    /*
    Interfaz
    Nombre: ProfesoresDeUnaAsignatura
    Comentario: Este subprograma llama al procedimiento almacenado de la base de datos y devuelve la lista de profesores de la asignatura introducida por parametro
    Cabecera: public ResultSet profesoresDeUnaAsignatura(Connection conn, int asignatura)
    Precondiciones: No hay
    Entrada: - Connection conn //Es la conexion con la bbdd
             - int asignatura //El identificador de la asignatura
    Salida: - ResultSet profesores //Es el select de profesores
    E/S: No hay
    Postcondiciones: Asociado al nombre, es la consulta de profesores de la asignatura, si da null significa que hay algun tipo de error
    */

    public ResultSet profesoresDeUnaAsignatura(Connection conn, int asignatura) {
        ResultSet profesores = null;
        System.out.println("En resguardo");
        return profesores;
    }

    /*
    Interfaz
    Nombre: insertarAlumno
    Comentario: Este subprograma inserta un alumno en la bbdd
    Cabecera: public int insertarAlumno(Connection conn, Alumno alumno)
    Precondiciones: No hay
    Entrada: - Connection conn //Es la conexion con la bbdd
             - Alumno alumno //El alumno ha introducir en la bbdd
    Salida: - int validez //0 Es correcto
                          //-1 numeroEstudiante ya existe
                          //-2 DNI ya existe
    E/S: No hay
    Postcondiciones: Asociado al nombre, depende del numero de la validez (0 Es correcto, -1 numeroEstudiante ya existe, -2 DNI ya existe)
    */

    public int insertarAlumno(Connection conn, Alumno alumno) {
        int validez = -3;
        System.out.println("En resguardo");
        return validez;
    }

    /*
    Interfaz
    Nombre: insertarProfesor
    Comentario: Este subprograma inserta un profesor en la bbdd
    Cabecera: public int insertarProfesor(Connection conn, Profesor profesor)
    Precondiciones: No hay
    Entrada: - Connection conn //Es la conexion con la bbdd
             - Profesor profesor //El profesor ha introducir en la bbdd
    Salida: - int validez //0 Es correcto
                          //-1 nrp ya existe
                          //-2 DNI ya existe
    E/S: No hay
    Postcondiciones: Asociado al nombre, depende del numero de la validez (0 Es correcto, -1 nrp ya existe, -2 DNI ya existe)
    */

    public int insertarProfesor(Connection conn, Profesor profesor) {
        int validez = -3;
        System.out.println("En resguardo");
        return validez;
    }

    /*
    Interfaz
    Nombre: insertarAsignatura
    Comentario: Este subprograma inserta una asignatura en la bbdd
    Cabecera: public int insertarAsignatura(Connection conn, AsignaturaImp asignatura)
    Precondiciones: No hay
    Entrada: - Connection conn //Es la conexion con la bbdd
             - AsignaturaImp asignatura //La asignatura ha introducir en la bbdd
    Salida: - int validez //0 Es correcto
                          //-1 identificador ya existe
                          //-2 nombre ya existe
    E/S: No hay
    Postcondiciones: Asociado al nombre, depende del numero de la validez (0 Es correcto, -1 identificador ya existe, -2 nombre ya existe)
    */

    public int insertarAsignatura(Connection conn, AsignaturaImp asignatura) {
        int validez = -3;
        System.out.println("En resguardo");
        return validez;
    }

    /*
    Interfaz
    Nombre: eliminarAlumno
    Comentario: Este subprograma elimina un alumno en la bbdd
    Cabecera: public int eliminarAlumno(Connection conn, int numeroEstudiante)
    Precondiciones: No hay
    Entrada: - Connection conn //Es la conexion con la bbdd
             - int numeroEstudiante //Es el numero del estudiante que hay que eliminar
    Salida: - int validez //0 Es correcto
                          //-1 No se ha encontrado el alumno
    E/S: No hay
    Postcondiciones: Asociado al nombre, depende del numero de la validez (0 Es correcto, -1 No se ha encontrado el alumno)
    */

    public int eliminarAlumno(Connection conn, int numeroEstudiante) {
        int validez = -3;
        System.out.println("En resguardo");
        return validez;
    }

    /*
    Interfaz
    Nombre: eliminarProfesor
    Comentario: Este subprograma elimina un profesor en la bbdd
    Cabecera: public int eliminarProfesor(Connection conn, String nrp)
    Precondiciones: No hay
    Entrada: - Connection conn //Es la conexion con la bbdd
             - String nrp //Es el nrp del profesor que hay que eliminar
    Salida: - int validez //0 Es correcto
                          //-1 No se ha encontrado el profesor
    E/S: No hay
    Postcondiciones: Asociado al nombre, depende del numero de la validez (0 Es correcto, -1 No se ha encontrado el profesor)
    */

    public int eliminarProfesor(Connection conn, String nrp) {
        int validez = -3;
        System.out.println("En resguardo");
        return validez;
    }

    /*
    Interfaz
    Nombre: eliminarAsignatura
    Comentario: Este subprograma elimina una asignatura en la bbdd
    Cabecera: public int eliminarAsignatura(Connection conn, int identificador)
    Precondiciones: No hay
    Entrada: - Connection conn //Es la conexion con la bbdd
             - int identificador //Es el identificador de la asignatura que hay que eliminar
    Salida: - int validez //0 Es correcto
                          //-1 No se ha encontrado la asignatura
    E/S: No hay
    Postcondiciones: Asociado al nombre, depende del numero de la validez (0 Es correcto, -1 No se ha encontrado la asignatura)
    */

    public int eliminarAsignatura(Connection conn, int identificador) {
        int validez = -3;
        System.out.println("En resguardo");
        return validez;
    }

    /*
    Interfaz
    Nombre: usarSentenciaConsulta
    Comentario: Este subprograma usa la sentencia y la ejecuta como una consulta (Select)
    Cabecera: public ResultSet usarSentenciaConsulta(Statement sentencia, String consulta)
    Precondiciones: No hay
    Entrada:  - Statement sentencia //El objeto para usar cualquier sentencia de sql
              - String consulta //Un String con la consulta
    Salida: - ResultSet resultado //El resultado de la consulta
    E/S: No hay
    Postcondiciones: Asociado al nombre, El resultado de la consulta
    */

    public ResultSet usarSentenciaConsulta(Statement sentencia, String consulta) {
        ResultSet resultado = null;
        System.out.println("En resguardo");
        return resultado;
    }
}
