import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CreateAccount extends JFrame {
    private ArrayList<Account> accountArrayList = new ArrayList<>();

    public CreateAccount() {
        setTitle("Banking Application");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel welcomeLabel = new JLabel("Welcome to Banking Application", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Serif", Font.BOLD, 24));
        add(welcomeLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 2));

        JButton newAccount = new JButton("Create a New Account");
        JButton signIn = new JButton("Sign In");

        newAccount.addActionListener(new newAccountListener());
        signIn.addActionListener(new signInListener());

        buttonPanel.add(newAccount);
        buttonPanel.add(signIn);

        add(buttonPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    private class newAccountListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String firstName = JOptionPane.showInputDialog(null, "Please enter your first name");
            String lastName = JOptionPane.showInputDialog(null, "Please enter your last name");
            String createUser = JOptionPane.showInputDialog(null, "Please create a username");
            String createPassword = JOptionPane.showInputDialog(null, "Please create a password");

            if (firstName != null && lastName != null && createUser != null && createPassword != null
                    && !firstName.isEmpty() && !lastName.isEmpty() && !createUser.isEmpty() && !createPassword.isEmpty()) {
                Account newAccount = new Account(firstName, lastName, createUser, createPassword);
                accountArrayList.add(newAccount);
                JOptionPane.showMessageDialog(null, "Account create successfully");
            } else {
                JOptionPane.showMessageDialog(null, "All fields are required");
            }
        }
    }

    private class signInListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            LoginScreen login = new LoginScreen(accountArrayList);
        }
    }

    public static void main(String[] args) {
        new CreateAccount();
    }
}
