package uni.object;

import uni.frame.CFrame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public abstract class Food implements IShowStepable {
    private int indexOfStep;
    private ArrayList<String> stepList;
    private ArrayList<String> ingredientsList;
    private ArrayList<String> tempIngrList = new ArrayList<>();
    private ESort sort = ESort.DEFAULT;

    public void setSort(ESort sort) {
        this.sort = sort;
    }

    protected abstract void makeList();

    protected abstract void makeIngredientsList();

    @Override
    public void showStep() {
        String step = stepList.get(0);
        setImageOnLabel(1);
        CFrame.getInstructionLabel().setText("1. " + step);
        CFrame.getSortDefaultMenuItem().setSelected(true);
        CFrame.getBackButton().setEnabled(false);
        CFrame.getIngredientsButton().setEnabled(true);
        CFrame.getNextButton().setEnabled(true);
        CFrame.getSortIngrAccMenuItem().setEnabled(true);
        CFrame.getSortIngrDescMenuItem().setEnabled(true);
        CFrame.getSortDefaultMenuItem().setEnabled(true);
    }

    private void setImageOnLabel(int fileName) {
        JLabel instructionImage = CFrame.getInstructionImage();
        int imageLabelHeight = instructionImage.getHeight();

        String type = this.getClass().getSimpleName().toLowerCase();
        ImageIcon image = new ImageIcon(getClass().getResource("/steps/" + type + "/" + fileName + ".jpg"));

        int originalHeight = image.getIconHeight();
        int originalWidth = image.getIconWidth();
        double ratio = (double)originalWidth / (double)originalHeight;

        int width = (int)(ratio * imageLabelHeight);

        image.setImage(image.getImage().getScaledInstance(width, imageLabelHeight, Image.SCALE_SMOOTH));
        instructionImage.setText("");
        instructionImage.setIcon(image);
    }

    @Override
    public void stepNext() {
        if (indexOfStep == stepList.size() - 2) {
            CFrame.getNextButton().setEnabled(false);
        } else {
            CFrame.getBackButton().setEnabled(true);
        }
        indexOfStep++;
        setStepLabelText();
        setImageOnLabel(indexOfStep + 1);
    }

    @Override
    public void stepBack() {
        if (indexOfStep == 1) {
            CFrame.getBackButton().setEnabled(false);
        } else {
            CFrame.getNextButton().setEnabled(true);
        }
        indexOfStep--;
        setStepLabelText();
        setImageOnLabel(indexOfStep + 1);
    }

    @Override
    public void showIngredients() {
        String ingredients;
        switch (sort) {
            case ASCENDING:
                Collections.sort(tempIngrList);
                ingredients = getIngredientText(tempIngrList);
                break;
            case DESCENDING:
                Collections.reverse(tempIngrList);
                ingredients = getIngredientText(tempIngrList);
                break;
            default:
                ingredients = getIngredientText(ingredientsList);
                break;
        }

        String title = "Ingredients for " + this.getClass().getSimpleName().toLowerCase();
        JOptionPane.showMessageDialog(null, ingredients, title, JOptionPane.INFORMATION_MESSAGE);
    }

    private String getIngredientText(ArrayList<String> targetList) {
        StringBuilder ingredients = new StringBuilder();
        ingredients.append("<html>");
        for (String s : targetList) {
            ingredients.append("<p>");
            ingredients.append(s);
            ingredients.append("</p>");
        }
        ingredients.append("</html>");
        return String.valueOf(ingredients);
    }

    private void setStepLabelText() {
        String step = stepList.get(indexOfStep);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<html><p>");
        stringBuilder.append(indexOfStep + 1);
        stringBuilder.append(". ");
        stringBuilder.append(step);
        stringBuilder.append("</p></html>");

        CFrame.getInstructionLabel().setText(String.valueOf(stringBuilder));
    }

    protected void setIndexOfStep(int indexOfStep) {
        this.indexOfStep = indexOfStep;
    }

    protected void setStepList(ArrayList<String> stepList) {
        this.stepList = stepList;
    }

    protected void setIngredientsList(ArrayList<String> ingredientsList) {
        this.ingredientsList = ingredientsList;
        tempIngrList.addAll(ingredientsList);
    }

}
