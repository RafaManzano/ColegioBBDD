package com.company.gestora;

import java.sql.*;

public class gestoraColegio {
    /*
    Interfaz
    Nombre: mostrarConsultaAlumno
    Comentario: Este subprograma muestra la consulta de los alumnos introducida por parametros
    Cabecera: public void mostrarConsulta(ResultSet consulta)
    Precondiciones: No hay
    Entrada: - ResultSet consulta //Es la consulta de la que se desea mostrar
    Salida: No hay
    E/S: No hay
    Postcondiciones: Solo muestra los datos de la consulta
    */

    public void mostrarConsultaAlumno(ResultSet consulta) {
        try {
            while (consulta.next()) {
                System.out.println("Numero de Estudiante: " + consulta.getShort("numeroEstudiante") + ", Nombre: " + consulta.getString("Nombre") + ", Apellidos: " + consulta.getString("Apellidos"));
            }

        }
        catch(SQLException err) {
            err.printStackTrace();
        }
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
        try {
            while (consulta.next()) {
                System.out.println("NRP: " + consulta.getString("nrp") + ", Nombre: " + consulta.getString("Nombre") + ", Apellidos: " + consulta.getString("Apellidos"));
            }

        }
        catch(SQLException err) {
            err.printStackTrace();
        }
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
        try {
            while (consulta.next()) {
                System.out.println("Identificador: " + consulta.getShort("identificador") + ", Nombre: " + consulta.getString("Nombre") + ", Numero de aula: " + consulta.getShort("numeroAula"));
            }

        }
        catch(SQLException err) {
            err.printStackTrace();
        }
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
                          //-4 El metodo ha fallado
    E/S: No hay
    Postcondiciones: Asociado al nombre, depende del numero de la validez (0 Es correcto, -1 Ya se ha asignado, -2 No existe el alumno, -3 No existe la asignatura, -4 El metodo ha fallado)
     */
    public int asignarAlumnoConAsignatura(Connection conn, int numeroEstudiante, int identificador) {
        int validez = -4;
        try {
            CallableStatement sp = conn.prepareCall("{CALL asignarAlumnoConAsignatura(?,?,?)}");
            //se cargan los parametros de entrada
            sp.setInt(1, numeroEstudiante);
            sp.setInt(2, identificador);
            // parametros de salida
            sp.registerOutParameter(3, Types.SMALLINT);
            // Se ejecuta el procedimiento almacenado
            sp.execute();
            // devuelve el valor del parametro de salida del procedimiento
            validez = sp.getInt(3);
        }
        catch (SQLException err) {
            err.printStackTrace();
        }

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
                          //-4 El metodo ha fallado
    E/S: No hay
    Postcondiciones: Asociado al nombre, depende del numero de la validez (0 Es correcto, -1 Ya se ha asignado, -2 No existe el profesor, -3 No existe la asignatura, -4 El metodo ha fallado)
     */
    public int asignarProfesorConAsignatura(Connection conn, String nrp, int identificador) {
        int validez = -4;
        try {
            CallableStatement sp = conn.prepareCall("{CALL asignarAlumnoConAsignatura(?,?,?)}");
            //se cargan los parametros de entrada
            sp.setString(1, nrp);
            sp.setInt(2, identificador);
            // parametros de salida
            sp.registerOutParameter(3, Types.SMALLINT);
            // Se ejecuta el procedimiento almacenado
            sp.execute();
            // devuelve el valor del parametro de salida del procedimiento
            validez = sp.getInt(3);
        }
        catch (SQLException err) {
            err.printStackTrace();
        }

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
                          //-4 El metodo ha fallado
    E/S: No hay
    Postcondiciones: Asociado al nombre, depende del numero de la validez (0 Es correcto, -1 Ya se ha asignado, -2 No existe el alumno, -3 No existe el profesor, -4 El metodo ha fallado)
    */

    public int asignarAlumnoConProfesor(Connection conn, int numeroEstudiante, String nrp) {
        int validez = -4;
        try {
            CallableStatement sp = conn.prepareCall("{CALL asignarAlumnoConProfesor(?,?,?)}");
            //se cargan los parametros de entrada
            sp.setInt(1, numeroEstudiante);
            sp.setString(2, nrp);
            // parametros de salida
            sp.registerOutParameter(3, Types.SMALLINT);
            // Se ejecuta el procedimiento almacenado
            sp.execute();
            // devuelve el valor del parametro de salida del procedimiento
            validez = sp.getInt(3);
        }
        catch (SQLException err) {
            err.printStackTrace();
        }

        return validez;
    }
}
