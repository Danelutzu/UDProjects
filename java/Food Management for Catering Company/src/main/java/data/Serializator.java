package data;

import bll.models.DeliveryService;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Serializator {

    private static Path path = Paths.get("src\\main\\resources\\data.txt");

    public static void serializ(DeliveryService deliveryService)
    {
        try {
            FileOutputStream fileOut =
                    new FileOutputStream(path.toAbsolutePath().toString());
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(deliveryService);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
    public static DeliveryService deserializ()
    {
        DeliveryService deliveryService = null;

        try {
            FileInputStream fileIn = new FileInputStream(path.toAbsolutePath().toString());
            ObjectInputStream in = new ObjectInputStream(fileIn);
            deliveryService = (DeliveryService) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return null;
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
            return null;
        }

        return deliveryService;
    }
}
