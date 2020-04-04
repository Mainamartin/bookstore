package Orders;

import static base.common.dialogPopUp;
import static base.common.ordersBuy;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;

public class manageOrders extends JFrame {

    JPanel panel, sm, bg;
    JLabel l1, l2, l3, l4, l5;
    JScrollPane sp;
    JTable table;

    JRadioButton approve, deny, cancel;
    ButtonGroup but;
    JTextField _l1, _l2, _l3, _l4;

    public manageOrders() {

        sp = new JScrollPane();
        table = new JTable();
        table.setFont(new Font("Sans Serif", 0, 11));
        sp.setBounds(500, 0, 400, 600);

        DisplayTable();

        sp.setViewportView(table);

        JPanel rdbts = new JPanel();
        rdbts.setLayout(new GridLayout(1, 3));

        approve = new JRadioButton("Approve");
        deny = new JRadioButton("Deny");
        cancel = new JRadioButton("Cancel");
        but = new ButtonGroup();
        but.add(deny);
        but.add(approve);
        rdbts.add(approve);
        rdbts.add(deny);
        rdbts.add(cancel);

        l1 = new JLabel("Username");
        l1.setBounds(20, 100, 200, 50);
        _l1 = new JTextField(15);
        _l1.setBounds(250, 100, 200, 50);
        l2 = new JLabel("Book Ordered");
        l2.setBounds(20,200,200,50);
        _l2 = new JTextField();
        _l2.setBounds(250,200,200,50);
        l3 = new JLabel("Date Ordered");
        _l3 = new JTextField();
        l4 = new JLabel("Order id");
        _l4 = new JTextField();
        l5 = new JLabel("Approve ?");

        add(sp);
        add(l1);
        add(_l1);

        ordersBuy(this);
        this.setTitle("BookStore | Orders");

    }

    public static void main(String[] args) {
        manageOrders mn = new manageOrders();
        mn.setVisible(true);
    }

    private void DisplayTable() {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore", "root", "");
            String query = "select bookName,  bookprice, dateordered, orderstatus from orders ";

            PreparedStatement st = con.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {
            dialogPopUp("Error", e.getMessage());
        }
    }
}
