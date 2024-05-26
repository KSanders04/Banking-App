import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.*;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame{
    private double balance = 1000.00; // Initial balance

    public Dashboard() {
        setTitle("Banking Application - Dashboard");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JLabel welcomeLabel = new JLabel("Welcome to Your Banking Dashboard", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Serif", Font.BOLD, 24));
        add(welcomeLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 3));

        JButton balanceButton = new JButton("Check Balance");
        JButton depositButton = new JButton("Deposit Money");

        balanceButton.addActionListener(new BalanceButtonListener());
        depositButton.addActionListener(new DepositButtonListener());

        buttonPanel.add(balanceButton);
        buttonPanel.add(depositButton);

        add(buttonPanel, BorderLayout.CENTER);

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
}
