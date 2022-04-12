package Presenter;

import Model.Animal;
import Model.PersistentaAnimal;
import View.IAngajatView;
import View.VizitatorView;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PrezentareAngajat {
    private final PersistentaAnimal animale;
    private final IAngajatView iAngajatView;
    public PrezentareAngajat(IAngajatView iAngajatView){
        animale = new PersistentaAnimal();
        this.iAngajatView = iAngajatView;
    }

    public void filterHabitat(String habitat){
        JPanel panel=iAngajatView.getMainPanel();
        ArrayList<Object[]> result=new ArrayList<>();
        for(Animal an: animale.getAnimale()){
            if(an.getHabitat().equals(habitat))
                result.add(new Object[]{an.getNume(), an.getSpecie(), an.getAlimentatie(), an.getHabitat()});
        }
        iAngajatView.updateTable(result,new String[]{"Name","Specie","Alimentatie","Habitat"},panel);
    }
    public void filterAlimentatie(String alimentatie){
        JPanel panel=iAngajatView.getMainPanel();
        ArrayList<Object[]> result=new ArrayList<>();
        for(Animal an: animale.getAnimale()){
            if(an.getAlimentatie().equals(alimentatie))
                result.add(new Object[]{an.getNume(), an.getSpecie(), an.getAlimentatie(), an.getHabitat()});
        }
        iAngajatView.updateTable(result,new String[]{"Name","Specie","Alimentatie","Habitat"},panel);
    }
    public void filterSpecie(String specie){
        JPanel panel=iAngajatView.getMainPanel();
        ArrayList<Object[]> result=new ArrayList<>();
        for(Animal an: animale.getAnimale()){
            if(an.getSpecie().equals(specie))
                result.add(new Object[]{an.getNume(), an.getSpecie(), an.getAlimentatie(), an.getHabitat()});
        }
        iAngajatView.updateTable(result,new String[]{"Name","Specie","Alimentatie","Habitat"},panel);
    }
    public void searchByName(String name){
        JPanel panel=iAngajatView.getMainPanel();
        ArrayList<Object[]> result=new ArrayList<>();
        for(Animal an: animale.getAnimale()){
            if(an.getNume().equals(name))
                result.add(new Object[]{an.getNume(), an.getSpecie(), an.getAlimentatie(), an.getHabitat()});
        }
        iAngajatView.updateTable(result,new String[]{"Name","Specie","Alimentatie","Habitat"},panel);
    }

    public ArrayList<Object[]> getAnimale(){
        ArrayList<Object[]> result = new ArrayList<>();
        JPanel panel=iAngajatView.getMainPanel();
        for(Animal an: animale.getAnimale()){
            if (an!=null){
                result.add(new Object[]{an.getNume(), an.getSpecie(), an.getAlimentatie(), an.getHabitat()});
            }
        }
        iAngajatView.updateTable(result,new String[]{"Name","Specie","Alimentatie","Habitat"},panel);
        return result;
    }

    public void updateTable(){
        JPanel mainPanel = iAngajatView.getMainPanel();
        ArrayList<Object[]> result = new ArrayList<>();
        for(Animal an: animale.getAnimale()){
            result.add(new Object[]{an.getNume(), an.getSpecie(), an.getAlimentatie(), an.getHabitat()});

        }
        Component[] components =mainPanel.getComponents();
        for(Component component : components){
            if(component instanceof JScrollPane){
                mainPanel.remove(component);
            }
        }
        iAngajatView.getMainPanel().revalidate();
        iAngajatView.getMainPanel().repaint();
        iAngajatView.updateTable(result,new String[]{"Name","Specie","Alimentatie","Habitat"}, mainPanel);


    }
    public void deleteAnimal(String name){
        animale.deleteAnimal(name);
        updateTable();
    }

    public void updateAnimale(String nume,String specie,String alimentatie,String habitat){

        for(Animal animal:animale.getAnimale()){
            if(animal.getNume().equals(nume)){
                animal.setSpecie(specie);
                animal.setAlimentatie(alimentatie);
                animal.setHabitat(habitat);
            }
        }
        animale.updateAnimal(nume,specie,alimentatie,habitat);
        updateTable();

    }
    public void addAnimal(){
        JPanel mainPanel = iAngajatView.getMainPanel();
        ArrayList<Object[]> result = new ArrayList<>();

        Animal animal = new Animal();
        animal.setNume(iAngajatView.getNume());
        animal.setHabitat(iAngajatView.getHabitat());
        animal.setAlimentatie(iAngajatView.getAlimentatie());
        animal.setSpecie(iAngajatView.getSpecie());

        animale.addAnimal(animal);

        for(Animal an: animale.getAnimale()){
            result.add(new Object[]{an.getNume(), an.getSpecie(), an.getAlimentatie(), an.getHabitat()});
        }
        iAngajatView.updateTable(result,new String[]{"Name","Specie","Alimentatie","Habitat"}, mainPanel);
    }
    public void generareRapoarte(){
        animale.raportCSV("RaportCSV");
        animale.raportJSON("RaportJSON");
    }
}
