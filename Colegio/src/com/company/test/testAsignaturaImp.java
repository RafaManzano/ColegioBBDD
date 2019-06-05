package com.company.test;

import com.company.clases.AsignaturaImp;

public class testAsignaturaImp {
    public static void main(String [] args) {
        AsignaturaImp p1 = new AsignaturaImp();
        AsignaturaImp p2 = new AsignaturaImp(1, "Programacion", 20);
        AsignaturaImp p3 = new AsignaturaImp(p2);

        //Identificador
        System.out.println(p1.getIdentificador());
        p1.setIdentificador(2);
        System.out.println(p1.getIdentificador());

        //Nombre
        System.out.println(p1.getNombre());
        p1.setNombre("Entornitos de Desarrollitos");
        System.out.println(p1.getNombre());

        //NumeroAula
        System.out.println(p1.getNumeroAula());
        p1.setNumeroAula(106);
        System.out.println(p1.getNumeroAula());


        //toString
        System.out.println(p2.toString());
        System.out.println(p1.toString());

        //hashCode
        System.out.println(p2.hashCode());
        System.out.println(p1.hashCode());

        //Equals
        System.out.println(p1.equals(p2));
        System.out.println(p2.equals(p2));

        //clone
        AsignaturaImp p4 = p2.clone();
        System.out.println(p4.toString());
    }
}
