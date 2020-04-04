package booksellingsystem;

import Orders.OrdersManage;
import Orders.showOrders;
import static base.ValidateUser.generateHash;
import static base.ValidateUser.validateEmail;
import static base.ValidateUser.validatePassword;
import static base.ValidateUser.validatePhoneNumber;
import static base.common.BUTTONS;
import static base.common.COMBOBOXES;
import static base.common.LABELS;
import static base.common.MENUITEMS;
import static base.common.MENUS;
import static base.common.PASSWORDFIELDS;
import static base.common.TEXTFIELDS;
import static base.common.comic;
import static base.common.dialogPopUp;
import static base.common.lightGray;
import static base.common.newAccount;
import static base.common.userhost;
import booksellingsystem.mainmenu.AddNewBooks;
import booksellingsystem.mainmenu.AddOldBooks;
import booksellingsystem.mainmenu.History;
import static database.database.CURRENTUSER;
import static database.database.LOGGEDOUT;
import static database.database.DELETEUSER;
import static database.database.USERS;
import static database.database.UpdateAdmin;
import static database.database.UpdateUser;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class AdminHost extends JFrame {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                String ss = null;
                AdminHost ah = new AdminHost();

                ah.setVisible(true);
            }
        });
    }

    JButton history,
            button,
            logout,
            request,
            rcb,
            buyook;
    JPanel center1, center2, mum;
    JLabel label;

    JMenu mainMenu,
            manage,
            order,
            userAdmin
            
            ;
    JMenuItem
            recycle,
            anb,
            showOrders,
            manageOrder,
            manageUsers,
            manageAdmin,
            managerequested
            ;
    public AdminHost() {
        setTitle("Book Store");
        userhost(this);

        JMenuBar menubar = new JMenuBar();

         mainMenu = new JMenu("Main Menu");
        menubar.add(mainMenu);

         recycle = new JMenuItem("Add Old books");
        recycle.addActionListener((r) -> {
            AddOldBooks ads = new AddOldBooks();
            ads.setVisible(true);
        });
        mainMenu.add(recycle);

         anb = new JMenuItem("Add New books");
        anb.addActionListener((r) -> {
            AddNewBooks ads = new AddNewBooks();
            ads.setVisible(true);
        });
        mainMenu.add(anb);

         manage = new JMenu("Manage");
        menubar.add(manage);

         order = new JMenu("Orders");
        order.setFont(comic);
        manage.add(order);

         showOrders = new JMenuItem("Show Orders");
        showOrders.addActionListener((d) -> {
            showOrders so = new showOrders();
            so.setVisible(true);
        });
        order.add(showOrders);

         manageOrder = new JMenuItem("Manage Orders");
        manageOrder.addActionListener((f) -> {
            OrdersManage so = new OrdersManage();
            so.setVisible(true);
        });
        order.add(manageOrder);

         userAdmin = new JMenu("Users");
        manage.add(userAdmin);

         manageUsers = new JMenuItem("Manage Users");
        manageUsers.addActionListener((f) -> {
            new manageUsers();

        });

        userAdmin.add(manageUsers);

         manageAdmin = new JMenuItem("Manage Admin Account");
        manageAdmin.addActionListener((a) -> {
            EditAccount mU = new EditAccount();
            mU.setVisible(true);
        });

        managerequested  = new JMenuItem("Manage Requested Books");
        managerequested.addActionListener((a)->{
            Orders.RequestAdmin r = new Orders.RequestAdmin();
            r.setVisible(true);
        });
        mainMenu.add(managerequested);
        userAdmin.add(manageAdmin);

        center1 = new JPanel();
        center1.setLayout(new GridLayout(1, 3));

        mum = new JPanel();
        mum.setLayout(new GridLayout(2, 1));;
        center2 = new JPanel();
        center2.setLayout(new GridLayout(1, 2));

        logout = new JButton("Log out");
        logout.addActionListener((a) -> {
            if (JOptionPane.showConfirmDialog(this, "Want to exit?") == JOptionPane.YES_OPTION) {
                LOGGEDOUT();
                dispose();
                BookSellingSystem bss = new BookSellingSystem();
                bss.setTitle("Book Store");
                bss.setVisible(true);

            }
        });

        button = new JButton("Show orders");
        button.setFont(new Font("Tahoma", Font.PLAIN, 29));
        button.addActionListener((ActionEvent e) -> {
            showOrders so = new showOrders();
            so.setVisible(true);
        });

        rcb = new JButton("Recycle");
        rcb.addActionListener((l) -> {
            AddOldBooks ad = new AddOldBooks();
            ad.setVisible(true);
        });

        history = new JButton("History");
        history.addActionListener((h) -> {
            History hh = new History();
            hh.setVisible(true);
        });

        this.setTitle("Book Store | " + CURRENTUSER());

        center1.add(button);
        center1.add(rcb);
        center2.add(history);
        center2.add(logout);

        mum.add(center1);
        mum.add(center2);
        

        setJMenuBar(menubar);

        this.add(mum);

        PLAY();
    }

    private void PLAY() {
        JButton[] list = {
            history,
            rcb,
            button,
            logout
        };
          JMenu [] menus = {
              mainMenu,
            manage,
            order,
            userAdmin
            
          } ;
    JMenuItem [] menuItems = {
            recycle,
            anb,
            showOrders,
            manageOrder,
            manageUsers,
            manageAdmin
    };
        MENUS(menus);
        MENUITEMS(menuItems);
        BUTTONS(list);
    }

}

