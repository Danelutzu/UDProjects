package Presenter;

import Model.Animal;
import Model.PersistentaAnimal;
import Model.PersistentaUtilizator;
import View.ILogIn;
import View.IVizitatorView;
import View.VizitatorView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PrezentareVizitator {


    private PersistentaAnimal animale;
    private IVizitatorView iVizitatorView;


    public PrezentareVizitator(IVizitatorView iVizitatorView) {
        this.iVizitatorView=iVizitatorView;
        animale=new PersistentaAnimal();
    }

    public void updateTable(){
        JPanel panel=iVizitatorView.getPanel();
        ArrayList<Object[]> result=new ArrayList<>();
        for(Animal an: animale.getAnimale()){
            result.add(new Object[]{an.getNume(), an.getSpecie(), an.getAlimentatie(), an.getHabitat()});
        }
        Component[] components=panel.getComponents();
        for(Component component:components){
            if(component instanceof JScrollPane){
                panel.remove(component);
            }
        }
        iVizitatorView.getPanel().revalidate();
        iVizitatorView.getPanel().repaint();
        iVizitatorView.setTable(result,new String[]{"Name","Specie","Alimentatie","Habitat"},panel);
    }


    public void filterHabitat(String habitat){
        JPanel panel=iVizitatorView.getPanel();
        ArrayList<Object[]> result=new ArrayList<>();
        for(Animal an: animale.getAnimale()){
            if(an.getHabitat().equals(habitat))
                result.add(new Object[]{an.getNume(), an.getSpecie(), an.getAlimentatie(), an.getHabitat()});
        }
        iVizitatorView.setTable(result,new String[]{"Name","Specie","Alimentatie","Habitat"},panel);
    }
    public void filterAlimentatie(String alimentatie){
        JPanel panel=iVizitatorView.getPanel();
        ArrayList<Object[]> result=new ArrayList<>();
        for(Animal an: animale.getAnimale()){
            if(an.getAlimentatie().equals(alimentatie))
                result.add(new Object[]{an.getNume(), an.getSpecie(), an.getAlimentatie(), an.getHabitat()});
        }
        iVizitatorView.setTable(result,new String[]{"Name","Specie","Alimentatie","Habitat"},panel);
    }
    public void filterSpecie(String specie){
        JPanel panel=iVizitatorView.getPanel();
        ArrayList<Object[]> result=new ArrayList<>();
        for(Animal an: animale.getAnimale()){
            if(an.getSpecie().equals(specie))
                result.add(new Object[]{an.getNume(), an.getSpecie(), an.getAlimentatie(), an.getHabitat()});
        }
        iVizitatorView.setTable(result,new String[]{"Name","Specie","Alimentatie","Habitat"},panel);
    }
    public void searchByName(String name){
        JPanel panel=iVizitatorView.getPanel();
        ArrayList<Object[]> result=new ArrayList<>();
        for(Animal an: animale.getAnimale()){
            if(an.getNume().equals(name))
                result.add(new Object[]{an.getNume(), an.getSpecie(), an.getAlimentatie(), an.getHabitat()});
        }
        iVizitatorView.setTable(result,new String[]{"Name","Specie","Alimentatie","Habitat"},panel);
    }

    public ArrayList<Object[]> getAnimale(){
        ArrayList<Object[]> result = new ArrayList<>();
        JPanel panel=iVizitatorView.getPanel();
        for(Animal an: animale.getAnimale()){
            if (an!=null){
                result.add(new Object[]{an.getNume(), an.getSpecie(), an.getAlimentatie(), an.getHabitat()});
            }
        }
        iVizitatorView.setTable(result,new String[]{"Name","Specie","Alimentatie","Habitat"},panel);
        return result;
    }
}
