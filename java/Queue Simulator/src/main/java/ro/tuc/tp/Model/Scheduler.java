package ro.tuc.tp.Model;

import java.util.ArrayList;
import java.util.List;

public class Scheduler {
    private List<Server> servers;
    private int maxNoServers;
    private int maxTasksPerServer;
    private Strategy strategy;
    private ArrayList<Thread> threads;
    int i;

    public Scheduler(int maxNoServers,int maxTasksPerServer){
        this.maxNoServers=maxNoServers;
        this.maxTasksPerServer=maxTasksPerServer;
        this.threads=new ArrayList<>(maxNoServers);
        this.servers=new ArrayList<Server>(maxNoServers);
        this.strategy=new ConcreteStrategyTime();
        for(i=0;i<maxNoServers;i++){
            servers.add(new Server(i,maxTasksPerServer));
            threads.add(new Thread(servers.get(i)));
            threads.get(i).start();
        }
    }
    public void changeStrategy(SelectionPolicy policy){
        //apply strategy pattern to instantiate the strategy with the concrete strategy corresponding to policy
        if(policy==SelectionPolicy.SHORTEST_QUEUE){
            strategy=new ConcreteStrategyQueue();
        }
        if(policy==SelectionPolicy.SHORTEST_TIME){
            strategy=new ConcreteStrategyTime();
        }
    }
    public void dispatchTask(Task t){
        strategy.addTask(servers,t);
    }

    public List<Server> getServers(){
        return servers;
    }

    public String showServers(){
        String s="";
        for(Server server:servers){
            s+=server+"\n";
        }
        return s;
    }
    public int totalWaitingTime(){
        int total=0;
        for(Server s:servers){
            total+=s.getWaitingPeriod().get();
        }
        return total;
    }
    public boolean isEmpty(){
        for(Server s:servers){
            if(!s.getTasks().isEmpty())
                return false;
        }
        return true;
    }
    public void destroyServers(){
        for(Server s:servers){
            s.Start(false);
        }
    }
}