class EditAccount extends JFrame {

    JLabel fname,
            sname,
            username,
            email,
            pn,
            pf,
            pf2;

    JTextField _username,
            _sname,
            _email,
            _pn,
            _fname;

    JPasswordField _pf,
            _pf2;

    JButton register,
            reset;

    public EditAccount() {
        newAccount(this);

        this.setTitle(this.getTitle() + "BookStore | Admin User Edit");

        fname = new JLabel("  First Name");
        _fname = new JTextField();
        _fname.transferFocus();
        sname = new JLabel("  Second Name");
        _sname = new JTextField();
        _sname.transferFocus();
        username = new JLabel("  Username");
        _username = new JTextField();
        _username.transferFocus();
        email = new JLabel("  Email");
        _email = new JTextField();
        _email.transferFocus();
        pn = new JLabel("  Phone NO");
        _pn = new JTextField();
        _pn.transferFocus();
        pf = new JLabel("  EnterPassword");
        _pf = new JPasswordField(15);
        _pf.transferFocus();
        pf2 = new JLabel("  Re-enter Passowrd");
        _pf2 = new JPasswordField(15);

        register = new JButton("Update");

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new GridLayout(8, 2));
        contentPane.add(fname);
        contentPane.add(_fname);
        contentPane.add(sname);
        contentPane.add(_sname);
        contentPane.add(username);
        contentPane.add(_username);
        contentPane.add(email);
        contentPane.add(_email);
        contentPane.add(pn);
        contentPane.add(_pn);
        contentPane.add(pf);
        contentPane.add(_pf);
        contentPane.add(pf2);
        contentPane.add(_pf2);
        contentPane.add(register);

        register.addActionListener((a) -> {
            if (_pf.getText().equals(_pf2.getText())) {
                if (validatePassword(_pf2.getText())) {
                    if (validateEmail(_email.getText())) {
                        if (validatePhoneNumber(_pn.getText())) {
                            UpdateAdmin(_fname.getText().toUpperCase(), _sname.getText().toUpperCase(), _username.getText().toLowerCase(), _email.getText().toLowerCase(), _pn.getText(), generateHash(_pf2.getText()));
                        } else {
                            dialogPopUp("Error", "Enter a valid Phone Number");
                        }
                    } else {
                        dialogPopUp("Error", "Enter a valid Email");
                    }
                } else {
                    dialogPopUp("Error", "Enter a valid Password");
                }
            } else {
                dialogPopUp("Error", "The two passwords does not match");
            }
        });

        reset = new JButton("Reset");
        reset.addActionListener((d) -> {
            _fname.setText("");
            _sname.setText("");
            _pf.setText("");
            _pf2.setText("");
            _pn.setText("");
            _username.setText("");
            _email.setText("");
        });

        contentPane.add(reset);
        contentPane.setBackground(lightGray);
        setContentPane(contentPane);

