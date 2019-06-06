package com.company.Main;

import com.company.Conexiones.conexionesBaseDatos;
import com.company.clases.Alumno;
import com.company.clases.AsignaturaImp;
import com.company.clases.PersonaImp;
import com.company.clases.Profesor;
import com.company.util.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
Nombre del programa: ColegioCompadre
Analisis
    Entrada: - opcion
             - usuario
             - password
    Salida: - Mensajes con el usuario
    Requisitos: - Opcion tiene que ser de 0 a 3

    PG Level 0
    Inicio
        MostrarMenuPrincipal
        LeeryValidarOpcionMenuPrincipal
        Segun(OpcionMenuPrincipal)
            caso 1
                Alumno
            caso 2
                Profesor
            caso 3
                Asignatura
        FinSegun
     Fin

     Modulo Alumno
     Inicio
        MostrarMenuAlumno
        LeeryValidarOpcionMenuAlumno
        Segun(OpcionMenuAlumno)
            caso 1
                AnhadirAlumno
            caso 2
                EliminarAlumno
            caso 3
                MostrarAlumnos
        FinSegun
     Fin

     Modulo Profesor
     Inicio
        MostrarMenuProfesor
        LeeryValidarOpcionMenuProfesor
        Segun(OpcionMenuProfesor)
            caso 1
                AnhadirProfesor
            caso 2
                EliminarProfesor
            caso 3
                MostrarProfesores
        FinSegun
     Fin

     Modulo Asignatura
     Inicio
        MostrarMenuAsignatura
        LeeryValidarOpcionMenuAsignatura
        Segun(OpcionMenuAsignatura)
            caso 1
                AnhadirAsignatura
            caso 2
                EliminarAsignatura
            caso 3
                MostrarAsignaturas
            caso 4
                Mostrar alumnos de una asignatura
            caso 5
                Mostrar profesores de una asignatura
        FinSegun
     Fin
*/
public class ColegioCompadre {

