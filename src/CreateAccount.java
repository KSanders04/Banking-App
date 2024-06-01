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
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER,20,20));
        //buttonPanel.setLayout(new GridLayout(1, 2, 30, 30));

        JButton newAccount = new JButton("Create a New Account");
        JButton signIn = new JButton("Sign In");

        Dimension buttonSize = new Dimension(200, 50);
        newAccount.setPreferredSize(buttonSize);
        signIn.setPreferredSize(buttonSize);

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
            JPanel panel = new JPanel(new GridLayout(0, 1));

            JTextField firstNameField = new JTextField(20);
            JTextField lastNameField = new JTextField(20);
            JTextField usernameField = new JTextField(20);
            JPasswordField passwordField = new JPasswordField(20);

            panel.add(new JLabel("First Name:"));
            panel.add(firstNameField);
            panel.add(new JLabel("Last Name:"));
            panel.add(lastNameField);
            panel.add(new JLabel("Username:"));
            panel.add(usernameField);
            panel.add(new JLabel("Password:"));
            panel.add(passwordField);

            int result = JOptionPane.showConfirmDialog(null, panel, "Create a New Acount", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

            if (result == JOptionPane.OK_OPTION) {
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                String createUser = usernameField.getText();
                String createPassword = new String(passwordField.getPassword());

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
    }


    private class signInListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JPanel panel = new JPanel(new GridLayout(0, 1));

            JTextField usernameField = new JTextField(20);
            JPasswordField passwordField = new JPasswordField(20);

            panel.add(new JLabel("Username:"));
            panel.add(usernameField);
            panel.add(new JLabel("Password:"));
            panel.add(passwordField);

            int result = JOptionPane.showConfirmDialog(null, panel, "Login In", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

            if (result == JOptionPane.OK_OPTION) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                boolean authentication = false;
                for (Account account : accountArrayList){
                    if (account.getUsername().equals(username) && account.getPassword().equals(password)){
                        authentication = true;
                        break;
                    }
                }
                if (authentication){
                    JOptionPane.showMessageDialog(null, "Login successful");
                    new Dashboard(accountArrayList);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid login. Please try again.");
                }
            }
        }
    }
}
