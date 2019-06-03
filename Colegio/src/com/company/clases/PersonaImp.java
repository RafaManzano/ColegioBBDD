package com.company.clases;

/*
Propiedades basicas:
DNI
Tipo: String
Cons. Si
Mod: Si

Nombre
Tipo: String
Cons: Si
Mod: Si

Apellidos
Tipo: String
Cons: Si
Mod: Si

Edad
Tipo: Int
Cons: Si
Mod: Si

Telefono
Tipo: String
Cons: Si
Mod: Si

Propiedades derivadas
No hay

Propiedades compartidas
No hay

Get and Set
DNI
public String getDNI()
public void setDNI(String dni)

Nombre
public String getNombre()
public void setNombre(String nombre)

Apellidos
public String getApellidos()
public void setApellidos(String apellidos)

Edad
public int getEdad()
public void setEdad(int edad)

Telefono
public String getTelefono()
public void setTelefono(String telefono)

Requisitos
DNI debe ser correcto
Edad mayor que 0
Telefono tiene que tener 9 digitos
*/

import com.company.interfaces.Persona;

public class PersonaImp implements Persona, Cloneable {
    //Atributos
    private String dni;
    private String nombre;
    private String apellidos;
    private int edad;
    private String telefono;

    //Constructor
    public PersonaImp() {
        dni = " ";
        nombre = " ";
        apellidos = " ";
        edad = 0;
        telefono = " ";
    }

    public PersonaImp(String dni, String nombre, String apellidos, int edad, String telefono) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.telefono = telefono;
    }

    public PersonaImp(PersonaImp cop) {
        this.dni = cop.getDNI();
        this.nombre = cop.getNombre();
        this.apellidos = cop.getApellidos();
        this.edad = cop.getEdad();
        this.telefono = cop.getTelefono();
    }

    //Get and Set
    //DNI
    public String getDNI() {
        return dni;
    }

    public void setDNI(String dni) {
        this.dni = dni;
    }

    //Nombre
    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //Apellidos
    public String getApellidos() {
        return apellidos;
    }


    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    //Edad
    public int getEdad() {
        return edad;
    }


    public void setEdad(int edad) {
        this.edad = edad;
    }

    //Telefono
    public String getTelefono() {
        return telefono;
    }


    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    //Metodos de la clase object
    //toString
    @Override
    public String toString() {
        return dni + ", " + nombre + ", " + apellidos + ", " + edad + ", " + telefono;
    }

    //hashCode
    @Override
    public int hashCode() {
        return dni.hashCode() + nombre.hashCode() * apellidos.hashCode() - edad * telefono.hashCode() * 21;
    }

    //Equals
    //Criterio de igualdad: DNI
    @Override
    public boolean equals (Object obj) {
        boolean res = false;

        if(this == obj) {
            res = true;
        }

        else if(obj != null && obj instanceof PersonaImp) {
            PersonaImp p = (PersonaImp) obj;

            if(this.dni == p.getDNI()) {
                res = true;
            }
        }
        return res;
    }

    //clone
    @Override
    public PersonaImp clone() {
        PersonaImp p = null;

        try {
            p = (PersonaImp) super.clone();
        }
        catch(CloneNotSupportedException err) {
            err.printStackTrace();
        }

        return p;
    }
}
