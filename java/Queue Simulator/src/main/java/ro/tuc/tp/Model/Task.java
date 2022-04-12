package ro.tuc.tp.Model;

import java.util.concurrent.atomic.AtomicInteger;

public class Task implements Comparable<Task> {
    private int arrivalTime;
    private AtomicInteger processingTime;
    private int ID;

    public Task(int ID, int arrivalTime,AtomicInteger processingTime){
        this.processingTime=processingTime;
        this.ID=ID;
        this.arrivalTime=arrivalTime;
    }
    public int  getArrivalTime(){return arrivalTime;}
    public AtomicInteger getProcessingTime(){return processingTime;}

    public String toString(){return "("+ID +" ,"+arrivalTime+" ,"+processingTime+")";}

    @Override
    public int compareTo(Task t){
        return this.getArrivalTime()-t.getArrivalTime();
    }
    public void decrementProcessingTime(){
        processingTime.addAndGet(-1);
    }
    public void setProcessingTime(AtomicInteger processingTime){
        this.processingTime=processingTime;
    }
}
