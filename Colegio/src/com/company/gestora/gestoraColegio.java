package com.company.gestora;

import com.company.clases.Alumno;
import com.company.clases.AsignaturaImp;
import com.company.clases.Profesor;

import java.sql.*;

public class gestoraColegio {
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
                          //-4 El procedimiento almacenado esta erroneo
    E/S: No hay
    Postcondiciones: Asociado al nombre, depende del numero de la validez (0 Es correcto, -1 Ya se ha asignado, -2 No existe el alumno, -3 No existe la asignatura, -4 El procedimiento almacenado esta erroneo)
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
                          //-4 El procedimiento almacenado esta erroneo
    E/S: No hay
    Postcondiciones: Asociado al nombre, depende del numero de la validez (0 Es correcto, -1 Ya se ha asignado, -2 No existe el profesor, -3 No existe la asignatura, -4 El procedimiento almacenado esta erroneo)
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
                          //-4 El procedimiento almacenado esta erroneo
    E/S: No hay
    Postcondiciones: Asociado al nombre, depende del numero de la validez (0 Es correcto, -1 Ya se ha asignado, -2 No existe el alumno, -3 No existe el profesor, -4 El procedimiento almacenado esta erroneo)
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
        try {
            CallableStatement sp = conn.prepareCall("{CALL mostrarAlumnosDeUnaAsignatura(?)}");
            //se cargan los parametros de entrada
            sp.setInt(1, asignatura);

            // Se ejecuta el procedimiento almacenado
            sp.execute();

            //Cogemos la consulta completa
            alumnos = sp.getResultSet();
        }
        catch (SQLException err) {
            err.printStackTrace();
        }

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
        try {
            CallableStatement sp = conn.prepareCall("{CALL mostrarProfesoresDeUnaAsignatura(?)}");
            //se cargan los parametros de entrada
            sp.setInt(1, asignatura);

            // Se ejecuta el procedimiento almacenado
            sp.execute();

            //Cogemos la consulta completa
            profesores = sp.getResultSet();
        }
        catch (SQLException err) {
            err.printStackTrace();
        }

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
        try {
            CallableStatement sp = conn.prepareCall("{CALL addAlumno(?,?,?,?,?,?,?)}");
            //se cargan los parametros de entrada
            sp.setString(1, alumno.getDNI());
            sp.setString(2, alumno.getNombre());
            sp.setString(3, alumno.getApellidos());
            sp.setInt(4, alumno.getEdad());
            sp.setString(5, alumno.getTelefono());
            sp.setInt(6, alumno.getNumeroEstudiante());
            // parametros de salida
            sp.registerOutParameter(7, Types.SMALLINT);
            // Se ejecuta el procedimiento almacenado
            sp.execute();
            // devuelve el valor del parametro de salida del procedimiento
            validez = sp.getInt(7);
        }
        catch (SQLException err) {
            err.printStackTrace();
        }

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
        try {
            CallableStatement sp = conn.prepareCall("{CALL addProfesor(?,?,?,?,?,?,?)}");
            //se cargan los parametros de entrada
            sp.setString(1, profesor.getDNI());
            sp.setString(2, profesor.getNombre());
            sp.setString(3, profesor.getApellidos());
            sp.setInt(4, profesor.getEdad());
            sp.setString(5, profesor.getTelefono());
            sp.setString(6, profesor.getNRP());
            // parametros de salida
            sp.registerOutParameter(7, Types.SMALLINT);
            // Se ejecuta el procedimiento almacenado
            sp.execute();
            // devuelve el valor del parametro de salida del procedimiento
            validez = sp.getInt(7);
        }
        catch (SQLException err) {
            err.printStackTrace();
        }

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
        try {
            CallableStatement sp = conn.prepareCall("{CALL addAsignatura(?,?,?,?)}");
            //se cargan los parametros de entrada
            sp.setInt(1, asignatura.getIdentificador());
            sp.setString(2, asignatura.getNombre());
            sp.setInt(3, asignatura.getNumeroAula());

            // parametros de salida
            sp.registerOutParameter(4, Types.SMALLINT);
            // Se ejecuta el procedimiento almacenado
            sp.execute();
            // devuelve el valor del parametro de salida del procedimiento
            validez = sp.getInt(4);
        }
        catch (SQLException err) {
            err.printStackTrace();
        }

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
        try {
            CallableStatement sp = conn.prepareCall("{CALL eliminarAlumno(?,?)}");
            //se cargan los parametros de entrada
            sp.setInt(1, numeroEstudiante);

            // parametros de salida
            sp.registerOutParameter(2, Types.SMALLINT);
            // Se ejecuta el procedimiento almacenado
            sp.execute();
            // devuelve el valor del parametro de salida del procedimiento
            validez = sp.getInt(2);
        }
        catch (SQLException err) {
            err.printStackTrace();
        }

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
        try {
            CallableStatement sp = conn.prepareCall("{CALL eliminarProfesor(?,?)}");
            //se cargan los parametros de entrada
            sp.setString(1, nrp);

            // parametros de salida
            sp.registerOutParameter(2, Types.SMALLINT);
            // Se ejecuta el procedimiento almacenado
            sp.execute();
            // devuelve el valor del parametro de salida del procedimiento
            validez = sp.getInt(2);
        }
        catch (SQLException err) {
            err.printStackTrace();
        }

        return validez;
    }

     /*
    Interfaz
    Nombre: eliminarAsignatura
    Comentario: Este subprograma elimina una asignatura en la bbdd
    Cabecera: public int eliminarAsignatura(Connection conn, int identificador)
    Precondiciones: No hay
    Entrada: - Connection conn //Es la conexion con la bbdd
             - String nrp //Es el identificador de la asignatura que hay que eliminar
    Salida: - int validez //0 Es correcto
                          //-1 No se ha encontrado la asignatura
    E/S: No hay
    Postcondiciones: Asociado al nombre, depende del numero de la validez (0 Es correcto, -1 No se ha encontrado la asignatura)
    */

    public int eliminarAsignatura(Connection conn, int identificador) {
        int validez = -3;
        try {
            CallableStatement sp = conn.prepareCall("{CALL eliminarAsignatura(?,?)}");
            //se cargan los parametros de entrada
            sp.setInt(1, identificador);

            // parametros de salida
            sp.registerOutParameter(2, Types.SMALLINT);
            // Se ejecuta el procedimiento almacenado
            sp.execute();
            // devuelve el valor del parametro de salida del procedimiento
            validez = sp.getInt(2);
        }
        catch (SQLException err) {
            err.printStackTrace();
        }

        return validez;
    }
}
