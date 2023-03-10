package viewLayer;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class AdminView extends JFrame {
    private JPanel contentPane;
    private JButton importProductsBtn;
    private JLabel lbNewLabel;
    private JButton manageProductsBtn;
    private JButton generateReportsBtn;

    public AdminView() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 500, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(Color.cyan);
        setContentPane(contentPane);
        contentPane.setLayout(null);

        lbNewLabel = new JLabel("Meniu Administrator");
        lbNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lbNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
        lbNewLabel.setBounds(0, 0, 436, 73);
        contentPane.add(lbNewLabel);

        importProductsBtn = new JButton("Importa Produse");
        importProductsBtn.setFont(new Font("Times New Roman", Font.BOLD, 16));
        importProductsBtn.setBounds(128, 84, 191, 37);
        importProductsBtn.setBackground(Color.blue);
        importProductsBtn.setForeground(Color.white);
        contentPane.add(importProductsBtn);

        manageProductsBtn = new JButton("Manage Produse");
        manageProductsBtn.setFont(new Font("Times New Roman", Font.BOLD, 16));
        manageProductsBtn.setBounds(128, 131, 191, 37);
        manageProductsBtn.setBackground(Color.blue);
        manageProductsBtn.setForeground(Color.white);
        contentPane.add(manageProductsBtn);

        generateReportsBtn = new JButton("Genereaza Rapoarte");
        generateReportsBtn.setFont(new Font("Times New Roman", Font.BOLD, 16));
        generateReportsBtn.setBounds(128, 175, 191, 37);
        generateReportsBtn.setBackground(Color.blue);
        generateReportsBtn.setForeground(Color.white);
        contentPane.add(generateReportsBtn);
    }

    public void addManageProductsBtnActionListener(ActionListener actionListener) {
        manageProductsBtn.addActionListener(actionListener);
    }

    public void addGenerateReportsBtnActionListener(ActionListener actionListener) {
        generateReportsBtn.addActionListener(actionListener);
    }

    public void addImportProductsBtnActionListener(ActionListener actionListener) {
        importProductsBtn.addActionListener(actionListener);
    }

    public void showError(String error) {
        JOptionPane.showMessageDialog(this, error);
    }

}