    public static void main(String[] args) {
        conexionesBaseDatos bbdd = new conexionesBaseDatos();
        int opcionMenuPrincipal;
        int opcionMenuAlumno;
        int opcionMenuProfesor;
        int opcionMenuAsignatura;
        String nombre;
        String apellidos;
        PersonaImp p;
        Alumno a;
        Profesor pr;
        AsignaturaImp as;
        menuColegio menus = new menuColegio();
        Connection conexion;
        Statement sentencia;
        ResultSet consulta = null;
        validacionesColegio validar = new validacionesColegio();
        Scanner teclado = new Scanner(System.in);

        //Login
        conexion = bbdd.iniciarConexion("administrado", "1234");
        sentencia = bbdd.crearSentencia(conexion);
        do {
            menus.mostrarMenuPrincipal();
            opcionMenuPrincipal = validar.leeryValidarOpcionDe3();

            switch (opcionMenuPrincipal) {
                case 1:
                    //System.out.println("Alumno");
                    do {
                        menus.mostrarMenuAlumno();
                        opcionMenuAlumno = validar.leeryValidarOpcionDe3();

                        switch (opcionMenuAlumno) {
                            case 1:
                                //System.out.println("Anhadir");
                                p = validar.leeryValidarPersona();
                                a = new Alumno(p.getDNI(), p.getNombre(), p.getApellidos(), p.getEdad(), p.getTelefono(), validar.leeryValidarNumeroEstudiante());
                                System.out.println("Se han insertado " + bbdd.usarSentenciaUDI(sentencia, "INSERT INTO PersonaAlumno VALUES (" + a.toString() + ")") + " filas.");
                            break;

                            case 2:
                                //System.out.println("Eliminar");
                                consulta = bbdd.usarSentenciaConsulta(sentencia, "SELECT Nombre, Apellidos FROM PersonaAlumno");
                                //Mostrar la tabla en Java
                                try {
                                    while (consulta.next()) {
                                        System.out.println("Nombre: " + consulta.getString("Nombre") + ", Apellidos: " + consulta.getString("Apellidos"));
                                    }

                                }
                                catch(SQLException err) {
                                    err.printStackTrace();
                                }
                                System.out.println("Escriba el nombre que deseas borrar?");
                                nombre = teclado.next();
                                System.out.println("Escriba el apellidos que deseas borrar");
                                apellidos = teclado.next();
                                System.out.println("Se han eliminado " + bbdd.usarSentenciaUDI(sentencia, "DELETE FROM PersonaAlumno WHERE Nombre = " + nombre + " AND Apellidos = " + apellidos + ")" + " filas."));
                            break;

                            case 3:
                                //System.out.println("Mostrar");
                                consulta = bbdd.usarSentenciaConsulta(sentencia, "SELECT Nombre, Apellidos FROM PersonaAlumno");
                                //Mostrar la tabla en Java
                                try {
                                    while (consulta.next()) {
                                        System.out.println("Nombre: " + consulta.getString("Nombre") + ", Apellidos: " + consulta.getString("Apellidos"));
                                    }

                                }
                                catch(SQLException err) {
                                    err.printStackTrace();
                                }
                            break;

                        }
                    }
                    while(opcionMenuAlumno != 0);
                break;

                case 2:
                    //System.out.println("Profesor");
                    do {
                        menus.mostrarMenuProfesores();
                        opcionMenuProfesor = validar.leeryValidarOpcionDe3();

                        switch (opcionMenuProfesor) {
                            case 1:
                                //System.out.println("Anhadir");
                                p = validar.leeryValidarPersona();
                                pr = new Profesor(p.getDNI(), p.getNombre(), p.getApellidos(), p.getEdad(), p.getTelefono(), validar.leeryValidarNRP());
                                System.out.println("Se han insertado " + bbdd.usarSentenciaUDI(sentencia, "INSERT INTO PersonaProfesor VALUES (" + pr.toString() + ")") + " filas.");
                            break;

                            case 2:
                                //System.out.println("Eliminar");
                                consulta = bbdd.usarSentenciaConsulta(sentencia, "SELECT Nombre, Apellidos FROM PersonaProfesor");
                                //Mostrar la tabla en Java
                                try {
                                    while (consulta.next()) {
                                        System.out.println("Nombre: " + consulta.getString("Nombre") + ", Apellidos: " + consulta.getString("Apellidos"));
                                    }

                                }
                                catch(SQLException err) {
                                    err.printStackTrace();
                                }
                                System.out.println("Escriba el nombre que deseas borrar?");
                                nombre = teclado.next();
                                System.out.println("Escriba el apellidos que deseas borrar");
                                apellidos = teclado.next();
                                System.out.println("Se han eliminado " + bbdd.usarSentenciaUDI(sentencia, "DELETE FROM PersonaProfesor WHERE Nombre = " + nombre + " AND Apellidos = " + apellidos + ")" + " filas."));
                            break;

                            case 3:
                                //System.out.println("Mostrar");
                                consulta = bbdd.usarSentenciaConsulta(sentencia, "SELECT Nombre, Apellidos FROM PersonaProfesor");
                                //Mostrar la tabla en Java
                                try {
                                    while (consulta.next()) {
                                        System.out.println("Nombre: " + consulta.getString("Nombre") + ", Apellidos: " + consulta.getString("Apellidos"));
                                    }

                                }
                                catch(SQLException err) {
                                    err.printStackTrace();
                                }
                            break;

                        }
                    }
                    while(opcionMenuProfesor != 0);
                break;

                case 3:
                    //System.out.println("Asignatura");
                    do {
                        menus.mostrarMenuAsignatura();
                        opcionMenuAsignatura = validar.leeryValidarOpcionDe5();

                        switch (opcionMenuAsignatura) {
                            case 1:
                                //System.out.println("Anhadir");
                                as = validar.leeryValidarAsignatura();
                                System.out.println("Se han insertado " + bbdd.usarSentenciaUDI(sentencia, "INSERT INTO Asignatura VALUES (" + as.toString() + ")") + " filas.");
                            break;

                            case 2:
                                //System.out.println("Eliminar");
                                consulta = bbdd.usarSentenciaConsulta(sentencia, "SELECT Identificador, Nombre, NumeroAula FROM Asignatura");
                                //Mostrar la tabla en Java
                                try {
                                    while (consulta.next()) {
                                        System.out.println("Identificador: " + consulta.getShort("Identificador") + ", Nombre: " + consulta.getString("Nombre") + ", Numero del Aula: " + consulta.getShort("NumeroAula"));
                                    }

                                }
                                catch(SQLException err) {
                                    err.printStackTrace();
                                }
                                System.out.println("Escriba el nombre que deseas borrar?");
                                nombre = teclado.next();
                                System.out.println("Se han eliminado " + bbdd.usarSentenciaUDI(sentencia, "DELETE FROM Asignatura WHERE Nombre = " + nombre +")" + " filas."));

                            break;

                            case 3:
                                //System.out.println("Mostrar");
                                bbdd.usarSentenciaConsulta(sentencia, "SELECT Identificador, Nombre, NumeroAula FROM Asignatura");
                            break;

                            case 4:
                               //System.out.println("Mostrar alumnos por asignatura");
                                System.out.println("En Construccion");
                            break;

                            case 5:
                                //System.out.println("Mostrar profesores por asignatura");
                                System.out.println("En Construccion");
                            break;
                        }
                    }
                    while(opcionMenuAsignatura != 0);
                break;
            }
        }
        while(opcionMenuPrincipal != 0);
        bbdd.cerrarTodo(sentencia,consulta,conexion);


    }
}
