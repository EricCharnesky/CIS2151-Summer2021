package exceptionsandfileio;

import java.io.Serializable;
import java.util.ArrayList;

public class Food implements Serializable {

    private String name;
    private double cost;
    ArrayList<String> ingredients;

    public Food(String name, double cost) {
        this.name = name;
        if ( cost <= 0 ){
            throw new IllegalArgumentException("Cost can not be 0 or less");
        }
        this.cost = cost;
        ingredients = new ArrayList<>();
    }

    public void addIngredient(String ingredient) {
        ingredients.add(ingredient);
    }
    
    public ArrayList<String> getIngredients(){
        return ingredients;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

}
