package bll.models;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
public class Order implements Serializable {
    private static Long counter = 0l;
    private Long id;
    private int price;
    private Date date;
    private List<MenuItem> menuItems;

    public Order(List<MenuItem> menuItems) {
        counter ++;
        this.id = counter;
        this.price = price;
        this.date = new Date();
        this.menuItems = new ArrayList<>(menuItems);
        this.menuItems.stream()
                .forEach(product->{
                    this.price += product.getPrice();
                });
    }
}
