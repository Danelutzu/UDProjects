package Presenter;

import Model.PersistentaUtilizator;
import Model.Utilizator;
import View.AdministratorView;
import View.AngajatView;
import View.ILogIn;

import static java.util.Objects.isNull;

public class PrezentareLogIn {
    private ILogIn iLogIn;
    private PersistentaUtilizator utilizator;

    public PrezentareLogIn(ILogIn iLogIn){
        this.iLogIn=iLogIn;
        utilizator=new PersistentaUtilizator();
    }

    public void logInUser(){
        Utilizator user=utilizator.getUtilizator(iLogIn.getUsername(),iLogIn.getPassword());

        if(!isNull(user)){
            if(user.getRole().equals("administrator")){
                AdministratorView administratorView=new AdministratorView();
            }
            else if(user.getRole().equals("angajat")){
                AngajatView angajatView=new AngajatView();
            }
        }
    }
}
