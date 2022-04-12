package calculator_polinomial.Model;

import calculator_polinomial.BusinessLogic.Operatii;

public class Main {

    public static void main(String []args){
        Operatii o1=new Operatii();
        Polinom p1=new Polinom();
        Polinom p2=new Polinom();
        Monom m1=new Monom(3,2);
        Monom m2=new Monom(4,0);
        Monom m3=new Monom(-5,1);
        Monom m4=new Monom(2,2);
        Monom m5=new Monom(1,3);
        Monom m6=new Monom(5,1);
        p1.addMonom(m1);
        p1.addMonom(m2);
        p1.addMonom(m3);
        p2.addMonom(m4);
        p2.addMonom(m5);
        p2.addMonom(m6);

        System.out.println(p1.getPolinom());
        System.out.println(p2.getPolinom());
        //System.out.println(o1.getGradMax(p1));
        //System.out.println(o1.getGradMax(p2));
        System.out.println("adunare:");
        System.out.println(o1.adunare(p1,p2).getPolinom());
        System.out.println("scadere:");
        System.out.println(o1.scadere(p1,p2).getPolinom());
        System.out.println("derivare");
        System.out.println(o1.derivare(p1).getPolinom());
        System.out.println("integrare");
        System.out.println(o1.integrare(p1).getPolinom());
        System.out.println("inmultire");
        System.out.println(o1.inmultire(p1,p2).getPolinom());
    }


}