        PLAY();
    }

    private void PLAY() {
        JLabel[] labels = {
            fname,
            sname,
            username,
            email,
            pn,
            pf,
            pf2
        };

        JTextField[] tf = {
            _username,
            _sname,
            _email,
            _pn,
            _fname
        };

        JPasswordField[] pwfs = {_pf,
            _pf2};

        JButton[] btns = {
            register,
            reset
        };

        LABELS(labels);
        TEXTFIELDS(tf);
        PASSWORDFIELDS(pwfs);
        BUTTONS(btns);
    }

}

/**
 * Manage Users Class As Admin.
 */
class manageUsers extends JFrame {

    JComboBox users;
    JLabel fname,
            user,
            lname,
            uname,
            email,
            phoneNumber,
            password1,
            password2;

    JTextField _fname,
            _lname,
            _uname,
            _phoneNumber,
            _email;
    JPasswordField _password1,
            _password2;

    JButton update,
            deleteUser,
            reset,
            close;
    JPanel contentPane,
            pic;

    public manageUsers() {
        this.setSize(800, 700);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        Dimension ss = java.awt.Toolkit.getDefaultToolkit().getScreenSize();

        setLocation(ss.width / 2 - getWidth() / 2, ss.height / 2 - getHeight() / 2);
        setResizable(false);
        setVisible(true);
        this.setTitle("BookStore | Manage Users");

        _phoneNumber = new JTextField();
        user = new JLabel("Select User ");
        user.setBounds(50, 50, 200, 50);
        contentPane = new JPanel();
        contentPane.setLayout(null);
        users = new JComboBox();
        users.addItem("--Select User--");
        users.addActionListener((t) -> {
            if (users.getSelectedItem().toString().equals("--Select User--")) {
                _fname.setText(null);
                _lname.setText(null);
                _uname.setText(null);
                _email.setText(null);
                _phoneNumber.setText(null);
                _password1.setText(null);
                _password2.setText(null);
            } else {
                try {
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore", "root", "");
                    String string = "select * from users where username = '" + users.getSelectedItem() + "'";
                    PreparedStatement ps = con.prepareStatement(string);
                    ResultSet rs = ps.executeQuery();

                    while (rs.next()) {
                        _fname.setText(rs.getString(3));
                        _lname.setText(rs.getString(4));
                        _uname.setText(rs.getString(7));
                        _email.setText(rs.getString(5));
                        _phoneNumber.setText(rs.getString(6));

                    }

                } catch (SQLException e) {
                    dialogPopUp("Error!", e.getMessage());
                }
            }

        });
        USERS(users);
        users.setBounds(250, 50, 200, 50);

        pic = new JPanel();
        JLabel pict = new JLabel();
        pict.setIcon(new ImageIcon(getClass().getResource("/images/picture.png")));

        pic.setBounds(570, 50, 230, 480);
        pic.add(pict);
        fname = new JLabel("First Name");
        fname.setBounds(10, 130, 200, 50);
        lname = new JLabel("Last Name");
        lname.setBounds(10, 200, 200, 50);
        uname = new JLabel("Username");
        uname.setBounds(10, 270, 200, 50);
        email = new JLabel("Email");
        email.setBounds(10, 340, 200, 50);
        phoneNumber = new JLabel("Phone NO");
        phoneNumber.setBounds(10, 410, 200, 50);
        password1 = new JLabel("Password");
        password1.setBounds(10, 480, 200, 50);
        password2 = new JLabel("Renter Pwd");
        password2.setBounds(10, 550, 210, 50);

        update = new JButton("Update");
        update.setBounds(40, 620, 150, 50);
        update.addActionListener((a) -> {
            if (_password1.getText().equals(_password2.getText())) {
                if (validatePassword(_password2.getText())) {
                    if (validateEmail(_email.getText())) {
                        if (validatePhoneNumber(_phoneNumber.getText())) {
                            UpdateUser(_fname.getText().toUpperCase(), _lname.getText().toUpperCase(), _uname.getText().toLowerCase(), _email.getText().toLowerCase(), _phoneNumber.getText(), generateHash(_password2.getText()), (String) users.getSelectedItem());
                            users.removeAllItems();
                            users.addItem("--Select User--");
                            USERS(users);
                        } else {
                            dialogPopUp("Error", "Enter a valid Phone Number");
                        }
                    } else {
                        dialogPopUp("Error", "Enter a valid Email");
                    }
                } else {
                    dialogPopUp("Error", "Enter a valid Password");
                }
            } else {
                dialogPopUp("Error", "The two passwords does not match");
            }
        });
        deleteUser = new JButton("Delete User");
        deleteUser.setBounds(200, 620, 250, 50);
        deleteUser.addActionListener((e) -> {
            if (!users.getSelectedItem().equals("--Select User--")) {
                DELETEUSER((String) users.getSelectedItem());
            }

        });
        reset = new JButton("Reset");
        reset.setBounds(470, 620, 110, 50);
        reset.addActionListener((e) -> {
            _fname.setText(null);
            _lname.setText(null);
            _uname.setText(null);
            _email.setText(null);
            _phoneNumber.setText(null);
            _password1.setText(null);
            _password2.setText(null);
            users.setSelectedIndex(0);
        });
        close = new JButton("Close");
        close.setBounds(580, 620, 150, 50);
        close.addActionListener((e) -> {
            if (JOptionPane.showConfirmDialog(this, "Do you want to save changes ", "Confirm close", JOptionPane.YES_NO_CANCEL_OPTION) == JOptionPane.YES_OPTION) {
                if (_password1.getText().equals(_password2.getText())) {
                    if (validatePassword(_password2.getText())) {
                        if (validateEmail(_email.getText())) {
                            if (validatePhoneNumber(_phoneNumber.getText())) {
                                UpdateUser(_fname.getText().toUpperCase(), _lname.getText().toUpperCase(), _uname.getText().toLowerCase(), _email.getText().toLowerCase(), _phoneNumber.getText(), generateHash(_password2.getText()), (String) users.getSelectedItem());
                                users.removeAllItems();
                                users.addItem("--Select User--");
                                USERS(users);
                            } else {
                                dialogPopUp("Error", "Enter a valid Phone Number");
                            }
                        } else {
                            dialogPopUp("Error", "Enter a valid Email");
                        }
                    } else {
                        dialogPopUp("Error", "Enter a valid Password");
                    }
                } else {
                    dialogPopUp("Error", "The two passwords does not match");
                }
            }else if (JOptionPane.showConfirmDialog(this, "Do you want to save changes ", "Confirm close", JOptionPane.YES_NO_CANCEL_OPTION) == JOptionPane.NO_OPTION){
                dispose();
            }
                
        });

        _fname = new JTextField();
        _fname.setBounds(250, 130, 200, 50);
        _lname = new JTextField();
        _lname.setBounds(250, 200, 200, 50);
        _uname = new JTextField();
        _uname.setBounds(250, 270, 300, 50);
        _email = new JTextField();
        _email.setBounds(250, 340, 300, 50);
        _phoneNumber.setBounds(250, 410, 200, 50);
        _password1 = new JPasswordField();
        _password1.setBounds(250, 480, 200, 50);
        _password2 = new JPasswordField();
        _password2.setBounds(250, 550, 200, 50);

        contentPane.add(user);
        contentPane.add(users);
        contentPane.add(fname);
        contentPane.add(lname);
        contentPane.add(uname);
        contentPane.add(email);
        contentPane.add(phoneNumber);
        contentPane.add(_phoneNumber);
        contentPane.add(password1);
        contentPane.add(password2);
        contentPane.add(_fname);
        contentPane.add(_lname);
        contentPane.add(_uname);
        contentPane.add(_email);
        contentPane.add(_password1);
        contentPane.add(_password2);
        contentPane.add(update);
        contentPane.add(deleteUser);
        contentPane.add(reset);
        contentPane.add(close);
        contentPane.add(pic);

        this.add(contentPane);

        PLAY();
    }

    private void PLAY() {
        JComboBox[] cbs = {users};
        JLabel[] labels = {fname,
            user,
            lname,
            uname,
            email,
            password1,
            password2,
            phoneNumber
        };

        JTextField[] tfs = {_fname,
            _lname,
            _uname,
            _email, _phoneNumber};

        JButton[] btns = {update,
            deleteUser,
            reset,
            close};

        JPasswordField[] pwfs = {
            _password1,
            _password2

        };

        COMBOBOXES(cbs);
        LABELS(labels);
        TEXTFIELDS(tfs);
        BUTTONS(btns);
        PASSWORDFIELDS(pwfs);
        contentPane.setBackground(lightGray);
        pic.setBackground(lightGray);;

    }

    public static void main(String[] args) {
        manageUsers mm = new manageUsers();
        mm.setVisible(true);

    }

}
