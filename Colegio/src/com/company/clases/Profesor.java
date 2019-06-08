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
    private String nrp;

    //Constructores
    public Profesor() {
        super();
        nrp = " ";
    }

    public Profesor(String dni, String nombre, String apellidos, int edad, String telefono, String nrp) {
        super(dni, nombre, apellidos, edad, telefono);
        this.nrp = nrp;
    }

    //Get and Set
    //NumeroEstudiante
    public String getNRP() {
        return  nrp;
    }

    public void setNRP(String nrp) {
        this.nrp = nrp;
    }

    //toString
    @Override
    public String toString() {
        return super.toString() + ", " + nrp;
    }


}
