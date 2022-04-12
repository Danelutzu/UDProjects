package BLL;

import BLL.Validators.OrderQuantityValidator;
import DAO.OrderDAO;
import Model.Orders;
import BLL.Validators.Validator;

import java.util.ArrayList;
import java.util.List;

/**
 * Clasa corespunzatoare validarii informatiilor introduse si transmiterea lor catre baza de date
 */
public class OrderBLL {

    private List<Validator<Orders>> validator;
    private OrderDAO orderDAO;
    /**
     * Constructorul clasei unde se initializeaza validatoarele si ordersDAO
     */
    public OrderBLL() {
        validator =new ArrayList<Validator<Orders>>();
        validator.add(new OrderQuantityValidator());
        orderDAO=new OrderDAO();
    }
    /**
     * Insereaza in tabelul order
     * @param o comanda care trebuie inserata
     * @return Insert pentru order
     */
    public Orders insert(Orders o) {
        try {
            validator.get(0).validate(o);
            return orderDAO.insert(o);
        }
        catch(Exception e) {
            return null;
        }
    }

}

