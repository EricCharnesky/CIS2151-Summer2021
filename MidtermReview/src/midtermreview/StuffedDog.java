
package midtermreview;

import java.util.Random;


public class StuffedDog extends StuffedAnimal {

    public StuffedDog(String name){
        super(name);
    }
    
    @Override
    public String makeNoise() {
        if ( batteryHasPower ){
            Random random = new Random();
            if ( random.nextInt(10)+1 == 1){
                batteryHasPower = false;
            }
            return getName() + " goes woof woof!";
        }
        else{
            return "";
        }
    }
    
}
