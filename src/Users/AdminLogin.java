package Users;

import static base.ValidateUser.generateHash;
import static base.common.loginFrame;
import static base.common.*;
import booksellingsystem.AdminHost;
import static database.database.LOGGEDIN;
import static database.database.Password;
import static database.database.verifyPassword;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public final class AdminLogin extends JFrame {

    JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AdminLogin frame = new AdminLogin();
                    frame.setTitle("Book Hub | Admin Login");;
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    JButton userLogin, ok;
    JLabel lp, lu;
    JTextField textField;
    JPasswordField pf;

    public AdminLogin() {
        setResizable(false);
        loginFrame(this);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(3, 2));

        this.setTitle("Book Store Login");
        lu = new JLabel("Username");
        lu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/user3.png")));

        contentPane.add(lu);
        textField = new JTextField();
        textField.setColumns(15);
        textField.setText("Admin");

        textField.setEditable(false);
        contentPane.add(textField);

        lp = new JLabel("Password");
        lp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/key.png")));

        contentPane.setBackground(lightGray);
        contentPane.add(lp);

        pf = new JPasswordField();
        pf.addKeyListener(new KeyAdapter() {

            public void Pressed(KeyEvent evt) {
                pfressed(evt);
            }

            private void pfressed(KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (login(textField.getText(), pf.getText())) {
                        LOGGEDIN(textField.getText());
                        dispose();
                        AdminHost ah = new AdminHost();
                        ah.setVisible(true);
                    } else {
                        dialogPopUp("Error!", "Incorrect login details");
                    }
                }
            }
        });
        /**
         * if (Password(textField.getText()).equals(generateHash(pf.getText())))
         * { LOGGEDIN(textField.getText()); dispose(); AdminHost ah = new
         * AdminHost(); ah.setVisible(true); } else { dialogPopUp("Error!",
         * "Wrong login details"); } } } .
         */

        contentPane.add(pf);

        ok = new JButton("Login");
        ok.addActionListener((a) -> {
            if (login(textField.getText(), pf.getText())) {
                LOGGEDIN(textField.getText());
                dispose();
                AdminHost ah = new AdminHost();
                ah.setVisible(true);
            } else {
                dialogPopUp("Error!", "Incorrect login details");
            }

        });
        contentPane.add(ok);

        userLogin = new JButton("User Login");
        userLogin.addActionListener((q) -> {
            dispose();
            UserLogin ul = new UserLogin();
            ul.setVisible(true);
        });

        contentPane.add(userLogin);

        PLAY();

    }

    public void PLAY() {

        JButton[] btns = {userLogin, ok};
        JLabel[] lbs = {lp, lu};
        JTextField[] tfs = {textField};
        JPasswordField[] pwfs = {pf};

        BUTTONS(btns);
        LABELS(lbs);
        TEXTFIELDS(tfs);
        PASSWORDFIELDS(pwfs);

    }

   
}
