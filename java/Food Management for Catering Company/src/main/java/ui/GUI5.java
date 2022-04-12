package ui;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

@Getter
@Setter
public class GUI5 extends JFrame {

    private final JButton backBtn;


    public GUI5(JTable jTable) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 500);
        setVisible(true);
        JPanel contentPane = new JPanel();
        contentPane.setBackground(new Color(152, 251, 152));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        backBtn = new JButton("Back");
        backBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
        backBtn.setBounds(390, 432, 85, 21);
        contentPane.add(backBtn);


        JScrollPane asdasdas = new JScrollPane();
        asdasdas.setBounds(10, 10, 470, 400);
        contentPane.add(asdasdas);

        asdasdas.setViewportView(jTable);
    }
}

