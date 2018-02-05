package uni.frame;

import javax.swing.*;
import java.awt.*;

public class TestFrame extends JFrame {
    private ImageIcon applicationIcon = new ImageIcon("src/uni/img/app_icon.png");

    private Color backgroundColor = new Color(181, 143, 155);
//    private Color backgroundColor = new Color(181, 143, 155);

    private JPanel mainPanel = new JPanel();

    private JPanel upPanel = new JPanel();
    private JPanel downPanel = new JPanel();

    private JPanel firstPanel = new JPanel();
    private JPanel secondPanel = new JPanel();

    private JPanel navPanel = new JPanel();

    private JButton saladButton = new JButton("Salad");
    private JButton friesButton = new JButton("Fries");

    private JLabel instructionLabel = new JLabel("<html><p>This is instruction label!</p></html>");

    private JLabel instructionImage = new JLabel("Hey!");

    private JButton backButton = new JButton("Back");
    private JButton nextButton = new JButton("Next");


    public TestFrame() {
        this.setSize(600, 600);
        this.setResizable(false);
        this.setTitle("Cooking book");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setIconImage(applicationIcon.getImage());

        saladButton.setHorizontalAlignment(AbstractButton.LEFT);
        saladButton.setVerticalAlignment(AbstractButton.BOTTOM);
        this.add(saladButton);

        this.setVisible(true);
    }
}
