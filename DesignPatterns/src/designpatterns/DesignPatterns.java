
package designpatterns;

public class DesignPatterns {

    public static void main(String[] args) {
        SingletonLogger logger = SingletonLogger.getInstance();
        
        logger.log("test");
    }
    
}
