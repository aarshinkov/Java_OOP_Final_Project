package uni.object;

import java.util.ArrayList;

public class Fries extends Food {
    public Fries() {
        makeList();
        makeIngredientsList();
        setIndexOfStep(0);
    }
    
    @Override
    protected void makeList() {
        ArrayList<String> tempList = new ArrayList<>();

        tempList.add("Peel the potatoes");
        tempList.add("Chop the potatoes");
        tempList.add("Put the potatoes in the pan");
        tempList.add("Fry until crispy");
        tempList.add("Serve with feta cheese or/and ketchup!");

        setStepList(tempList);
    }

    @Override
    protected void makeIngredientsList() {
        ArrayList<String> tempList = new ArrayList<>();

        tempList.add("potatoes (1 kg)");
        tempList.add("cooking oil");
        tempList.add("salt to taste");

        setIngredientsList(tempList);
    }
}
