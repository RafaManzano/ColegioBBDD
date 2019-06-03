package com.company.interfaces;

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
public interface Persona {
    //DNI
    public String getDNI();
    public void setDNI(String dni);

    //Nombre
    public String getNombre();
    public void setNombre(String nombre);

    //Apellidos
    public String getApellidos();
    public void setApellidos(String apellidos);

    //Edad
    public int getEdad();
    public void setEdad(int edad);

    //Telefono
    public String getTelefono();
    public void setTelefono(String telefono);
}
