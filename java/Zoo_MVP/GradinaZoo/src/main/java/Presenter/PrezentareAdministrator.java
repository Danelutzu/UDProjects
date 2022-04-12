package Presenter;

import Model.Animal;
import Model.PersistentaAnimal;
import Model.PersistentaUtilizator;
import Model.Utilizator;
import View.IAdministratorView;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PrezentareAdministrator {
    private final PersistentaUtilizator utilizator;
    private PersistentaAnimal animale=new PersistentaAnimal();
    private final IAdministratorView iAdministratorView;

    public PrezentareAdministrator(IAdministratorView iAdministratorView){
        utilizator = new PersistentaUtilizator();
        this.iAdministratorView = iAdministratorView;
    }



    public void filterHabitat(String habitat){
        JPanel panel=iAdministratorView.getMainPanel();
        ArrayList<Object[]> result=new ArrayList<>();
        for(Animal an: animale.getAnimale()){
            if(an.getHabitat().equals(habitat))
                result.add(new Object[]{an.getNume(), an.getSpecie(), an.getAlimentatie(), an.getHabitat()});
        }
        iAdministratorView.updateTableAnimale(result,new String[]{"Name","Specie","Alimentatie","Habitat"},panel);
        //updateTableAnimale();
    }
    public void filterAlimentatie(String alimentatie){
        JPanel panel=iAdministratorView.getMainPanel();
        ArrayList<Object[]> result=new ArrayList<>();
        for(Animal an: animale.getAnimale()){
            if(an.getAlimentatie().equals(alimentatie))
                result.add(new Object[]{an.getNume(), an.getSpecie(), an.getAlimentatie(), an.getHabitat()});
        }
        iAdministratorView.updateTableAnimale(result,new String[]{"Name","Specie","Alimentatie","Habitat"},panel);
        //updateTableAnimale();
    }
    public void filterSpecie(String specie){
        JPanel panel=iAdministratorView.getMainPanel();
        ArrayList<Object[]> result=new ArrayList<>();
        for(Animal an: animale.getAnimale()){
            if(an.getSpecie().equals(specie))
                result.add(new Object[]{an.getNume(), an.getSpecie(), an.getAlimentatie(), an.getHabitat()});
        }
        iAdministratorView.updateTableAnimale(result,new String[]{"Name","Specie","Alimentatie","Habitat"},panel);
        //updateTableAnimale();
    }
    public void searchByName(String name){
        JPanel panel=iAdministratorView.getMainPanel();
        ArrayList<Object[]> result=new ArrayList<>();
        for(Animal an: animale.getAnimale()){
            if(an.getNume().equals(name))
                result.add(new Object[]{an.getNume(), an.getSpecie(), an.getAlimentatie(), an.getHabitat()});
        }
        iAdministratorView.updateTableAnimale(result,new String[]{"Name","Specie","Alimentatie","Habitat"},panel);
        //updateTableAnimale();
    }

    public ArrayList<Object[]> getAnimale(){
        ArrayList<Object[]> result = new ArrayList<>();
        JPanel panel=iAdministratorView.getMainPanel();
        for(Animal an: animale.getAnimale()){
            if (an!=null){
                result.add(new Object[]{an.getNume(), an.getSpecie(), an.getAlimentatie(), an.getHabitat()});
            }
        }
        iAdministratorView.updateTableAnimale(result,new String[]{"Name","Specie","Alimentatie","Habitat"},panel);
        return result;
    }


    //administator
    public ArrayList<Object[]> getUtilizatori(){
        ArrayList<Object[]> result = new ArrayList<>();
        JPanel panel=iAdministratorView.getMainPanel();
        for(Utilizator u:utilizator.getUtilizatori()){
            result.add(new Object[]{u.getId(), u.getUsername(), u.getPassword(),u.getRole()});
        }
        iAdministratorView.updateTable(result,new String[] {"ID", "Nume", "Parola", "Rol"}, panel);
        //updateTable();
        return result;

    }
    public void updateTable(){
        JPanel mainPanel = iAdministratorView.getMainPanel();
        Component[] componentList =mainPanel.getComponents();
        for(Component c : componentList){
            if(c instanceof JScrollPane){
                mainPanel.remove(c);
            }
        }
        iAdministratorView.getMainPanel().revalidate();
        iAdministratorView.getMainPanel().repaint();
        iAdministratorView.updateTable(getUtilizatori(),new String[] {"ID", "Nume", "Parola", "Rol"}, mainPanel);

    }
    public void updateTableAnimale(){
        JPanel mainPanel = iAdministratorView.getMainPanel();
        Component[] componentList =mainPanel.getComponents();
        for(Component c : componentList){
            if(c instanceof JScrollPane){
                mainPanel.remove(c);
            }
        }
        iAdministratorView.getMainPanel().revalidate();
        iAdministratorView.getMainPanel().repaint();
        iAdministratorView.updateTable(getAnimale(),new String[] {"ID", "Nume", "Parola", "Rol"}, mainPanel);
    }
    public void deleteUtilizator(String id){
        utilizator.deleteUtilizator(id);
        updateTable();
    }
    public void updateUtilizator(){
        Utilizator utilizatorNou = new Utilizator(iAdministratorView.getID(),iAdministratorView.getName(),iAdministratorView.getPassword() ,iAdministratorView.getRole() );
        utilizator.updateUtilizator(utilizatorNou);
        updateTable();
    }
    public void addUtilizator(){
        String error;
        Utilizator utilizatorNou = new Utilizator(iAdministratorView.getIDText(),iAdministratorView.getNameText(),iAdministratorView.getPasswordText() ,iAdministratorView.getRoleText());
        error = utilizator.addUtilizator(utilizatorNou);
        //iAdministratorView.setLabel(error);
        updateTable();
    }
}
