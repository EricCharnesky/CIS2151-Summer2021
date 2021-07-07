
package midtermreview;

import java.util.ArrayList;


public class Sundae {
    private ArrayList<String> ingredients;
    private double costPerScoop;
    private double costPerIngredient;
    private int numberOfScoops;

    public Sundae(double costPerScoop, double costPerIngredient, int numberOfScoops) {
        this.costPerScoop = costPerScoop;
        this.costPerIngredient = costPerIngredient;
        this.numberOfScoops = numberOfScoops;
        ingredients = new ArrayList<>();
    }
    
    public void addIngredient(String ingredient){
        ingredients.add(ingredient);
    }
    
    public double getTotalCost(){
        return costPerScoop * numberOfScoops + costPerIngredient * ingredients.size();
    }
    
}
