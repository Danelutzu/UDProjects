package bll;

import bll.models.*;
import bll.models.MenuItem;
import bll.utilities.ExistingUserException;
import bll.utilities.InvalidCredentials;
import bll.utilities.MenuItemNotFound;
import bll.utilities.Role;
import data.Serializator;
import ui.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class Controller implements Runnable{
    private final DeliveryService deliveryService;
    private final GUI1 gui1;
    private User currUser;
    private List<MenuItem> compositeProductMenuItemsList = new ArrayList<>();
    private List<MenuItem> orderMenuItemsList = new ArrayList<>();

    public Controller(DeliveryService deliveryService,GUI1 gui1)
    {
        this.deliveryService = deliveryService;
        assert deliveryService.invariant();
        this.gui1 = gui1;
    }

    @Override
    public void run() {
        this.gui1.setVisible(true);

        this.gui1.getFrame().addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Serializator.serializ(deliveryService);
            }
        });

        this.gui1.getOkSignUpButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username;
                String password;

                username = gui1.getUsernameSignUpText().getText();
                password = gui1.getPasswordSignUpText().getText();
                Role role = Role.valueOf(gui1.getComboBox().getSelectedItem().toString());


                if(username.equals("") || password.equals(""))
                {
                    throw new InvalidCredentials("Invalid credentials");
                }

                deliveryService.signUp(new User(username,password,role));
                gui1.clearSignUp();

            }
        });

        this.gui1.getOkSignInButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = gui1.getUsernameSignInText().getText();
                String password = gui1.getPasswordSignInText().getText();

                if(username.equals("") || password.equals(""))
                {
                    throw new InvalidCredentials("Invalid credentials");
                }

                currUser = deliveryService.logIn(username,password);

                if(currUser == null)
                {
                    throw new ExistingUserException("User with that credentials doesn t exist");
                }
                else
                {
                    gui1.clearSignIn();
                    if(currUser.getRole().toString().equals("ADMINISTRATOR"))
                    {
                        gui1.setVisible(false);
                        GUI2 gui2 = new GUI2();
                        gui2.setVisible(true);
                        gui2.getBackButton().addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                compositeProductMenuItemsList.clear();
                                gui2.dispose();
                                gui1.setVisible(true);
                            }
                        });
                        gui2.getOkAddBaseProductButton().addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                String title = gui2.getTitleAddBaseProductText().getText();
                                float rating = Float.parseFloat(gui2.getRatingAddBaseProductText().getText());
                                int calories = Integer.parseInt(gui2.getCaloriesAddBaseProductText().getText());
                                int proteins = Integer.parseInt(gui2.getProteinAddBaseProductText().getText());
                                int fats = Integer.parseInt(gui2.getFatAddBaseProductText().getText());
                                int sodium = Integer.parseInt(gui2.getSodiumAddBaseProductText().getText());
                                int price = Integer.parseInt(gui2.getPriceAddBaseProductText().getText());

                                deliveryService.addProduct(new BaseProduct(title,rating,calories,proteins,fats,sodium,price));
                            }
                        });
                        gui2.getOkEditProductButton().addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                String productSearch = gui2.getProductEditProductText().getText();
                                String title = gui2.getTitleEditProductText().getText();
                                float rating = Float.parseFloat(gui2.getRatingEditProductText().getText());
                                int calories = Integer.parseInt(gui2.getCaloriesEditProductText().getText());
                                int proteins = Integer.parseInt(gui2.getProteinEditProductText().getText());
                                int fats = Integer.parseInt(gui2.getFatEditProductText().getText());
                                int sodium = Integer.parseInt(gui2.getSodiumEditProductText().getText());
                                int price = Integer.parseInt(gui2.getPriceEditProductText().getText());

                                deliveryService.editProduct(productSearch,title,rating,calories,proteins,fats,sodium,price);
                            }
                        });
                        gui2.getOkDeleteProductButton().addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                String title = gui2.getProductDeleteProductText().getText();

                                deliveryService.deleteProduct(title);
                            }
                        });
                        gui2.getImportButton().addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                deliveryService.importFromCSV();
                            }
                        });
                        gui2.getAddAddCompositeProductButton().addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                String searchProduct = gui2.getProductAddCompositeProductText().getText();
                                MenuItem menuItem = deliveryService.getProduct(searchProduct);

                                compositeProductMenuItemsList.add(menuItem);
                            }
                        });
                        gui2.getOkAddCompositeProductButton().addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                String title = gui2.getNameAddCompositeProductText().getText();

                                deliveryService.addProduct(new CompositeProduct(title,compositeProductMenuItemsList));
                                compositeProductMenuItemsList.clear();
                            }
                        });
                        gui2.getReport1Button().addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                int start = Integer.parseInt(gui2.getStartReport1Text().getText());
                                int end = Integer.parseInt(gui2.getEndReport1Text().getText());

                                deliveryService.raport1(start,end);
                            }
                        });
                        gui2.getReport2Button().addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                int nr = Integer.parseInt(gui2.getNumberReport2Text().getText());

                                deliveryService.raport2(nr);
                            }
                        });
                        gui2.getReport4Button().addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                int day = Integer.parseInt(gui2.getValueReport4Text().getText());

                                deliveryService.raport4(day);
                            }
                        });
                        gui2.getReport3Button().addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                int times = Integer.parseInt(gui2.getNumberReport3Text().getText());
                                int value = Integer.parseInt(gui2.getValueReport3Text().getText());

                                deliveryService.raport3(times,value);
                            }
                        });
                    }
                    else
                    {
                        if(currUser.getRole().toString().equals("CLIENT"))
                        {
                            gui1.setVisible(false);
                            GUI3 gui3 = new GUI3();
                            gui3.setVisible(true);
                            gui3.getBackButton().addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    gui3.dispose();
                                    gui1.setVisible(true);
                                }
                            });
                            gui3.getAddOrderCreateButton().addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    String searchProduct = gui3.getProductOrderCreateText().getText();

                                    MenuItem menuItem = deliveryService.getProduct(searchProduct);
                                    orderMenuItemsList.add(menuItem);

                                }
                            });
                            gui3.getOkOrderCreateButton().addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    for(MenuItem i : orderMenuItemsList)
                                    {
                                        i.ord();
                                    }
                                    Order order = new Order(orderMenuItemsList);
                                    deliveryService.addOrder(order);
                                    currUser.ord(order);
                                    orderMenuItemsList.clear();
                                }
                            });
                            gui3.getOkSearchProductButton().addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    String title = gui3.getTitleSearchProductText().getText();
                                    float rating = Float.parseFloat(gui3.getRatingSearchProductText().getText());
                                    int calories = Integer.parseInt(gui3.getCaloriesSearchProductText().getText());
                                    int proteins = Integer.parseInt(gui3.getProteinSearchProductTextt().getText());
                                    int fats = Integer.parseInt(gui3.getFatSearchProductText().getText());
                                    int sodium = Integer.parseInt(gui3.getSodiumSearchProductText().getText());
                                    int price = Integer.parseInt(gui3.getPriceSearchProductText().getText());

                                    MenuItem menuItem = deliveryService.searchProduct(title,rating,calories,proteins,fats,sodium,price);

                                    if(menuItem == null)
                                    {
                                        throw new MenuItemNotFound("Item coresponding not found");
                                    }
                                    else
                                    {
                                        String[] top = {"Title","Rating","Calories","Proteins","Fats","Sodium","Price"};
                                        Object[][] content = new Object[1][7];

                                        content[0][0] = menuItem.getTitle();
                                        content[0][1] = menuItem.getRating();
                                        content[0][2] = menuItem.getCalories();
                                        content[0][3] = menuItem.getProteins();
                                        content[0][4] = menuItem.getFats();
                                        content[0][5] = menuItem.getSodium();
                                        content[0][6] = menuItem.getPrice();

                                        GUI5 gui5 = new GUI5(new JTable(content,top));
                                        gui3.setVisible(false);
                                        gui5.setVisible(true);
                                        gui5.getBackBtn().addActionListener(new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                                gui5.dispose();
                                                gui3.setVisible(true);
                                            }
                                        });
                                    }
                                }
                            });
                            gui3.getShowButton().addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    GUI5 gui5 = deliveryService.showAll();
                                    gui5.setVisible(true);
                                    gui3.setVisible(false);
                                    gui5.getBackBtn().addActionListener(new ActionListener() {
                                        @Override
                                        public void actionPerformed(ActionEvent e) {
                                            gui5.dispose();
                                            gui3.setVisible(true);
                                        }
                                    });
                                }
                            });
                        }
                        else
                        {
                            if(currUser.getRole().toString().equals("EMPLOYEE"))
                            {
                                gui1.setVisible(false);
                                GUI4 gui4 = new GUI4();
                                gui4.setVisible(true);
                                gui4.getBackButton().addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        gui4.dispose();
                                        gui1.setVisible(true);
                                    }
                                });
                            }
                        }
                    }
                }
            }
        });
    }
}
