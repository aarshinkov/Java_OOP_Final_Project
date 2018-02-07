package uni.frame;

import uni.object.ESort;
import uni.object.Food;
import uni.object.Fries;
import uni.object.Salad;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CFrame extends JFrame {
    private static final long serialVersionUID = 1;
    private final ImageIcon APPLICATION_ICON = new ImageIcon(getClass().getResource("/img/app_icon.png"));

    private Food food;

    //Panels
    private JPanel mainPanel = new JPanel();
    private JPanel upPanel = new JPanel();
    private JPanel downPanel = new JPanel();
    private JPanel firstPanel = new JPanel();
    private JPanel secondPanel = new JPanel();
    private JPanel navPanel = new JPanel();

    private static JPanel saladButton = new JPanel();
    private static JPanel saladBImage = new JPanel();
    private static JLabel saladBText = new JLabel();

    private static JPanel friesButton = new JPanel();
    private static JPanel friesBImage = new JPanel();
    private static JLabel friesBText = new JLabel();


    //Labels
    private static JLabel instructionLabel = new JLabel("<html><p>Choose a food!</p></html>");
    private static JLabel instructionImage = new JLabel("This is step image!");

    //Buttons
    private static JButton backButton = new JButton("Back");
    private static JButton nextButton = new JButton("Next");
    private static JButton ingredientsButton = new JButton("Ingredients");

    //Menu
    private JMenuBar menuBar;

    private JMenu fileMenu;
    private JMenu sortMenu;
    private JMenu recipes;

    private static JMenuItem exitMenuItem;
    private static JMenuItem sortIngrAccMenuItem;
    private static JMenuItem sortIngrDescMenuItem;
    private static JMenuItem sortDefaultMenuItem;
    private static JMenuItem newRecipeMenuItem;
    private static JMenuItem otherRecipesMenuItem;

    //Constructor
    public CFrame() {
//        System.out.println("Present Project Directory : " + System.getProperty("user.dir"));

        this.setSize(600, 650);
        this.setPreferredSize(new Dimension(600, 650));

        //setting the frame at center of screen
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setTitle("Cooking book");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setIconImage(APPLICATION_ICON.getImage());
        this.setLayout(new BorderLayout());

        createMenuBar();
        createMainPanel();
        createUpPanel();
        createDownPanel();
        createFirstPanel();
        createSecondPanel();
        createNavPanel();

        saladButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                saladButton.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2, true));
                friesButton.setBorder(BorderFactory.createLineBorder(new Color(142, 142, 142), 1, false));
                food = new Salad();
                food.showStep();
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                saladButton.setToolTipText("Click for salad recipe");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                saladButton.setToolTipText(null);
            }
        });

        friesButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                friesButton.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0), 2, true));
                saladButton.setBorder(BorderFactory.createLineBorder(new Color(142, 142, 142), 1, false));
                food = new Fries();
                food.showStep();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                friesButton.setToolTipText("Click for fries recipe");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                friesButton.setToolTipText(null);
            }
        });

        backButton.addActionListener(new backStepAction());
        ingredientsButton.addActionListener(new showIngredients());
        nextButton.addActionListener(new nextStepAction());

        this.add(mainPanel, BorderLayout.CENTER);
        this.add(navPanel, BorderLayout.SOUTH);

        this.pack();
        this.setVisible(true);
    }

    private void createMenuBar() {
        menuBar = new JMenuBar();

        fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_DOWN_MASK));
        exitMenuItem.addActionListener(new exitMenuItemAction());
        fileMenu.add(exitMenuItem);

        sortMenu = new JMenu("Sort");
        menuBar.add(sortMenu);

        ButtonGroup group = new ButtonGroup();
        sortIngrAccMenuItem = new JRadioButtonMenuItem("Ingredients ascending");
        group.add(sortIngrAccMenuItem);
        sortIngrAccMenuItem.addActionListener(new sortAscendingAction());
        sortMenu.add(sortIngrAccMenuItem);

        sortIngrDescMenuItem = new JRadioButtonMenuItem("Ingredients descending");
        group.add(sortIngrDescMenuItem);
        sortIngrDescMenuItem.addActionListener(new sortDescendingAction());
        sortMenu.add(sortIngrDescMenuItem);

        sortDefaultMenuItem = new JRadioButtonMenuItem("Default order");
        sortDefaultMenuItem.setSelected(true);
        group.add(sortDefaultMenuItem);
        sortDefaultMenuItem.addActionListener(new sortDefaultAction());
        sortMenu.add(sortDefaultMenuItem);

        sortIngrAccMenuItem.setEnabled(false);
        sortIngrDescMenuItem.setEnabled(false);
        sortDefaultMenuItem.setEnabled(false);

