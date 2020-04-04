package Users;

import static base.ValidateUser.generateHash;
import static base.common.BUTTONS;
import static base.common.LABELS;
import static base.common.PASSWORDFIELDS;
import static base.common.TEXTFIELDS;
import static base.common.dialogPopUp;
import static base.common.loginFrame;
import booksellingsystem.UserHost;
import static database.database.LOGGEDIN;
import static database.database.verifyPassword;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class UserLogin extends JFrame {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                UserLogin ul = new UserLogin();
                ul.setVisible(true);
            }
        });
    }

    JLabel label1, passfield;
    JButton ok, admin, cna, reset;
    JTextField user;
    JPasswordField pf;

    public UserLogin() {
        loginFrame(this);

        JPanel cp = new JPanel();
        cp.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(cp);
        cp.setBackground(Color.lightGray);
        cp.setLayout(new GridLayout(4, 2));

        label1 = new JLabel("Username");
        label1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/user3.png")));
        cp.add(label1);

        user = new JTextField();
        cp.add(user);

        passfield = new JLabel("Password ");
        passfield.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/key.png")));
        cp.add(passfield);

        pf = new JPasswordField();
        pf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent evt) {
                pfKeyPressed(evt);
            }

            private void pfKeyPressed(KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (login(user.getText(), pf.getText())) {
                        LOGGEDIN(user.getText());
                        dispose();
                        UserHost uh = new UserHost();
                        uh.setVisible(true);
                    } else {

                    }
                }
            }
        });
        cp.add(pf);

        ok = new JButton("Login");
        ok.addActionListener((ActionEvent w) -> {
            if (login(user.getText(), pf.getText())) {
                LOGGEDIN(user.getText());
                dispose();
                UserHost uh = new UserHost();
                uh.setVisible(true);
            } else {
                dialogPopUp("Error!", "Incorrect login details");
            }
        });
        cp.add(ok);

        admin = new JButton("Admin Login");
        admin.addActionListener((d) -> {
            dispose();
            AdminLogin al = new AdminLogin();
            al.setVisible(true);
        });
        cp.add(admin);

        cna = new JButton("Create Account");
        cna.addActionListener((c) -> {
            CreateNewAccount CNA = new CreateNewAccount();
            CNA.setVisible(true);
        });
        cp.add(cna);

        reset = new JButton("Reset");
        reset.addActionListener((r) -> {
            pf.setText("");
            user.setText("");
        });
        cp.add(reset);
        setTitle("Book Store | User Login");

        PLAY();
    }

    public boolean login(String username, String password) {

        boolean isAuthenticated = false;

        String hashedPassword = generateHash(password);

        if (hashedPassword.equals(verifyPassword(username, password))) {

            isAuthenticated = true;

        } else {

            isAuthenticated = false;

        }

        return isAuthenticated;

    }

    public void PLAY() {
        JLabel[] labels = {label1, passfield};
        JButton[] buttons = {ok, admin, cna, reset};

        JTextField[] tfs = {
            user
        };

        JPasswordField[] pwfs = {
            pf
        };

        LABELS(labels);
        BUTTONS(buttons);
        TEXTFIELDS(tfs);
        PASSWORDFIELDS(pwfs);

    }
}
