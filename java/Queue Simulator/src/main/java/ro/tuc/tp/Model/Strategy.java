package ro.tuc.tp.Model;

import java.util.List;

public interface Strategy {
    void addTask(List<Server> servers, Task t);
}
