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
public class GUI2 extends JFrame {
    private JTextField titleAddBaseProductText;
    private JTextField ratingAddBaseProductText;
    private JTextField caloriesAddBaseProductText;
    private JTextField proteinAddBaseProductText;
    private JTextField fatAddBaseProductText;
    private JTextField sodiumAddBaseProductText;
    private JTextField priceAddBaseProductText;
    private JTextField productEditProductText;
    private JTextField titleEditProductText;
    private JTextField ratingEditProductText;
    private JTextField caloriesEditProductText;
    private JTextField proteinEditProductText;
    private JTextField fatEditProductText;
    private JTextField sodiumEditProductText;
    private JTextField priceEditProductText;
    private JTextField nameAddCompositeProductText;
    private JTextField productAddCompositeProductText;
    private JTextField productDeleteProductText;
    private JTextField startReport1Text;
    private JTextField endReport1Text;
    private JTextField numberReport2Text;
    private JTextField numberReport3Text;
    private JTextField valueReport3Text;
    private JButton backButton;
    private JButton report4Button;
    private JButton report3Button;
    private JButton report2Button;
    private JButton report1Button;
    private JButton importButton;
    private JButton okDeleteProductButton;
    private JButton okAddCompositeProductButton;
    private JButton addAddCompositeProductButton;
    private JButton okEditProductButton;
    private JTextField valueReport4Text;
    private JButton okAddBaseProductButton;

