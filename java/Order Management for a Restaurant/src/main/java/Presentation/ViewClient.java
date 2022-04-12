package Presentation;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class ViewClient extends JFrame {

    public JTextField textFieldNameClient;
    public JTextField textFieldEmailClient;
    public JTextField textFieldAgeClient;
    public JTextField textFieldNameUpdate;
    public JTextField textFieldEmailUpdate;
    public JTextField textFieldAgeUpdate;
    public JTextField textFieldIdUpdate;
    public JTextField textFieldIdDelete;
    public JTable tableClients;
    final JScrollPane scrollPane;
    final JPanel panelClients;

    public JButton btnAddClient =  new JButton("ADD CLIENT");
    public JButton btnUpdateClient = new JButton("UPDATE CLIENT");
    public JButton btnDeleteClient = new JButton("DELETE CLIENT");

    public ViewClient() {
        this.setSize(1000, 580);
        this.setVisible(true);
        this.setLocation(0, 0);

        panelClients = new JPanel();

        JLabel lblName = new JLabel("Name");
        lblName.setBounds(43, 29, 50, 15);
        panelClients.add(lblName);

        JLabel lblEmail = new JLabel("Email");
        lblEmail.setBounds(177, 29, 50, 15);
        panelClients.add(lblEmail);

        JLabel lblAge = new JLabel("Age");
        lblAge.setBounds(325, 29, 42, 15);
        panelClients.add(lblAge);

        textFieldNameClient = new JTextField();
        textFieldNameClient.setBounds(12, 50, 114, 19);
        panelClients.add(textFieldNameClient);
        textFieldNameClient.setColumns(10);

        textFieldEmailClient = new JTextField();
        textFieldEmailClient.setBounds(148, 50, 114, 19);
        panelClients.add(textFieldEmailClient);
        textFieldEmailClient.setColumns(10);

        textFieldAgeClient = new JTextField();
        textFieldAgeClient.setBounds(287, 50, 114, 19);
        panelClients.add(textFieldAgeClient);
        textFieldAgeClient.setColumns(10);

        btnAddClient = new JButton("ADD CLIENT");
        btnAddClient.setBounds(428, 44, 117, 25);
        panelClients.add(btnAddClient);

        JLabel lblNameUpdate = new JLabel("Name");
        lblNameUpdate.setBounds(187, 81, 50, 15);
        panelClients.add(lblNameUpdate);

        JLabel lblEmailUpdate = new JLabel("Email");
        lblEmailUpdate.setBounds(321, 81, 50, 15);
        panelClients.add(lblEmailUpdate);

        JLabel lblAgeUpdate = new JLabel("Age");
        lblAgeUpdate.setBounds(469, 81, 42, 15);
        panelClients.add(lblAgeUpdate);

        JLabel lblIdUpdate = new JLabel("ID");
        lblIdUpdate.setBounds(55, 81, 26, 15);
        panelClients.add(lblIdUpdate);

        textFieldNameUpdate = new JTextField();
        textFieldNameUpdate.setColumns(10);
        textFieldNameUpdate.setBounds(151, 97, 114, 19);
        panelClients.add(textFieldNameUpdate);

        textFieldEmailUpdate = new JTextField();
        textFieldEmailUpdate.setColumns(10);
        textFieldEmailUpdate.setBounds(290, 97, 114, 19);
        panelClients.add(textFieldEmailUpdate);

        textFieldAgeUpdate = new JTextField();
        textFieldAgeUpdate.setColumns(10);
        textFieldAgeUpdate.setBounds(431, 97, 114, 19);
        panelClients.add(textFieldAgeUpdate);

        textFieldIdUpdate = new JTextField();
        textFieldIdUpdate.setColumns(10);
        textFieldIdUpdate.setBounds(15, 97, 114, 19);
        panelClients.add(textFieldIdUpdate);

        btnUpdateClient = new JButton("UPDATE CLIENT");
        btnUpdateClient.setBounds(568, 91, 139, 25);
        panelClients.add(btnUpdateClient);

        textFieldIdDelete = new JTextField();
        textFieldIdDelete.setColumns(10);
        textFieldIdDelete.setBounds(12, 142, 114, 19);
        panelClients.add(textFieldIdDelete);

        JLabel lblIdDelete = new JLabel("ID");
        lblIdDelete.setBounds(55, 128, 26, 15);
        panelClients.add(lblIdDelete);

        btnDeleteClient = new JButton("DELETE CLIENT");
        btnDeleteClient.setBounds(148, 139, 139, 25);
        panelClients.add(btnDeleteClient);

        JLabel lblClientTable = new JLabel("CLIENT TABLE");
        lblClientTable.setBounds(310, 179, 99, 15);
        panelClients.add(lblClientTable);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(43, 217, 647, 311);
        panelClients.add(scrollPane);

        panelClients.setLayout(null);
        this.add(panelClients);
        tableClients = new JTable();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void addListener(ActionListener c) {
        btnAddClient.addActionListener(c);
        btnUpdateClient.addActionListener(c);
        btnDeleteClient.addActionListener(c);

    }

}