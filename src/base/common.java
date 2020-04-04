package base;

import static base.ValidateUser.generateHash;
import static database.database.verifyPassword;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class common {

    public static Font comic = (new java.awt.Font("Comic Sans MS", 1, 18));
    public static Font andika = (new java.awt.Font("Andika", 1, 18));
    public static Font arial = (new java.awt.Font("Arial", 1, 18));
    public static Font arialBlack = (new java.awt.Font("Arial Black", 1, 18));
    public static Font handwriting = (new java.awt.Font("Bradley HandITC", 1, 18));
    public static Font handwritingsmall = (new java.awt.Font("Bradley HandITC", 0, 12));
    public static Font handwritinghead = (new java.awt.Font("Bradley HandITC", 1, 20));
    public static Font calibri = (new java.awt.Font("Calibri", 1, 18));
    public static Font calibriLight = (new java.awt.Font("Calibri Light", 1, 18));
    public static Font courierNew = (new java.awt.Font("Courier New", 1, 18));
    public static Font dejavuSans = (new java.awt.Font("DejaVu Sans", 1, 18));
    public static Font elephant = (new java.awt.Font("Elephant", 1, 18));
    public static Font euclid = (new java.awt.Font("Euclid", 1, 18));
    public static Font freeMono = (new java.awt.Font("FreeMono", 1, 18));
    public static Font freeSans = (new java.awt.Font("FreeSans", 1, 18));
    public static Font freeSerif = (new java.awt.Font("FreeSErif", 1, 18));
    public static Font georgia = (new java.awt.Font("Georgia", 1, 18));
    public static Font gigi = (new java.awt.Font("Gigi", 1, 18));
    public static Font harrington = (new java.awt.Font("Harrington", 1, 18));
    public static Font jokerMan = (new java.awt.Font("Jokerman", 1, 18));
    public static Font lato = (new java.awt.Font("Lato", 1, 11));
    public static Font latoBlack = (new java.awt.Font("Lato Black", 1, 18));
    public static Font extraBold = (new java.awt.Font("Rockwell Extra Bold", 1, 18));
    public static Color red = Color.RED;
    public static Color blue = Color.BLUE;
    public static Color black = Color.BLACK;
    public static Color cyan = Color.CYAN;
    public static Color green = Color.GREEN;
    public static Color orange = Color.ORANGE;
    public static Color yellow = Color.YELLOW;
    public static Color pink = Color.PINK;
    public static Color magenta = Color.MAGENTA;
    public static Color darkGray = Color.DARK_GRAY;
    public static Color gray = Color.GRAY;
    public static Color lightGray = Color.LIGHT_GRAY;
    public static Color white = Color.WHITE;
    public static Color next;
    public static Color exit = new java.awt.Color(0, 255, 0);
    public static Color game = new java.awt.Color(200, 100, 200);
    public static Color reset;
    public static Color confirm;
    public static Color selecctLevel;
    public static LineBorder labelBorder = new javax.swing.border.LineBorder(new java.awt.Color(200, 0, 200), 1, true);
    public static LineBorder tfBorder = new javax.swing.border.LineBorder(new java.awt.Color(200, 100, 200), 2, true);
    public static LineBorder panelBorder = new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 255), 1, true);
    public static Color tfBg = new java.awt.Color(100, 100, 100);

    public static void makeFrameFullSize(JFrame f) {
        Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        f.setSize(screenSize.width, screenSize.height);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
    }


    public static void userhost(JFrame f) {
        Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        f.setSize(600, 320);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocation(screenSize.width / 2 - f.getWidth() / 2, screenSize.height / 2 - f.getHeight()
                / 2);
        f.setBackground(orange);
        f.setResizable(false);

    }

    public static void smallerscreen(JFrame f) {
        Dimension ss = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        f.setSize(500, 400);
        f.setLocation(ss.width / 2 - f.getWidth() / 2, ss.height / 2 - f.getHeight()
                / 2);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }

    public static void ordersBuy(JFrame f) {
        Dimension ss = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        f.setSize(933, 600);
        f.setLocation(ss.width / 2 - f.getWidth() / 2, ss.height / 2 - f.getHeight()
                / 2);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }

    public static void mainscreen(JFrame f) {
        Dimension ss = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        f.setSize(550, 300);
        f.setLocation(ss.width / 2 - f.getWidth() / 2, ss.height / 2 - f.getHeight()
                / 2);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void loginFrame(JFrame f) {
        Dimension ss = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        f.setSize(613, 350);
        f.setLocation(ss.width / 2 - f.getWidth() / 2, ss.height / 2 - f.getHeight() / 2);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setFont(new Font("CracklingFire", Font.PLAIN, 25));
        f.setResizable(false);
    }

    public static void newAccount(JFrame f) {
        f.setSize(800, 450);
        f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        Dimension ss = java.awt.Toolkit.getDefaultToolkit().getScreenSize();

        f.setLocation(ss.width / 2 - f.getWidth() / 2, ss.height / 2 - f.getHeight() / 2);
        f.setResizable(false);
        f.setVisible(true);
    }

    public static void dialogPopUp(String msgType, String msg) {
        JOptionPane.showMessageDialog(null, msg, msgType, JOptionPane.PLAIN_MESSAGE);
    }

    public static void BUTTONS(JButton x[]) {
        for (JButton x1 : x) {
//            x1.setFont(new Font("HighStyle", Font.PLAIN, 25));
            x1.setFont(new Font("JFRockOutcrop", Font.PLAIN, 25));
//            x1.setFont(new Font("Ruthless Dripping TWO", Font.PLAIN, 25));
//            x1.setFont(new Font("Street Art", Font.PLAIN, 25));
//            x1.setFont(new Font("HighStyle", Font.PLAIN, 25));
//            x1.setFont(new Font("CracklingFire", Font.PLAIN, 25));
            x1.setForeground(new Color(50, 50, 255));
            x1.setBackground(lightGray);
            x1.setBorder(null);

        }
    }

    public static void LABELS(JLabel x[]) {
        for (JLabel l : x) {
            l.setFont(new Font("ScrapItUp", Font.BOLD, 30));
            l.setForeground(tfBg);
            l.setBackground(lightGray);

        }
    }

    public static void RADIOBUTTONS(JRadioButton x[]) {
        for (JRadioButton x1 : x) {
            x1.setFont(new Font("JFRockOutcrop", Font.BOLD, 25));
            x1.setForeground(new Color(100, 0, 255));
            x1.setBackground(lightGray);
            x1.setHorizontalAlignment(SwingConstants.TRAILING);
        }
    }

    public static void PANELS(JPanel x[]) {
        for (JPanel p : x) {
            p.setBackground(lightGray);
        }
    }

    public static void COMBOBOXES(JComboBox x[]) {
        for (JComboBox x1 : x) {
            x1.setBackground(lightGray);
            x1.setFont(new Font("Ubuntu Bold", Font.BOLD, 20));

        }
    }

    public static void LABELSADD(JLabel x[]) {
        for (JLabel x1 : x) {
            x1.setFont(new Font("Ubuntu Bold", Font.BOLD, 20));
        }
    }

    public static void BUTTONSLOGIN(JButton x[]) {
        for (JButton x1 : x) {
            x1.setFont(new Font("This Night", Font.BOLD, 25));
            x1.setForeground(Color.BLACK);
            x1.setBackground(lightGray);
            x1.setBorder(null);
        }
    }

    public static void TEXTFIELDS(JTextField x[]) {
        for (JTextField x1 : x) {
            x1.setBorder(null);
            x1.setBackground(lightGray);
            x1.setFont(new Font("Sans Serif", Font.PLAIN, 25));
        }
    }

    public static void PASSWORDFIELDS(JPasswordField x[]) {
        for (JPasswordField x1 : x) {
            x1.setFont(new Font("Ubuntu Bold", Font.BOLD, 40));
            x1.setBackground(lightGray);
            x1.setBorder(null);

        }
    }
    
     public static boolean login(String username, String password) {

        boolean isAuthenticated = false;

        String hashedPassword = generateHash(password);

        if (hashedPassword.equals(verifyPassword(username, password))) {

            isAuthenticated = true;

        } else {

            isAuthenticated = false;

        }

        return isAuthenticated;

    }
     
     public static void MENUS(JMenu x[]){
         for(JMenu x1 : x){
             x1.setFont(new Font("CORONA COVID19", Font.BOLD, 15));
             x1.setForeground(black);
             x1.setBackground(white);
         }
     }
     
     public static void MENUITEMS(JMenuItem x[]){
         for(JMenuItem x1 : x){
             x1.setFont(new Font("CORONA COVID19", Font.BOLD, 15));
             x1.setForeground(black);
             x1.setBackground(white);
         }
     }
}
