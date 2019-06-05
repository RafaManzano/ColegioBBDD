package com.company.util;
import com.company.clases.PersonaImp;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    /*
    Interfaz
    Nombre: leeryValidarPersona
    Comentario: Este subprograma lee y valida una nueva persona
    Cabecera: public PersonaImp leeryValidarPersona()
    Precondiciones: No hay
    Entrada: No hay
    Salida: PersonaImp persona //La persona creada y validada correctamente
    E/S: No hay
    Postcondiciones: Asociado al nombre. La persona estaria validada y creada correctamente
    */

    public PersonaImp leeryValidarPersona() {
        Scanner teclado = new Scanner(System.in);
        PersonaImp persona = null;
        String dni;
        char letra = ' ';
        String nombre;
        String apellidos;
        int edad;
        String telefono;

        System.out.println("Escriba su DNI");
        dni = leeryValidarDNI();
        calcularLetraDni(dni);
        dni = dni + letra;
        System.out.println("Escriba su nombre");
        nombre = teclado.next();
        System.out.println("Escriba su apellidos");
        apellidos = teclado.next();
        edad = leeryValidarEdad();
        telefono = leeryValidarTelefono();

        persona = new PersonaImp(dni, nombre, apellidos, edad, telefono);

        return persona;
    }

    /*
    Interfaz
    Nombre: leeryValidarEdad
    Comentario: Este subprograma lee y valida la edad de la persona
    Cabecera: public int leeryValidarEdad()
    Precondiciones: No hay
    Entrada: No hay
    Salida: int edad //La edad de la persona correcta (Mayor que 0)
    E/S: No hay
    Postcondiciones: Asociado al nombre, la edad de la persona correcta (Mayor que 0)
    */

    public int leeryValidarEdad() {
        Scanner teclado = new Scanner(System.in);
        int edad = 0;
        do{
            System.out.println("La edad tiene que ser mayor que 0");
            edad = teclado.nextInt();
        }
        while(edad < 0);

        return edad;
    }

    /*
    Interfaz
    Nombre: leeryValidarTelefono
    Comentario: Este subprograma lee y valida un telefono de la persona
    Cabecera: public String leeryValidarTelefono()
    Precondiciones: No hay
    Entrada: No hay
    Salida: - String telefono //El telefono correcto (9 digitos y el primer digito 6 o 7)
    E/S: No hay
    Postcondiciones: Asociado al nombre, el telefono validado (9 digitos y el primer digito 6 o 7)
    */

    public String leeryValidarTelefono() {
        Scanner teclado = new Scanner(System.in);
        String telefono;
        do{
            System.out.println("El telefono son 9 digitos y tiene que empezar por 6 o 7");
            telefono = teclado.next();
        }
        while(!telefono.matches("6.*") || !telefono.matches("7.*") || telefono.matches("\\D{8}"));

        return telefono;
    }

    /*
    Interfaz
    Nombre: leeryValidarDNISL
    Comentario: Este subprograma lee y valida el dni de una persona sin la letra
    Cabecera: public String leeryValidarDNI()
    Precondiciones: No hay
    Entrada: No hay
    Salida: - String dni //El dni con 8 digitos sin la letra
    E/S: No hay
    Postcondiciones: Asociado al nombre, el dni con 8 digitos sin la letra
    */

    public String leeryValidarDNI() {
        String dni;
        Scanner teclado = new Scanner(System.in);

        do{
            System.out.println("El DNI son 8 digitos. No tiene letra");
            dni = teclado.next();
        }
        while(dni.matches("\\D{8}"));

        return dni;
    }

    /*
    Interfaz
    Nombre: leeryValidarDNISL
    Comentario: Este subprograma calcula la letra del dni de una persona
    Cabecera:  public char calcularLetraDni(String dni)
    Precondiciones: No hay
    Entrada: - String dni //El dni de la persona para calcular la letra
    Salida: - char letra //De un dni calcula la letra y la devuelve
    E/S: No hay
    Postcondiciones: Asociado al nombre, el caracter con la letra del dni que le corresponde
	*/

    public char calcularLetraDni(String dni)
    {
        String caracteres="TRWAGMYFPDXBNJZSQVHLCKE";
        char letra=' ';
        int res=0;

        res=Integer.parseInt(dni)%23;
        letra = caracteres.charAt(res);

        return letra;
    }
    
    /*
    Interfaz
    Nombre: leeryValidarNumeroEstudiante
    Comentario: Este subprograma lee y valida el numero de un estudiante (identificador)
    Cabecera: public int leeryValidarNumeroEstudiante()
    Precondiciones: No hay
    Entrada: No hay
    Salida: int numeroEstudiante //El numero de un estudiante este correcto (Mayor que 0)
    E/S: No hay
    Postcondiciones: Asociado al nombre, el numero de un estudiante este correcto (Mayor que 0)
    */

    public int leeryValidarNumeroEstudiante() {
        Scanner teclado = new Scanner(System.in);
        int numeroEstudiante = 0;
        do{
            System.out.println("La numeroEstudiante tiene que ser mayor que 0");
            numeroEstudiante = teclado.nextInt();
        }
        while(numeroEstudiante < 0);

        return numeroEstudiante;
    }
    
    /*
    Interfaz
    Nombre: leeryValidarNRP
    Comentario: Este subprograma lee y valida el nrp de un profesor (identificador)
    Cabecera: public int leeryValidarNRP()
    Precondiciones: No hay
    Entrada: No hay
    Salida: int nrp //El nrp (identificador) de un profesor correcta (Mayor que 0)
    E/S: No hay
    Postcondiciones: Asociado al nombre, el nrp (identificador) de un profesor correcta (Mayor que 0)
    */

    public int leeryValidarNRP() {
        Scanner teclado = new Scanner(System.in);
        int nrp = 0;
        do{
            System.out.println("El nrp (identificador) tiene que ser mayor que 0");
            nrp = teclado.nextInt();
        }
        while(nrp < 0);

        return nrp;
    }
}
