package ui;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;

@Getter
@Setter
public class GUI1 extends JFrame {
    private JTextField usernameSignInText;
    private JPasswordField passwordSignInText;
    private JTextField usernameSignUpText;
    private JPasswordField passwordSignUpText;
    private String[] roles = {"ADMINISTRATOR", "EMPLOYEE", "CLIENT"};
    private JButton okSignUpButton;
    private  JComboBox comboBox;
    private JButton okSignInButton;

    public GUI1() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 939, 379);
        JPanel contentPane = new JPanel();
        contentPane.setBackground(new Color(152, 251, 152));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setLayout(null);

        JLabel etA = new JLabel("SIGN IN");
        etA.setForeground(new Color(46, 139, 87));
        etA.setFont(new Font("Verdana", Font.BOLD, 35));
        etA.setBounds(133, 21, 237, 51);
        contentPane.add(etA);

        JLabel etD = new JLabel("SIGN UP");
        etD.setForeground(new Color(46, 139, 87));
        etD.setFont(new Font("Verdana", Font.BOLD, 35));
        etD.setBounds(603, 21, 237, 51);
        contentPane.add(etD);

        JLabel etB = new JLabel("Username:");
        etB.setForeground(new Color(46, 139, 87));
        etB.setFont(new Font("Verdana", Font.BOLD, 25));
        etB.setBounds(25, 108, 163, 51);
        contentPane.add(etB);

        JLabel etC = new JLabel("Password:");
        etC.setForeground(new Color(46, 139, 87));
        etC.setFont(new Font("Verdana", Font.BOLD, 25));
        etC.setBounds(25, 162, 152, 51);
        contentPane.add(etC);

        usernameSignInText = new JTextField();
        usernameSignInText.setForeground(new Color(46, 139, 87));
        usernameSignInText.setFont(new Font("Verdana", Font.BOLD, 15));
        usernameSignInText.setBounds(198, 126, 152, 27);
        contentPane.add(usernameSignInText);
        usernameSignInText.setColumns(10);

        passwordSignInText = new JPasswordField();
        passwordSignInText.setForeground(new Color(46, 139, 87));
        passwordSignInText.setFont(new Font("Verdana", Font.BOLD, 15));
        passwordSignInText.setColumns(10);
        passwordSignInText.setBounds(198, 176, 152, 27);
        contentPane.add(passwordSignInText);

        okSignInButton = new JButton("OK");
        okSignInButton.setFont(new Font("Verdana", Font.BOLD, 22));
        okSignInButton.setForeground(new Color(46, 139, 87));
        okSignInButton.setBounds(148, 235, 103, 35);
        contentPane.add(okSignInButton);

        JLabel etU = new JLabel("Username:");
        etU.setForeground(new Color(46, 139, 87));
        etU.setFont(new Font("Verdana", Font.BOLD, 25));
        etU.setBounds(497, 108, 163, 51);
        contentPane.add(etU);

        JLabel etP = new JLabel("Password:");
        etP.setForeground(new Color(46, 139, 87));
        etP.setFont(new Font("Verdana", Font.BOLD, 25));
        etP.setBounds(497, 162, 152, 51);
        contentPane.add(etP);

        JLabel etR = new JLabel("Role:");
        etR.setForeground(new Color(46, 139, 87));
        etR.setFont(new Font("Verdana", Font.BOLD, 25));
        etR.setBounds(497, 215, 152, 51);
        contentPane.add(etR);

        usernameSignUpText = new JTextField();
        usernameSignUpText.setForeground(new Color(46, 139, 87));
        usernameSignUpText.setFont(new Font("Verdana", Font.BOLD, 15));
        usernameSignUpText.setColumns(10);
        usernameSignUpText.setBounds(670, 122, 152, 27);
        contentPane.add(usernameSignUpText);

        passwordSignUpText = new JPasswordField();
        passwordSignUpText.setForeground(new Color(46, 139, 87));
        passwordSignUpText.setFont(new Font("Verdana", Font.BOLD, 15));
        passwordSignUpText.setColumns(10);
        passwordSignUpText.setBounds(670, 176, 152, 27);
        contentPane.add(passwordSignUpText);

        comboBox = new JComboBox(roles);
        comboBox.setForeground(new Color(46, 139, 87));
        comboBox.setFont(new Font("Verdana", Font.BOLD, 15));
        comboBox.setBounds(660, 229, 175, 27);
        contentPane.add(comboBox);

        okSignUpButton = new JButton("OK");
        okSignUpButton.setForeground(new Color(46, 139, 87));
        okSignUpButton.setFont(new Font("Verdana", Font.BOLD, 22));
        okSignUpButton.setBounds(626, 276, 103, 35);
        contentPane.add(okSignUpButton);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(438, 0, 7, 363);
        contentPane.add(scrollPane);
    }
    public void clearSignUp()
    {
        this.usernameSignUpText.setText("");
        this.passwordSignUpText.setText("");
    }public void clearSignIn()
    {
        this.usernameSignInText.setText("");
        this.passwordSignInText.setText("");
    }
    public JFrame getFrame()
    {
        return this;
    }
}
