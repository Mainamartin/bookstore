package Orders;

import static base.common.dialogPopUp;
import static base.common.ordersBuy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

public class showOrders extends JFrame {

    JScrollPane panel;
    JTable table;

    public showOrders() {

        panel = new JScrollPane();
        table = new JTable();
        table.setFont(new java.awt.Font("DejaVu Serif", 1, 12));

        DisplayTable();

        panel.setViewportView(table);

        add(panel);
        ordersBuy(this);
        this.setTitle("BookStore | Orders");

    }

    public static void main(String[] args) {
        showOrders so = new showOrders();
        so.setVisible(true);
    }

    private void DisplayTable() {
        String sql = null;
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore", "root", "");
            sql = "select requestorname as '<html><b>User</b></html>', bookname as'<html><b>Book</b></html>', bookid as'<html><b>Id</b></html>', dateordered as'<html><b><tt>Date Ordered</tt></b></html>', dateapproved as '<html><b><tt>Approved Date</tt></b></html>', orderstatus as '<html><b>Order Status</b></html>' from orders order by dateapproved desc";
            
            PreparedStatement st  = con.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            
            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (SQLException e) {
            dialogPopUp("Error!", e.getMessage());
        }
        }
    }
