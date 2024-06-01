import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Dashboard extends JFrame{
    private double balance = 0; // Initial balance

    public Dashboard(ArrayList<Account> accountArrayList) {
        setTitle("Banking Application - Dashboard");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel welcomeLabel = new JLabel("Welcome to Your Banking Dashboard", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Serif", Font.BOLD, 24));
        add(welcomeLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 2));

        JButton balanceButton = new JButton("Check Balance");
        JButton depositButton = new JButton("Deposit Money");
        JButton signOutButton = new JButton("Sign Out");

        balanceButton.addActionListener(new BalanceButtonListener());
        depositButton.addActionListener(new DepositButtonListener());
        signOutButton.addActionListener(new SignOutButtonListener());

        buttonPanel.add(balanceButton);
        buttonPanel.add(depositButton);
        buttonPanel.add(signOutButton);

        add(buttonPanel, BorderLayout.WEST);

        setVisible(true);
    }

    private class BalanceButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "Your current balance is: $" + balance);
        }
    }

    private class DepositButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String depositAmount = JOptionPane.showInputDialog("Enter amount to deposit:");
            if (depositAmount != null && !depositAmount.isEmpty()) {
                try {
                    double amount = Double.parseDouble(depositAmount);
                    if (amount > 0) {
                        balance += amount;
                        JOptionPane.showMessageDialog(null, "Deposit successful! New balance: $" + balance);
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid amount. Please enter a positive number.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number.");
                }
            }
        }
    }
    private class SignOutButtonListener implements ActionListener{
        @Override
        public  void actionPerformed(ActionEvent e){
            int confirmation = JOptionPane.showConfirmDialog(null, "Are you sure?","Confirm Sign-Out",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (confirmation == JOptionPane.YES_OPTION){
                dispose();
                new CreateAccount();
            }
        }
    }
}
