package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;

public interface IVizitatorView {
     void setTable(ArrayList<Object[]> result, String[] header, JPanel panel);
    JPanel getPanel();
    void setPassword(String password);
    void setUsername(String username);
    String getPassword();
    String getUsername();
    }

