package com.company.util;

public class menuColegio {
    /*
    Interfaz
    Nombre: mostrarMenuPrincipal
    Comentario: Este subprograma muestra el menu de opciones
    Cabecera: public void mostrarMenuPrincipal()
    Precondiciones: No hay
    Entrada: No hay
    Salida: No hay
    E/S: No hay
    Postcondiciones: No hay, Solo pinta en pantalla el menu principal
    */

    public void mostrarMenuPrincipal() {
        System.out.println("MENU PRINCIPAL");
        System.out.println("1. Alumnos");
        System.out.println("2. Profesores");
        System.out.println("3. Asignaturas");
        System.out.println("0. Salir");
    }

    /*
    Interfaz
    Nombre: mostrarMenuAlumno
    Comentario: Este subprograma muestra el menu de opciones de alumnos
    Cabecera: public void mostrarMenuAlumno()
    Precondiciones: No hay
    Entrada: No hay
    Salida: No hay
    E/S: No hay
    Postcondiciones: No hay, Solo pinta en pantalla el menu de alumnos
    */

    public void mostrarMenuAlumno() {
        System.out.println("MENU ALUMNO");
        System.out.println("1. Anhadir Alumno");
        System.out.println("2. Eliminar Alumno");
        System.out.println("3. Mostrar Alumno");
        System.out.println("0. Salir");
    }

    /*
    Interfaz
    Nombre: mostrarMenuProfesor
    Comentario: Este subprograma muestra el menu de opciones de profesores
    Cabecera: public void mostrarMenuProfesor()
    Precondiciones: No hay
    Entrada: No hay
    Salida: No hay
    E/S: No hay
    Postcondiciones: No hay, Solo pinta en pantalla el menu de profesores
    */

    public void mostrarMenuProfesores() {
        System.out.println("MENU PROFESOR");
        System.out.println("1. Anhadir Profesor");
        System.out.println("2. Eliminar Profesor");
        System.out.println("3. Mostrar Profesor");
        System.out.println("0. Salir");
    }

    /*
    Interfaz
    Nombre: mostrarMenuAsignatura
    Comentario: Este subprograma muestra el menu de opciones de asignaturas
    Cabecera: public void mostrarMenuAsignatura()
    Precondiciones: No hay
    Entrada: No hay
    Salida: No hay
    E/S: No hay
    Postcondiciones: No hay, Solo pinta en pantalla el menu de asignaturas
    */

    public void mostrarMenuAsignatura() {
        System.out.println("MENU ASIGNATURA");
        System.out.println("1. Anhadir Asignatura");
        System.out.println("2. Eliminar Asigntatura");
        System.out.println("3. Mostrar Asignatura");
        System.out.println("4. Mostrar alumnos de una asignatura");
        System.out.println("5. Mostrar profesores de una asignatura");
        System.out.println("0. Salir");
    }


}
