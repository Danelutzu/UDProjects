package Model;

public class Orders {
    private int id;
    private int productid;
    private int clientid;
    private int quantity;
    private int price;

    /**
     * Constructorul clasei orders
     * @param id id-ul
     * @param productid id-ul produsului
     * @param clientid id-ul clientului
     * @param quantity cantitatea pe care dorim sa o comandam
     * @param price pretul price
     */
    public Orders(int id,  int productid,int clientid, int quantity, int price) {
        this.id = id;
        this.productid=productid;
        this.clientid=clientid;
        this.quantity=quantity;
        this.price=price;
    }
    /**
     * Constructorul clasei orders
     * @param productid id-ul produsului
     * @param clientid id-ul clientului
     * @param quantity cantitatea pe care dorim sa o comandam
     * @param price pretul price
     */
    public Orders(  int productid,int clientid, int quantity, int price) {
        this.productid=productid;
        this.clientid=clientid;
        this.quantity=quantity;
        this.price=price;
    }
    public Orders(){
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public int getClientid(){
        return clientid;
    }
    public void setClientid(int id){
        clientid=id;
    }
    public int getProductid(){
        return productid;
    }
    public void setProductid(int id){
        productid=id;
    }
    public int getQuantity(){
        return quantity;
    }
    public void setQuantity(int id){
        quantity=id;
    }
    public int getPrice(){
        return price;
    }
    public void setPrice(int id){
        price=id;
    }

    public String toString(){
        return "Order "+"id: "+id+" clientid: "+clientid+" productid: "+productid+" quantity: "+quantity+" price "+price;
    }
}
