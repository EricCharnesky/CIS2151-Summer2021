
package project4;

import java.io.Serializable;

public class Space implements Serializable {
    private String description;
    private Tool tool;

    public Space(){
        this("");
    }
    
    public Space(String description) {
        this.description = description;
        setTool(null);
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
    
    public boolean hasTool(){
        return tool != null;
    }

    public Tool getTool() {
        return tool;
    }

    public void setTool(Tool tool) {
        this.tool = tool;
    }
    
}
