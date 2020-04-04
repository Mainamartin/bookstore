package booksellingsystem.mainmenu;

import static base.common.dialogPopUp;
import static base.common.smallerscreen;
import static database.database.ADDBOOK;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class AddNewBooks extends JFrame {

    JPanel panelbig,
            panellr,
            panelleft,
            panelright,
            panelbottom;

    JLabel booksName,
            writersName,
            condition,
            datePublished,
            price,
            publisherName,
            subec,
            source;

    JTextField _booksName,
            _writersName,
            _price,
            _publisherName,
            _source;

    JRadioButton _condition,
            old;

    JButton add,
            reset;

    JComboBox date,
            month,
            year,
            subjects;
    String months[] = {
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
    String subs[] = {
        "English",
        "Kiswahili",
        "Mathematics",
        "Social Studies",
        "CRE",
        "IRE",
        "Civics",
        "Geography",
        "History",
        "Music",
        "HomeScience",
        "Chemistry",
        "Biology",
        "Physics",
        "Business Studies",
        "Ethics",
        "Computer",
        "Others"
    };

    public AddNewBooks() {

        booksName = new JLabel("Boook's Name :- ");

        writersName = new JLabel("Writer(s) Name :- ");

        condition = new JLabel("Condition :- ");

        _booksName = new JTextField();

        _writersName = new JTextField();

        _condition = new JRadioButton("New");
        _condition.setSelected(true);
        _condition.setEnabled(true);

        old = new JRadioButton("Old");
        old.setSelected(false);
        old.setEnabled(false);

        datePublished = new JLabel("Date Published");

        publisherName = new JLabel("Publisher Name");
        _publisherName = new JTextField();

        date = new JComboBox();
        for (int i = 1; i <= 31; i++) {

            date.addItem(String.valueOf(i));
        }

        month = new JComboBox();
        for (int i = 0; i < months.length; i++) {
            month.addItem(months[i]);
            System.out.println(months[i]);
        }

        year = new JComboBox();
        for (int i = 1900; i <= 2020; i++) {
            year.addItem(i);
        }
        subjects = new JComboBox<>();
        for (String s : subs) {
            subjects.addItem(s);
        }

        subec = new JLabel("Subject");

        price = new JLabel("Price (KES) :- ");

        _price = new JTextField();

        source = new JLabel("Source :- ");

        _source = new JTextField();

        add = new JButton("Add");
        add.addActionListener((w) -> {
            if (JOptionPane.showConfirmDialog(this, "Sure to add") == 0) {
                String name = _booksName.getText(),
                        writer = _writersName.getText(),
                        condition = "New",
                        sourc = _source.getText(),
                        subje = (String) subjects.getSelectedItem(),
                        prc = _price.getText(),
                        publi = _publisherName.getText(),
                        dat = date.getSelectedItem().toString(),
                        mth = month.getSelectedItem().toString(),
                        yr = year.getSelectedItem().toString();

                if (name != null && writer != null && sourc != null && prc != null) {

                    ADDBOOK(name, writer, "New", sourc, publi, subje, prc, dat, mth, yr);

                } else {
                    dialogPopUp("Error!", "Fill in al the fields");
                }

            }
        });

        reset = new JButton("Reset");
        reset.addActionListener((a) -> {
            _booksName.setText(null);
            _writersName.setText(null);
            _price.setText(null);
            _publisherName.setText(null);
            _source.setText(null);
        });

        panelleft = new JPanel();
        panelleft.setLayout(new GridLayout(1, 3));
        panelleft.add(date);
        panelleft.add(month);
        panelleft.add(year);

        panelright = new JPanel();
        panelright.setLayout(new GridLayout(1, 2));
        panelright.add(_condition);
        panelright.add(old);

        panelbig = new JPanel();
        panelbig.setLayout(new GridLayout(9, 2));

        panelbig.add(booksName);
        panelbig.add(_booksName);
        panelbig.add(writersName);
        panelbig.add(_writersName);
        panelbig.add(datePublished);
        panelbig.add(panelleft);
        panelbig.add(price);
        panelbig.add(_price);
        panelbig.add(publisherName);
        panelbig.add(_publisherName);
        panelbig.add(source);
        panelbig.add(_source);
        panelbig.add(condition);
        panelbig.add(panelright);
        panelbig.add(subec);
        panelbig.add(subjects);
        panelbig.add(add);
        panelbig.add(reset);

        add(panelbig);

        PLAY();

        smallerscreen(this);
        this.setTitle("Book Store | Add Book");
    }

    public static void main(String[] args) {
        AddNewBooks anb = new AddNewBooks();
        anb.setVisible(true);
    }

    private void PLAY() {

    }

}
