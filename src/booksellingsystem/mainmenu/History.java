package booksellingsystem.mainmenu;

import static base.common.ordersBuy;
import static database.database.CURRENTUSER;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

public class History extends JFrame {

    JTable table;
    JScrollPane sp;

    public History() {

        sp = new javax.swing.JScrollPane();
        table = new JTable();
        table.setFont(new java.awt.Font("DejaVu Serif", 1, 12));

        DisplayTable();

        sp.setViewportView(table);

        add(sp);

        ordersBuy(this);
        if (CURRENTUSER().equals("Admin")) {
            this.setTitle("BookStore | History ");
        } else {
            this.setTitle("BookStore | History of " + CURRENTUSER());
        }

    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {

            public void run() {
                History bb = null;

                bb = new History();

                bb.setVisible(true);
            }
        });
    }

    private void DisplayTable() {
        String sql = null;
        try {

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore", "root", "");

            if (CURRENTUSER().equals("Admin")) {

                sql = "select bookname as '<html><b>Book Name</b></html>', bookprice as '<html><b>Book Price </b></html>', booksubject as '<html><b> Book Subject</b></html>', dateborrowed as '<html><b>Date Borrowed </b></html>', dateapproved as '<html><b> Date Approved</b></html>', datedisbursed as '<html><b> Date Disbursed</b></html>', bookrecycled as '<html><b> Book Recycled </b></html>' from history ";
            } else {

                sql = "select bookname as '<html><b>Book Name</b></html>', bookprice as '<html><b>Book Price </b></html>', booksubject as '<html><b> Book Subject</b></html>', dateborrowed as '<html><b>Date Borrowed </b></html>', dateapproved as '<html><b> Date Approved</b></html>', datedisbursed as '<html><b> Date Disbursed</b></html>', bookrecycled as '<html><b> Book Recycled </b></html>' from history where username = '" + CURRENTUSER() + "'";
            }

            PreparedStatement st = con.prepareStatement(sql);

            ResultSet rs = st.executeQuery();

            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

}
