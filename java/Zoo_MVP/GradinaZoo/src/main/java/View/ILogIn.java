package View;

import javax.swing.*;

public interface ILogIn {

    //public boolean LogIn(String username,String password);
    public String getUsername();
    public String getPassword();

    public JButton getLogInButton();
    public void setUsername(String username);
    public void setPassword(String password);
}
