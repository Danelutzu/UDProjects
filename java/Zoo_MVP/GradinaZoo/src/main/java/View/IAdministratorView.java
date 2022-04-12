package View;

import javax.swing.*;
import java.util.ArrayList;

public interface IAdministratorView {
    JPanel getMainPanel();
    void updateTable(ArrayList<Object[]> result, String[] header, JPanel mainPanel);
    String getName();
    String getID();
    String getRole();
    String getPassword();
    String getNameText();
    String getRoleText();
    String getPasswordText();
    String getIDText();
    //void setLabel(String text);
    void updateTableAnimale(ArrayList<Object[]> result, String[] header, JPanel mainPanel);
}
