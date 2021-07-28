
package guicontrols;


public class ReceiptItem {
    private String description;
    private double cost;

    public ReceiptItem(String description, double cost) {
        this.description = description;
        this.cost = cost;
    }

    public String getDescription() {
        return description;
    }

    public double getCost() {
        return cost;
    }
    
    
}
