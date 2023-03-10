package viewLayer;

import businessLayer.BaseProduct;
import businessLayer.MenuItem;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AddProductView extends JFrame {

    private JPanel contentPane;
    private JLabel lbNewLabel;
    private JTextField title;
    private JTextField raiting;
    private JTextField price;
    private JTextField proteins;
    private JTextField calories;
    private JTextField sodium;
    private JTextField fat;
    private JLabel titleLb;
    private JLabel raitingLb;
    private JLabel priceLb;
    private JLabel proteinsLb;
    private JLabel caloriesLb;
    private JLabel sodiumLb;
    private JLabel fatLb;
    private JButton addButton;

    public AddProductView() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 500, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(Color.yellow);
        setContentPane(contentPane);
        contentPane.setLayout(null);

        lbNewLabel = new JLabel("Adauga produs nou in Meniu");
        lbNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lbNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
        lbNewLabel.setBounds(121, 36, 240, 31);
        lbNewLabel.setForeground(Color.blue);
        contentPane.add(lbNewLabel);

        titleLb = new JLabel("Titlu:");
        titleLb.setFont(new Font("Times New Roman", Font.BOLD, 16));
        titleLb.setBounds(55, 78, 56, 22);
        titleLb.setForeground(Color.blue);
        contentPane.add(titleLb);

        title = new JTextField();
        title.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        title.setBounds(121, 81, 240, 19);
        title.setBackground(Color.orange);
        contentPane.add(title);
        title.setColumns(10);

        raitingLb = new JLabel("Raiting:");
        raitingLb.setFont(new Font("Times New Roman", Font.BOLD, 16));
        raitingLb.setBounds(55, 118, 56, 22);
        raitingLb.setForeground(Color.blue);
        contentPane.add(raitingLb);

        raiting = new JTextField();
        raiting.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        raiting.setBounds(121, 121, 78, 19);
        raiting.setBackground(Color.orange);
        contentPane.add(raiting);
        raiting.setColumns(10);

        priceLb = new JLabel("Pret:");
        priceLb.setFont(new Font("Times New Roman", Font.BOLD, 16));
        priceLb.setBounds(217, 118, 56, 22);
        priceLb.setForeground(Color.blue);
        contentPane.add(priceLb);

        price = new JTextField();
        price.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        price.setColumns(10);
        price.setBounds(283, 121, 78, 19);
        price.setBackground(Color.orange);
        contentPane.add(price);

        proteinsLb = new JLabel("Proteine:");
        proteinsLb.setFont(new Font("Times New Roman", Font.BOLD, 16));
        proteinsLb.setBounds(55, 150, 70, 22);
        proteinsLb.setForeground(Color.blue);
        contentPane.add(proteinsLb);

        proteins = new JTextField();
        proteins.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        proteins.setColumns(10);
        proteins.setBounds(121, 153, 78, 19);
        proteins.setBackground(Color.orange);
        contentPane.add(proteins);

        caloriesLb = new JLabel("Calorii:");
        caloriesLb.setFont(new Font("Times New Roman", Font.BOLD, 16));
        caloriesLb.setBounds(217, 150, 56, 22);
        caloriesLb.setForeground(Color.blue);
        contentPane.add(caloriesLb);

        calories = new JTextField();
        calories.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        calories.setColumns(10);
        calories.setBounds(283, 153, 78, 19);
        calories.setBackground(Color.orange);
        contentPane.add(calories);

        sodiumLb = new JLabel("Sodiu:");
        sodiumLb.setFont(new Font("Times New Roman", Font.BOLD, 16));
        sodiumLb.setBounds(55, 182, 56, 22);
        sodiumLb.setForeground(Color.blue);
        contentPane.add(sodiumLb);

        sodium = new JTextField();
        sodium.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        sodium.setColumns(10);
        sodium.setBounds(121, 185, 78, 19);
        sodium.setBackground(Color.orange);
        contentPane.add(sodium);

        fatLb = new JLabel("Grasimi:");
        fatLb.setFont(new Font("Times New Roman", Font.BOLD, 16));
        fatLb.setBounds(217, 182, 70, 22);
        fatLb.setForeground(Color.blue);
        contentPane.add(fatLb);

        fat = new JTextField();
        fat.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        fat.setColumns(10);
        fat.setBounds(283, 185, 78, 19);
        fat.setBackground(Color.orange);
        contentPane.add(fat);

        addButton = new JButton("ADAUGA");
        addButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
        addButton.setForeground(Color.white);
        addButton.setBackground(Color.blue);
        addButton.setBounds(121, 220, 240, 31);
        contentPane.add(addButton);
    }

    public void addAddButtonActionListener(ActionListener actionListener) {
        addButton.addActionListener(actionListener);
    }

    public MenuItem getNewMenuItem() {
        String prodTitle = title.getText();
        float prodRating = raiting.getText().isEmpty() ? 0 : Float.parseFloat(raiting.getText());
        int prodCalories = Integer.parseInt(calories.getText());
        int prodProteins = Integer.parseInt(proteins.getText());
        int prodFat = Integer.parseInt(fat.getText());
        int prodSodium = Integer.parseInt(sodium.getText());
        int prodPrice = Integer.parseInt(price.getText());
        return new BaseProduct(prodTitle, prodRating, prodCalories, prodProteins, prodFat, prodSodium, prodPrice);
    }

    public String[] newRow() {
        return new String[]{title.getText(), raiting.getText(), calories.getText(), proteins.getText(), fat.getText(),
                sodium.getText(), price.getText()};
    }

}
