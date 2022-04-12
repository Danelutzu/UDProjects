package Presentation;

import javax.swing.*;
import java.awt.event.ActionListener;

public class ViewProduct extends JFrame{

    public JTextField textFieldNameAddProduct;
    public JTextField textFieldPriceAddProduct;
    public JTextField textFieldQuantityAddProduct;
    public JTextField textFieldNameUpdateProduct;
    public JTextField textFieldPriceUpdateProduct;
    public JTextField textFieldQuantityUpdateProduct;
    public JTextField textFieldIdUpdateProduct;
    public JTextField textFieldIdDeleteProduct;
    public JTable tableProducts;
    public JButton btnAddProduct;
    public JButton btnUpdateProduct;
    public JButton btnDeleteProduct;
    final JScrollPane scrollPane_1;
    final JPanel panelProducts;

    public ViewProduct(){
        panelProducts = new JPanel();
        this.add(panelProducts);
        this.setSize(1000, 580);
        this.setVisible(true);
        panelProducts.setLayout(null);

        JLabel lblNameAdd = new JLabel("Name");
        lblNameAdd.setBounds(12, 12, 43, 15);
        panelProducts.add(lblNameAdd);

        JLabel lblPriceAdd = new JLabel("Price");
        lblPriceAdd.setBounds(169, 12, 43, 15);
        panelProducts.add(lblPriceAdd);

        JLabel lblQuantityAdd = new JLabel("Quantity");
        lblQuantityAdd.setBounds(295, 12, 70, 15);
        panelProducts.add(lblQuantityAdd);

        textFieldNameAddProduct = new JTextField();
        textFieldNameAddProduct.setBounds(12, 26, 114, 19);
        panelProducts.add(textFieldNameAddProduct);
        textFieldNameAddProduct.setColumns(10);

        textFieldPriceAddProduct = new JTextField();
        textFieldPriceAddProduct.setBounds(142, 26, 114, 19);
        panelProducts.add(textFieldPriceAddProduct);
        textFieldPriceAddProduct.setColumns(10);

        textFieldQuantityAddProduct = new JTextField();
        textFieldQuantityAddProduct.setBounds(276, 26, 114, 19);
        panelProducts.add(textFieldQuantityAddProduct);
        textFieldQuantityAddProduct.setColumns(10);

        btnAddProduct = new JButton("ADD PRODUCT");
        btnAddProduct.setBounds(458, 23, 140, 25);
        panelProducts.add(btnAddProduct);


        JLabel lblNameUpdate = new JLabel("Name");
        lblNameUpdate.setBounds(182, 70, 43, 15);
        panelProducts.add(lblNameUpdate);

        JLabel lblPriceUpdate = new JLabel("Price");
        lblPriceUpdate.setBounds(299, 70, 43, 15);
        panelProducts.add(lblPriceUpdate);

        JLabel lblQuantityUpdate = new JLabel("Quantity");
        lblQuantityUpdate.setBounds(425, 70, 70, 15);
        panelProducts.add(lblQuantityUpdate);

        textFieldNameUpdateProduct = new JTextField();
        textFieldNameUpdateProduct.setColumns(10);
        textFieldNameUpdateProduct.setBounds(142, 84, 114, 19);
        panelProducts.add(textFieldNameUpdateProduct);

        textFieldPriceUpdateProduct = new JTextField();
        textFieldPriceUpdateProduct.setColumns(10);
        textFieldPriceUpdateProduct.setBounds(272, 84, 114, 19);
        panelProducts.add(textFieldPriceUpdateProduct);

        textFieldQuantityUpdateProduct = new JTextField();
        textFieldQuantityUpdateProduct.setColumns(10);
        textFieldQuantityUpdateProduct.setBounds(406, 84, 114, 19);
        panelProducts.add(textFieldQuantityUpdateProduct);
        btnUpdateProduct = new JButton("UPDATE PRODUCT");
        btnUpdateProduct.setBounds(570, 81, 158, 25);
        panelProducts.add(btnUpdateProduct);

        JLabel lblIdUpdate = new JLabel("ID");
        lblIdUpdate.setBounds(66, 70, 26, 15);
        panelProducts.add(lblIdUpdate);

        textFieldIdUpdateProduct = new JTextField();
        textFieldIdUpdateProduct.setBounds(12, 84, 114, 19);
        panelProducts.add(textFieldIdUpdateProduct);
        textFieldIdUpdateProduct.setColumns(10);

        textFieldIdDeleteProduct = new JTextField();
        textFieldIdDeleteProduct.setColumns(10);
        textFieldIdDeleteProduct.setBounds(12, 140, 114, 19);
        panelProducts.add(textFieldIdDeleteProduct);

        JLabel lblIdDelete = new JLabel("ID");
        lblIdDelete.setBounds(66, 126, 26, 15);
        panelProducts.add(lblIdDelete);

        btnDeleteProduct = new JButton("DELETE PRODUCT");
        btnDeleteProduct.setBounds(168, 137, 158, 25);
        panelProducts.add(btnDeleteProduct);

        scrollPane_1 = new JScrollPane();
        scrollPane_1.setBounds(44, 218, 647, 311);
        panelProducts.add(scrollPane_1);

        tableProducts = new JTable();

        scrollPane_1.setViewportView(tableProducts);
    }
    public void addListener(ActionListener c)
    {

        btnAddProduct.addActionListener(c);
        btnUpdateProduct.addActionListener(c);
        btnDeleteProduct.addActionListener(c);

    }
}
