package View;

import Presenter.PrezentareAngajat;
import Presenter.PrezentareVizitator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AngajatView extends JFrame implements ActionListener,IAngajatView {
    private JButton backButton = new JButton("Back");
    private JButton deleteButton = new JButton("Delete");
    private JButton updateButton = new JButton("Update");
    private JButton addButton = new JButton("Add");
    private JButton raportButton=new JButton("Rapoarte");

    private JTextField addNameTextField = new JTextField("");
    private JTextField addSpecieTextField=new JTextField("");
    private JTextField addAlimentatieTextField = new JTextField("");
    private JTextField addHabitatTextField=new JTextField("");

    private JLabel nameLabel=new JLabel("Nume");
    private JLabel specieLabel=new JLabel("Specie");
    private JLabel alimentatieLabel=new JLabel("Alimentatie");
    private JLabel habitatLabel=new JLabel("Habitat");


    private JTextField habitatField=new JTextField();
    private JTextField alimentatieField=new JTextField();
    private JTextField specieField=new JTextField();
    private JTextField cautaField=new JTextField();

    private JLabel filterHabitatLabel=new JLabel("Filter By Habitat");
    private JLabel filterSpecieLabel=new JLabel("Filter By Specie");
    private JLabel filterAlimentatieLabel=new JLabel("Filter By Alimentatie");
    private JLabel cautaLabel=new JLabel("Search By Name");

    private JButton showButton;
    private JButton FiltreazaHabitatButon;
    private JButton CautaButton;
    private JButton FiltreazaSpecieButton;
    private JButton FiltreazaAlimentatieButton;

    private String[] header={"Nume", "Specie", "Alimentatie", "Habitat"};

    private JTable animaleTable ;
    private final JPanel panel = new JPanel();

    public AngajatView() {

        panel.setSize(new Dimension(2000,2000));
        this.setBounds(0,0,2000, 2000);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);

        panel.setLayout(null);
        JLabel title = new JLabel("Angajat");
        title.setHorizontalAlignment((JLabel.CENTER));
        title.setVerticalTextPosition(JLabel.TOP);

        JLabel addAnimal = new JLabel("Adauga un animal");
        addAnimal.setBounds(10,10,200,25);

        addNameTextField.setBounds(225,5,100,20);
        addSpecieTextField.setBounds(225,35,100,20);
        addAlimentatieTextField.setBounds(225,65,100,20);
        addHabitatTextField.setBounds(225,95,100,20);

        nameLabel.setBounds(150,5,100,20);
        specieLabel.setBounds(150,35,100,20);
        alimentatieLabel.setBounds(150,65,100,20);
        habitatLabel.setBounds(150,95,100,20);

        addButton.setBounds(675,150,100,20);
        addButton.addActionListener(this);

        deleteButton.setBounds(675,300,100,20);
        deleteButton.addActionListener(this);

        updateButton.setBounds(675,250,100,20);
        updateButton.addActionListener(this);

        backButton.setBounds(35,600,100,20);
        backButton.addActionListener(this);

        raportButton.setBounds(675,200,100,20);
        raportButton.addActionListener(this);


        //operatii vizitator

        showButton=new JButton("Show");
        showButton.setBounds(675,500,100,20);

        filterHabitatLabel.setBounds(150,550,100,20);
        habitatField.setBounds(275,550,100,20);
        FiltreazaHabitatButon=new JButton("HFilter");
        FiltreazaHabitatButon.setBounds(400,550,100,20);

        filterAlimentatieLabel.setBounds(150,580,150,20);
        alimentatieField.setBounds(275,580,100,20);
        FiltreazaAlimentatieButton=new JButton("AFilter");
        FiltreazaAlimentatieButton.setBounds(400,580,100,20);

        filterSpecieLabel.setBounds(150,610,100,20);
        specieField.setBounds(275,610,100,20);
        FiltreazaSpecieButton=new JButton("SFilter");
        FiltreazaSpecieButton.setBounds(400,610,100,20);

        cautaLabel.setBounds(775,550,100,20);
        cautaField.setBounds(875,550,100,20);
        CautaButton=new JButton("Cauta");
        CautaButton.setBounds(675,550,100,20);

        FiltreazaHabitatButon.addActionListener(this);
        showButton.addActionListener(this);
        FiltreazaSpecieButton.addActionListener(this);
        FiltreazaAlimentatieButton.addActionListener(this);
        CautaButton.addActionListener(this);

        PrezentareAngajat pv = new PrezentareAngajat(this);
        pv.updateTable();

        panel.add(title);

        panel.add(addNameTextField);
        panel.add(addSpecieTextField);
        panel.add(addAlimentatieTextField);
        panel.add(addHabitatTextField);

        panel.add(addButton);
        panel.add(deleteButton);
        panel.add(updateButton);
        panel.add(backButton);
        panel.add(raportButton);

        //adaugare elemente pt operatii vizitator

        panel.add(nameLabel);
        panel.add(specieLabel);
        panel.add(alimentatieLabel);
        panel.add(habitatLabel);


        panel.add(showButton);
        panel.add(FiltreazaHabitatButon);
        panel.add(filterHabitatLabel);
        panel.add(habitatField);
        panel.add(FiltreazaAlimentatieButton);
        panel.add(FiltreazaSpecieButton);
        panel.add(CautaButton);

        panel.add(alimentatieField);
        panel.add(specieField);
        panel.add(cautaField);
        panel.add(filterAlimentatieLabel);
        panel.add(filterSpecieLabel);
        panel.add(cautaLabel);



        this.add(panel);

    }
    public void updateTable(ArrayList<Object[]> result, String[] header, JPanel mainPanel){

        Component[] componentList = panel.getComponents();
        for(Component c : componentList){
            if(c instanceof JScrollPane){
                panel.remove(c);
            }
        }
        mainPanel.revalidate();
        mainPanel.repaint();
        animaleTable = new JTable(result.toArray(new Object[][]{}),header);
        animaleTable.setBackground(new Color( 0xEAE6F0));
        animaleTable.setRowSelectionAllowed(true);
        animaleTable.setFillsViewportHeight(true);
        JScrollPane scroll= new JScrollPane(animaleTable);
        scroll.setBounds(30,300,600,200);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setVisible(true);
        mainPanel.add(scroll);

        this.setVisible(true);


    }
    public JPanel getMainPanel(){
        return panel;
    }

    @Override
    public String getNume(){
        int row = animaleTable.getSelectedRow();
        return addNameTextField.getText();
    }
    @Override
    public String getSpecie(){
        int row = animaleTable.getSelectedRow();
        return addSpecieTextField.getText();
    }
    @Override
    public String getAlimentatie(){
        int row = animaleTable.getSelectedRow();
        return addAlimentatieTextField.getText();
    }
    @Override
    public String getHabitat(){
        int row = animaleTable.getSelectedRow();
        return addHabitatTextField.getText();
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == backButton) {
            this.dispose();
            VizitatorView vizitator = new VizitatorView();
        }
        if(e.getSource() == addButton){
            PrezentareAngajat pa = new PrezentareAngajat(this);
            pa.addAnimal();
        }
        if(e.getSource() == deleteButton){
            int row = animaleTable.getSelectedRow();
            String name = animaleTable.getValueAt(row,0).toString();
            System.out.println(name);
            PrezentareAngajat pa = new PrezentareAngajat(this);
            pa.deleteAnimal(name);
        }
        if(e.getSource() == updateButton){
            PrezentareAngajat pa = new PrezentareAngajat(this);
            pa.updateAnimale(addNameTextField.getText(),addSpecieTextField.getText(),addAlimentatieTextField.getText(),addHabitatTextField.getText());
        }
        if(e.getSource()==raportButton){
            PrezentareAngajat pa = new PrezentareAngajat(this);
            pa.generareRapoarte();
        }


        //vizitator


        if(e.getSource()==FiltreazaHabitatButon){
            PrezentareAngajat prezentareAngajat=new PrezentareAngajat(this);
            prezentareAngajat.filterHabitat(habitatField.getText());
            habitatField.setText("");
        }
        if(e.getSource()==showButton){
            PrezentareAngajat prezentareAngajat=new PrezentareAngajat(this);
            prezentareAngajat.getAnimale();
        }
        if(e.getSource()==FiltreazaAlimentatieButton){
            PrezentareAngajat prezentareAngajat=new PrezentareAngajat(this);
            prezentareAngajat.filterAlimentatie(alimentatieField.getText());
            alimentatieField.setText("");
        }
        if(e.getSource()==FiltreazaSpecieButton){
            PrezentareAngajat prezentareAngajat=new PrezentareAngajat(this);
            prezentareAngajat.filterSpecie(specieField.getText());
            specieField.setText("");
        }
        if(e.getSource()==CautaButton){
            PrezentareAngajat prezentareAngajat=new PrezentareAngajat(this);
            prezentareAngajat.searchByName(cautaField.getText());
            cautaField.setText("");
        }

    }

}
