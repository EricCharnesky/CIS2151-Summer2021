package project4;

import java.io.Serializable;

public class Tool implements Serializable {

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

    @Override
    public String toString() {
        return name;
    }
}
