package com.company.test;

import com.company.clases.PersonaImp;

public class testPersonaImp {
    public static void main(String [] args) {
        PersonaImp p1 = new PersonaImp();
        PersonaImp p2 = new PersonaImp("1A", "Nzhdeh", "Manueh", 20, "60218940");
        PersonaImp p3 = new PersonaImp("2A", "Yeyi", "Manueh", 25, "605208940");
        PersonaImp p4 = new PersonaImp(p2);

        //DNI
        System.out.println(p1.getDNI());
        p1.setDNI("96A");
        System.out.println(p1.getDNI());

        //Nombre
        System.out.println(p1.getNombre());
        p1.setNombre("Nzhdeh");
        System.out.println(p1.getNombre());

        //Apellidos
        System.out.println(p1.getApellidos());
        p1.setApellidos("Yeghiazaryan");
        System.out.println(p1.getApellidos());

        //Edad
        System.out.println(p1.getEdad());
        p1.setEdad(26);
        System.out.println(p1.getEdad());

        //Telefono
        System.out.println(p1.getTelefono());
        p1.setTelefono("601289401");
        System.out.println(p1.getTelefono());

        //toString
        System.out.println(p2.toString());
        System.out.println(p3.toString());

        //hashCode
        System.out.println(p2.hashCode());
        System.out.println(p3.hashCode());

        //Equals
        System.out.println(p1.equals(p2));
        System.out.println(p2.equals(p4));

        //clone
        PersonaImp p5 = p2.clone();
        System.out.println(p5.toString());

        //No necesita compareTo ni deepClone
    }
}
