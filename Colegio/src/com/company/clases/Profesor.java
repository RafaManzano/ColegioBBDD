package com.company.clases;

//Clase heredada de PersonaImp

/*
Propiedades basicas:
NRP
Tipo: Int
Cons: Si
Mod: Si

Propiedades derivadas
No hay

Propiedades compartidas
No hay

Get and Set
numeroEstudiante
public int getNRP()
public void setNRP(int nrp)

Requisitos
No hay
*/

public class Profesor extends PersonaImp{
    //Atributos
    private int nrp;

    //Constructores
    public Profesor() {
        super();
        nrp = 0;
    }

    public Profesor(String dni, String nombre, String apellidos, int edad, String telefono, int nrp) {
        super(dni, nombre, apellidos, edad, telefono);
        this.nrp = nrp;
    }

    //Get and Set
    //NumeroEstudiante
    public int getNRP() {
        return  nrp;
    }

    public void setNRP(int nrp) {
        this.nrp = nrp;
    }

    //toString
    @Override
    public String toString() {
        return super.toString() + ", " + nrp;
    }

    //Debo hablar con yeray para equals
}