//        recipes = new JMenu("Recipes");
//        menuBar.add(recipes);
//
//        newRecipeMenuItem = new JMenuItem("New recipe");
//        newRecipeMenuItem.setAccelerator(KeyStroke.getKeyStroke(
//                KeyEvent.VK_1, InputEvent.ALT_DOWN_MASK));
//        newRecipeMenuItem.setToolTipText("Creates new recipe");
//        newRecipeMenuItem.addActionListener(new addNewRecipe());
//        recipes.add(newRecipeMenuItem);
//
//        recipes.addSeparator();
//
//        otherRecipesMenuItem = new JMenuItem("Other recipes");
//        otherRecipesMenuItem.addActionListener(new chooseOtherRecipe());
//        recipes.add(otherRecipesMenuItem);


        this.setJMenuBar(menuBar);
    }

    private void createMainPanel() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(2, 1));
        mainPanel.add(upPanel);
        mainPanel.add(downPanel);
    }

    private void createUpPanel() {
        upPanel.setLayout(new GridLayout(2, 1));
        upPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 5, 20));
        upPanel.add(firstPanel);
        upPanel.add(secondPanel);
    }

    private void createDownPanel() {
        downPanel.setLayout(new GridLayout(1, 1));
        downPanel.setBorder(BorderFactory.createEmptyBorder(5, 20, 20, 20));
        downPanel.add(instructionImage);
        instructionImage.setBorder(BorderFactory.createLineBorder(Color.black));
    }

    private void createFirstPanel() {
        firstPanel.setLayout(new GridLayout(1, 2, 200, 200));

        firstPanel.add(saladButton);
        createFoodButton(saladButton, saladBImage, saladBText, "salad.jpg", "Salad");

        firstPanel.add(friesButton);
        createFoodButton(friesButton, friesBImage, friesBText, "fries.jpg", "Fries");
    }

    private void createSecondPanel() {
        secondPanel.setLayout(new GridLayout(1, 1));
        secondPanel.add(instructionLabel);
    }

    private void createNavPanel() {
        navPanel.setLayout(new FlowLayout());
        navPanel.setBackground(new Color(90, 161, 184));
        navPanel.add(backButton);
        backButton.setEnabled(false);
        navPanel.add(ingredientsButton);
        ingredientsButton.setEnabled(false);
        navPanel.add(nextButton);
        nextButton.setEnabled(false);
    }

    private void createFoodButton(JPanel recipeButton, JPanel recipeImagePanel, JLabel recipeTextLabel, String imageResource, String recipeName) {
        //Button
        recipeButton.setLayout(new BorderLayout());
        recipeButton.setBorder(BorderFactory.createLineBorder(new Color(142, 142, 142)));

        //Adding image and text panels
        recipeButton.add(recipeImagePanel, BorderLayout.CENTER);
        recipeButton.add(recipeTextLabel, BorderLayout.SOUTH);

        //Text under image
        recipeTextLabel.setText(recipeName);
        recipeTextLabel.setHorizontalAlignment(SwingConstants.CENTER);

        //Food image
        recipeImagePanel.setBounds(0, 0, 175, 110);
        recipeImagePanel.setBorder(BorderFactory.createEmptyBorder(-5,0,0,0));

        //Setting image to panel
        ImageIcon image = new ImageIcon(getClass().getResource("/img/" + imageResource));
        image.setImage(image.getImage().getScaledInstance(saladBImage.getWidth(), saladBImage.getHeight(), Image.SCALE_SMOOTH));
        recipeImagePanel.add(new JLabel(image));
    }

    private class backStepAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                food.stepBack();
            } catch (NullPointerException ex) {
                System.out.println("The button BACK has no reference to any object of type Food!");
            }
        }

    }

    private class nextStepAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                food.stepNext();
            } catch (NullPointerException ex) {
                System.out.println("The button NEXT has no reference to any object of type Food!");
            }
        }

    }

    private class showIngredients implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                food.showIngredients();
            } catch (NullPointerException ex) {
                System.out.println("The button INGREDIENTS has no reference to any object of type Food!");
            }
        }

    }

    private class exitMenuItemAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

    private class sortAscendingAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            food.setSort(ESort.ASCENDING);
        }
    }

    private class sortDescendingAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            food.setSort(ESort.DESCENDING);
        }
    }

    private class sortDefaultAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            food.setSort(ESort.DEFAULT);
        }
    }

    //TODO implement addNewRecipe()
    private class addNewRecipe implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("New recipe added");
        }
    }

    //TODO implement chooseOtherRecipe
    private class chooseOtherRecipe implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Other recipes chosen");
        }
    }

    public static JButton getBackButton() {
        return backButton;
    }

    public static JButton getIngredientsButton() {
        return ingredientsButton;
    }

    public static JButton getNextButton() {
        return nextButton;
    }

    public static JLabel getInstructionLabel() {
        return instructionLabel;
    }

    public static JLabel getInstructionImage() {
        return instructionImage;
    }

    public static JMenuItem getSortIngrAccMenuItem() {
        return sortIngrAccMenuItem;
    }

    public static JMenuItem getSortIngrDescMenuItem() {
        return sortIngrDescMenuItem;
    }

    public static JMenuItem getSortDefaultMenuItem() {
        return sortDefaultMenuItem;
    }

}