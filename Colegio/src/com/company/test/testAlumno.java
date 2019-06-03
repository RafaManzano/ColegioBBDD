package com.company.test;


import com.company.clases.Alumno;

public class testAlumno {
    public static void main(String [] args) {
        Alumno p1 = new Alumno();
        Alumno p2 = new Alumno("1A", "Nzhdeh", "Manueh", 20, "60218940", 2);

        //NumeroEstudiante
        System.out.println(p1.getNumeroEstudiante());
        p1.setNumeroEstudiante(90);
        System.out.println(p1.getNumeroEstudiante());

        //toString
        System.out.println(p2.toString());
        System.out.println(p1.toString());
    }
}
