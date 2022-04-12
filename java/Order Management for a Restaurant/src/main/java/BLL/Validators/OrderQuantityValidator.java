package BLL.Validators;
import Model.Orders;
public class OrderQuantityValidator implements Validator<Orders>{
    /**
     * Verifica daca quantity ul cerut in comanda este disponibil in stoc
     * @param t comanda care se verifica
     */
    public void validate(Orders t){
        if(t.getQuantity()<=0){
            throw new IllegalArgumentException("Quantity can't be below 0");
        }
    }
}
