package bll.models;

import ui.GUI5;

import java.io.Serializable;

public interface IDeliveryService extends Serializable {
    void importFromCSV();

    /**
     *aceasta metoda este folosita pentru logarea unui user deja existent
     * @Pre username != null and password != null
     * @param username este username-ul
     * @param password este parola
//     * @return
     */
    User logIn(String username,String password);

    /**
     * aceasta metoda este folosita pentru inregistrarea userilor
     * @Pre user != null
     * @param user user-ul
     */
    void signUp(User user);

    /**
     * adauga un produs
     * @Pre menuItem != null
     * @param menuItem
     */
    void addProduct(MenuItem menuItem);

    /**
     * returneaza un obiect de tip menuItem
     * @Pre title != null
     * @param title
     * @return
     */
    MenuItem getProduct(String title);

    /**
     * sterge un produs dupa nume
     * @Pre title != null
     * @param title numele produsului
     */
    void deleteProduct(String title);

    /**
     * se editeaza un produs
     * @Pre title != null
     * @Pre newTitle != null
     * @Pre newRating >= 0
     * @Pre newCalories >= 0
     * @Pre newProtein >= 0
     * @Pre newFat >= 0
     * @Pre newSodium >= 0
     * @Pre newPrice >= 0
     * @param title numele initial
     * @param newTitle noul nume
     * @param newRating rating
     * @param newCalories calorii
     * @param newProtein proteine
     * @param newFat grasimi
     * @param newSodium sodiu
     * @param newPrice pret
     */
    void editProduct(String title,String newTitle,float newRating,int newCalories,int newProtein,int newFat,int newSodium,int newPrice);

    /**
     * se adauga o comanda
     * @Pre order != null
     * @param order comanda
     */
    void addOrder(Order order);

    /**
     * se cauta un produs
     * @Pre title != null
     * @Pre rating >= 0
     * @Pre calories >= 0
     * @Pre proteins >= 0
     * @Pre fats >= 0
     * @Pre sodium >= 0
     * @Pre price >= 0
     * @param title titlu
     * @param rating rating
     * @param calories calorii
     * @param proteins proteine
     * @param fats grasimi
     * @param sodium sodiu
     * @param price pret
     * @return
     */
    MenuItem searchProduct(String title,float rating,int calories,int proteins,int fats,int sodium,int price);

    /**
     * @Post gui5 != null
     * @return
     */
    GUI5 showAll();

    /**
     * @Pre start>=0 and end>=0
     * @param start
     * @param end
     */
    void raport1(int start,int end);

    /**
     * @Pre nr>=0
     * @param nr
     */
    void raport2(int nr);

    /**
     * @Pre day>=0
     * @param day ziua
     */
    void raport4(int day);

    /**
     * @Pre times>=0 and value>0
     * @param times de cate ori
     * @param value valoarea
     */
    void raport3(int times,int value);
}
