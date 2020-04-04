package booksellingsystem.mainmenu;

import static base.common.ordersBuy;
import static database.database.displayBooks;
import static database.database.BUYBOOK;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

public class BuyBooks extends JFrame {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                BuyBooks bb = new BuyBooks();
                bb.setVisible(true);
            }
        });
    }
    JTable table;
    JScrollPane panel;

    public BuyBooks() {

        table = new JTable();

        panel = new JScrollPane();

        table.setModel(displayBooks());

        table.addMouseListener(new MouseAdapter() {
          public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableclicked(evt);
            }
        });

        panel.setViewportView(table);
        this.add(panel);

        ordersBuy(this);
        
    }

    private void tableclicked(java.awt.event.MouseEvent evt) {
        int i = table.getSelectedRow();
        TableModel model = table.getModel();

        if (JOptionPane.showConfirmDialog(null, "Do you wanna buy this Book?") == JOptionPane.YES_OPTION) {
            BUYBOOK(model.getValueAt(i, 0).toString(), Integer.parseInt(model.getValueAt(i, 2).toString()), model.getValueAt(i, 4).toString(), Integer.parseInt(model.getValueAt(i, 5).toString()));
        }
    }

    private void DisplayTable() {
        try {
            java.sql.Connection con = java.sql.DriverManager.getConnection("jdbc:mysql//localhodt:3306/bookstore", "root", "");
            java.sql.PreparedStatement ps = con.prepareStatement("SELECT * FROM booksdb");
            java.sql.ResultSet rs = ps.executeQuery();
            
            net.proteanit.sql.DbUtils.resultSetToTableModel(rs);
        } catch (Exception e) {
        }
    }
}
