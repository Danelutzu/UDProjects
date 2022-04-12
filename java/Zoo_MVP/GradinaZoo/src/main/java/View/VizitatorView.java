package View;

import Model.Utilizator;
import Presenter.PrezentareLogIn;
import Presenter.PrezentareVizitator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VizitatorView extends JFrame implements ActionListener,ILogIn,IVizitatorView{
    private JTextField usernameTextField;
    private JPasswordField passwordTextField;
    private JTextField rolesField=new JTextField();
    private JTextField habitatField=new JTextField();
    private JTextField alimentatieField=new JTextField();
    private JTextField specieField=new JTextField();
    private JTextField cautaField=new JTextField();

    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JLabel roleLabel;
    private JLabel filterHabitatLabel=new JLabel("Filter By Habitat");
    private JLabel filterSpecieLabel=new JLabel("Filter By Specie");
    private JLabel filterAlimentatieLabel=new JLabel("Filter By Alimentatie");
    private JLabel cautaLabel=new JLabel("Search By Name");

    private JButton LogInButton;
    private JButton showButton;
    private JButton FiltreazaHabitatButon;
    private JButton CautaButton;
    private JButton FiltreazaSpecieButton;
    private JButton FiltreazaAlimentatieButton;

    private String[][] rec={};
    private String[] header={"Nume", "Specie", "Alimentatie", "Habitat"};

    private JPanel panel=new JPanel();

    public VizitatorView(){

        panel.setLayout(null);
        this.setBounds(0,0,1150,750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setTitle("Vizitator");
        this.setResizable(true);
        this.setVisible(true);
        panel.setBounds(0,0,1150,750);
        panel.setVisible(true);

        usernameLabel=new JLabel("Username");
        usernameLabel.setBounds(100,100,100,20);

        passwordLabel=new JLabel("Password");
        passwordLabel.setBounds(100,150,100,20);

        roleLabel=new JLabel("Role");
        roleLabel.setBounds(100,200,50,20);

        usernameTextField=new JTextField();
        usernameTextField.setBounds(170,100,200,20);

        passwordTextField=new JPasswordField();
        passwordTextField.setBounds(170,150,200,20);

        rolesField.setBounds(170,200,200,20);

        LogInButton=new JButton("LogIn");
        LogInButton.setBounds(200,250,100,20);

        showButton=new JButton("Show");
        showButton.setBounds(900,350,100,20);

        filterHabitatLabel.setBounds(480,350,100,20);
        habitatField.setBounds(600,350,100,20);
        FiltreazaHabitatButon=new JButton("HFilter");
        FiltreazaHabitatButon.setBounds(750,350,100,20);

        filterAlimentatieLabel.setBounds(480,380,150,20);
        alimentatieField.setBounds(600,380,100,20);
        FiltreazaAlimentatieButton=new JButton("AFilter");
        FiltreazaAlimentatieButton.setBounds(750,380,100,20);

        filterSpecieLabel.setBounds(480,410,100,20);
        specieField.setBounds(600,410,100,20);
        FiltreazaSpecieButton=new JButton("SFilter");
        FiltreazaSpecieButton.setBounds(750,410,100,20);

        cautaLabel.setBounds(480,440,100,20);
        cautaField.setBounds(600,440,100,20);
        CautaButton=new JButton("Cauta");
        CautaButton.setBounds(750,440,100,20);


        FiltreazaHabitatButon.addActionListener(this);
        showButton.addActionListener(this);
        FiltreazaSpecieButton.addActionListener(this);
        FiltreazaAlimentatieButton.addActionListener(this);
        CautaButton.addActionListener(this);
        LogInButton.addActionListener(this);

        PrezentareVizitator prezentareVizitator=new PrezentareVizitator(this);
        prezentareVizitator.updateTable();

        panel.add(usernameLabel);
        panel.add(passwordLabel);
        panel.add(roleLabel);
        panel.add(usernameTextField);
        panel.add(passwordTextField);
        panel.add(LogInButton);
        panel.add(rolesField);
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
        this.setResizable(false);

    }
    @Override
    public void setTable(ArrayList<Object[]> result, String[] header, JPanel mainPanel) {
        this.panel = mainPanel;
        //    Tabel
        JTable animaleTable = new JTable(result.toArray(new Object[][]{}), header);
        animaleTable.setBackground(new Color(0xF1CED4));
        animaleTable.setRowSelectionAllowed(true);
        animaleTable.setFillsViewportHeight(true);
        JScrollPane scroll= new JScrollPane(animaleTable);
        scroll.setBounds(460,100,600,200);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setVisible(true);
        mainPanel.add(scroll);

        this.setVisible(true);
    }
    @Override
    public String getUsername(){
        return usernameTextField.getText();
    }

    @Override
    public String getPassword(){
        return String.valueOf(passwordTextField.getPassword());
    }

    public JButton getLogInButton(){
        return LogInButton;
    }

    @Override
    public JPanel getPanel(){
        return panel;
    }

    public String[] getHeader(){
        return this.header;
    }

    @Override
    public void setPassword(String password){
        passwordTextField.setText(password);
    }

    @Override
    public void setUsername(String username){
        usernameTextField.setText(username);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==LogInButton){
            PrezentareLogIn prezentareLogIn=new PrezentareLogIn(this);
            this.dispose();
            prezentareLogIn.logInUser();

        }
        if(e.getSource()==FiltreazaHabitatButon){
            PrezentareVizitator prezentareVizitator=new PrezentareVizitator(this);
            prezentareVizitator.filterHabitat(habitatField.getText());
            habitatField.setText("");
        }
        if(e.getSource()==showButton){
            PrezentareVizitator prezentareVizitator=new PrezentareVizitator(this);
            prezentareVizitator.getAnimale();
        }
        if(e.getSource()==FiltreazaAlimentatieButton){
            PrezentareVizitator prezentareVizitator=new PrezentareVizitator(this);
            prezentareVizitator.filterAlimentatie(alimentatieField.getText());
            alimentatieField.setText("");
        }
        if(e.getSource()==FiltreazaSpecieButton){
            PrezentareVizitator prezentareVizitator=new PrezentareVizitator(this);
            prezentareVizitator.filterSpecie(specieField.getText());
            specieField.setText("");
        }
        if(e.getSource()==CautaButton){
            PrezentareVizitator prezentareVizitator=new PrezentareVizitator(this);
            prezentareVizitator.searchByName(cautaField.getText());
            cautaField.setText("");
        }
    }
}