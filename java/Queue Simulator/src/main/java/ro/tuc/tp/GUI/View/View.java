package ro.tuc.tp.GUI.View;

import ro.tuc.tp.GUI.Controller.Controller;

import javax.swing.*;
import java.awt.*;

public class View extends JFrame {
    JLabel[] InputLabels;
    JTextField[] InputTexts;
    JPanel[] InputPanels;
    JLabel title;
    JPanel first_panel;
    JPanel second_panel;
    JButton result,goBack;
    Controller controller = new Controller(this);
    JTextArea resultText;



    public View() {
        first_panel = new JPanel();
        InputTexts = new JTextField[7];
        second_panel = new JPanel();
        result = new JButton();
        InputPanels = new JPanel[7];
        goBack = new JButton();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000,800);
        this.getContentPane().setBackground(new Color(50,50,50));
        this.setVisible(true);


        goBack.setText("<=");
        goBack.setVisible(false);
        this.add(goBack,BorderLayout.WEST);
        goBack.addActionListener(controller);

        //InputLabels pentru inputuri si rezultat
        InputLabels = new JLabel[7];
        InputLabels[0] = new JLabel("Nr clients:  ");
        InputLabels[1] = new JLabel("Nr servers: ");
        InputLabels[2] = new JLabel("Simulation time: ");
        InputLabels[3] = new JLabel("Minim Arrival Time: ");
        InputLabels[4] = new JLabel("Maxim Arrival Time: ");
        InputLabels[5] = new JLabel("Minim Processing Time: ");
        InputLabels[6] = new JLabel("Maxim Processing Time: ");
        InputLabels[0].setFont(new Font(Font.DIALOG,Font.BOLD,18));
        InputLabels[1].setFont(new Font(Font.DIALOG,Font.BOLD,18));
        InputLabels[2].setFont(new Font(Font.DIALOG,Font.BOLD,18));
        InputLabels[3].setFont(new Font(Font.DIALOG,Font.BOLD,18));
        InputLabels[4].setFont(new Font(Font.DIALOG,Font.BOLD,18));
        InputLabels[5].setFont(new Font(Font.DIALOG,Font.BOLD,18));
        InputLabels[6].setFont(new Font(Font.DIALOG,Font.BOLD,18));



        //jpanel intermediar
        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.add( Box.createRigidArea(new Dimension(0,30)) );
        content.setBounds(0,0,500,100);


        title = new JLabel("Simulation inputs");
        title.setFont(new Font(Font.DIALOG,Font.BOLD,38));
        title.setHorizontalAlignment(JLabel.CENTER);
        content.add(title);
        content.add( Box.createRigidArea(new Dimension(0,30)) );


        for(int i=0;i<7;i++){
            InputTexts[i] = new JTextField();
            InputTexts[i].setFont(new Font(Font.DIALOG,Font.BOLD,15));
            InputPanels[i] = new JPanel();
            InputPanels[i].setLayout(new BoxLayout(InputPanels[i],BoxLayout.X_AXIS));
            InputPanels[i].add(InputLabels[i]);
            InputPanels[i].add(InputTexts[i]);
            content.add(InputPanels[i]);
            content.add( Box.createRigidArea(new Dimension(0,30)) );
        }
        //butonul de rezultat
        result.setFont(new Font(Font.DIALOG,Font.BOLD,28));
        result.setText("Result");
        result.setPreferredSize(new Dimension(30,40));
        result.addActionListener(controller);
        //l-am adaugat in panel
        content.add(result);
        content.add( Box.createRigidArea(new Dimension(0,30)) );
        first_panel.add(content);
        this.add(first_panel);
        first_panel.setVisible(true);

        this.validate();
        this.repaint();

        JPanel simulationContent = new JPanel();
        simulationContent.setLayout(new BoxLayout(simulationContent, BoxLayout.Y_AXIS));
        simulationContent.add( Box.createRigidArea(new Dimension(20,30)) );
        simulationContent.setBounds(0,0,500,100);

        JLabel resultLabel = new JLabel("Simulation Results");
        resultLabel.setFont(new Font(Font.DIALOG,Font.BOLD,48));
        resultLabel.setHorizontalAlignment(JLabel.CENTER);
        simulationContent.add(resultLabel);
        simulationContent.add( Box.createRigidArea(new Dimension(0,30)) );
        resultText = new JTextArea(30,70);
        resultText.setEditable(false);
        resultText.setFont(new Font(Font.DIALOG,Font.BOLD,18));
        resultText.setWrapStyleWord(true);
        resultText.setLineWrap(true);
        simulationContent.add(resultText);
        second_panel.add(simulationContent);
        second_panel.setVisible(false);
        this.add(second_panel);

        this.validate();
        this.repaint();
    }
    public void changePanels(){
        if(first_panel.isVisible()){
            first_panel.setVisible(false);
            second_panel.setVisible(true);
            goBack.setVisible(true);
        }else{
            first_panel.setVisible(true);
            second_panel.setVisible(false);
            goBack.setVisible(false);
            for (JTextField t: InputTexts
            ) {
                t.setText("");
            }
        }
    }
    public JButton getResult() {
        return result;
    }
    public void setOutput(String s) {
        resultText.setText(s);
    }
    public JTextField getInputTexts(int i) {
        return InputTexts[i];
    }
    public void EnableBack(boolean runningSimulation) {
        this.goBack.setEnabled(runningSimulation);
    }
}
