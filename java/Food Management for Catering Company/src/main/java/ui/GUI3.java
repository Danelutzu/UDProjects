package ui;

import lombok.Getter;
import lombok.Setter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
@Getter
@Setter
public class GUI3 extends JFrame {
    private JTextField titleSearchProductText;
    private JTextField ratingSearchProductText;
    private JTextField caloriesSearchProductText;
    private JTextField proteinSearchProductTextt;
    private JTextField fatSearchProductText;
    private JTextField sodiumSearchProductText;
    private JTextField priceSearchProductText;
    private JTextField productOrderCreateText;
    private JButton okSearchProductButton;
    private JButton addOrderCreateButton;
    private JButton okOrderCreateButton;
    private JButton showButton;
    private JButton backButton;

    public GUI3() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 735, 540);
        JPanel contentPane = new JPanel();
        contentPane.setBackground(new Color(152, 251, 152));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setLayout(null);

        JLabel etD = new JLabel("CLIENT");
        etD.setForeground(new Color(46, 139, 87));
        etD.setFont(new Font("Verdana", Font.BOLD, 35));
        etD.setBounds(283, 10, 373, 51);
        contentPane.add(etD);

        JLabel a = new JLabel("SEARCH PRODUCT");
        a.setForeground(new Color(46, 139, 87));
        a.setFont(new Font("Verdana", Font.BOLD, 27));
        a.setBounds(24, 71, 333, 51);
        contentPane.add(a);

        titleSearchProductText = new JTextField();
        titleSearchProductText.setForeground(new Color(46, 139, 87));
        titleSearchProductText.setFont(new Font("Verdana", Font.BOLD, 15));
        titleSearchProductText.setColumns(10);
        titleSearchProductText.setBounds(156, 144, 152, 27);
        contentPane.add(titleSearchProductText);

        okSearchProductButton = new JButton("OK");
        okSearchProductButton.setFont(new Font("Verdana", Font.BOLD, 22));
        okSearchProductButton.setForeground(new Color(46, 139, 87));
        okSearchProductButton.setBounds(97, 456, 103, 35);
        contentPane.add(okSearchProductButton);

        JLabel b = new JLabel("Title:");
        b.setForeground(new Color(46, 139, 87));
        b.setFont(new Font("Verdana", Font.BOLD, 23));
        b.setBounds(10, 131, 228, 51);
        contentPane.add(b);

        JLabel c = new JLabel("Rating:");
        c.setForeground(new Color(46, 139, 87));
        c.setFont(new Font("Verdana", Font.BOLD, 23));
        c.setBounds(10, 173, 228, 51);
        contentPane.add(c);

        JLabel cdd = new JLabel("Calories:");
        cdd.setForeground(new Color(46, 139, 87));
        cdd.setFont(new Font("Verdana", Font.BOLD, 23));
        cdd.setBounds(10, 216, 228, 51);
        contentPane.add(cdd);

        JLabel e = new JLabel("Protein:");
        e.setForeground(new Color(46, 139, 87));
        e.setFont(new Font("Verdana", Font.BOLD, 23));
        e.setBounds(10, 256, 228, 51);
        contentPane.add(e);

        JLabel f = new JLabel("Fat:");
        f.setForeground(new Color(46, 139, 87));
        f.setFont(new Font("Verdana", Font.BOLD, 23));
        f.setBounds(10, 298, 228, 51);
        contentPane.add(f);

        JLabel g = new JLabel("Sodium:");
        g.setForeground(new Color(46, 139, 87));
        g.setFont(new Font("Verdana", Font.BOLD, 23));
        g.setBounds(10, 340, 228, 51);
        contentPane.add(g);

        JLabel h = new JLabel("Price:");
        h.setForeground(new Color(46, 139, 87));
        h.setFont(new Font("Verdana", Font.BOLD, 23));
        h.setBounds(10, 379, 228, 51);
        contentPane.add(h);

        ratingSearchProductText = new JTextField();
        ratingSearchProductText.setForeground(new Color(46, 139, 87));
        ratingSearchProductText.setFont(new Font("Verdana", Font.BOLD, 15));
        ratingSearchProductText.setColumns(10);
        ratingSearchProductText.setBounds(156, 192, 152, 27);
        contentPane.add(ratingSearchProductText);

        caloriesSearchProductText = new JTextField();
        caloriesSearchProductText.setForeground(new Color(46, 139, 87));
        caloriesSearchProductText.setFont(new Font("Verdana", Font.BOLD, 15));
        caloriesSearchProductText.setColumns(10);
        caloriesSearchProductText.setBounds(156, 238, 152, 27);
        contentPane.add(caloriesSearchProductText);

        proteinSearchProductTextt = new JTextField();
        proteinSearchProductTextt.setForeground(new Color(46, 139, 87));
        proteinSearchProductTextt.setFont(new Font("Verdana", Font.BOLD, 15));
        proteinSearchProductTextt.setColumns(10);
        proteinSearchProductTextt.setBounds(156, 277, 152, 27);
        contentPane.add(proteinSearchProductTextt);

        fatSearchProductText = new JTextField();
        fatSearchProductText.setForeground(new Color(46, 139, 87));
        fatSearchProductText.setFont(new Font("Verdana", Font.BOLD, 15));
        fatSearchProductText.setColumns(10);
        fatSearchProductText.setBounds(156, 317, 152, 27);
        contentPane.add(fatSearchProductText);

        sodiumSearchProductText = new JTextField();
        sodiumSearchProductText.setForeground(new Color(46, 139, 87));
        sodiumSearchProductText.setFont(new Font("Verdana", Font.BOLD, 15));
        sodiumSearchProductText.setColumns(10);
        sodiumSearchProductText.setBounds(156, 356, 152, 27);
        contentPane.add(sodiumSearchProductText);

        priceSearchProductText = new JTextField();
        priceSearchProductText.setForeground(new Color(46, 139, 87));
        priceSearchProductText.setFont(new Font("Verdana", Font.BOLD, 15));
        priceSearchProductText.setColumns(10);
        priceSearchProductText.setBounds(156, 395, 152, 27);
        contentPane.add(priceSearchProductText);

        JLabel sdds = new JLabel("ORDER CREATE");
        sdds.setForeground(new Color(46, 139, 87));
        sdds.setFont(new Font("Verdana", Font.BOLD, 27));
        sdds.setBounds(424, 110, 333, 51);
        contentPane.add(sdds);

        JLabel ddd = new JLabel("Product:");
        ddd.setForeground(new Color(46, 139, 87));
        ddd.setFont(new Font("Verdana", Font.BOLD, 23));
        ddd.setBounds(392, 173, 228, 51);
        contentPane.add(ddd);

        addOrderCreateButton = new JButton("ADD");
        addOrderCreateButton.setForeground(new Color(46, 139, 87));
        addOrderCreateButton.setFont(new Font("Verdana", Font.BOLD, 22));
        addOrderCreateButton.setBounds(422, 232, 103, 35);
        contentPane.add(addOrderCreateButton);

        okOrderCreateButton = new JButton("OK");
        okOrderCreateButton.setForeground(new Color(46, 139, 87));
        okOrderCreateButton.setFont(new Font("Verdana", Font.BOLD, 22));
        okOrderCreateButton.setBounds(553, 232, 103, 35);
        contentPane.add(okOrderCreateButton);

        productOrderCreateText = new JTextField();
        productOrderCreateText.setForeground(new Color(46, 139, 87));
        productOrderCreateText.setFont(new Font("Verdana", Font.BOLD, 15));
        productOrderCreateText.setColumns(10);
        productOrderCreateText.setBounds(522, 187, 152, 27);
        contentPane.add(productOrderCreateText);

        showButton = new JButton("SHOW ");
        showButton.setForeground(new Color(46, 139, 87));
        showButton.setFont(new Font("Verdana", Font.BOLD, 22));
        showButton.setBounds(363, 340, 162, 35);
        contentPane.add(showButton);

        backButton = new JButton("BACK");
        backButton.setForeground(new Color(46, 139, 87));
        backButton.setFont(new Font("Verdana", Font.BOLD, 22));
        backButton.setBounds(553, 340, 140, 35);
        contentPane.add(backButton);
    }
}
