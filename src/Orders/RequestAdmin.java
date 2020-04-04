package Orders;

import java.awt.Font;

public class RequestAdmin extends javax.swing.JFrame {

    javax.swing.JScrollPane panel;
    javax.swing.JTable table;

    public RequestAdmin() {
        base.common.ordersBuy(this);
        setTitle("BookStore | Books Requested");
        panel = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {

                tablecc(evt);

            }
        });
        table.setFont(new Font("Sans Serif", Font.PLAIN, 13));
        table.setForeground(java.awt.Color.BLACK);
        
        panel.setViewportView(table);
        this.add(panel);

        DisplayTable();
    }

    private void tablecc(java.awt.event.MouseEvent evt) {
        if (javax.swing.JOptionPane.showConfirmDialog(null, "Book added?") == javax.swing.JOptionPane.YES_OPTION) {
            REQUESTCHECKED();
        }
    }

    private void DisplayTable() {
        try {
            java.sql.Connection con = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore", "root", "");
            java.sql.PreparedStatement ps = con.prepareStatement("select bookname as '<html><b>Name</b></html>', bookwriter as '<html><b>Author</b></html>', booksubject as '<html><b>Subject</b></html>', bookadded as '<html><b>Book Added?</b></html>', daterequested as '<html><b>Date Requested</b></html>', dateadded as '<html><b>Date Added</b></html>'from requested");
            java.sql.ResultSet rs = ps.executeQuery();

            table.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs));

        } catch (java.sql.SQLException e) {
            base.common.dialogPopUp("Database Error", e.getMessage());
        }
    }

    public static void main(String[] args) {
        RequestAdmin ra = new RequestAdmin();
        ra.setVisible(true);
    }

    private void REQUESTCHECKED() {
        int i = table.getSelectedRow();

        javax.swing.table.TableModel model = table.getModel();
        try {
            java.sql.Connection con = java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore", "root", "");
            java.sql.PreparedStatement ps = con.prepareStatement("UPDATE requested set bookadded = 'Yes', dateadded = CURDATE() where bookname = '" + model.getValueAt(i, 0) + "' AND bookwriter = '" + model.getValueAt(i, 1) + "' AND booksubject = '" + model.getValueAt(i, 2) + "'");
            ps.execute();
            DisplayTable();
        } catch (java.sql.SQLException e) {
        }
    }
}
