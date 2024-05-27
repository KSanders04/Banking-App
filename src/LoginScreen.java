import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LoginScreen extends JFrame{
    private JTextField userText;
    private JPasswordField passwordText;
    private ArrayList<Account> accountArrayList;

    public LoginScreen(ArrayList<Account> accountArrayList) {
        this.accountArrayList = accountArrayList;

        setTitle("Banking Application - Login");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2));

        JLabel userLabel = new JLabel("Username:");
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

            boolean authentication = false;
            for (Account account : accountArrayList){
                if (account.getUsername().equals(username) && account.getPassword().equals(password)){
                    authentication = true;
                    break;
                }
            }
            if (authentication){
                JOptionPane.showMessageDialog(null, "Login successful");
                new Dashboard();
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid login. Please try again.");
            }
        }
    }
}