    public GUI2() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1111, 882);
        JPanel contentPane = new JPanel();
        contentPane.setBackground(new Color(152, 251, 152));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setLayout(null);

        JLabel etD = new JLabel("ADMINISTRATOR");
        etD.setForeground(new Color(46, 139, 87));
        etD.setFont(new Font("Verdana", Font.BOLD, 35));
        etD.setBounds(358, 10, 373, 51);
        contentPane.add(etD);

        JLabel a = new JLabel("Add base product");
        a.setForeground(new Color(46, 139, 87));
        a.setFont(new Font("Verdana", Font.BOLD, 27));
        a.setBounds(24, 71, 333, 51);
        contentPane.add(a);

        titleAddBaseProductText = new JTextField();
        titleAddBaseProductText.setForeground(new Color(46, 139, 87));
        titleAddBaseProductText.setFont(new Font("Verdana", Font.BOLD, 15));
        titleAddBaseProductText.setColumns(10);
        titleAddBaseProductText.setBounds(156, 144, 152, 27);
        contentPane.add(titleAddBaseProductText);

        okAddBaseProductButton = new JButton("OK");
        okAddBaseProductButton.setFont(new Font("Verdana", Font.BOLD, 22));
        okAddBaseProductButton.setForeground(new Color(46, 139, 87));
        okAddBaseProductButton.setBounds(94, 483, 103, 35);
        contentPane.add(okAddBaseProductButton);

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

        ratingAddBaseProductText = new JTextField();
        ratingAddBaseProductText.setForeground(new Color(46, 139, 87));
        ratingAddBaseProductText.setFont(new Font("Verdana", Font.BOLD, 15));
        ratingAddBaseProductText.setColumns(10);
        ratingAddBaseProductText.setBounds(156, 192, 152, 27);
        contentPane.add(ratingAddBaseProductText);

        caloriesAddBaseProductText = new JTextField();
        caloriesAddBaseProductText.setForeground(new Color(46, 139, 87));
        caloriesAddBaseProductText.setFont(new Font("Verdana", Font.BOLD, 15));
        caloriesAddBaseProductText.setColumns(10);
        caloriesAddBaseProductText.setBounds(156, 238, 152, 27);
        contentPane.add(caloriesAddBaseProductText);

        proteinAddBaseProductText = new JTextField();
        proteinAddBaseProductText.setForeground(new Color(46, 139, 87));
        proteinAddBaseProductText.setFont(new Font("Verdana", Font.BOLD, 15));
        proteinAddBaseProductText.setColumns(10);
        proteinAddBaseProductText.setBounds(156, 277, 152, 27);
        contentPane.add(proteinAddBaseProductText);

        fatAddBaseProductText = new JTextField();
        fatAddBaseProductText.setForeground(new Color(46, 139, 87));
        fatAddBaseProductText.setFont(new Font("Verdana", Font.BOLD, 15));
        fatAddBaseProductText.setColumns(10);
        fatAddBaseProductText.setBounds(156, 317, 152, 27);
        contentPane.add(fatAddBaseProductText);

        sodiumAddBaseProductText = new JTextField();
        sodiumAddBaseProductText.setForeground(new Color(46, 139, 87));
        sodiumAddBaseProductText.setFont(new Font("Verdana", Font.BOLD, 15));
        sodiumAddBaseProductText.setColumns(10);
        sodiumAddBaseProductText.setBounds(156, 356, 152, 27);
        contentPane.add(sodiumAddBaseProductText);

        priceAddBaseProductText = new JTextField();
        priceAddBaseProductText.setForeground(new Color(46, 139, 87));
        priceAddBaseProductText.setFont(new Font("Verdana", Font.BOLD, 15));
        priceAddBaseProductText.setColumns(10);
        priceAddBaseProductText.setBounds(156, 395, 152, 27);
        contentPane.add(priceAddBaseProductText);

        JLabel j = new JLabel("Edit product");
        j.setForeground(new Color(46, 139, 87));
        j.setFont(new Font("Verdana", Font.BOLD, 27));
        j.setBounds(378, 71, 333, 51);
        contentPane.add(j);

        JLabel l = new JLabel("Title:");
        l.setForeground(new Color(46, 139, 87));
        l.setFont(new Font("Verdana", Font.BOLD, 23));
        l.setBounds(335, 173, 80, 51);
        contentPane.add(l);

        JLabel k = new JLabel("Product:");
        k.setForeground(new Color(46, 139, 87));
        k.setFont(new Font("Verdana", Font.BOLD, 23));
        k.setBounds(335, 132, 116, 51);
        contentPane.add(k);

        JLabel w = new JLabel("Calories:");
        w.setForeground(new Color(46, 139, 87));
        w.setFont(new Font("Verdana", Font.BOLD, 23));
        w.setBounds(335, 256, 114, 51);
        contentPane.add(w);

        JLabel q = new JLabel("Rating:");
        q.setForeground(new Color(46, 139, 87));
        q.setFont(new Font("Verdana", Font.BOLD, 23));
        q.setBounds(335, 216, 103, 51);
        contentPane.add(q);

        JLabel t = new JLabel("Protein:");
        t.setForeground(new Color(46, 139, 87));
        t.setFont(new Font("Verdana", Font.BOLD, 23));
        t.setBounds(335, 298, 116, 51);
        contentPane.add(t);

        JLabel y = new JLabel("Fat:");
        y.setForeground(new Color(46, 139, 87));
        y.setFont(new Font("Verdana", Font.BOLD, 23));
        y.setBounds(335, 340, 103, 51);
        contentPane.add(y);

        JLabel u = new JLabel("Sodium:");
        u.setForeground(new Color(46, 139, 87));
        u.setFont(new Font("Verdana", Font.BOLD, 23));
        u.setBounds(335, 379, 116, 51);
        contentPane.add(u);

        JLabel i = new JLabel("Price:");
        i.setForeground(new Color(46, 139, 87));
        i.setFont(new Font("Verdana", Font.BOLD, 23));
        i.setBounds(335, 419, 103, 51);
        contentPane.add(i);

        productEditProductText = new JTextField();
        productEditProductText.setForeground(new Color(46, 139, 87));
        productEditProductText.setFont(new Font("Verdana", Font.BOLD, 15));
        productEditProductText.setColumns(10);
        productEditProductText.setBounds(466, 144, 152, 27);
        contentPane.add(productEditProductText);

        titleEditProductText = new JTextField();
        titleEditProductText.setForeground(new Color(46, 139, 87));
        titleEditProductText.setFont(new Font("Verdana", Font.BOLD, 15));
        titleEditProductText.setColumns(10);
        titleEditProductText.setBounds(466, 189, 152, 27);
        contentPane.add(titleEditProductText);

        ratingEditProductText = new JTextField();
        ratingEditProductText.setForeground(new Color(46, 139, 87));
        ratingEditProductText.setFont(new Font("Verdana", Font.BOLD, 15));
        ratingEditProductText.setColumns(10);
        ratingEditProductText.setBounds(466, 229, 152, 27);
        contentPane.add(ratingEditProductText);

        caloriesEditProductText = new JTextField();
        caloriesEditProductText.setForeground(new Color(46, 139, 87));
        caloriesEditProductText.setFont(new Font("Verdana", Font.BOLD, 15));
        caloriesEditProductText.setColumns(10);
        caloriesEditProductText.setBounds(466, 270, 152, 27);
        contentPane.add(caloriesEditProductText);

        proteinEditProductText = new JTextField();
        proteinEditProductText.setForeground(new Color(46, 139, 87));
        proteinEditProductText.setFont(new Font("Verdana", Font.BOLD, 15));
        proteinEditProductText.setColumns(10);
        proteinEditProductText.setBounds(466, 314, 152, 27);
        contentPane.add(proteinEditProductText);

        fatEditProductText = new JTextField();
        fatEditProductText.setForeground(new Color(46, 139, 87));
        fatEditProductText.setFont(new Font("Verdana", Font.BOLD, 15));
        fatEditProductText.setColumns(10);
        fatEditProductText.setBounds(466, 353, 152, 27);
        contentPane.add(fatEditProductText);

        sodiumEditProductText = new JTextField();
        sodiumEditProductText.setForeground(new Color(46, 139, 87));
        sodiumEditProductText.setFont(new Font("Verdana", Font.BOLD, 15));
        sodiumEditProductText.setColumns(10);
        sodiumEditProductText.setBounds(466, 395, 152, 27);
        contentPane.add(sodiumEditProductText);

        priceEditProductText = new JTextField();
        priceEditProductText.setForeground(new Color(46, 139, 87));
        priceEditProductText.setFont(new Font("Verdana", Font.BOLD, 15));
        priceEditProductText.setColumns(10);
        priceEditProductText.setBounds(466, 432, 152, 27);
        contentPane.add(priceEditProductText);

        okEditProductButton = new JButton("OK");
        okEditProductButton.setForeground(new Color(46, 139, 87));
        okEditProductButton.setFont(new Font("Verdana", Font.BOLD, 22));
        okEditProductButton.setBounds(414, 483, 103, 35);
        contentPane.add(okEditProductButton);

        JLabel o = new JLabel("Add composite product");
        o.setForeground(new Color(46, 139, 87));
        o.setFont(new Font("Verdana", Font.BOLD, 27));
        o.setBounds(645, 71, 421, 51);
        contentPane.add(o);

        JLabel p = new JLabel("Name:");
        p.setForeground(new Color(46, 139, 87));
        p.setFont(new Font("Verdana", Font.BOLD, 23));
        p.setBounds(670, 128, 116, 51);
        contentPane.add(p);

        JLabel z = new JLabel("Product:");
        z.setForeground(new Color(46, 139, 87));
        z.setFont(new Font("Verdana", Font.BOLD, 23));
        z.setBounds(670, 173, 116, 51);
        contentPane.add(z);

        nameAddCompositeProductText = new JTextField();
        nameAddCompositeProductText.setForeground(new Color(46, 139, 87));
        nameAddCompositeProductText.setFont(new Font("Verdana", Font.BOLD, 15));
        nameAddCompositeProductText.setColumns(10);
        nameAddCompositeProductText.setBounds(806, 141, 152, 27);
        contentPane.add(nameAddCompositeProductText);

        productAddCompositeProductText = new JTextField();
        productAddCompositeProductText.setForeground(new Color(46, 139, 87));
        productAddCompositeProductText.setFont(new Font("Verdana", Font.BOLD, 15));
        productAddCompositeProductText.setColumns(10);
        productAddCompositeProductText.setBounds(806, 185, 152, 27);
        contentPane.add(productAddCompositeProductText);

        JLabel x = new JLabel("Delete product:");
        x.setForeground(new Color(46, 139, 87));
        x.setFont(new Font("Verdana", Font.BOLD, 27));
        x.setBounds(696, 297, 249, 51);
        contentPane.add(x);

        addAddCompositeProductButton = new JButton("ADD");
        addAddCompositeProductButton.setForeground(new Color(46, 139, 87));
        addAddCompositeProductButton.setFont(new Font("Verdana", Font.BOLD, 22));
        addAddCompositeProductButton.setBounds(696, 237, 103, 35);
        contentPane.add(addAddCompositeProductButton);

        okAddCompositeProductButton = new JButton("OK");
        okAddCompositeProductButton.setForeground(new Color(46, 139, 87));
        okAddCompositeProductButton.setFont(new Font("Verdana", Font.BOLD, 22));
        okAddCompositeProductButton.setBounds(832, 237, 103, 35);
        contentPane.add(okAddCompositeProductButton);

        JLabel cv = new JLabel("Product:");
        cv.setForeground(new Color(46, 139, 87));
        cv.setFont(new Font("Verdana", Font.BOLD, 23));
        cv.setBounds(670, 365, 116, 51);
        contentPane.add(cv);

        productDeleteProductText = new JTextField();
        productDeleteProductText.setForeground(new Color(46, 139, 87));
        productDeleteProductText.setFont(new Font("Verdana", Font.BOLD, 15));
        productDeleteProductText.setColumns(10);
        productDeleteProductText.setBounds(806, 379, 152, 27);
        contentPane.add(productDeleteProductText);

        okDeleteProductButton = new JButton("OK");
        okDeleteProductButton.setForeground(new Color(46, 139, 87));
        okDeleteProductButton.setFont(new Font("Verdana", Font.BOLD, 22));
        okDeleteProductButton.setBounds(751, 419, 103, 35);
        contentPane.add(okDeleteProductButton);

        importButton = new JButton("IMPORT");
        importButton.setForeground(new Color(46, 139, 87));
        importButton.setFont(new Font("Verdana", Font.BOLD, 22));
        importButton.setBounds(700, 483, 220, 35);
        contentPane.add(importButton);

        JLabel n = new JLabel("REPORT 1");
        n.setForeground(new Color(46, 139, 87));
        n.setFont(new Font("Verdana", Font.BOLD, 27));
        n.setBounds(26, 554, 171, 51);
        contentPane.add(n);

        JLabel ee = new JLabel("Start:");
        ee.setForeground(new Color(46, 139, 87));
        ee.setFont(new Font("Verdana", Font.BOLD, 23));
        ee.setBounds(10, 615, 80, 51);
        contentPane.add(ee);

        JLabel rr = new JLabel("End:");
        rr.setForeground(new Color(46, 139, 87));
        rr.setFont(new Font("Verdana", Font.BOLD, 23));
        rr.setBounds(10, 658, 74, 51);
        contentPane.add(rr);

        startReport1Text = new JTextField();
        startReport1Text.setForeground(new Color(46, 139, 87));
        startReport1Text.setFont(new Font("Verdana", Font.BOLD, 15));
        startReport1Text.setColumns(10);
        startReport1Text.setBounds(94, 629, 108, 27);
        contentPane.add(startReport1Text);

        endReport1Text = new JTextField();
        endReport1Text.setForeground(new Color(46, 139, 87));
        endReport1Text.setFont(new Font("Verdana", Font.BOLD, 15));
        endReport1Text.setColumns(10);
        endReport1Text.setBounds(94, 672, 108, 27);
        contentPane.add(endReport1Text);

        report1Button = new JButton("OK");
        report1Button.setForeground(new Color(46, 139, 87));
        report1Button.setFont(new Font("Verdana", Font.BOLD, 22));
        report1Button.setBounds(54, 720, 103, 35);
        contentPane.add(report1Button);

        JLabel m = new JLabel("REPORT 2");
        m.setForeground(new Color(46, 139, 87));
        m.setFont(new Font("Verdana", Font.BOLD, 27));
        m.setBounds(280, 554, 171, 51);
        contentPane.add(m);

        JLabel tt = new JLabel("Number:");
        tt.setForeground(new Color(46, 139, 87));
        tt.setFont(new Font("Verdana", Font.BOLD, 23));
        tt.setBounds(229, 629, 119, 51);
        contentPane.add(tt);

        numberReport2Text = new JTextField();
        numberReport2Text.setForeground(new Color(46, 139, 87));
        numberReport2Text.setFont(new Font("Verdana", Font.BOLD, 15));
        numberReport2Text.setColumns(10);
        numberReport2Text.setBounds(358, 645, 108, 27);
        contentPane.add(numberReport2Text);

        report2Button = new JButton("OK");
        report2Button.setForeground(new Color(46, 139, 87));
        report2Button.setFont(new Font("Verdana", Font.BOLD, 22));
        report2Button.setBounds(300, 720, 103, 35);
        contentPane.add(report2Button);

        JLabel qq = new JLabel("REPORT 3");
        qq.setForeground(new Color(46, 139, 87));
        qq.setFont(new Font("Verdana", Font.BOLD, 27));
        qq.setBounds(540, 554, 171, 51);
        contentPane.add(qq);

        JLabel yy = new JLabel("Number:");
        yy.setForeground(new Color(46, 139, 87));
        yy.setFont(new Font("Verdana", Font.BOLD, 23));
        yy.setBounds(499, 615, 119, 51);
        contentPane.add(yy);

        JLabel uu = new JLabel("Value:");
        uu.setForeground(new Color(46, 139, 87));
        uu.setFont(new Font("Verdana", Font.BOLD, 23));
        uu.setBounds(499, 658, 119, 51);
        contentPane.add(uu);

        numberReport3Text = new JTextField();
        numberReport3Text.setForeground(new Color(46, 139, 87));
        numberReport3Text.setFont(new Font("Verdana", Font.BOLD, 15));
        numberReport3Text.setColumns(10);
        numberReport3Text.setBounds(628, 629, 108, 27);
        contentPane.add(numberReport3Text);

        valueReport3Text = new JTextField();
        valueReport3Text.setForeground(new Color(46, 139, 87));
        valueReport3Text.setFont(new Font("Verdana", Font.BOLD, 15));
        valueReport3Text.setColumns(10);
        valueReport3Text.setBounds(628, 672, 108, 27);
        contentPane.add(valueReport3Text);

        report3Button = new JButton("OK");
        report3Button.setForeground(new Color(46, 139, 87));
        report3Button.setFont(new Font("Verdana", Font.BOLD, 22));
        report3Button.setBounds(559, 720, 103, 35);
        contentPane.add(report3Button);

        JLabel ww = new JLabel("REPORT 4");
        ww.setForeground(new Color(46, 139, 87));
        ww.setFont(new Font("Verdana", Font.BOLD, 27));
        ww.setBounds(806, 554, 171, 51);
        contentPane.add(ww);

        JLabel ii = new JLabel("Number:");
        ii.setForeground(new Color(46, 139, 87));
        ii.setFont(new Font("Verdana", Font.BOLD, 23));
        ii.setBounds(764, 629, 119, 51);
        contentPane.add(ii);

        valueReport4Text = new JTextField();
        valueReport4Text.setForeground(new Color(46, 139, 87));
        valueReport4Text.setFont(new Font("Verdana", Font.BOLD, 15));
        valueReport4Text.setColumns(10);
        valueReport4Text.setBounds(890, 643, 108, 27);
        contentPane.add(valueReport4Text);

        report4Button = new JButton("OK");
        report4Button.setForeground(new Color(46, 139, 87));
        report4Button.setFont(new Font("Verdana", Font.BOLD, 22));
        report4Button.setBounds(832, 720, 103, 35);
        contentPane.add(report4Button);

        backButton = new JButton("BACK");
        backButton.setForeground(new Color(46, 139, 87));
        backButton.setFont(new Font("Verdana", Font.BOLD, 22));
        backButton.setBounds(973, 720, 114, 35);
        contentPane.add(backButton);
    }
}
