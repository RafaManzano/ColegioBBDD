package com.company.clases;
import com.company.interfaces.Asignatura;
/*
Propiedades basicas
Identificador
Tipo: Int
Cons: Si
Mod: Si

Nombre
Tipo: String
Cons: Si
Mod: Si

NumeroAula
Tipo: Int
Cons: Si
Mod: Si

Propiedades derivadas
No hay

Propiedades compartidas
No hay

Get and Set
Identificador
public int getIdentificador()
public void setIdentificador(int identificador)

Nombre
public String getNombre()
public void setNombre(String nombre)

NumeroAula
public int getNumeroAula()
public void setNumeroAula(int numeroAula)

Requisitos:
Identificador mayor que 0
NumeroAula mayor que 0

Metodos anhadidos
No tiene
*/

public class AsignaturaImp implements Asignatura, Cloneable {
    //Atributos
    private int identificador;
    private String nombre;
    private int numeroAula;

    //Constructor
    public AsignaturaImp() {
        identificador = 0;
        nombre = " ";
        numeroAula = 0;
    }

    public AsignaturaImp(int identificador, String nombre, int numeroAula) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.numeroAula = numeroAula;
    }

    public AsignaturaImp(AsignaturaImp cop) {
        this.identificador = cop.getIdentificador();
        this.nombre = cop.getNombre();
        this.numeroAula = cop.getNumeroAula();
    }

    //Get and Set
    //Identificador
    public int getIdentificador() {
        return identificador;
    }


    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    //Nombre
    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //NumeroAula
    public int getNumeroAula() {
        return numeroAula;
    }


    public void setNumeroAula(int numeroAula) {
        this.numeroAula = numeroAula;
    }

    //Metodos de la clase object
    //toString
    @Override
    public String toString() {
        return identificador + ", " + nombre + ", " + numeroAula;
    }

    //hashCode
    @Override
    public int hashCode() {
        return identificador + nombre.hashCode() * numeroAula * 21;
    }

    //Equals
    //Criterio de igualdad: identificador
    @Override
    public boolean equals (Object obj) {
        boolean res = false;

        if(this == obj) {
            res = true;
        }

        else if(obj != null && obj instanceof AsignaturaImp) {
            AsignaturaImp a = (AsignaturaImp) obj;

            if(this.identificador == a.getIdentificador()) {
                res = true;
            }
        }
        return res;
    }

    //clone
    @Override
    public AsignaturaImp clone() {
        AsignaturaImp a = null;

        try {
            a = (AsignaturaImp) super.clone();
        }
        catch(CloneNotSupportedException err) {
            err.printStackTrace();
        }

        return a;
    }

    //No necesita ni compareTo ni deepClone
}
