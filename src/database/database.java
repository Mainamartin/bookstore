package database;

import static base.common.dialogPopUp;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

public class database {

    public static final String url = "jdbc:mysql://localhost:3306/bookstore";
    public static final String pass = "";
    public static final String user = "root";

    public static String Password(String who) {
        String password = null;
        try {
            Connection con = DriverManager.getConnection(url, user, pass);

            String query = "select * from users where userclass='" + who + "' LIMIT 1";

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery(query);

            while (rs.next()) {
                password = rs.getString("password");

            }

        } catch (SQLException e) {
            dialogPopUp("Error!", e.getMessage());
        }
        return password;

    }

    public static void NewUserCreate(String fname, String lname, String uname, String email, String phoneNo, String password) {

        try {
            Connection con = DriverManager.getConnection(url, user, pass);

            PreparedStatement addUser
                    = con.prepareStatement("INSERT INTO users"
                            + "(first_name, last_name, username, phone_number, email, password, userclass)"
                            + "VALUES(?,?,?,?,?,?,?)"
                    );

            addUser.setString(1, fname);
            addUser.setString(2, lname);
            addUser.setString(3, uname);
            addUser.setString(4, phoneNo);
            addUser.setString(5, email);
            addUser.setString(6, password);
            addUser.setString(7, "User");

            addUser.executeUpdate();

        } catch (SQLException e) {
            dialogPopUp("Error!", e.getMessage());
        }

    }
//UpdateUser(_fname.getText().toUpperCase(), _lname.getText().toUpperCase(), _uname.getText().toLowerCase(), _email.getText().toLowerCase(), generateHash(_password2.getText()));
    public static void UpdateUser(String fname, String lname, String uname, String email, String phoneNo, String password, String username) {
        try {
            Connection con = DriverManager.getConnection(url, user, pass);

            PreparedStatement addUser
                    = con.prepareStatement("UPDATE users set first_name = ? ,last_name = ?, username = ?, phone_number = ?, email = ?,  password =?, userclass = ?  where username= ?");

            addUser.setString(1, fname);
            addUser.setString(2, lname);
            addUser.setString(3, uname);
            addUser.setString(4, phoneNo);
            addUser.setString(5, email);
            addUser.setString(6, password);
            addUser.setString(7, "User");
            addUser.setString(8, username);

            addUser.executeUpdate();
            dialogPopUp("Kudos!", "User Updated Successfully");
        } catch (SQLException e) {
            dialogPopUp("Error!", e.getMessage());
        }

    }

    public static void UpdateAdmin(String fname, String lname, String uname, String email, String phoneNo, String password) {
        try {
            Connection con = DriverManager.getConnection(url, user, pass);

            PreparedStatement addUser = con.prepareStatement("UPDATE users set first_name = ? ,last_name = ? username = ? phone_number = ? email = ?  password =? userclass = ? where username= ?");
            addUser.setString(1, fname);
            addUser.setString(2, fname);
            addUser.setString(3, fname);
            addUser.setString(4, fname);
            addUser.setString(5, fname);
            addUser.setString(6, fname);
            addUser.setString(7, "Admin");
            addUser.setString(8, CURRENTUSER());

            addUser.executeUpdate();
            dialogPopUp("Kudos!", "Admin credentials updated Successfully");
        } catch (SQLException e) {
            dialogPopUp("Error!", e.getMessage());

        }
    }

    public static void DELETEUSER(String username) {
        try {
            Connection con = DriverManager.getConnection(url, user, pass);
            
            PreparedStatement deleteUser = con.prepareStatement("DELETE FROM users WHERE username ='"+username+"' ");
            deleteUser.execute();
        } catch (SQLException e) {
            dialogPopUp("Error!", e.getMessage());
        }
    }
    
    public static void REQUESTBOOK(String bookname, String bookauthor, String booksubject){
        try {
            Connection con = DriverManager.getConnection(url, user, pass);
            
            PreparedStatement requestbook = con.prepareStatement("INSERT INTO requested (bookname, bookwriter, booksubject) VALUES('"+bookname+"', '"+bookauthor+"', '"+booksubject+"')");
            requestbook.execute();
        } catch (SQLException e) {
            dialogPopUp("Error!", e.getMessage());
        }
    }

