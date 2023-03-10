package viewLayer;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class LogInView extends JFrame {

    private JPanel contentPane;
    private JLabel lblLogIn;
    private JPasswordField password;
    private JTextField username;
    private JButton signInBtn;
    private JLabel lbPassword;
    private JLabel lbUsername;
    private JLabel lbSignUp;
    private JButton signUpBtn;

    public LogInView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(Color.yellow);
        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblLogIn = new JLabel("Log In");
        lblLogIn.setFont(new Font("Times New Roman", Font.BOLD, 18));
        lblLogIn.setHorizontalAlignment(SwingConstants.CENTER);
        lblLogIn.setBounds(115, 33, 200, 39);
        lblLogIn.setForeground(Color.red);
        contentPane.add(lblLogIn);

        username = new JTextField();
        username.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        username.setBounds(219, 95, 96, 19);
        username.setBackground(Color.orange);
        contentPane.add(username);
        username.setColumns(10);

        lbUsername = new JLabel("Utilizator:");
        lbUsername.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lbUsername.setBounds(103, 99, 91, 13);
        lbUsername.setForeground(Color.red);
        contentPane.add(lbUsername);

        lbPassword = new JLabel("Parola:");
        lbPassword.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        lbPassword.setBounds(103, 144, 91, 13);
        lbPassword.setForeground(Color.red);
        contentPane.add(lbPassword);

        signInBtn = new JButton("SIGN IN");
        signInBtn.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        signInBtn.setBounds(219, 182, 96, 21);
        signInBtn.setForeground(Color.red);
        signInBtn.setBackground(Color.orange);
        contentPane.add(signInBtn);

        password = new JPasswordField();
        password.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        password.setBounds(219, 142, 96, 19);
        password.setBackground(Color.orange);
        contentPane.add(password);

        lbSignUp = new JLabel("Nu ai cont? Inregistreaza-te!");
        lbSignUp.setFont(new Font("Times New Roman", Font.BOLD, 12));
        lbSignUp.setBounds(321, 228, 190, 13);
        lbSignUp.setForeground(Color.red);
        contentPane.add(lbSignUp);

        signUpBtn = new JButton("Inregistrare");
        signUpBtn.setFont(new Font("Times New Roman", Font.BOLD, 16));
        signUpBtn.setBounds(348, 247, 125, 21);
        signUpBtn.setForeground(Color.red);
        signUpBtn.setBackground(Color.orange);
        contentPane.add(signUpBtn);
    }

    public String getPassword() {
        return new String(password.getPassword());
    }

    public String getUsername() {
        return username.getText();
    }

    public void addsignInBtnListener(ActionListener actionListener) {
        signInBtn.addActionListener(actionListener);
    }

    public void addSignUpBtnListener(ActionListener actionListener) {
        signUpBtn.addActionListener(actionListener);
    }

    public void showError(String error) {
        JOptionPane.showMessageDialog(this, error);
    }

}
