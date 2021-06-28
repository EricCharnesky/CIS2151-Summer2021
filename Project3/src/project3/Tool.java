/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project3;

import java.util.ArrayList;

/**
 *
 * @author omara
 */
public class Tool {

    private boolean shovel;
    private boolean axe;
    private boolean hammer;
    private ArrayList<String> arrayTools;

    public Tool(ArrayList<String> toolArray) {
        shovel = false;
        axe = false;
        hammer = false;
        arrayTools = toolArray;
        

    }

    public boolean isShovel() {
        return shovel;
    }

    public void setShovel(boolean shovel) {
        this.shovel = shovel;
    }

    public boolean isAxe() {
        return axe;
    }

    public void setAxe(boolean axe) {
        this.axe = axe;
    }

    public boolean isHammer() {
        return hammer;
    }

    public void setHammer(boolean hammer) {
        this.hammer = hammer;
    }

    public ArrayList<String> getArrayTools() {
        return arrayTools;
    }

    public void setArrayTools(ArrayList<String> arrayTools) {
        this.arrayTools = arrayTools;
    }

    public Tool() {
        shovel = false;
        axe = false;
        hammer = false;
    }

    
}
