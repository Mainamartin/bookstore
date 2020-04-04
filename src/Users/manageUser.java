package Users;

import static base.ValidateUser.generateHash;
import static base.ValidateUser.validateEmail;
import static base.ValidateUser.validatePassword;
import static base.ValidateUser.validatePhoneNumber;
import static base.common.BUTTONS;
import static base.common.LABELS;
import static base.common.PASSWORDFIELDS;
import static base.common.TEXTFIELDS;
import static base.common.dialogPopUp;
import static base.common.newAccount;
import static database.database.CURRENTUSER;
import static database.database.UpdateUser;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class manageUser extends JFrame {

    JLabel fname,
            sname,
            username,
            email,
            pf,
            pf2,
            pn;

    JButton register,
            editUser,
            ahaa,
            reset;

    JTextField _fname,
            _sname,
            _username,
            _email,
            _pn;

    JPasswordField _pf,
            _pf2;

    public manageUser() {
        newAccount(this);

        this.setTitle("Update Yah Account | Mr "+ CURRENTUSER());

        fname = new JLabel("  First Name");

        _fname = new JTextField();
        _fname.transferFocus();
        sname = new JLabel("  Second Name");
        _sname = new JTextField();
        _sname.transferFocus();
        username = new JLabel("  Username");
        _username = new JTextField(CURRENTUSER());
        _username.transferFocus();
        email = new JLabel("  Email");
        _email = new JTextField();
        _email.transferFocus();
        pn = new JLabel("  Phone NO");
        _pn = new JTextField();
        _pn.transferFocus();
        pf = new JLabel("  EnterPassword");
        _pf = new JPasswordField(15);
        _pf.transferFocus();
        pf2 = new JLabel("  Re-enter Passowrd");
        _pf2 = new JPasswordField(15);

        register = new JButton("Update");
        editUser = new JButton("Edit User Details");
        editUser.setEnabled(false);

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
                            UpdateUser(_fname.getText().toUpperCase(), _sname.getText().toUpperCase(), _username.getText().toLowerCase(), _email.getText().toLowerCase(), _pn.getText(), generateHash(_pf2.getText()), CURRENTUSER());
                            
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

        ahaa = new JButton("Have account? Sign in");
        ahaa.addActionListener((a) -> {
            dispose();
            UserLogin ul = new UserLogin();
            ul.setVisible(true);
        });
        ahaa.setEnabled(false);

        reset = new JButton("Reset");
        reset.addActionListener((d) -> {
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

        PLAY();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                ArrayList ar = null;
                manageUser cna = new manageUser();
                cna.setVisible(true);

            }
        });
    }

    public void keyPressed(KeyEvent evt) {
        int key = evt.getKeyCode();
        switch (key) {
            case KeyEvent.VK_Q:
                System.exit(0);
                break;
        }

    }

    private void PLAY() {

        JLabel[] labels = {fname,
            sname,
            username,
            email,
            pf,
            pf2,
            pn
        };

        JButton[] butns = {register,
            editUser,
            ahaa,
            reset
        };

        JTextField[] tfs = {_fname,
            _sname,
            _username,
            _email,
            _pn
        };

        JPasswordField[] pfws = {
            _pf,
            _pf2
        };
        
        LABELS(labels);
        BUTTONS(butns);
        TEXTFIELDS(tfs);
        PASSWORDFIELDS(pfws);
    }

}
