package com.company.test;


import com.company.clases.Profesor;

public class testProfesor {
    public static void main(String [] args) {
        Profesor p1 = new Profesor();
        Profesor p2 = new Profesor("1A", "Nzhdeh", "Manueh", 20, "60218940", "2");

        //NRP
        System.out.println(p1.getNRP());
        p1.setNRP("90");
        System.out.println(p1.getNRP());

        //toString
        System.out.println(p2.toString());
        System.out.println(p1.toString());
    }
}
