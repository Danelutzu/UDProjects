package ro.tuc.tp.Model;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

public class Server implements Runnable{
    private BlockingQueue<Task> tasks;
    private AtomicInteger waitingPeriod;
    private AtomicInteger ID;
    private boolean start=true;

    public Server(int ID,int nrTasks){
        this.ID=new AtomicInteger(ID);
        this.tasks=new ArrayBlockingQueue<Task>(nrTasks);
        this.waitingPeriod=new AtomicInteger(0);
    }
    public AtomicInteger getID(){
        return ID;
    }
    public AtomicInteger getWaitingPeriod(){
        return waitingPeriod;
    }
    public void Start(boolean start){
        this.start=start;
    }

    public void run(){
        while(start){
            if(!tasks.isEmpty()){
                AtomicInteger processingTime=tasks.peek().getProcessingTime();
                try{
                    Thread.sleep(1000);
                    waitingPeriod.addAndGet(-1);
                    tasks.peek().decrementProcessingTime();
                    if(tasks.peek().getProcessingTime().get()==0){
                        tasks.take();
                    }
                }catch (Throwable e){
                    e.printStackTrace();
                }
            }
        }
    }
    public void addTask(Task t){
        tasks.add(t);
        waitingPeriod.addAndGet(t.getProcessingTime().get());
    }

    public BlockingQueue<Task> getTasks(){
        return tasks;
    }
    public int getNumberTasks(){
        return tasks.size();
    }
    @Override
    public String toString(){
        if(!tasks.isEmpty()){
            return "Server"+ ID+": "+tasks;
        }
        return "Server"+ID+": closed";
    }
    public Task getFirstTask(){
        return tasks.peek();
    }
    public void deleteFirstTask(){
        tasks.remove();
    }
}
