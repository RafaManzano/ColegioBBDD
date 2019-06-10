package com.company.Main;

import com.company.Conexiones.conexionesBaseDatos;
import com.company.clases.Alumno;
import com.company.clases.AsignaturaImp;
import com.company.clases.PersonaImp;
import com.company.clases.Profesor;
import com.company.gestora.gestoraColegio;
import com.company.util.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/*
Nombre del programa: ColegioCompadre
Analisis
    Entrada: - opcionMenuPrincipal
             - opcionMenuAlumno
             - opcionMenuProfesor
             - opcionMenuAsignatura
             - opcionMenuMatricula
             - usuario
             - password
    Salida: - Mensajes con el usuario
    Requisitos: - opcionMenuPrincipal tiene que ser de 0 a 4
                - opcionMenuAlumno tiene que ser de 0 a 3
                - opcionMenuProfesor tiene que ser de 0 a 3
                - opcionMenuAsignatura tiene que ser de 0 a 5
                - opcionMenuMatricula tiene que ser de 0 a 3

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
            caso 4
                Matricula
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

     Modulo Matricula
     Inicio
        MostrarMenuMatricula
        LeeryValidarOpcionMenuMatricula
        Segun(OpcionMenuMatricula)
            caso 1
                Matricular un alumno en una asigunatura
            caso 2
                Matricular un profesor en una asigunatura
            caso 3
                Asignar un profesor con un alumno
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
        int opcionMenuMatricula;
        int numeroEstudiante;
        String nrp;
        int identificador;
        int validez;
        PersonaImp p;
        Alumno a;
        Profesor pr;
        AsignaturaImp as;
        menuColegio menus = new menuColegio();
        Connection conexion;
        Statement sentencia;
        ResultSet consulta = null;
        validacionesColegio validar = new validacionesColegio();
        gestoraColegio gestora = new gestoraColegio();
        Scanner teclado = new Scanner(System.in);

        //Login
        conexion = bbdd.iniciarConexion("administrador", "1234");
        sentencia = bbdd.crearSentencia(conexion);
        do {
            menus.mostrarMenuPrincipal();
            opcionMenuPrincipal = validar.leeryValidarOpcionDe4();

            switch (opcionMenuPrincipal) {
                case 1:
                    //System.out.println("Alumno");
                    //Alumno
                    do {
                        menus.mostrarMenuAlumno();
                        opcionMenuAlumno = validar.leeryValidarOpcionDe3();

                        switch (opcionMenuAlumno) {
                            case 1:
                                //AnhadirAlumno
                                //System.out.println("Anhadir");
                                p = validar.leeryValidarPersona();
                                a = new Alumno(p.getDNI(), p.getNombre(), p.getApellidos(), p.getEdad(), p.getTelefono(), validar.leeryValidarNumeroEstudiante());
                                //De momento el insert no funciona, probablemente haya que hacerlo con la clase PreparedStantement //Metodo sql
                                //System.out.println("Se han insertado " + bbdd.usarSentenciaUDI(sentencia, "INSERT INTO PersonaAlumno " +  "VALUES (" + a.getDNI() + "," + a.getNombre() + "," + a.getApellidos() + "," + a.getEdad() + "," + a.getTelefono() + "," + a.getNumeroEstudiante() + ")"));
                                validez = gestora.insertarAlumno(conexion, a);
                                System.out.println(validez);
                                //validez = bbdd.usarSentenciaProcedimiento(sentencia, "addAlumno(" + a.toString() + ")");
                            break;

                            case 2:
                                //EliminarAlumno
                                //System.out.println("Eliminar");
                                consulta = bbdd.usarSentenciaConsulta(sentencia, "SELECT NumeroEstudiante, Nombre, Apellidos FROM PersonaAlumno");
                                gestora.mostrarConsultaAlumno(consulta);//Mostrar la tabla en Java
                                System.out.println("Escriba el numero de estudiantes que deseas borrar?");
                                numeroEstudiante = teclado.nextInt();
                                validez = gestora.eliminarAlumno(conexion, numeroEstudiante);
                                System.out.println(validez);
                                //System.out.println("Se han eliminado " + bbdd.usarSentenciaUDI(sentencia, "DELETE FROM PersonaAlumno WHERE numeroEstudiante = " + numeroEstudiante + ")" + " filas."));
                            break;

                            case 3:
                                //MostrarAlumno
                                //System.out.println("Mostrar");
                                consulta = bbdd.usarSentenciaConsulta(sentencia, "SELECT NumeroEstudiante, Nombre, Apellidos FROM PersonaAlumno");
                                //Mostrar la tabla en Java
                                gestora.mostrarConsultaAlumno(consulta);
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
                                //AnhadirProfesor
                                //System.out.println("Anhadir");
                                p = validar.leeryValidarPersona();
                                System.out.println("Escriba su nrp");
                                nrp = teclado.next();
                                pr = new Profesor(p.getDNI(), p.getNombre(), p.getApellidos(), p.getEdad(), p.getTelefono(), nrp);
                                //System.out.println("Se han insertado " + bbdd.usarSentenciaUDI(sentencia, "INSERT INTO PersonaProfesor VALUES (" + pr.toString() + ")") + " filas.");
                                validez = gestora.insertarProfesor(conexion, pr);
                                System.out.println(validez);
                            break;

                            case 2:
                                //EliminarProfesor
                                //System.out.println("Eliminar");
                                consulta = bbdd.usarSentenciaConsulta(sentencia, "SELECT NRP, Nombre, Apellidos FROM PersonaProfesor");
                                gestora.mostrarConsultaProfesor(consulta);  //Mostrar la tabla en Java
                                System.out.println("Escriba el nrp que deseas borrar?");
                                nrp = teclado.next();
                                validez = gestora.eliminarProfesor(conexion, nrp);
                                System.out.println(validez);
                                //System.out.println("Se han eliminado " + bbdd.usarSentenciaUDI(sentencia, "DELETE FROM PersonaProfesor WHERE nrp = " + nrp + ")" + " filas."));
                            break;

                            case 3:
                                //MostrarProfesor
                                //System.out.println("Mostrar");
                                consulta = bbdd.usarSentenciaConsulta(sentencia, "SELECT NRP, Nombre, Apellidos FROM PersonaProfesor");
                                gestora.mostrarConsultaProfesor(consulta); //Mostrar la tabla en Java
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
                                //AnhadirAsignatura
                                //System.out.println("Anhadir");
                                as = validar.leeryValidarAsignatura();
                                //System.out.println("Se han insertado " + bbdd.usarSentenciaUDI(sentencia, "INSERT INTO Asignatura VALUES (" + as.toString() + ")") + " filas.");
                                validez = gestora.insertarAsignatura(conexion, as);
                                System.out.println(validez);
                            break;

                            case 2:
                                //EliminarAsignatura
                                //System.out.println("Eliminar");
                                consulta = bbdd.usarSentenciaConsulta(sentencia, "SELECT Identificador, Nombre, NumeroAula FROM Asignatura");
                                gestora.mostrarConsultaAsignatura(consulta); //Mostrar la tabla en Java
                                System.out.println("Escriba el identificador que deseas borrar?");
                                identificador = teclado.nextInt();
                                validez = gestora.eliminarAsignatura(conexion, identificador);
                                System.out.println(validez);
                                //System.out.println("Se han eliminado " + bbdd.usarSentenciaUDI(sentencia, "DELETE FROM Asignatura WHERE Identificador = " + identificador +")" + " filas."));

                            break;

                            case 3:
                                //MostrarAsignatura
                                //System.out.println("Mostrar");
                                consulta = bbdd.usarSentenciaConsulta(sentencia, "SELECT Identificador, Nombre, NumeroAula FROM Asignatura");
                                gestora.mostrarConsultaAsignatura(consulta);
                            break;

                            case 4:
                                //Mostrar alumnos de una asignatura
                                //System.out.println("Mostrar alumnos por asignatura");
                                //System.out.println("En Construccion");
                                consulta = bbdd.usarSentenciaConsulta(sentencia, "SELECT Identificador, Nombre, NumeroAula FROM Asignatura");
                                gestora.mostrarConsultaAsignatura(consulta); //Mostrar la tabla en Java
                                System.out.println("Escriba el identificador de la asignatura que deseas consultar");
                                identificador = teclado.nextInt();
                                consulta = gestora.alumnosDeUnaAsignatura(conexion, identificador);
                                gestora.mostrarConsultaAlumno(consulta);
                            break;

                            case 5:
                                //Mostrar profesores por asignatura
                                //System.out.println("Mostrar profesores por asignatura");
                                //System.out.println("En Construccion");
                                consulta = bbdd.usarSentenciaConsulta(sentencia, "SELECT Identificador, Nombre, NumeroAula FROM Asignatura");
                                gestora.mostrarConsultaAsignatura(consulta); //Mostrar la tabla en Java
                                System.out.println("Escriba el identificador de la asignatura que deseas consultar");
                                identificador = teclado.nextInt();
                                consulta = gestora.profesoresDeUnaAsignatura(conexion, identificador);
                                gestora.mostrarConsultaProfesor(consulta);
                            break;
                        }
                    }
                    while(opcionMenuAsignatura != 0);
                break;

                case 4:
                    //Matriculaciones
                    //System.out.println("Matriculaciones");
                    do {
                        menus.mostrarMenuMatricula();
                        opcionMenuMatricula = validar.leeryValidarOpcionDe3();
                        switch (opcionMenuMatricula) {
                            case 1:
                                //Matricular un alumno en una asigunatura
                                //System.out.println("Anhadir alumno con asignatura");
                                consulta = bbdd.usarSentenciaConsulta(sentencia, "SELECT NumeroEstudiante, Nombre, Apellidos FROM PersonaAlumno");
                                gestora.mostrarConsultaAlumno(consulta);//Mostrar la tabla en Java
                                System.out.println("Escriba el numero de estudiantes que deseas asignar");
                                numeroEstudiante = teclado.nextInt();
                                consulta = bbdd.usarSentenciaConsulta(sentencia, "SELECT Identificador, Nombre, NumeroAula FROM Asignatura");
                                gestora.mostrarConsultaAsignatura(consulta); //Mostrar la tabla en Java
                                System.out.println("Escriba el identificador que deseas asignar");
                                identificador = teclado.nextInt();
                                validez = gestora.asignarAlumnoConAsignatura(conexion, numeroEstudiante, identificador);
                                System.out.println(validez);
                            break;

                            case 2:
                                //Matricular un profesor en una asigunatura
                                //System.out.println("Anhadir profe con asignatura");
                                consulta = bbdd.usarSentenciaConsulta(sentencia, "SELECT NRP, Nombre, Apellidos FROM PersonaProfesor");
                                gestora.mostrarConsultaProfesor(consulta);  //Mostrar la tabla en Java
                                System.out.println("Escriba el nrp que deseas asignar?");
                                nrp = teclado.next();
                                consulta = bbdd.usarSentenciaConsulta(sentencia, "SELECT Identificador, Nombre, NumeroAula FROM Asignatura");
                                gestora.mostrarConsultaAsignatura(consulta); //Mostrar la tabla en Java
                                System.out.println("Escriba el identificador que deseas asignar");
                                identificador = teclado.nextInt();
                                validez = gestora.asignarProfesorConAsignatura(conexion, nrp, identificador);
                                System.out.println(validez);
                            break;

                            case 3:
                                //Asignar un profesor con un alumno
                                //System.out.println("Anhadir profe con alumno");
                                consulta = bbdd.usarSentenciaConsulta(sentencia, "SELECT NumeroEstudiante, Nombre, Apellidos FROM PersonaAlumno");
                                gestora.mostrarConsultaAlumno(consulta);//Mostrar la tabla en Java
                                System.out.println("Escriba el numero de estudiantes que deseas asignar");
                                numeroEstudiante = teclado.nextInt();
                                consulta = bbdd.usarSentenciaConsulta(sentencia, "SELECT NRP, Nombre, Apellidos FROM PersonaProfesor");
                                gestora.mostrarConsultaProfesor(consulta);  //Mostrar la tabla en Java
                                System.out.println("Escriba el nrp que deseas asignar?");
                                nrp = teclado.next();
                                validez = gestora.asignarAlumnoConProfesor(conexion, numeroEstudiante, nrp);
                                System.out.println(validez);
                            break;
                        }
                    }
                    while(opcionMenuMatricula!= 0);
                break;
            }
        }
        while(opcionMenuPrincipal != 0);
        bbdd.cerrarTodo(sentencia,consulta,conexion);
    }
}
