package calculator_polinomial.BusinessLogic;

import calculator_polinomial.Model.Monom;
import calculator_polinomial.Model.Polinom;

import java.util.ArrayList;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Operatii {
    public int getGradMax(Polinom p){
        int gmax=0;
        for(Monom m:p.getPolinom()){
            if(m.getExponent()>gmax)
                gmax=m.getExponent();
        }
        return gmax;
    }
    public String PolinomToString(Polinom p1){
        String rez="";
        for(Monom m: p1.getPolinom()){
            rez=rez+m.toString();
        }
        return rez;
    }
    public Polinom StringToPolinom(String s){
        String p_pattern="(-?\\b\\d+)[xX]\\^(-?\\d+\\b)";
        Pattern pattern=Pattern.compile(p_pattern);
        Matcher matcher=pattern.matcher(s);
        ArrayList<Monom> m=new ArrayList<Monom>();
        Polinom p1=new Polinom();
        while(matcher.find()){
            Monom x=new Monom(0,0);
            x.setCoeficient(Integer.parseInt(matcher.group(1)));
            x.setExponent(Integer.parseInt((matcher.group(2))));
            m.add(x);
        }
        for(Monom x:m)
            p1.addMonom(x);
        return p1;
    }
    public Polinom adunare(Polinom p1, Polinom p2){
        Polinom p=new Polinom();
        Monom m;
        for(Monom m1:p1.getPolinom()){
            for(Monom m2:p2.getPolinom()){
                if(m1.getExponent()==m2.getExponent()){
                     m=new Monom(m1.getCoeficient().intValue()+m2.getCoeficient().intValue(),m1.getExponent());
                     m1.setParcurs(true);
                     m2.setParcurs(true);
                     p.addMonom(m);
                }
            }
        }
        for(Monom m1:p1.getPolinom()) {
            if (!m1.getParcurs()) {
                m = new Monom(m1.getCoeficient(), m1.getExponent());
                m1.setParcurs(true);
                p.addMonom(m);
            }
        }
        for(Monom m1:p2.getPolinom()) {
            if (!m1.getParcurs()) {
                m = new Monom(m1.getCoeficient(), m1.getExponent());
                m1.setParcurs(true);
                p.addMonom(m);
            }
        }
        return p;
    }
    public Polinom scadere(Polinom p1, Polinom p2){
        Polinom p=new Polinom();
        Monom m;
        for(Monom m1:p1.getPolinom()) {
                m1.setParcurs(false);
        }
        for(Monom m1:p2.getPolinom()) {
                m1.setParcurs(false);
        }
        for(Monom m1:p1.getPolinom()){
            for(Monom m2:p2.getPolinom()){
                if(m1.getExponent()==m2.getExponent()){
                    m=new Monom(m1.getCoeficient().intValue()-m2.getCoeficient().intValue(),m1.getExponent());
                    m1.setParcurs(true);
                    m2.setParcurs(true);
                    p.addMonom(m);
                }
            }
        }
        for(Monom m1:p1.getPolinom()) {
            if (!m1.getParcurs()) {
                m = new Monom(m1.getCoeficient().intValue(), m1.getExponent());
                m1.setParcurs(true);
                p.addMonom(m);
            }
        }
        for(Monom m1:p2.getPolinom()) {
            if (!m1.getParcurs()) {
                m = new Monom((-m1.getCoeficient().intValue()), m1.getExponent());
                m1.setParcurs(true);
                p.addMonom(m);
            }
        }
        return p;
    }
    public Polinom inmultire(Polinom p1, Polinom p2){
        Polinom p=new Polinom();
        Polinom rez=new Polinom();
        Monom m;
        int nr=0;
        for(Monom m1:p1.getPolinom()) {
            m1.setParcurs(false);
        }
        for(Monom m1:p2.getPolinom()) {
            m1.setParcurs(false);
        }
        for(Monom m1:p1.getPolinom()){
            for(Monom m2:p2.getPolinom()){
                nr++;
            }
        }
        Vector<Integer> v=new Vector<>(nr);

        int i=0;
        int gasit=0;
        for(Monom m1:p1.getPolinom()){
            for(Monom m2:p2.getPolinom()){
                gasit=0;
                    m=new Monom(m1.getCoeficient().intValue()*m2.getCoeficient().intValue(),m1.getExponent()+m2.getExponent());
                    m1.setParcurs(true);
                    m2.setParcurs(true);
                    p.addMonom(m);
                    i=m1.getExponent()+m2.getExponent();
                    for(int j=0;j<v.size();j++)
                        if(v.get(j)==i)
                          gasit=1;
                      if(gasit==0)
                        v.add(i);

            }
        }

        for(i=0;i<v.size();i++){
            Monom m3=new Monom(0,0);
            for(Monom m1:p.getPolinom()){
                if(m1.getExponent()==v.get(i)){
                    m3.setCoeficient(m3.getCoeficient().intValue()+m1.getCoeficient().intValue());
                    m3.setExponent(v.get(i));
                }
            }
            rez.addMonom(m3);
        }
        return rez;
    }
    public Polinom derivare(Polinom p1){
        Polinom p=new Polinom();
        Monom m;
        for(Monom m1:p1.getPolinom()){
            if(m1.getExponent()!=0) {
                m = new Monom(m1.getCoeficient().intValue() * m1.getExponent(), m1.getExponent() - 1);
                p.addMonom(m);
            }
        }
        return p;
    }
    public Polinom integrare(Polinom p1){
        ArrayList<Monom> poli=p1.getPolinom();
        Polinom p=new Polinom();

        for(Monom m1:poli){
            Monom m=new Monom(0,0);
            Double c=(double)(m1.getCoeficient().doubleValue())/((double)(m1.getExponent()+1));
            m.setCoeficient(c);
            m.setExponent(m1.getExponent()+1);
            p.addMonom(m);
        }
        return p;
    }
}
