package Presentation;

import BLL.ClientBLL;
import BLL.OrderBLL;
import BLL.ProductBLL;
import DAO.ClientDAO;
import DAO.OrderDAO;
import DAO.ProductDAO;
import Generate.Bill;
import Model.Client;
import Model.Orders;
import Model.Product;
import Presentation.ViewClient;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    ViewProduct viewProduct;
    ViewOrders viewOrders;
    ViewClient viewClient;
    Listener listener=new Listener();
    public Controller() {
        this.viewClient = new ViewClient();
        this.viewClient.setVisible(true);
        this.viewOrders = new ViewOrders();
        this.viewOrders.setVisible(true);
        this.viewProduct = new ViewProduct();
        this.viewProduct.setVisible(true);
        this.viewClient.addListener(listener);
        this.viewProduct.addListener(listener);
        this.viewOrders.addListener(listener);

        DefaultTableModel model1 = (DefaultTableModel) viewClient.tableClients.getModel();
        model1.setRowCount(0);
        try {
            tabelC();
            viewClient.scrollPane.setViewportView(viewClient.tableClients);
            viewClient.panelClients.add(viewClient.scrollPane);
            viewClient.setVisible(true);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        viewProduct.panelProducts.setVisible(true);
        DefaultTableModel model2 = (DefaultTableModel) viewProduct.tableProducts.getModel();
        model2.setRowCount(0);
        try {
            tabelP();
            viewProduct.scrollPane_1.setViewportView(viewProduct.tableProducts);
            viewProduct.panelProducts.add(viewProduct.scrollPane_1);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        viewOrders.panelOrders.setVisible(true);
        DefaultTableModel model3 = (DefaultTableModel) viewOrders.tableOrders.getModel();
        model3.setRowCount(0);
        try {
            tabelO();
            viewOrders.scrollPane_1_1.setViewportView(viewOrders.tableOrders);
            viewOrders.panelOrders.add(viewOrders.scrollPane_1_1);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }


    public void tabelC() throws IllegalAccessException {

        ClientDAO cDAO = new ClientDAO();
        List<Client> cList = cDAO.findAll();
        viewClient.tableClients = cDAO.createTable(cList);
    }

    public void tabelP() throws IllegalAccessException {
        ProductDAO pDAO = new ProductDAO();
        List<Product> pList = pDAO.findAll();
        viewProduct.tableProducts = pDAO.createTable(pList);
    }
    public void tabelO() throws IllegalAccessException {
        OrderDAO oDAO = new OrderDAO();
        List<Orders> oList = oDAO.findAll();
        viewOrders.tableOrders = oDAO.createTable(oList);
    }


    class Listener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == viewClient.btnAddClient) {
                System.out.println("a intrat");
                Client c = new Client(viewClient.textFieldNameClient.getText(), viewClient.textFieldEmailClient.getText(), Integer.parseInt(viewClient.textFieldAgeClient.getText()));
                ClientBLL cBLL = new ClientBLL();
                cBLL.insertClient(c);
                DefaultTableModel model = (DefaultTableModel) viewClient.tableClients.getModel();
                model.setRowCount(0);
                try {
                    tabelC();
                    viewClient.scrollPane.setViewportView(viewClient.tableClients);
                    viewClient.panelClients.add(viewClient.scrollPane);
                } catch (IllegalAccessException ex) {
                    ex.printStackTrace();
                }
            }
            if (e.getSource() == viewClient.btnUpdateClient) {
                ClientBLL cBLL = new ClientBLL();
                ClientDAO cDAO = new ClientDAO();
                ArrayList<Client> list = cDAO.clientList();
                int id = Integer.parseInt(viewClient.textFieldIdUpdate.getText());
                int row = 0;
                int verif = 0;
                for (Client client : list) {
                    if (client.getId() == id) {
                        try {
                            verif = 1;
                            Field idF = client.getClass().getDeclaredField("id");
                            Field nameF = client.getClass().getDeclaredField("name");
                            Field emailF = client.getClass().getDeclaredField("email");
                            Field ageF = client.getClass().getDeclaredField("age");
                            idF.setAccessible(true);
                            nameF.setAccessible(true);
                            emailF.setAccessible(true);
                            ageF.setAccessible(true);
                            nameF.set(client, viewClient.textFieldNameUpdate.getText());
                            emailF.set(client, viewClient.textFieldEmailUpdate.getText());
                            ageF.set(client, Integer.parseInt(viewClient.textFieldAgeUpdate.getText()));
                        } catch (NoSuchFieldException | IllegalAccessException ex) {
                            ex.printStackTrace();
                        }
                    } else {
                        ++row;
                    }
                    cBLL.update(client);
                    if (verif == 1) {
                        DefaultTableModel model = (DefaultTableModel) viewClient.tableClients.getModel();
                        model.setRowCount(0);
                        try {
                            tabelC();
                            viewClient.scrollPane.setViewportView(viewClient.tableClients);
                            viewClient.panelClients.add(viewClient.scrollPane);
                        } catch (IllegalAccessException ex) {
                            ex.printStackTrace();
                        }

                        break;
                    }
                    verif = 0;
                }
            }
            if (e.getSource() == viewClient.btnDeleteClient) {
                ClientBLL cBLL = new ClientBLL();
                ClientDAO cDAO = new ClientDAO();
                ArrayList<Client> list = cDAO.clientList();
                int id = Integer.parseInt(viewClient.textFieldIdDelete.getText());
                int row = 0;
                int verif = 0;
                for (Client client : list) {
                    if (client.getId() == id) {
                        cBLL.delete(id);
                        verif = 1;
                    } else {
                        ++row;
                    }
                }
                if (verif == 1) {
                    DefaultTableModel model = (DefaultTableModel) viewClient.tableClients.getModel();
                    model.setRowCount(0);
                    try {
                        tabelC();
                        viewClient.scrollPane.setViewportView(viewClient.tableClients);
                        viewClient.panelClients.add(viewClient.scrollPane);
                    } catch (IllegalAccessException ex) {
                        ex.printStackTrace();
                    }
                } else {
                    System.out.println("Nu exista client cu id-ul:" + id);
                }
            }

            if (e.getSource() == viewProduct.btnAddProduct) {
                Product p = new Product(viewProduct.textFieldNameAddProduct.getText(),Integer.parseInt(viewProduct.textFieldPriceAddProduct.getText()),Integer.parseInt(viewProduct.textFieldQuantityAddProduct.getText()));
                ProductBLL cBLL = new ProductBLL();
                cBLL.insert(p);
                DefaultTableModel model = (DefaultTableModel) viewProduct.tableProducts.getModel();
                model.setRowCount(0);
                try {
                    tabelP();
                    viewProduct.scrollPane_1.setViewportView(viewProduct.tableProducts);
                    viewProduct.panelProducts.add(viewProduct.scrollPane_1);
                } catch (IllegalAccessException ex) {
                    ex.printStackTrace();
                }
            }
            if (e.getSource() == viewProduct.btnUpdateProduct) {
                ProductBLL pBLL = new ProductBLL();
                ProductDAO pDAO = new ProductDAO();
                ArrayList<Product> list = pDAO.productList();
                int id = Integer.parseInt(viewProduct.textFieldIdUpdateProduct.getText());
                int row = 0;
                int verif = 0;
                for (Product product : list) {
                    if (product.getId() == id) {
                        try {
                            verif = 1;
                            Field idF = product.getClass().getDeclaredField("id");
                            Field nameF = product.getClass().getDeclaredField("name");
                            Field priceF = product.getClass().getDeclaredField("price");
                            Field quantityF = product.getClass().getDeclaredField("quantity");
                            idF.setAccessible(true);
                            nameF.setAccessible(true);
                            priceF.setAccessible(true);
                            quantityF.setAccessible(true);
                            nameF.set(product, viewProduct.textFieldNameUpdateProduct.getText());
                            priceF.set(product, Integer.parseInt(viewProduct.textFieldPriceUpdateProduct.getText()));
                            quantityF.set(product, Integer.parseInt(viewProduct.textFieldQuantityUpdateProduct.getText()));
                        } catch (NoSuchFieldException | IllegalAccessException ex) {
                            ex.printStackTrace();
                        }
                    } else {
                        ++row;
                    }
                    pBLL.update(product);
                    if (verif == 1) {
                        DefaultTableModel model = (DefaultTableModel) viewProduct.tableProducts.getModel();
                        model.setRowCount(0);
                        try {
                            tabelP();
                            viewProduct.scrollPane_1.setViewportView(viewProduct.tableProducts);
                            viewProduct.panelProducts.add(viewProduct.scrollPane_1);
                        } catch (IllegalAccessException ex) {
                            ex.printStackTrace();
                        }
                        break;
                    }
                    verif = 0;
                }
            }
            if (e.getSource() == viewProduct.btnDeleteProduct) {
                ProductBLL pBLL = new ProductBLL();
                ProductDAO pDAO = new ProductDAO();
                ArrayList<Product> list = pDAO.productList();
                int id = Integer.parseInt(viewProduct.textFieldIdDeleteProduct.getText());
                int row = 0;
                int verif = 0;
                for (Product product : list) {
                    if (product.getId() == id) {
                        pBLL.delete(id);
                        verif = 1;
                    }
                    else{++row;}

                }
                if(verif == 1) {
                    DefaultTableModel model = (DefaultTableModel) viewProduct.tableProducts.getModel();
                    model.setRowCount(0);
                    try {
                        tabelP();
                        viewProduct. scrollPane_1.setViewportView(viewProduct.tableProducts);
                        viewProduct.panelProducts.add(viewProduct.scrollPane_1);
                    } catch (IllegalAccessException ex) {
                        ex.printStackTrace();
                    }
                }else{System.out.println("Nu exista produs cu id-ul:" + id);}
            }
            if(e.getSource()==viewOrders.btnCreateOrder)
            {
                int idClient = Integer.parseInt(viewOrders.textFieldIdClientOrder.getText());
                int idProduct = Integer.parseInt(viewOrders.textFieldIdProductOrder.getText());
                int quantity = Integer.parseInt(viewOrders.textFieldQuantityOrder.getText());
                OrderBLL oBLL = new OrderBLL();
                ProductBLL pBLL = new ProductBLL();
                ProductDAO pDAO = new ProductDAO();
                ClientBLL cBLL = new ClientBLL();
                ClientDAO cDAO = new ClientDAO();
                ArrayList<Product> listProducts = pDAO.productList();
                ArrayList<Client> listClients = cDAO.clientList();
                int verif = 0;
                int price = 0;
                Client c_aux = null;
                Product p_aux = null;
                for(Product p : listProducts){
                    if(p.getId() == idProduct){
                        if(p.getQuantity() >= quantity){
                            Field quantityF = null;
                            try {
                                p_aux = p;
                                quantityF = p.getClass().getDeclaredField("quantity");
                                quantityF.setAccessible(true);
                                quantityF.set(p, (int)quantityF.get(p) - quantity);
                                pBLL.update(p);
                            } catch (NoSuchFieldException | IllegalAccessException ex) {
                                ex.printStackTrace();
                            }
                            price = quantity * p.getPrice();
                            for(Client c : listClients){
                                if (c.getId() == idClient) {
                                    c_aux = c;
                                    verif = 1;
                                    break;
                                }
                            }
                        }else {System.out.println("Cantitate insuficenta!"); break;}
                    }
                    if(verif == 1){
                        Orders o = new Orders(Integer.parseInt(viewOrders.textFieldIdProductOrder.getText()),Integer.parseInt(viewOrders.textFieldIdClientOrder.getText()),Integer.parseInt(viewOrders.textFieldQuantityOrder.getText()),price);
                        oBLL.insert(o);
                        DefaultTableModel model = (DefaultTableModel) viewOrders.tableOrders.getModel();
                        model.setRowCount(0);
                        try {
                            tabelO();
                            viewOrders.scrollPane_1_1.setViewportView(viewOrders.tableOrders);
                            viewOrders.panelOrders.add(viewOrders.scrollPane_1_1);
                        } catch (IllegalAccessException ex) {
                            ex.printStackTrace();
                        }
                        try {
                            new Bill((int)viewOrders.tableOrders.getValueAt((viewOrders.tableOrders.getRowCount()-1), 0)+1,c_aux,p_aux,quantity,price);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                        break;
                    }
                }
            }


        }
    }


}
