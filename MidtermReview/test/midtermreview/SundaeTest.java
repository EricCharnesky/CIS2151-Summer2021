
package midtermreview;

import org.junit.Test;
import static org.junit.Assert.*;


public class SundaeTest {
    
    public SundaeTest() {
    }

    @Test
    public void testGetTotalCost() {
        // Arrange
        double costPerScoop = 1.5;
        double costPerIngredient = .5;
        int numberOfScoops = 3;
        double expectedCost = 5.5;
        
        // Act
        Sundae sundae = new Sundae(costPerScoop, costPerIngredient, numberOfScoops);
        sundae.addIngredient("whipped cream");
        sundae.addIngredient("hot fudge");
        double actualCost = sundae.getTotalCost();
        
        // Assert
        assertEquals(expectedCost, actualCost, .001);
    }
    
}
