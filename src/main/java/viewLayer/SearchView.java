package viewLayer;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class SearchView extends JFrame {

    private JPanel contentPane;
    private JLabel lbNewLabel;
    private JLabel lbKeywordInThe;
    private JLabel lbMinimumRating;
    private JLabel lbMaximumPrice;
    private JLabel lbMaximumNumberOf;
    private JLabel lbMinimumNumberOf;
    private JLabel lbMaximumGramsOf;
    private JLabel lbMaximumGramsOf_1;
    private JTextField keyword;
    private JTextField rating;
    private JTextField price;
    private JTextField calories;
    private JTextField proteins;
    private JTextField fat;
    private JTextField sodium;
    private JButton searchBtn;

    public SearchView() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 500, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(Color.cyan);
        setContentPane(contentPane);
        contentPane.setLayout(null);

        lbNewLabel = new JLabel("Cautare Produse ");
        lbNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lbNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
        lbNewLabel.setBounds(133, 25, 150, 35);
        contentPane.add(lbNewLabel);

        lbKeywordInThe = new JLabel("Cuvinte cheie in titlu:");
        lbKeywordInThe.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lbKeywordInThe.setBounds(26, 70, 220, 25);
        contentPane.add(lbKeywordInThe);

        lbMinimumRating = new JLabel("Rating minim:");
        lbMinimumRating.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lbMinimumRating.setBounds(26, 104, 190, 25);
        contentPane.add(lbMinimumRating);

        lbMaximumPrice = new JLabel("Pret maxim:");
        lbMaximumPrice.setFont(new Font("Times New Roman", Font.BOLD, 14));
        lbMaximumPrice.setBounds(26, 138, 190, 25);
        contentPane.add(lbMaximumPrice);

        lbMaximumNumberOf = new JLabel("Numar maxim de calorii:");
        lbMaximumNumberOf.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lbMaximumNumberOf.setBounds(26, 172, 220, 25);
        contentPane.add(lbMaximumNumberOf);

        lbMinimumNumberOf = new JLabel("Min grame de proteine:");
        lbMinimumNumberOf.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lbMinimumNumberOf.setBounds(26, 206, 200, 25);
        contentPane.add(lbMinimumNumberOf);

        lbMaximumGramsOf = new JLabel("Max grame de grasimi:");
        lbMaximumGramsOf.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lbMaximumGramsOf.setBounds(26, 240, 200, 25);
        contentPane.add(lbMaximumGramsOf);

        lbMaximumGramsOf_1 = new JLabel("Max grame de sodiu:");
        lbMaximumGramsOf_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lbMaximumGramsOf_1.setBounds(26, 274, 200, 25);
        contentPane.add(lbMaximumGramsOf_1);

        keyword = new JTextField();
        keyword.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        keyword.setBounds(241, 70, 120, 20);
        contentPane.add(keyword);
        keyword.setColumns(10);

        rating = new JTextField();
        rating.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        rating.setColumns(10);
        rating.setBounds(241, 104, 120, 20);
        contentPane.add(rating);

        price = new JTextField();
        price.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        price.setColumns(10);
        price.setBounds(241, 138, 120, 20);
        contentPane.add(price);

        calories = new JTextField();
        calories.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        calories.setColumns(10);
        calories.setBounds(241, 172, 120, 20);
        contentPane.add(calories);

        proteins = new JTextField();
        proteins.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        proteins.setColumns(10);
        proteins.setBounds(241, 206, 120, 20);
        contentPane.add(proteins);

        fat = new JTextField();
        fat.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        fat.setColumns(10);
        fat.setBounds(241, 240, 120, 20);
        contentPane.add(fat);

        sodium = new JTextField();
        sodium.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        sodium.setColumns(10);
        sodium.setBounds(241, 274, 120, 20);
        contentPane.add(sodium);

        searchBtn = new JButton("CAUTARE");
        searchBtn.setFont(new Font("Times New Roman", Font.BOLD, 16));
        searchBtn.setBounds(241, 315, 120, 22);
        searchBtn.setBackground(Color.blue);
        searchBtn.setForeground(Color.white);
        contentPane.add(searchBtn);
    }

    public void addSearchBtnActionListener(ActionListener actionListener) {
        searchBtn.addActionListener(actionListener);
    }

    public int getFat() {
        if (fat.getText().equals(""))
            return Integer.MAX_VALUE;
        return Integer.parseInt(fat.getText());
    }

    public int getSodium() {
        if (sodium.getText().equals(""))
            return Integer.MAX_VALUE;
        return Integer.parseInt(sodium.getText());
    }


    public int getProteins() {
        if (proteins.getText().equals(""))
            return 0;
        return Integer.parseInt(proteins.getText());
    }

    public int getCalories() {
        if (calories.getText().equals(""))
            return Integer.MAX_VALUE;
        return Integer.parseInt(calories.getText());
    }


    public int getPrice() {
        if (price.getText().equals(""))
            return Integer.MAX_VALUE;
        return Integer.parseInt(price.getText());
    }


    public float getRaiting() {
        if (rating.getText().equals(""))
            return 0;
        return Float.parseFloat(rating.getText());
    }

    public String getKeyword() {
        return keyword.getText();
    }

}
