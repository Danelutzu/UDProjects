package View;

import javax.swing.*;
import java.util.ArrayList;

public interface IAngajatView {
     void updateTable(ArrayList<Object[]> result, String[] header, JPanel mainPanel);
     JPanel getMainPanel();
     String getNume();
     String getSpecie();
     String getAlimentatie();
     String getHabitat();
}
