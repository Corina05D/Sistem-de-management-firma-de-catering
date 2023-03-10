package viewLayer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class OrderView extends JFrame implements Observer {

    private JPanel contentPane;
    private JLabel lbNewLabel;
    private JTextArea textArea;

    public OrderView() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(Color.cyan);
        setContentPane(contentPane);
        contentPane.setLayout(null);

        lbNewLabel = new JLabel("Comenzi plasate de clienti");
        lbNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lbNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
        lbNewLabel.setBounds(10, 24, 620, 55);
        contentPane.add(lbNewLabel);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 85, 700, 400);
        contentPane.add(scrollPane);

        textArea = new JTextArea();
        textArea.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        scrollPane.setViewportView(textArea);

    }

    @Override
    public void update(Observable o, Object arg) {
        textArea.setText((String) arg);
    }
}
