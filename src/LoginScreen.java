import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginScreen extends JFrame{
    private JTextField userText;
    private JPasswordField passwordText;

    public void LoginScreen() {
        setTitle("Banking Application - Login");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2));

        JLabel userLabel = new JLabel("User:");
        userText = new JTextField(20);
        JLabel passwordLabel = new JLabel("Password:");
        passwordText = new JPasswordField(20);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new LoginScreen.LoginButtonListener());

        add(userLabel);
        add(userText);
        add(passwordLabel);
        add(passwordText);
        add(new JLabel(""));
        add(loginButton);

        setVisible(true);
    }

    private class LoginButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = userText.getText();
            String password = new String(passwordText.getPassword());

            // Simple authentication check
            if ("user".equals(username) && "password".equals(password)) {
                new Dashboard();
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid login. Please try again.");
            }
        }
    }

}
