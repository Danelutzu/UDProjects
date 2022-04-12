package ro.tuc.tp.Model;

import java.util.List;

public class ConcreteStrategyTime implements Strategy{
    @Override
    public void addTask(List<Server> servers, Task t){
        //TO DO auto-generated method stub
        int min=Integer.MAX_VALUE;
        int id=0;
        for(Server s:servers){
            if(s.getWaitingPeriod().get()<min){
                min=s.getWaitingPeriod().get();
                id=s.getID().get();
            }
        }
        for(Server s:servers){
            if(s.getID().get()==id){
                s.addTask(t);
            }
        }
    }
}
