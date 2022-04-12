package bll.models;

import bll.utilities.ExistingUserException;
import bll.utilities.MenuItemNotFound;
import data.Writer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ui.GUI5;

import javax.swing.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@NoArgsConstructor
@Setter
@Getter
public class DeliveryService implements IDeliveryService{
    private HashSet<User> users = new HashSet<>();
    private HashSet<MenuItem> menuItems = new HashSet<>();
    private HashSet<Order> orders = new HashSet<>();


    public boolean invariant()
    {
        return menuItems != null;
    }

    public void importFromCSV()
    {
        Path path = Paths.get("src\\main\\resources\\products.csv");
        try (Stream<String> lines = Files.lines(path.toAbsolutePath()).skip(1)) {
            List<List<String>> values = lines.map(line -> Arrays.asList(line.split(","))).collect(Collectors.toList());
            for (List<String> value : values) {
                menuItems.add(new BaseProduct(value.get(0), Float.parseFloat(value.get(1)), Integer.parseInt(value.get(2)), Integer.parseInt(value.get(3)),
                        Integer.parseInt(value.get(4)), Integer.parseInt(value.get(5)), Integer.parseInt(value.get(6))));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public User logIn(String username,String password)
    {
        assert username != null && password != null;

        for(User i:users)
        {
            if(i.getUsername().equals(username))
            {
                if(i.getPassword().equals(password))
                {
                    return i;
                }
            }
        }
        return null;
    }
    public void signUp(User user)
    {
        assert user != null;

        User user1 = users.stream()
                .filter(userr ->userr.getUsername().equals(user.getUsername()))
                .findAny()
                .orElse(null);

        if(user1 != null)
        {
            throw new ExistingUserException("There is another user with that username");
        }
        else
        {
            users.add(user);
        }
    }
    public void addProduct(MenuItem menuItem)
    {
        assert menuItem != null;

        menuItems.add(menuItem);
    }
    public MenuItem getProduct(String title)
    {
        assert title!= null;

        MenuItem menuItem = menuItems.stream()
                .filter(product->product.getTitle().equals(title))
                .findAny()
                .orElse(null);

        if(menuItem == null)
        {
            throw new MenuItemNotFound("There is not a product with that title");
        }
        else
        {
            return menuItem;
        }
    }
    public void deleteProduct(String title)
    {
        assert title != null;

        MenuItem product = menuItems.stream()
                .filter(prod->prod.getTitle().equals(title))
                .findAny()
                .orElse(null);

        if(product != null)
        {
            menuItems.removeIf(i -> i.getTitle().equals(product.getTitle()));
        }
        else
        {
            throw new MenuItemNotFound("There is not a product with that title");
        }
    }
    public void editProduct(String title,String newTitle,float newRating,int newCalories,int newProtein,int newFat,int newSodium,int newPrice)
    {
        assert title != null;
        assert newTitle != null;
        assert newCalories >= 0;
        assert newProtein >= 0;
        assert newFat >= 0;
        assert newSodium >= 0;
        assert newPrice >= 0;

        MenuItem product = menuItems.stream()
                .filter(prod->prod.getTitle().equals(title))
                .findAny()
                .orElse(null);

        if(product != null)
        {
            product.setTitle(newTitle);
            product.setRating(newRating);
            product.setCalories(newCalories);
            product.setProteins(newProtein);
            product.setFats(newFat);
            product.setSodium(newSodium);
            product.setPrice(newPrice);
        }
        else
        {
            throw new MenuItemNotFound("There is not a product with that title");
        }
    }
    public void addOrder(Order order)
    {
        assert order != null;

        orders.add(order);
        Writer.wirteBill(order);
    }
    public MenuItem searchProduct(String title,float rating,int calories,int proteins,int fats,int sodium,int price)
    {
        assert title != null;
        assert rating >= 0;
        assert calories >= 0;
        assert proteins >= 0;
        assert fats >= 0;
        assert sodium >= 0;
        assert price >= 0;

        return menuItems.stream()
                .filter(product->product.getTitle().equals(title))
                .filter(product->product.getRating() == rating)
                .filter(product->product.getCalories() == calories)
                .filter(product->product.getProteins() == proteins)
                .filter(product->product.getFats() == fats)
                .filter(product->product.getSodium() == sodium)
                .filter(product->product.getPrice() == price)
                .findAny()
                .orElse(null);
    }
    public GUI5 showAll()
    {
        String[] top = {"Title","Rating","Calories","Proteins","Fats","Sodium","Price"};
        Object[][] content = new Object[menuItems.size()][top.length];

        int i=0;
        for(MenuItem j:menuItems)
        {
            content[i][0] = j.getTitle();
            content[i][1] = j.getRating();
            content[i][2] = j.getCalories();
            content[i][3] = j.getProteins();
            content[i][4] = j.getFats();
            content[i][5] = j.getSodium();
            content[i][6] = j.getPrice();

            i++;
        }

        GUI5 gui5 = new GUI5(new JTable(content,top));
        assert gui5 != null;

        return gui5;
    }
    public void raport1(int start,int end)
    {
        assert start>=0 && end>=0;

        List<Order> list = orders.stream()
                .filter(order-> order.getDate().getHours()>=start && order.getDate().getHours()<end)
                .collect(Collectors.toList());

        Writer.raport1(list);
    }
    public void raport2(int nr)
    {
        assert nr>=0;

        List<MenuItem> list = menuItems.stream()
                .filter(product->product.getOrdered() > nr)
                .collect(Collectors.toList());

        Writer.raport2(list);
    }
    public void raport4(int day)
    {
        assert day>=0;

        List<Order> list = orders.stream()
                .filter(order->order.getDate().getDay() == day)
                .collect(Collectors.toList());

        HashSet<MenuItem> menuItems = new HashSet<>();

        for(Order i : list)
        {
            menuItems.addAll(i.getMenuItems());
        }

        Writer.raport4(menuItems);
    }
    public int utilRap3(List<Order> list,int value)
    {
        int nr = 0;
        for(Order i: list)
        {
            if(i.getPrice() > value)
            {
                nr++;
            }
        }
        return nr;
    }

    public void raport3(int times,int value)
    {
        assert times>=0 && value>=0;

        List<User> list = users.stream()
                .filter(user->this.utilRap3(user.getOrderList(),value) > times)
                .collect(Collectors.toList());

        Writer.raport3(list);
    }

}
