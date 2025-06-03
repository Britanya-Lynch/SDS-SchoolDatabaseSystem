import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.HashMap;

public class LoginGUI extends JFrame implements ActionListener {
    JPasswordField password;
    JTextField username;
    JLabel passwordLabel, usernameLabel, showPassword;
    JButton btn, reset_btn;
    JCheckBox showPasswordbox;

    HashMap<String, String> credentials = new HashMap<>();

    public LoginGUI() {
        credentials.put("kelly gomez", "J100TREE");
        credentials.put("donae clarke", "J101HOUSE");
        credentials.put("felicia donaldson", "J102BAG");
        credentials.put("leroy brown", "J103SHOES");
        credentials.put("john davis", "J104PHONE");
        credentials.put("kara smith", "J105GRASS");

        this.setSize(490, 400);
        this.setTitle("User Login");
        this.setLayout(null);

        usernameLabel = new JLabel("Name:");
        usernameLabel.setBounds(60, 80, 190, 30);
        username = new JTextField();
        username.setBounds(145, 80, 227, 32);

        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(60, 140, 100, 30);
        password = new JPasswordField();
        password.setBounds(145, 140, 227, 32);

        btn = new JButton("Sign in");
        btn.setBounds(120, 250, 100, 40);
        btn.addActionListener(this);

        showPasswordbox = new JCheckBox();
        showPasswordbox.setBounds(247, 190, 28, 30);
        showPasswordbox.addActionListener(this);

        showPassword = new JLabel("Show Password");
        showPassword.setBounds(275, 200, 120, 10);

        reset_btn = new JButton("Reset");
        reset_btn.setBounds(250, 250, 100, 40);
        reset_btn.addActionListener(this);

        this.add(password);
        this.add(passwordLabel);
        this.add(usernameLabel);
        this.add(username);
        this.add(btn);
        this.add(showPasswordbox);
        this.add(showPassword);
        this.add(reset_btn);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn) {
            String userText = username.getText().trim().toLowerCase();
            String pwdText = new String(password.getPassword());

            if (credentials.containsKey(userText)) {
                if (credentials.get(userText).equalsIgnoreCase(pwdText)) {
                    JOptionPane.showMessageDialog(this, "Hi " + username.getText() + ", you've logged in successfully!");
                    this.dispose();
                    new StudRecordsGUI();
                } else {
                    JOptionPane.showMessageDialog(this, "Incorrect password.");
                }
            } else {
                if (credentials.containsValue(pwdText)) {
                    JOptionPane.showMessageDialog(this, "Incorrect username.");
                } else {
                    JOptionPane.showMessageDialog(this, "Both username and password are incorrect.");
                }
            }
        }

        if (e.getSource() == reset_btn) {
            username.setText("");
            password.setText("");
        }

        if (e.getSource() == showPasswordbox) {
            password.setEchoChar(showPasswordbox.isSelected() ? (char) 0 : '*');
        }
    }
}
