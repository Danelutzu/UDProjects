import bll.Controller;
import bll.models.DeliveryService;
import data.Serializator;
import ui.GUI1;

public class Start {
    public static void main(String[] args) {
        GUI1 gui1 = new GUI1();
        DeliveryService deliveryService = Serializator.deserializ();

        if(deliveryService == null)
        {
            deliveryService = new DeliveryService();
        }

        Controller controller = new Controller(deliveryService,gui1);
        Thread controllerThread = new Thread(controller);
        controllerThread.start();
    }
}
