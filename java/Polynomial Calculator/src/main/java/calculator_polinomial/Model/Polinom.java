package calculator_polinomial.Model;


import java.util.ArrayList;
public class Polinom {
    private ArrayList<Monom> poli;
    public Polinom(){poli=new ArrayList<Monom>();}

    public void addMonom(Monom m){poli.add(m);}

    public ArrayList<Monom> getPolinom(){
        return poli;
    }

}
