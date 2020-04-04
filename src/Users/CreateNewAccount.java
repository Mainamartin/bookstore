package Users;

import static base.ValidateUser.generateHash;
import static base.ValidateUser.validateEmail;
import static base.ValidateUser.validatePassword;
import static base.ValidateUser.validatePhoneNumber;
import static base.common.dialogPopUp;
import static base.common.newAccount;
import static database.database.NewUserCreate;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

class CreateNewAccount extends JFrame {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                CreateNewAccount cna = new CreateNewAccount();
                cna.setVisible(true);
            }
        });
    }

    public CreateNewAccount() {
        newAccount(this);
        this.setTitle(this.getTitle() + "New User Register");

        JLabel fname = new JLabel("  First Name");
        JTextField _fname = new JTextField(15);
        _fname.transferFocus();
        JLabel sname = new JLabel("  Second Name");
        JTextField _sname = new JTextField(15);
        _sname.transferFocus();
        JLabel username = new JLabel("  Username");
        JTextField _username = new JTextField(15);
        _username.transferFocus();
        JLabel email = new JLabel("  Email");
        JTextField _email = new JTextField(15);
        _email.transferFocus();
        JLabel pn = new JLabel("  Phone NO");
        JTextField _pn = new JTextField();
        _pn.transferFocus();
        JLabel pf = new JLabel("  EnterPassword");
        JPasswordField _pf = new JPasswordField(15);
        _pf.transferFocus();
        JLabel pf2 = new JLabel("  Re-enter Passowrd");
        JPasswordField _pf2 = new JPasswordField(15);

        JButton register = new JButton("Register");
        JButton editUser = new JButton("Edit User Details");

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new GridLayout(9, 2));
        contentPane.add(fname);
        contentPane.add(_fname);
        contentPane.add(sname);
        contentPane.add(_sname);
        contentPane.add(username);
        contentPane.add(_username);
        contentPane.add(email);
        contentPane.add(_email);
        contentPane.add(pn);
        contentPane.add(_pn);
        contentPane.add(pf);
        contentPane.add(_pf);
        contentPane.add(pf2);
        contentPane.add(_pf2);
        contentPane.add(register);
        contentPane.add(editUser);

        register.addActionListener((a) -> {
            if (_pf.getText().equals(_pf2.getText())) {
                if (validatePassword(_pf2.getText())) {
                    if (validateEmail(_email.getText())) {
                        if (validatePhoneNumber(_pn.getText())) {
                            NewUserCreate(_fname.getText().toUpperCase(), _sname.getText().toUpperCase(), _username.getText().toLowerCase(), _email.getText().toLowerCase(), _pn.getText(), generateHash(_pf2.getText()));
                        } else {
                            dialogPopUp("Error", "Enter a valid Phone Number");
                        }
                    } else {
                        dialogPopUp("Error", "Enter a valid Email");
                    }
                } else {
                    dialogPopUp("Error", "Enter a valid Password");
                }
            } else {
                dialogPopUp("Error", "The two passwords does not match");
            }
        });

        JButton ahaa = new JButton("Have account? Sign in");
        ahaa.addActionListener((a) -> {
            dispose();
            UserLogin ul = new UserLogin();
            ul.setVisible(true);
        });
        

        JButton reset = new JButton("Reset");
        reset.addActionListener((d)->{
            _fname.setText("");
            _sname.setText("");
            _pf.setText("");
            _pf2.setText("");
            _pn.setText("");
            _username.setText("");
            _email.setText("");
        });
        
        contentPane.add(ahaa);
        contentPane.add(reset);
        setContentPane(contentPane);
    }
    
    public void keyPressed(KeyEvent evt){
        int key = evt.getKeyCode();
        switch(key){
            case KeyEvent.VK_Q:
                System.exit(0);
                break;
        }
        
    }

}
