package org.example;

import calculator_polinomial.GUI.Controller.Controller;
import calculator_polinomial.GUI.View.View;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        View view=new View();
        Controller controller=new Controller(view);
        view.setVisible(true);
    }

}
