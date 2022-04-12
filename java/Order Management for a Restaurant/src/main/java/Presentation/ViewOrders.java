package Presentation;

import BLL.ClientBLL;
import BLL.OrderBLL;
import BLL.ProductBLL;
import DAO.AbstractDAO;
import DAO.ClientDAO;
import DAO.OrderDAO;
import DAO.ProductDAO;
import Model.Client;
import Model.Orders;
import Model.Product;
import Generate.Bill;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ViewOrders extends JFrame {

    public JTextField textFieldIdClientOrder;
    public JTextField textFieldIdProductOrder;
    public JTextField textFieldQuantityOrder;
    public JButton btnCreateOrder;
    final JScrollPane scrollPane_1_1;
    final JPanel panelOrders;

    public JTable tableOrders;

    public ViewOrders() {
        final JPanel panel = new JPanel();

        panelOrders = new JPanel();
        this.add(panelOrders);
        this.setVisible(true);
        this.setSize(1000, 580);
        panelOrders.setLayout(null);

        JLabel lblIdProdus = new JLabel("ID PRODUS");
        lblIdProdus.setBounds(224, 27, 88, 15);
        panelOrders.add(lblIdProdus);

        JLabel lblIdClient = new JLabel("ID CLIENT");
        lblIdClient.setBounds(70, 27, 70, 15);
        panelOrders.add(lblIdClient);

        JLabel lblQuantity = new JLabel("QUANTITY");
        lblQuantity.setBounds(385, 27, 70, 15);
        panelOrders.add(lblQuantity);

        textFieldIdClientOrder = new JTextField();
        textFieldIdClientOrder.setBounds(51, 41, 114, 19);
        panelOrders.add(textFieldIdClientOrder);
        textFieldIdClientOrder.setColumns(10);

        textFieldIdProductOrder = new JTextField();
        textFieldIdProductOrder.setBounds(204, 41, 114, 19);
        panelOrders.add(textFieldIdProductOrder);
        textFieldIdProductOrder.setColumns(10);

        textFieldQuantityOrder = new JTextField();
        textFieldQuantityOrder.setBounds(360, 41, 114, 19);
        panelOrders.add(textFieldQuantityOrder);
        textFieldQuantityOrder.setColumns(10);

        btnCreateOrder = new JButton("CREATE ORDER");
        btnCreateOrder.setBounds(197, 72, 136, 51);
        panelOrders.add(btnCreateOrder);

        scrollPane_1_1 = new JScrollPane();
        scrollPane_1_1.setBounds(44, 191, 647, 322);
        panelOrders.add(scrollPane_1_1);

        tableOrders = new JTable();

        scrollPane_1_1.setViewportView(tableOrders);

    }

    public void addListener(ActionListener c) {
        btnCreateOrder.addActionListener(c);

    }

}
