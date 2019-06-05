package com.company.Main;

import com.company.Conexiones.conexionesBaseDatos;
import com.company.clases.Alumno;
import com.company.clases.PersonaImp;
import com.company.util.*;

import java.sql.Connection;
import java.sql.Statement;

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
        PersonaImp p;
        Alumno a;
        menuColegio menus = new menuColegio();
        Connection conexion;
        Statement sentencia;
        validacionesColegio validar = new validacionesColegio();

        //Login
        conexion = bbdd.iniciarConexion("admin", "1234");
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
                                bbdd.usarSentenciaProcedimiento(sentencia, "INSERT INTO Alumno VALUES (" + a.toString() + ")");
                            break;

                            case 2:
                                System.out.println("Eliminar");
                            break;

                            case 3:
                                //System.out.println("Mostrar");
                                bbdd.usarSentenciaConsulta(sentencia, "SELECT Nombre, Apellidos FROM Alumno");
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
                                System.out.println("Anhadir");
                            break;

                            case 2:
                                System.out.println("Eliminar");
                            break;

                            case 3:
                                //System.out.println("Mostrar");
                                bbdd.usarSentenciaConsulta(sentencia, "SELECT Nombre, Apellidos FROM Profesor");
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
                                System.out.println("Anhadir");
                            break;

                            case 2:
                                System.out.println("Eliminar");
                            break;

                            case 3:
                                //System.out.println("Mostrar");
                                bbdd.usarSentenciaConsulta(sentencia, "SELECT Identificador, Nombre, NumeroAula FROM Asignatura");
                            break;

                            case 4:
                               System.out.println("Mostrar alumnos por asignatura");
                            break;

                            case 5:
                                System.out.println("Mostrar profesores por asignatura");
                            break;
                        }
                    }
                    while(opcionMenuAsignatura != 0);
                break;
            }
        }
        while(opcionMenuPrincipal != 0);


    }
}
