package org.example;

import calculator_polinomial.BusinessLogic.Operatii;
import calculator_polinomial.Model.Polinom;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class AppTest 
{
    @Test
    public void shouldAnswerWithTrue()
    {
        Operatii o1=new Operatii();
        String poli1="3x^2+4x^0-5x^1";
        String poli2="2x^2+1x^3+5x^1";
        Polinom p1=o1.StringToPolinom(poli1);
        Polinom p2=o1.StringToPolinom(poli2);
        assertEquals(o1.PolinomToString(o1.adunare(p1,p2)),"+5X^2+4+1X^3");
        assertEquals(o1.PolinomToString(o1.scadere(p1,p2)),"+1X^2-10X^1+4-1X^3");
        assertEquals(o1.PolinomToString(o1.inmultire(p1,p2)),"+1X^4+3X^5+9X^3-17X^2+20X^1");
        assertEquals(o1.PolinomToString(o1.derivare(p1)),"+6X^1-5");
        assertEquals(o1.PolinomToString(o1.derivare(p2)),"+4X^1+3X^2+5");
    }
}
