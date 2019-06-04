package com.company.util;
import java.util.*;
public class validacionesColegio {
    /*
    Interfaz
    Nombre: leeryValidarOpcionDe3
    Comentario: Este subprograma lee y valida la opcion del menu cual tenga 3 opciones
    Cabecera: public int leeryValidarOpcionDe3()
    Precondiciones: No hay
    Entrada: No hay
    Salida: int opcion //La opcion del menu ya validada
    E/S: No hay
    Postcondiciones: Asociado al nombre, la opcion queda validada de 0 a 3
    */

    public int leeryValidarOpcionDe3() {
        Scanner teclado = new Scanner(System.in);
        int opcion = 0;
        do{
            System.out.println("La opcion tiene que ser de 0 a 3");
            opcion = teclado.nextInt();
        }
        while(opcion < 0 || opcion > 3);

        return opcion;
    }

    /*
    Interfaz
    Nombre: leeryValidarOpcionDe5
    Comentario: Este subprograma lee y valida la opcion del menu cual tenga 5 opciones
    Cabecera: public int leeryValidarOpcionDe5()
    Precondiciones: No hay
    Entrada: No hay
    Salida: int opcion //La opcion del menu ya validada
    E/S: No hay
    Postcondiciones: Asociado al nombre, la opcion queda validada de 0 a 5
    */

    public int leeryValidarOpcionDe5() {
        Scanner teclado = new Scanner(System.in);
        int opcion = 0;
        do{
            System.out.println("La opcion tiene que ser de 0 a 5");
            opcion = teclado.nextInt();
        }
        while(opcion < 0 || opcion > 5);

        return opcion;
    }
}
