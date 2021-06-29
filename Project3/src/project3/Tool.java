
package project3;

public class Tool {
    
    public static final String AXE = "axe";
    public static final String HAMMER = "hammer";
    public static final String SHOVEL = "shovel";
    
    private String name;

    public Tool(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
