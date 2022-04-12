package bll.models;

import lombok.EqualsAndHashCode;

import java.io.Serializable;

public interface MenuItem extends Serializable {
    String getTitle();
    int getCalories();
    int getProteins();
    float getRating();
    int getFats();
    int getSodium();
    int getPrice();
    int getOrdered();

    void setTitle(String title);
    void setCalories(int calories);
    void setProteins(int proteins);
    void setFats(int fats);
    void setSodium(int sodium);
    void setPrice(int price);
    void ord();
    void setRating(float rating);
}
