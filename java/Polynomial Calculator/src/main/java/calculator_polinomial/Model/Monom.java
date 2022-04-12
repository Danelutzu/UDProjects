package calculator_polinomial.Model;

public class Monom{
    private Number coeficient;
    private int exponent;
    boolean parcurs;
    public Monom( Number coeficient, int exponent )
    {
        this.coeficient = coeficient;
        this.exponent = exponent;
        parcurs=false;
    }
    //---------------------------------------------Coeficient
    public void setCoeficient( Number coeficient )
    {
        this.coeficient = coeficient;
    }
    public Number getCoeficient( )
    {
        return coeficient;
    }
    //---------------------------------------------Exponent
    public void setExponent( int exponent )
    {
        this.exponent = exponent;
    }
    public int getExponent( )
    {
        return exponent;
    }
    public String toString( )
    {
        if( coeficient.intValue() == 0 && exponent == 0 )
            return "";
        if( coeficient.intValue() == 0 )
            return "";
        if( exponent == 0 && coeficient.intValue() > 0 )
            return "+" + coeficient.intValue() ;
        if( exponent == 0 && coeficient.intValue() < 0 )
            return  coeficient.intValue() + "";
        if( coeficient.intValue() == 1 && exponent == 1 )
            return "X";
        if( exponent > 0 && coeficient.intValue() > 0 )
            return "+" + coeficient.intValue() + "X^" + exponent;
        else
            return coeficient.intValue() + "X^" + exponent;
    }
    public void setParcurs( boolean parcurs )
    {
        this.parcurs = parcurs;
    }

    public boolean getParcurs( )
    {
        return parcurs;
    }
}

