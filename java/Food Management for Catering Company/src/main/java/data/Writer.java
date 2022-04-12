package data;

import bll.models.MenuItem;
import bll.models.Order;
import bll.models.User;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;

public class Writer {
    public static void wirteBill(Order order)
    {
        Path path = Paths.get("src\\main\\resources\\bill.txt");
        try {
            FileWriter myWriter = new FileWriter(path.toAbsolutePath().toString());
            myWriter.write("ID: "+order.getId()+" \n");
            myWriter.write("Date: "+order.getDate()+"\n");
            myWriter.write("Price: "+order.getPrice());
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static void raport1(List<Order> orderList)
    {
        Path path = Paths.get("src\\main\\resources\\raport1.txt");
        try {
            FileWriter myWriter = new FileWriter(path.toAbsolutePath().toString());
            myWriter.write("");
            for(Order i:orderList)
            {
                myWriter.write("ID: "+i.getId()+"  Hour: "+i.getDate().getHours()+" Price: "+i.getPrice()+"\n");
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static void raport2(List<MenuItem> menuItemList)
    {

        Path path = Paths.get("src\\main\\resources\\raport2.txt");
        try {
            FileWriter myWriter = new FileWriter(path.toAbsolutePath().toString());
            myWriter.write("");
            for(MenuItem i:menuItemList)
            {
                myWriter.write("Title: "+i.getTitle() +" Rating: "+i.getRating()+" Price: "+i.getRating()+" ordered: "+i.getOrdered()+ "\n");
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
    public static void raport4(HashSet<MenuItem> menuItems)
    {
        Path path = Paths.get("src\\main\\resources\\raport4.txt");
        try {
            FileWriter myWriter = new FileWriter(path.toAbsolutePath().toString());
            myWriter.write("");
            for(MenuItem i : menuItems)
            {
                myWriter.write("Title: "+i.getTitle() +" Rating: "+i.getRating()+" Price: "+i.getRating()+" ordered: "+i.getOrdered()+ "\n");
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static void raport3(List<User> userList)
    {
        Path path = Paths.get("src\\main\\resources\\raport3.txt");
        try {
            FileWriter myWriter = new FileWriter(path.toAbsolutePath().toString());
            myWriter.write("");
            for(User i: userList)
            {
                myWriter.write("ID: "+i.getId()+" Username: "+i.getUsername()+" ordered: "+i.getOrderList().size()+"\n");
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
