package booksellingsystem;

import Users.manageUser;
import static base.common.BUTTONS;
import static base.common.LABELS;
import static base.common.TEXTFIELDS;
import static base.common.orange;
import static base.common.dialogPopUp;
import static base.common.userhost;
import booksellingsystem.mainmenu.BuyBooks;
import booksellingsystem.mainmenu.AddOldBooks;
import booksellingsystem.mainmenu.History;
import static database.database.CURRENTUSER;
import static database.database.LOGGEDOUT;
import static database.database.REQUESTBOOK;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UserHost extends JFrame {

    JButton history,
            rcb,
            logout,
            request,
            buyook;
    JPanel center1, center2, mum;
    JLabel label;

    public UserHost() {

        JPanel panel;
        JLabel bookname,
                bookwriter,
                booksubject;
        JTextField _bookname,
                _bookwriter,
                _booksubject;

        JButton add, cancel;
        panel = new JPanel();
        panel.setSize(400, 400);
        panel.setLayout(new GridLayout(4, 2));

        bookname = new JLabel("Book Name");
        _bookname = new JTextField(15);

        bookwriter = new JLabel("Author ");
        _bookwriter = new JTextField(15);

        booksubject = new JLabel("Subject");
        _booksubject = new JTextField(15);

        add = new JButton("Request");
        add.addActionListener((q) -> {

        });
        cancel = new JButton("Cancel");
        cancel.addActionListener((q) -> {
            _bookname.setText("");
            _bookwriter.setText("");
            _booksubject.setText("");
        });
        panel.add(bookname);
        panel.add(_bookname);
        panel.add(bookwriter);
        panel.add(_bookwriter);
        panel.add(booksubject);
        panel.add(_booksubject);
        panel.add(add);
        panel.add(cancel);

        userhost(this);

        JMenuBar menubar = new JMenuBar();

        JMenu mainMenu = new JMenu("Main Menu");
        menubar.add(mainMenu);

        JMenuItem buyBook = new JMenuItem("Buy Books");
        buyBook.addActionListener((a) -> {
            BuyBooks obj = new BuyBooks();
            obj.setVisible(true);
        });
        mainMenu.add(buyBook);

        JMenuItem recycle = new JMenuItem("Recycle your books");
        recycle.addActionListener((r) -> {
            AddOldBooks ads = new AddOldBooks();
            ads.setVisible(true);
        });
        mainMenu.add(recycle);

        JMenu manage = new JMenu("Manage");
        menubar.add(manage);

        JMenu userAdmin = new JMenu("User");
        manage.add(userAdmin);

        JMenuItem manageUsers = new JMenuItem("Manage your account");
        manageUsers.addActionListener((g) -> {
            manageUser mu = new manageUser();
            mu.setTitle("Manage your account |" + CURRENTUSER());
            mu.setVisible(true);
        });
        userAdmin.add(manageUsers);

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

        buyook = new JButton("Buy Books");
        buyook.addActionListener((a) -> {
            BuyBooks bb = new BuyBooks();
            bb.setVisible(true);
        });

        rcb = new JButton("Recycle");
        rcb.addActionListener((l) -> {

            AddOldBooks aob = new AddOldBooks();
            aob.setVisible(true);
        });

        history = new JButton("History");
        history.addActionListener((h) -> {

            History bb = new History();
            bb.setVisible(true);
        });
        history.setBounds(699, 197, 264, 118);

        request = new JButton("Request");
        request.addActionListener((ActionEvent r) -> {
            Request request1 = new Request();
            request1.setVisible(true);
        });
        request.setBounds(237, 366, 264, 118);

        label = new JLabel("Book Store | " + CURRENTUSER());
        label.setBounds(99, 84, 431, 86);
        this.setTitle(label.getText());

        center1.add(buyook);
        center1.add(request);
        center1.add(rcb);
        center2.add(history);
        center2.add(logout);

        mum.add(center1);
        mum.add(center2);

        this.add(mum);

        PLAY();

        menubar.setBounds(0, 0, 1008, 26);
        this.setJMenuBar(menubar);

    }

    private void PLAY() {
        JButton[] list = {
            history,
            rcb,
            buyook,
            request,
            logout

        };
        JLabel[] lbs = {
            label
        };
        BUTTONS(list);
        LABELS(lbs);
    }

    public static void main(String[] args) {
        UserHost uh = new UserHost();
        uh.setVisible(true);
    }
}

class Request extends JFrame {

    JPanel panel;
    JLabel bookname,
            bookwriter,
            booksubject;
    JTextField _bookname,
            _bookwriter,
            _booksubject;

    JButton add, cancel;

    Request() {
        Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setSize(600, 320);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocation(screenSize.width / 2 - getWidth() / 2, screenSize.height / 2 - getHeight()
                / 2);

        setResizable(false);
        setTitle("BookStore | Request Book");

        panel = new JPanel();
        panel.setSize(400, 400);
        panel.setLayout(new GridLayout(4, 2));

        bookname = new JLabel("Book Name");
        _bookname = new JTextField(15);

        bookwriter = new JLabel("Author ");
        _bookwriter = new JTextField(15);

        booksubject = new JLabel("Subject");
        _booksubject = new JTextField(15);

        add = new JButton("Request");
        add.addActionListener((q) -> {
            REQUESTBOOK(_bookname.getText(), _bookwriter.getText(), _booksubject.getText());
            dialogPopUp("Book Request", "Book requested, Your request is in processing. Thank you!");
            _bookname.setText("");
            _bookwriter.setText("");
            _booksubject.setText("");
        });
        cancel = new JButton("Cancel");
        cancel.addActionListener((q) -> {
            _bookname.setText("");
            _bookwriter.setText("");
            _booksubject.setText("");
            dispose();
        });
        panel.add(bookname);
        panel.add(_bookname);
        panel.add(bookwriter);
        panel.add(_bookwriter);
        panel.add(booksubject);
        panel.add(_booksubject);
        panel.add(add);
        panel.add(cancel);
        add(panel);
        
        PLAY();

    }
    private void PLAY(){
         JLabel [] labels = {bookname,
            bookwriter,
            booksubject};
    JTextField [] tfs = {_bookname,
            _bookwriter,
            _booksubject};

    JButton [] btns = {add, cancel};
    
    LABELS(labels);
    TEXTFIELDS(tfs);
    BUTTONS(btns);
    }
}
