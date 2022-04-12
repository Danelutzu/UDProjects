package bll.models;

import bll.utilities.Role;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class User implements Serializable {
    private static Long counter = 0l;
    private Long id;
    private String username;
    private String password;
    private Role role;
    private List<Order> orderList = new ArrayList<>();

    public User(String username, String password, Role role) {
        counter++;
        this.id = counter;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public void ord(Order order)
    {
        orderList.add(order);
    }

}
