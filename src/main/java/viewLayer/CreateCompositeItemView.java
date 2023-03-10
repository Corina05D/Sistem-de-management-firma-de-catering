package viewLayer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CreateCompositeItemView extends JFrame {

    private JPanel contentPane;
    private JLabel lbNewLabel;
    private JLabel lbSelectTitle;
    private JTextField title;
    private JButton createButton;

    public CreateCompositeItemView() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 500, 250);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(Color.blue);
        setContentPane(contentPane);
        contentPane.setLayout(null);

        lbNewLabel = new JLabel("Creeaza meniu compus");
        lbNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lbNewLabel.setToolTipText("");
        lbNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
        lbNewLabel.setBounds(10, 47, 420, 27);
        lbNewLabel.setForeground(Color.white);
        contentPane.add(lbNewLabel);

        lbSelectTitle = new JLabel("Titlul meniului:");
        lbSelectTitle.setToolTipText("");
        lbSelectTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lbSelectTitle.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lbSelectTitle.setBounds(10, 84, 210, 27);
        lbSelectTitle.setForeground(Color.white);
        contentPane.add(lbSelectTitle);

        title = new JTextField();
        title.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        title.setBounds(165, 84, 210, 22);
        title.setBackground(Color.cyan);
        contentPane.add(title);
        title.setColumns(10);

        createButton = new JButton("CREEAZA");
        createButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
        createButton.setBounds(75, 121, 300, 22);
        createButton.setBackground(Color.BLACK);
        createButton.setForeground(Color.yellow);
        contentPane.add(createButton);
    }

    public void addCreateButtonActionListener(ActionListener actionListener) {
        createButton.addActionListener(actionListener);
    }

    public String getTitle() {
        return title.getText();
    }

}
