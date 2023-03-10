package viewLayer;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;

public class SignUpView extends JFrame {

    private JPanel contentPane;
    private JTextField username;
    private JPasswordField password;
    private JTextField name;
    private JLabel lbPassword;
    private JLabel lbUsername;
    private JLabel lbName;
    private JLabel lbSignUp;
    private JButton signUpBtn;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SignUpView frame = new SignUpView();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public SignUpView() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 500, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(Color.green);
        setContentPane(contentPane);
        contentPane.setLayout(null);

        lbSignUp = new JLabel("Sign Up");
        lbSignUp.setHorizontalAlignment(SwingConstants.CENTER);
        lbSignUp.setFont(new Font("Times New Roman", Font.BOLD, 18));
        lbSignUp.setBounds(116, 29, 200, 39);
        lbSignUp.setForeground(Color.red);
        contentPane.add(lbSignUp);

        username = new JTextField();
        username.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        username.setColumns(10);
        username.setBounds(220, 136, 100, 20);
        contentPane.add(username);

        lbUsername = new JLabel("Utilizator:");
        lbUsername.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lbUsername.setBounds(104, 140, 90, 13);
        contentPane.add(lbUsername);

        lbPassword = new JLabel("Parola:");
        lbPassword.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lbPassword.setBounds(104, 178, 90, 13);
        contentPane.add(lbPassword);

        signUpBtn = new JButton("SIGN UP");
        signUpBtn.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        signUpBtn.setBounds(220, 218, 100, 22);
        signUpBtn.setForeground(Color.white);
        signUpBtn.setBackground(Color.magenta);
        contentPane.add(signUpBtn);

        password = new JPasswordField();
        password.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        password.setBounds(220, 176, 100, 20);
        contentPane.add(password);

        lbName = new JLabel("Nume:");
        lbName.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lbName.setBounds(104, 102, 90, 13);
        contentPane.add(lbName);

        name = new JTextField();
        name.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        name.setBounds(220, 100, 100, 20);
        contentPane.add(name);
    }

    public String getPassword() {
        return new String(password.getPassword());
    }

    public String getUsername() {
        return username.getText();
    }

    public String getName() {
        return name.getText();
    }

    public void addSignUpBtnListener(ActionListener actionListener) {
        signUpBtn.addActionListener(actionListener);
    }

    public void showError(String error) {
        JOptionPane.showMessageDialog(this, error);
    }

}
