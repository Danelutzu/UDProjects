package bll.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class CompositeProduct implements MenuItem{

    private String title;
    private float rating;
    private int calories;
    private int proteins;
    private int fats;
    private int sodium;
    private int price;
    private List<MenuItem> baseProducts;
    private int ordered = 0;

    public CompositeProduct(String title, List<MenuItem> baseProducts) {
        this.title = title;
        this.baseProducts = new ArrayList<>(baseProducts);
        this.baseProducts.stream()
                .forEach(product-> {
                    this.rating+=product.getRating();
                    this.calories+=product.getCalories();
                    this.proteins+=product.getProteins();
                    this.fats+=product.getFats();
                    this.sodium+=product.getSodium();
                    this.price+=product.getPrice();
                });
        this.rating /= this.baseProducts.size();
    }

    public void ord()
    {
        this.ordered ++;
    }
}
