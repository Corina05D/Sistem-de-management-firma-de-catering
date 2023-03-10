package viewLayer;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class GenerateReportsView extends JFrame {

    private JPanel contentPane;
    private JTextField clientsTimesOrdered;
    private JTextField amount;
    private JTextField productsTimesOrdered;
    private JTextField startHour;
    private JTextField endHour;
    private JTextField day;
    private JTextField month;
    private JTextField year;
    private JLabel lbNewLabel1;
    private JLabel lbNewLabel2;
    private JLabel lbNewLabel;
    private JButton generateReport1Btn;
    private JButton generateReport2Btn;
    private JButton generateReport3Btn;
    private JButton generateReport4Btn;
    private JLabel lbNewLabel3;
    private JLabel lbNewLabel4;
    private JLabel lbNewLabel5;
    private JLabel lbNewLabel6;
    private JLabel lbNewLabel8;
    private JLabel lbNewLabel9;
    private JLabel lbNewLabel10;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GenerateReportsView frame = new GenerateReportsView();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public GenerateReportsView() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 900, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(Color.yellow);
        setContentPane(contentPane);
        contentPane.setLayout(null);

        lbNewLabel = new JLabel("Genereaza Rapoarte");
        lbNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lbNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
        lbNewLabel.setBounds(0, 34, 730, 33);
        contentPane.add(lbNewLabel);

        lbNewLabel1 = new JLabel("Interval timp comenzi.      ora de start:");
        lbNewLabel1.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lbNewLabel1.setBounds(10, 77, 275, 26);
        contentPane.add(lbNewLabel1);

        lbNewLabel3 = new JLabel("Produse comandate mai mult de ");
        lbNewLabel3.setFont(new Font("Times New Roman", Font.BOLD, 12));
        lbNewLabel3.setBounds(10, 113, 250, 26);
        contentPane.add(lbNewLabel3);

        lbNewLabel5 = new JLabel("Clienti care au comandat mai mult de ");
        lbNewLabel5.setFont(new Font("Times New Roman", Font.BOLD, 12));
        lbNewLabel5.setBounds(10, 149, 250, 26);
        contentPane.add(lbNewLabel5);

        lbNewLabel6 = new JLabel("ori si valoarea comenzii a fost mai mare de ");
        lbNewLabel6.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lbNewLabel6.setBounds(299, 149, 310, 26);
        contentPane.add(lbNewLabel6);

        clientsTimesOrdered = new JTextField();
        clientsTimesOrdered.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        clientsTimesOrdered.setBounds(241, 154, 50, 20);
        contentPane.add(clientsTimesOrdered);
        clientsTimesOrdered.setColumns(10);

        amount = new JTextField();
        amount.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        amount.setColumns(10);
        amount.setBounds(613, 154, 50, 20);
        contentPane.add(amount);


        lbNewLabel4 = new JLabel(" ori pana acum.");
        lbNewLabel4.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lbNewLabel4.setBounds(248, 113, 310, 26);
        contentPane.add(lbNewLabel4);

        productsTimesOrdered = new JTextField();
        productsTimesOrdered.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        productsTimesOrdered.setColumns(10);
        productsTimesOrdered.setBounds(190, 118, 50, 20);
        contentPane.add(productsTimesOrdered);

        lbNewLabel2 = new JLabel("ora sfarsit:");
        lbNewLabel2.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lbNewLabel2.setBounds(393, 77, 100, 26);
        contentPane.add(lbNewLabel2);

        startHour = new JTextField();
        startHour.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        startHour.setColumns(10);
        startHour.setBounds(291, 82, 85, 20);
        contentPane.add(startHour);

        endHour = new JTextField();
        endHour.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        endHour.setColumns(10);
        endHour.setBounds(472, 82, 85, 20);
        contentPane.add(endHour);

        lbNewLabel8 = new JLabel("Produse comandate in data de :          zi:");
        lbNewLabel8.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lbNewLabel8.setBounds(10, 185, 270, 26);
        contentPane.add(lbNewLabel8);

        day = new JTextField();
        day.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        day.setColumns(10);
        day.setBounds(241, 189, 50, 20);
        contentPane.add(day);

        lbNewLabel9 = new JLabel("luna:");
        lbNewLabel9.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lbNewLabel9.setBounds(299, 185, 50, 26);
        contentPane.add(lbNewLabel9);

        month = new JTextField();
        month.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        month.setColumns(10);
        month.setBounds(351, 189, 50, 20);
        contentPane.add(month);

        lbNewLabel10 = new JLabel("an:");
        lbNewLabel10.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lbNewLabel10.setBounds(411, 185, 50, 26);
        contentPane.add(lbNewLabel10);

        year = new JTextField();
        year.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        year.setColumns(10);
        year.setBounds(454, 189, 50, 20);
        contentPane.add(year);

        generateReport4Btn = new JButton("Genereaza");
        generateReport4Btn.setFont(new Font("Times New Roman", Font.BOLD, 16));
        generateReport4Btn.setBounds(691, 189, 110, 21);
        contentPane.add(generateReport4Btn);

        generateReport3Btn = new JButton("Genereaza");
        generateReport3Btn.setFont(new Font("Times New Roman", Font.BOLD, 16));
        generateReport3Btn.setBounds(691, 153, 110, 21);
        contentPane.add(generateReport3Btn);

        generateReport2Btn = new JButton("Genereaza");
        generateReport2Btn.setFont(new Font("Times New Roman", Font.BOLD, 16));
        generateReport2Btn.setBounds(691, 117, 110, 21);
        contentPane.add(generateReport2Btn);

        generateReport1Btn = new JButton("Genereaza");
        generateReport1Btn.setFont(new Font("Times New Roman", Font.BOLD, 16));
        generateReport1Btn.setBounds(691, 81, 110, 21);
        contentPane.add(generateReport1Btn);
    }

    public int getStartHour() {
        return Integer.parseInt(startHour.getText());
    }

    public int getEndHour() {
        return Integer.parseInt(endHour.getText());
    }

    public int getAmount() {
        return Integer.parseInt(amount.getText());
    }

    public int getDay() {
        return Integer.parseInt(day.getText());
    }

    public int getMonth() {
        return Integer.parseInt(month.getText());
    }

    public int getYear() {
        return Integer.parseInt(year.getText());
    }

    public int getProductsTimesOrdered() {
        return Integer.parseInt(productsTimesOrdered.getText());
    }

    public int getClientsTimesOrdered() {
        return Integer.parseInt(clientsTimesOrdered.getText());
    }

    public void addGenerateReport1BtnActionListener(ActionListener actionListener) {
        generateReport1Btn.addActionListener(actionListener);
    }

    public void addGenerateReport2BtnActionListener(ActionListener actionListener) {
        generateReport2Btn.addActionListener(actionListener);
    }

    public void addGenerateReport3BtnActionListener(ActionListener actionListener) {
        generateReport3Btn.addActionListener(actionListener);
    }

    public void addGenerateReport4BtnActionListener(ActionListener actionListener) {
        generateReport4Btn.addActionListener(actionListener);
    }

    public void showError(String error) {
        JOptionPane.showMessageDialog(this, error);
    }

}