    public static void BUYBOOK(int id){
        
    }
    public static TableModel displayBooks() {
        ResultSet rs = null;
        try {

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore", "root", "");
            String sql = "select bookname as '<html><b>Book Name</b></html>', writername as '<html><b>Author</b></html>', price as '<html><b>Price</b></html>', bookcondition as '<html><b>Condition</b></html>', subject as '<html><b> Subject</b></html>', id as '<html><b>Book Id</b></html>' from booksdb";
            PreparedStatement st = con.prepareStatement(sql);
            rs = st.executeQuery();

        } catch (SQLException e) {
            dialogPopUp("Error!", e.getMessage());
        }
        return DbUtils.resultSetToTableModel(rs);
    }

    public static TableModel displayHistory() {

        ResultSet rs = null;

        String username = null;
        try {
            final Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstore", "root",
                    "");

            String sql1 = "select username from loggedin";
            PreparedStatement st1 = con.prepareStatement(sql1);
            ResultSet rs1 = st1.executeQuery();

            while (rs1.next()) {
                username = rs1.getString("username");
            }

            String sql = "select bookname as '<html><b>Book Name</b></html>', bookprice, booksubject, dateborrowed, dateapproved, datedisbursed, bookrecycled from history where username = '" + username + "'";
            final PreparedStatement st = con.prepareStatement(sql);
            rs = st.executeQuery();

        } catch (SQLException e) {
            dialogPopUp("Error!", e.getMessage());
        }
        return DbUtils.resultSetToTableModel(rs);
    }

    public static String verifyPassword(String username, String password) {

        String storedHashedPassword = null;

        try {

            Connection con = DriverManager.getConnection(url, user, pass);

            String query = "select * from users where username ='" + username + "' ";

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery(query);

            while (rs.next()) {

                storedHashedPassword = rs.getString("password");

            }

        } catch (SQLException e) {
            dialogPopUp("Error!", e.getMessage());
        }

        return storedHashedPassword;
    }

    public static void ADDBOOK(String name, String writer, String condition, String source, String publisher, String subject, String price, String day, String month, String year) {

        int mon = 0;
        String[] months = {
            "Jan",
            "Feb",
            "Mar",
            "Apr",
            "May",
            "Jun",
            "Jul",
            "Aug",
            "Sep",
            "Oct",
            "Nov",
            "Dec"
        };

        for (int i = 0; i < months.length; i++) {
            if (month.equalsIgnoreCase(months[i])) {
                mon = i;
            }
        }
        try {
            Connection con = DriverManager.getConnection(url, user, pass);
            PreparedStatement addBook = con.prepareStatement("INSERT INTO booksdb "
                    + "(bookname, writername, datePublished, price, publishername, source, bookcondition, subject) "
                    + "VALUES('" + name + "','" + writer + "','" + year + "-" + mon + "-" + day + "','" + price + "','" + publisher + "','" + source + "','" + condition + "','" + subject + "')"
            );

            addBook.execute();

            dialogPopUp("Book Added", name + " added Successfully");
        } catch (SQLException e) {
            dialogPopUp("Sorry, Error!", e.getMessage());
        }
    }

    public static String[] SUBJECTS() {

        String[] list = null;

        try {
            Connection con = DriverManager.getConnection(url, user, pass);

            String query = "select * from subjects";

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery(query);

            ArrayList newlist;

            int rowNumber = 0;
            while (rs.next()) {
                rowNumber++;
            }

            for (int i = 0; i < rowNumber; i++) {
                while (rs.next()) {
                    list[i] = rs.getString(1);
                }
            }

        } catch (SQLException e) {
            dialogPopUp("Error!", e.getMessage());
        }
        return list;

    }

    public static void SHOWORDERS() {

    }

    public static void MANAGEORDERS() {

    }

    public static void manageUser(String username) {

    }

    public static ArrayList LOGGED(String usern) {
        String username, first_name, last_name, email, phone_number;
        ArrayList arr = null;

        try {

            Connection con = DriverManager.getConnection(url, user, pass);

            String query = "select * from users where username ='" + usern + "' ";

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery(query);

            while (rs.next()) {

                username = usern;
                first_name = rs.getString("first_name");
                last_name = rs.getString("last_name");
                email = rs.getString("email");
                phone_number = rs.getString("phone_number");
                arr.add(1, username);
                arr.add(2, first_name);
                arr.add(3, last_name);
                arr.add(4, email);
                arr.add(5, phone_number);
            }

        } catch (SQLException e) {
            dialogPopUp("Error!", e.getMessage());
        }
        return arr;
    }

    public static void LOGGEDIN(String email) {
        try {
            Connection con = DriverManager.getConnection(url, user, pass);
            PreparedStatement addBook = con.prepareStatement("INSERT INTO loggedin "
                    + "(username) "
                    + "VALUES('" + email + "')"
            );

            addBook.execute();
        } catch (SQLException e) {
            dialogPopUp("Error!", e.getMessage());
        }

    }

    public static String CURRENTUSER() {
        String cu = null;
        try {
            Connection con = DriverManager.getConnection(url, user, pass);
            PreparedStatement whoIsIn = con.prepareStatement("select * from loggedin");
            ResultSet rs = whoIsIn.executeQuery();
            while (rs.next()) {
                cu = rs.getString("username");
            }
        } catch (SQLException e) {
            dialogPopUp("Error!", e.getMessage());
        }
        return cu;

    }

    public static void LOGGEDOUT() {
        try {
            Connection con = DriverManager.getConnection(url, user, pass);
            PreparedStatement addBook = con.prepareStatement("DELETE FROM loggedin");

            addBook.execute();
        } catch (SQLException e) {
            dialogPopUp("Error!", e.getMessage());
        }

    }

    public static void MODIFYUSERS() {
        try {
            Connection con = DriverManager.getConnection(url, user, pass);
            Statement st = con.createStatement();

//            File file = new File("Avatars/avatar2.png");
            File file = new File("file:///root/NetBeansProjects/BookSellingSystem/src/Avatars/avatar3.png");
//            Image image = new Image(getClass().getResource("/Avatars/avatar2.png"));
            FileInputStream fis = new FileInputStream(file);

            PreparedStatement ps = con.prepareStatement("insert into users (image) values(?) where userclass = 'Admin'");
//
            ps.setBinaryStream(1, fis, (int) file.length());
            ps.executeUpdate();

            ps.close();
            fis.close();
            con.close();
        } catch (Exception e) {
            dialogPopUp("Error!", e.getMessage());
        }
    }

    public static JComboBox BOOKSINDATABASE(JComboBox x) {
        try {
            Connection con = DriverManager.getConnection(url, user, pass);
            PreparedStatement ps = con.prepareStatement("select bookname from booksdb");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                x.addItem(rs.getString(1));
            }
        } catch (Exception e) {
        }
        return x;
    }

    public static void BUYBOOK(String bookname, int bookprice, String booksubject, int bookid) {
        try {
            Connection con = DriverManager.getConnection(url, user, pass);
            PreparedStatement ps = con.prepareStatement("insert into history (username, bookname, bookprice, booksubject, dateborrowed) VALUES('" + CURRENTUSER() + "','" + bookname + "','" + bookprice + "','" + booksubject + "', CURDATE())");
            PreparedStatement ps1 = con.prepareStatement("INSERT INTO orders (requestorname, bookname, bookid, bookprice) VALUES('"+CURRENTUSER()+"', '"+bookname+"', '"+bookid+"', '"+bookprice+"')");
            ps.execute();
            ps1.execute();
            dialogPopUp("Message!", "Order Sent, Wait for Approval");
        } catch (SQLException e) {
            dialogPopUp("Error!", e.getMessage());
        }
    }

    public static JComboBox USERS(JComboBox x) {
        try {
            Connection con = DriverManager.getConnection(url, user, pass);
            PreparedStatement ps = con.prepareStatement("Select username from users");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                x.addItem(rs.getString(1));
            }
        } catch (Exception e) {
        }
        return x;
    }
}
