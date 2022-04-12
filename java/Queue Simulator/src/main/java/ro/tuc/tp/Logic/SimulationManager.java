package ro.tuc.tp.Logic;

import ro.tuc.tp.GUI.View.View;
import ro.tuc.tp.Model.*;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class SimulationManager implements Runnable{
    //data read from UI
    public  int timeLimit;//maximum processing time-read from UI
    public  int maxProcessingTime;
    public  int minProcessingTime;
    public  int minArrivalTime;
    public  int maxArrivalTime;
    public  int numberOfServers;
    public  int numberOfTasks;
    public SelectionPolicy selectionPolicy=SelectionPolicy.SHORTEST_TIME;
    private View view;
    //entity responsible with queue mannagement and client distribution
    private Scheduler scheduler;
    //pool of tasks(client shopping in the store)
    private List<Task> generatedTasks;

    public SimulationManager(int timeLimit,int maxProcessingTime,int minProcessingTime,int maxArrivalTime,int minArrivalTime,int numberOfServers,int numberOfTasks,View view){
        this.timeLimit=timeLimit;
        this.maxArrivalTime=maxArrivalTime;
        this.numberOfTasks=numberOfTasks;
        this.maxProcessingTime=maxProcessingTime;
        this.minArrivalTime=minArrivalTime;
        this.minProcessingTime=minProcessingTime;
        this.numberOfServers=numberOfServers;
        this.view=view;
        scheduler=new Scheduler(numberOfServers,numberOfTasks);
        generateNRandomTasks();
    }
    @Override
    public void run(){
        StringBuilder result;
        int currentTime=0;
        int waitMax=0;
        int processingTime=0;
        int waitingTime=0;
        int peak=0;

        Iterator<Task> i=generatedTasks.iterator();
        Task task=i.next();
        String toWrite="";
        while(timeLimit>currentTime) {
            //daca se depaseste limita de timp, simularea se opreste
            while (currentTime == task.getArrivalTime()) {
                //daca se termina task urile , se opreste simularea
                processingTime = processingTime + task.getProcessingTime().get();
                scheduler.dispatchTask(task);
                if (i.hasNext()) {
                    task = i.next();
                } else
                    break;
            }

            waitingTime = waitingTime + scheduler.totalWaitingTime();
            if (scheduler.totalWaitingTime() > waitMax) {
                peak = currentTime;
                waitMax = scheduler.totalWaitingTime();
            }
            String stringCurrentTime = "Time" + currentTime;
            String stringWaitingTasks = "Waiting tasks: ";
            stringWaitingTasks += waitingTasks(task, currentTime);
            String stringServer = scheduler.showServers();
            view.setOutput(stringCurrentTime + "\n" + stringWaitingTasks + "\n" + stringServer);
            toWrite += stringCurrentTime + "\n" + stringWaitingTasks + "\n" + stringServer + "\n";
            currentTime++;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (scheduler.isEmpty() && task.getProcessingTime().get() == 0) {
                break;
            }
        }
        scheduler.destroyServers();
        toWrite+="Avg Processing Time: "+((float)processingTime)/numberOfServers/generatedTasks.indexOf(task)+"\n";
        toWrite+="Avg Wait Time: "+((float)waitingTime)/numberOfServers/timeLimit+"\n";
        toWrite+="Peak Time: "+peak+"\n";
        WriteToFile.write("result.txt",toWrite);
        view.EnableBack(true);
    }
    public String waitingTasks(Task task,int currentTime){
        String result="";
        int index=generatedTasks.indexOf(task);
        int j;
        for(j=index;j<generatedTasks.size();j++){
            if(!(currentTime>= task.getArrivalTime() && index==generatedTasks.size()-1))
                result+=generatedTasks.get(j)+" ";
        }
        return result;
    }
    public void generateNRandomTasks() {
        Random r = new Random();
        generatedTasks=new ArrayList<Task>(numberOfTasks);
        int i;
        for (i = 1; i <= numberOfTasks; i++) {
            Task task=new Task(i,r.nextInt(maxArrivalTime-minArrivalTime)+minArrivalTime,new AtomicInteger(r.nextInt(maxProcessingTime-minProcessingTime)+minProcessingTime));
            generatedTasks.add(task);
        }
        Collections.sort(generatedTasks);
    }
    public static void main(String[] args){
        View view=new View();
    }
}
