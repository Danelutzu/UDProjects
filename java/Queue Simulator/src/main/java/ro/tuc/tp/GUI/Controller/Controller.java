package ro.tuc.tp.GUI.Controller;

import ro.tuc.tp.GUI.View.View;
import ro.tuc.tp.Logic.SimulationManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
    private View view;
    private int timeLimit = 200;
    private int maxProcessingTime = 9;
    private int minProcessingTime = 3;
    private int maxArrivalTime = 100;
    private int minArrivalTime = 10;
    private int numberOfServers = 20;
    private int numberOfClients = 1000;

    public Controller(View view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton buttonPressed = (JButton) e.getSource();
        if(buttonPressed == view.getResult()){
            try{
                view.changePanels();
                numberOfClients = Integer.parseInt(view.getInputTexts(0).getText());
                numberOfServers = Integer.parseInt(view.getInputTexts(1).getText());
                timeLimit = Integer.parseInt(view.getInputTexts(2).getText());
                minArrivalTime = Integer.parseInt(view.getInputTexts(3).getText());
                maxArrivalTime = Integer.parseInt(view.getInputTexts(4).getText());
                minProcessingTime = Integer.parseInt(view.getInputTexts(5).getText());
                maxProcessingTime = Integer.parseInt(view.getInputTexts(6).getText());
                view.EnableBack(false);
                SimulationManager sim = new SimulationManager(timeLimit,maxProcessingTime,minProcessingTime,maxArrivalTime,minArrivalTime,numberOfServers,numberOfClients,view);
                Thread t =  new Thread(sim);
                t.start();
            }catch (Throwable throwable){
                view.changePanels();
            }

        }else {
            view.changePanels();
        }
    }
}
