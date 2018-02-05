package uni.object;

import java.util.ArrayList;

public class Salad extends Food {
    public Salad() {
        makeList();
        makeIngredientsList();
        setIndexOfStep(0);
    }

    @Override
    protected void makeList() {
        ArrayList<String> tempList = new ArrayList<>();

        tempList.add("Wash the vegetables");
        tempList.add("Peel the vegetables");
        tempList.add("Cut the vegetables");
        tempList.add("Stir the feta cheese");
        tempList.add("Add salt, cooking oil and vinegar");
        tempList.add("Serve with rakia!");

        setStepList(tempList);
    }

    @Override
    protected void makeIngredientsList() {
        ArrayList<String> tempList = new ArrayList<>();

        tempList.add("tomatoes (2)");
        tempList.add("cucumber (1)");
        tempList.add("green peppers (2)");
        tempList.add("onion (1)");
        tempList.add("feta cheese (150 - 200 grams)");
        tempList.add("pinch salt (2)");
        tempList.add("cooking oil (1 tablespoon)");
        tempList.add("vinegar (1/2 tablespoon)");

        setIngredientsList(tempList);
    }
}
