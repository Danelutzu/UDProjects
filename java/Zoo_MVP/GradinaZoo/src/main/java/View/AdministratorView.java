package View;

import Presenter.PrezentareAdministrator;
import Presenter.PrezentareVizitator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AdministratorView extends JFrame implements ActionListener, IAdministratorView {
    private final JPanel panel = new JPanel();

    private JLabel titleLable = new JLabel("Administrator");
    private JLabel addNew = new JLabel("Adauga un nou angajat:");
    //private JLabel addLabel = new JLabel();
    //    Buttons
    private final JButton backButton = new JButton("Back");
    private final JButton deleteAngajatButton = new JButton("Delete");
    private final JButton addAngajatButton = new JButton("Add");
    private final JButton updateAngajatButton = new JButton("Update");
    private JButton showUtilizatoriButton=new JButton("ShowU");

    // Text area
    private final JTextField idText =new JTextField("id");
    private final JTextField numeText = new JTextField("nume");
    private final JTextField roleText =  new JTextField("rol");
    private final JTextField passwordText = new JTextField("parola");
    //  Tabel
    private JTable utilizatori;

    //vizitator
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

    public AdministratorView(){

        this.setBounds(0,0,2000, 2000);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setVisible(true);

        panel.setSize(new Dimension(2000,2000));

        panel.setLayout(null);
        titleLable.setBounds(270, 0,1000,35);

        backButton.setBounds(35,650,150,50);
        backButton.addActionListener( this);

        addNew.setHorizontalAlignment((JLabel.CENTER));
        addNew.setBounds(15,75,250,45);

        idText.setBounds(260,80,100,30);

        numeText.setBounds(370,80,200,30);

        roleText.setBounds(580,80,100,30);

        passwordText.setBounds(340,120,150,30);

        addAngajatButton.setBounds(500,120,180,30);
        addAngajatButton.addActionListener( this);

        deleteAngajatButton.setBounds(30,510,180,30);
        deleteAngajatButton.addActionListener( this);

        showUtilizatoriButton.setBounds(230,510,100,30);
        showUtilizatoriButton.addActionListener(this);

        updateAngajatButton.setBounds(400,510,180,30);
        updateAngajatButton.addActionListener( this);

        PrezentareAdministrator pv = new PrezentareAdministrator(this);
        pv.updateTable();
        pv.updateTableAnimale();

        backButton.addActionListener(this);
        deleteAngajatButton.addActionListener(this);
        updateAngajatButton.addActionListener(this);
        addAngajatButton.addActionListener(this);

        panel.add(updateAngajatButton);
        panel.add(deleteAngajatButton);
        panel.add(addAngajatButton);
        panel.add(passwordText);
        panel.add(roleText);
        panel.add(numeText);
        panel.add(idText);
        panel.add(addNew);
        panel.add(titleLable);
        panel.add(backButton);
        panel.add(showUtilizatoriButton);

        //vizitator

        showButton=new JButton("Show");
        showButton.setBounds(1050,350,100,20);

        filterHabitatLabel.setBounds(700,350,100,20);
        habitatField.setBounds(820,350,100,20);
        FiltreazaHabitatButon=new JButton("HFilter");
        FiltreazaHabitatButon.setBounds(940,350,100,20);

        filterAlimentatieLabel.setBounds(700,380,150,20);
        alimentatieField.setBounds(820,380,100,20);
        FiltreazaAlimentatieButton=new JButton("AFilter");
        FiltreazaAlimentatieButton.setBounds(940,380,100,20);

        filterSpecieLabel.setBounds(700,410,100,20);
        specieField.setBounds(820,410,100,20);
        FiltreazaSpecieButton=new JButton("SFilter");
        FiltreazaSpecieButton.setBounds(940,410,100,20);

        cautaLabel.setBounds(700,440,100,20);
        cautaField.setBounds(820,440,100,20);
        CautaButton=new JButton("Cauta");
        CautaButton.setBounds(940,440,100,20);


        FiltreazaHabitatButon.addActionListener(this);
        showButton.addActionListener(this);
        FiltreazaSpecieButton.addActionListener(this);
        FiltreazaAlimentatieButton.addActionListener(this);
        CautaButton.addActionListener(this);

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


    //vizitator
    @Override
    public void updateTableAnimale(ArrayList<Object[]> result, String[] header, JPanel mainPanel){

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
        scroll.setBounds(900,50,600,200);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setVisible(true);
        mainPanel.add(scroll);

        this.setVisible(true);


    }


    @Override
    public JPanel getMainPanel(){
        return panel;
    }
    @Override
    public void updateTable(ArrayList<Object[]> result, String[] header, JPanel mainPanel){

        Component[] componentList = mainPanel.getComponents();
        for(Component c : componentList){
            if(c instanceof JScrollPane){
                utilizatori.remove(c);
            }
        }
        mainPanel.revalidate();
        mainPanel.repaint();
        utilizatori = new JTable(result.toArray(new Object[][]{}),header);
        utilizatori.setRowSelectionAllowed(true);
        utilizatori.setFillsViewportHeight(true);
        JScrollPane scroll= new JScrollPane(utilizatori);
        scroll.setBounds(20,200,600,300);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setVisible(true);
        mainPanel.add(scroll);

        this.setVisible(true);


    }

    @Override
    public String getName(){
        int row = utilizatori.getSelectedRow();
        return numeText.getText();
    }
    @Override
    public String getID() {
        int row = utilizatori.getSelectedRow();
        return idText.getText();
    }
    @Override
    public String getRole() {
        int row = utilizatori.getSelectedRow();
        return roleText.getText();
    }

    @Override
    public String getPassword() {
        int row = utilizatori.getSelectedRow();
        return passwordText.getText();
    }

    @Override
    public String getIDText() {
        return idText.getText();
    }

    @Override
    public String getNameText() {
        return numeText.getText();
    }

    @Override
    public String getRoleText() {
        return roleText.getText();
    }

    @Override
    public String getPasswordText() {
        return passwordText.getText();
    }

   /* @Override
    public void setLabel(String text) {
        addLabel.setText(text);
        if(text.contains("Error")){
            addLabel.setForeground(new Color( 0x900800));
        }else{
            addLabel.setForeground(new Color(0x03A65A));
        }

        addLabel.setFont(new Font(Font.SERIF, Font.BOLD, 20));
        addLabel.setOpaque(true);
        addLabel.setHorizontalAlignment((JLabel.CENTER));
        addLabel.setBounds(150,550,400,45);
        addLabel.setBackground(new Color(0xF3EAC0));
        panel.add(addLabel);
    }*/

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            this.dispose();
            VizitatorView vizitator = new VizitatorView();
        }
        if(e.getSource()==deleteAngajatButton){
            PrezentareAdministrator pa = new PrezentareAdministrator(this);
            int row = utilizatori.getSelectedRow();
            String id = utilizatori.getValueAt(row,0).toString();
            System.out.println(id);
            pa.deleteUtilizator(id);

        }
        if(e.getSource() == updateAngajatButton){
            PrezentareAdministrator pa  = new PrezentareAdministrator(this);
            pa.updateUtilizator();
        }
        if(e.getSource()==addAngajatButton){
            PrezentareAdministrator pa = new PrezentareAdministrator(this);
            pa.addUtilizator();
        }
        if(e.getSource()==showUtilizatoriButton){
            PrezentareAdministrator prezentareAdministrator=new PrezentareAdministrator(this);
            prezentareAdministrator.getUtilizatori();
        }

        //vizitator


        if(e.getSource()==FiltreazaHabitatButon){
            PrezentareAdministrator prezentareAdministrator=new PrezentareAdministrator(this);
            prezentareAdministrator.filterHabitat(habitatField.getText());
            habitatField.setText("");
        }
        if(e.getSource()==showButton){
            PrezentareAdministrator prezentareAdministrator=new PrezentareAdministrator(this);
            prezentareAdministrator.getAnimale();
        }
        if(e.getSource()==FiltreazaAlimentatieButton){
            PrezentareAdministrator prezentareAdministrator=new PrezentareAdministrator(this);
            prezentareAdministrator.filterAlimentatie(alimentatieField.getText());
            alimentatieField.setText("");
        }
        if(e.getSource()==FiltreazaSpecieButton){
            PrezentareAdministrator prezentareAdministrator=new PrezentareAdministrator(this);
            prezentareAdministrator.filterSpecie(specieField.getText());
            specieField.setText("");
        }
        if(e.getSource()==CautaButton){
            PrezentareAdministrator prezentareAdministrator=new PrezentareAdministrator(this);
            prezentareAdministrator.searchByName(cautaField.getText());
            cautaField.setText("");
        }
    }
}
