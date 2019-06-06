package com.company.gestora;

import java.sql.ResultSet;
import java.sql.SQLException;

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
                System.out.println("NRP: " + consulta.getString("nrp") + ", Nombre: " + consulta.getString("Nombre") + ", Apellidos: " + consulta.getString("Apellidos"));
            }

        }
        catch(SQLException err) {
            err.printStackTrace();
        }
    }
}
