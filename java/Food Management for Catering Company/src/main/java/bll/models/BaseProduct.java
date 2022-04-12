package bll.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class BaseProduct implements MenuItem {
    private String title;
    private float rating;
    private int calories;
    private int proteins;
    private int fats;
    private int sodium;
    private int price;
    private int ordered = 0;

    public BaseProduct(String title, float rating, int calories, int proteins, int fats, int sodium, int price) {
        this.title = title.trim();
        this.rating = rating;
        this.calories = calories;
        this.proteins = proteins;
        this.fats = fats;
        this.sodium = sodium;
        this.price = price;
    }
    public void ord()
    {
        this.ordered ++;
    }
}
