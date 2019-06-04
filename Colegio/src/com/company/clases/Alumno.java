package com.company.clases;

//Clase heredada de PersonaImp

/*
Propiedades basicas:
numeroEstudiante
Tipo: Int
Cons: Si
Mod: Si

Propiedades derivadas
No hay

Propiedades compartidas
No hay

Get and Set
numeroEstudiante
public int getNumeroEstudiante()
public void setNumeroEstudiante(int numeroEstudiante)

Requisitos
No hay
*/

public class Alumno extends PersonaImp {
    //Atributos
    private int numeroEstudiante;

    //Constructores
    public Alumno() {
        super();
        numeroEstudiante = 0;
    }

    public Alumno(String dni, String nombre, String apellidos, int edad, String telefono, int numeroEstudiante) {
        super(dni, nombre, apellidos, edad, telefono);
        this.numeroEstudiante = numeroEstudiante;
    }

    //Get and Set
    //NumeroEstudiante
    public int getNumeroEstudiante() {
        return  numeroEstudiante;
    }

    public void setNumeroEstudiante(int numeroEstudiante) {
        this.numeroEstudiante = numeroEstudiante;
    }

    //toString
    @Override
    public String toString() {
        return super.toString() + ", " + numeroEstudiante;
    }


}
