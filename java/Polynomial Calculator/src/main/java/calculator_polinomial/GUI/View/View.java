package calculator_polinomial.GUI.View;
import calculator_polinomial.Model.Monom;
import calculator_polinomial.Model.Polinom;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;
public class View extends JFrame{
    public JTextField polinom1=new JTextField(40);
    public JTextField polinom2=new JTextField(40);
    public JTextField rezultat=new JTextField(40);

    public JLabel label1=new JLabel("Polinom 1:");
    public JLabel label2=new JLabel("Polinom 2:");
    public JLabel label3=new JLabel("Rezultat  :");

    public JButton adunare=new JButton("+");
    public JButton scadere=new JButton("-");
    public JButton inmultire=new JButton("*");
    public JButton derivare1=new JButton("'1");
    public JButton integrare1=new JButton("S1");
    public JButton derivare2=new JButton("'2");
    public JButton integrare2=new JButton("S2");

    public View(){
        JPanel panel=new JPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,200);

        rezultat.setBounds(100,20,750,25);
        panel.add(label1);
        panel.add(polinom1);

        panel.add(label2);
        panel.add(polinom2);

        panel.add(label3);
        panel.add(rezultat);

        panel.add(adunare);
        panel.add(scadere);
        panel.add(inmultire);
        panel.add(derivare1);
        panel.add(derivare2);
        panel.add(integrare1);
        panel.add(integrare2);
        this.add(panel);
    }
    public Polinom getPolinom1(){
        String t1=polinom1.getText();
        String p_pattern="(-?\\b\\d+)[xX]\\^(-?\\d+\\b)";
        Pattern pattern=Pattern.compile(p_pattern);
        Matcher matcher=pattern.matcher(t1);
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

    public Polinom getPolinom2(){
        String t2=polinom2.getText();
        String p_pattern="(-?\\b\\d+)[xX]\\^(-?\\d+\\b)";
        Pattern pattern=Pattern.compile(p_pattern);
        Pattern pattern1=Pattern.compile(p_pattern);
        Matcher matcher1=pattern.matcher(t2);
        ArrayList<Monom> m2=new ArrayList<Monom>();
        Polinom p2=new Polinom();

        while(matcher1.find()){
            Monom x2=new Monom(0,0);
            x2.setCoeficient(Integer.parseInt(matcher1.group(1)));
            x2.setExponent(Integer.parseInt(matcher1.group(2)));
            m2.add(x2);
        }

        for(Monom x2:m2){
            p2.addMonom(x2);
        };
        return p2;
    }

    public void setRezultat(String s){
        rezultat.setText(s);
    }

    public void addAdunareListener(ActionListener listenerForAdunare){
        adunare.addActionListener(listenerForAdunare);
    }

    public void addScadereListener(ActionListener listenerForScadere){
        scadere.addActionListener(listenerForScadere);
    }

    public void addInmultireListener(ActionListener listenerForInmultire){
        inmultire.addActionListener(listenerForInmultire);
    }

    public void addDerivare1Listener(ActionListener listenerForDerivare){
        derivare1.addActionListener(listenerForDerivare);
    }

    public void addIntegrare1Listener(ActionListener listenerForIntegrare){
        integrare1.addActionListener(listenerForIntegrare);
    }
    public void addDerivare2Listener(ActionListener listenerForDerivare){
        derivare2.addActionListener(listenerForDerivare);
    }

    public void addIntegrare2Listener(ActionListener listenerForIntegrare){
        integrare2.addActionListener(listenerForIntegrare);
    }
}
