package calculator_polinomial.GUI.Controller;

import calculator_polinomial.BusinessLogic.Operatii;
import calculator_polinomial.GUI.View.View;
import calculator_polinomial.Model.Monom;
import calculator_polinomial.Model.Polinom;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private final View view;
    Operatii o1=new Operatii();

    public Controller(View view){
        this.view=view;

        this.view.addAdunareListener(new ListenForOperation());
        this.view.addScadereListener(new ListenForOperation());
        this.view.addInmultireListener(new ListenForOperation());
        this.view.addDerivare1Listener(new ListenForOperation());
        this.view.addIntegrare1Listener(new ListenForOperation());
        this.view.addDerivare2Listener(new ListenForOperation());
        this.view.addIntegrare2Listener(new ListenForOperation());
    }
    class ListenForOperation implements ActionListener{
        public void actionPerformed(ActionEvent arg0){
            Polinom p1=view.getPolinom1();
            Polinom p2=view.getPolinom2();

            if(arg0.getSource()==view.adunare){
                Polinom p3=o1.adunare(p1,p2);
                String rez="";
                view.setRezultat(rez);
                for(Monom m:p3.getPolinom()){
                    rez=rez+m.toString();
                }
                view.setRezultat(rez);
            }

            if(arg0.getSource()==view.scadere){
                Polinom p3=o1.scadere(p1,p2);
                String rez="";
                view.setRezultat(rez);
                for(Monom m:p3.getPolinom()){
                    rez=rez+m.toString();
                }
                view.setRezultat(rez);
            }

            if(arg0.getSource()==view.inmultire){
                Polinom p3=o1.inmultire(p1,p2);
                String rez="";
                view.setRezultat(rez);
                for(Monom m:p3.getPolinom()){
                    rez=rez+m.toString();
                }
                view.setRezultat(rez);
            }
            if(arg0.getSource()==view.derivare1){
                Polinom p3=o1.derivare(p1);
                String rez="";
                view.setRezultat(rez);
                for(Monom m:p3.getPolinom()){
                    rez=rez+m.toString();
                }
                view.setRezultat(rez);
            }
            if(arg0.getSource()==view.integrare1){

                Polinom p3=o1.integrare(p1);
                String rez="";
                view.setRezultat(rez);
                for(Monom m:p3.getPolinom()){
                    rez=rez+m.toString();
                }
                view.setRezultat(rez);
            }
            if(arg0.getSource()==view.derivare2){
                Polinom p3=o1.derivare(p2);
                String rez="";
                view.setRezultat(rez);
                for(Monom m:p3.getPolinom()){
                    rez=rez+m.toString();
                }
                view.setRezultat(rez);
            }
            if(arg0.getSource()==view.integrare2){

                Polinom p3=o1.integrare(p2);
                String rez="";
                view.setRezultat(rez);
                for(Monom m:p3.getPolinom()){
                    rez=rez+m.toString();
                }
                view.setRezultat(rez);
            }

        }
    }
}
