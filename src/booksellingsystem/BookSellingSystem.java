package booksellingsystem;

import Users.AdminLogin;
import Users.UserLogin;
import static base.ValidateUser.generateHash;
import static base.common.BUTTONS;
import static base.common.BUTTONSLOGIN;
import static base.common.mainscreen;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class BookSellingSystem extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    JButton AdminBtn, userBtn;

    /**
     * Main Screen Frame
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BookSellingSystem frame = new BookSellingSystem();
                    frame.setTitle("Book Selling System");
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

    public BookSellingSystem() {
        setIconImage(Toolkit.getDefaultToolkit().getImage("/usr/share/legion/images/linux-icon.png"));

        mainscreen(this);

        int width = this.getWidth();
        int height = this.getHeight();

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(Color.LIGHT_GRAY );
        setContentPane(contentPane);

        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Book Store");
        lblNewLabel.setForeground(new Color(200, 20, 20));
        lblNewLabel.setFont(new Font("Fine COllege", Font.BOLD, 75));
        lblNewLabel.setBounds(20, 0, 490, 100);

        contentPane.add(lblNewLabel);

        AdminBtn = new JButton("Admin");
        AdminBtn.addActionListener((a) -> {
            dispose();
            AdminLogin ad = new AdminLogin();
            ad.setVisible(true);
        });
        AdminBtn.setBounds(50, 200, 150, 30);
        AdminBtn.setBorderPainted(false);
        contentPane.add(AdminBtn);

        userBtn = new JButton("User Login");
        userBtn.addActionListener((a) -> {
            dispose();
            UserLogin ul = new UserLogin();
            ul.setVisible(true);
        });
        userBtn.setBounds(250, 200, 220, 30);
        userBtn.setBorderPainted(false);

        contentPane.add(userBtn);

        JLabel bsr = new JLabel("Buy Sell Recycle");
        bsr.setForeground(new Color(100, 055, 250));
        bsr.setFont(new Font("Planet Benson 2", Font.BOLD, 35));
        bsr.setBounds(60, 100, 450, 86);
        contentPane.add(bsr);

        PLAY();
    }

    private void PLAY() {

        JButton[] listbtns = {
            AdminBtn,
            userBtn
        };

        BUTTONSLOGIN(listbtns);
    }

}
