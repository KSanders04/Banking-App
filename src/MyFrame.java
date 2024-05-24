import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MyFrame extends JFrame implements ActionListener{

    JButton button;
    JPanel newPanel;
    JLabel username, password;
    JTextField textField1, textField2;

    MyFrame(){
        username = new JLabel();
        username.setText("Username");

        textField1 = new JTextField(15);

        JTextField textField2 = new JPasswordField(15);
        //password.setText("Password");

        button = new JButton("Submit");
        button.addActionListener(this);

        password = new JLabel();
        password.setText("Password");

        newPanel = new JPanel(new GridLayout(3, 1));
        newPanel.add(username);
        newPanel.add(password);
        newPanel.add(textField2);
        newPanel.add(button);

        add(newPanel, BorderLayout.CENTER);

        button.addActionListener(this);
        setTitle("Login");
/*
        textField.setPreferredSize((new Dimension(250, 40)));
        textField.setFont(new Font("Consolas", Font.BOLD, 35));
        textField.setText("Name");

        this.add(button);
        this.add(textField);
        this.pack();
        this.setVisible(true);
*/
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username = textField1.getText();
        String password = textField2.getText();

        if(username.equals("KSanders04") && password.equals("test")){
            NewPage page = new NewPage();

            page.setVisible(true);

            JLabel welcome = new JLabel("Welcome + username");
            page.getContentPane().add(welcome);
        }else{
            System.out.println("Invalid username or password");
        }



        if(e.getSource() == button){
            System.out.println("Welcome " + textField1.getText());
        }
    }
}
