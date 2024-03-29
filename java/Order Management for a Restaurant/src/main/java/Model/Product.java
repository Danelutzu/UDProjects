package Model;

public class Product {
    private int id;
    private String name;
    private int price;
    private int quantity;
    /**
     * Creeaza un obiect de tipul product
     * @param id id-ul produsului
     * @param name numele
     * @param price pretul
     * @param quantity cantitatea
     */
    public Product(int id, String name, int price, int quantity)
    {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    /**
     * Creeaza un obiect de tipul product
     * @param name numele
     * @param price pretul
     * @param quantity cantitatea
     */
    public Product( String name, int price, int quantity)
    {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    public Product(){
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String toString() {
    return "Product "+" id: "+id+" name: "+name+" price: "+price+" quantity: "+quantity;
    }
}
