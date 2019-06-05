package com.company.interfaces;
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

Metodos anhadidos
No tiene
*/
public interface Asignatura {
    //Identificador
    public int getIdentificador();
    public void setIdentificador(int identificador);

    //Nombre
    public String getNombre();
    public void setNombre(String nombre);

    //NumeroAula
    public int getNumeroAula();
    public void setNumeroAula(int numeroAula);
}
