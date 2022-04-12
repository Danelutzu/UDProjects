package ui;

import lombok.Getter;
import lombok.Setter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;

@Getter
@Setter
public class GUI4 extends JFrame {
    private JButton backButton;

    public GUI4() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 274);
        JPanel contentPane = new JPanel();
        contentPane.setBackground(new Color(152, 251, 152));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setLayout(null);

        JLabel etD = new JLabel("EMPLOYEE");
        etD.setForeground(new Color(46, 139, 87));
        etD.setFont(new Font("Verdana", Font.BOLD, 35));
        etD.setBounds(87, 10, 373, 51);
        contentPane.add(etD);

        backButton = new JButton("BACK");
        backButton.setForeground(new Color(46, 139, 87));
        backButton.setFont(new Font("Verdana", Font.BOLD, 22));
        backButton.setBounds(98, 174, 140, 35);
        contentPane.add(backButton);
    }
}
