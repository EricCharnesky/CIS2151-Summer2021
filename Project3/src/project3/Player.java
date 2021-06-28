
package project3;

import java.util.ArrayList;

public class Player {
    
    
    String name;
    ArrayList<String> listOfFriends;
    ArrayList<String> trustedFriends;
    String [] tools;
    boolean canDig;
    boolean canBuild;
    boolean canChop;
    int toolCounter;

    public void setCanBuild(boolean canBuild) {
        this.canBuild = canBuild;
    }


    public void setCanChop(boolean canChop) {
        this.canChop = canChop;
    }
    
    
    public Player() {
        tools = new String[10];
        listOfFriends = new ArrayList<>();
        trustedFriends = new ArrayList<>();
        
    }

    public boolean canDig() {
        return canDig;
    }

    public void setCanDig(boolean canDig) {
        this.canDig = canDig;
    }

    public boolean canBuild() {
        return canBuild;
    }

    public boolean canChop() {
        return canChop;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getTrustedFriends() {
        return trustedFriends;
    }

    public void setTrustedFriends(String trustedFriend) {
        trustedFriends.add(trustedFriend);
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getListOfFriends() {
        return listOfFriends;
    }

    public void setListOfFriends(String friend) {
        listOfFriends.add(friend);
    }

//    public boolean canDig()
//    {
//        return true;
//    }

    public String[] getTools() {
        return tools;
    }

    public void setTools(String tool) {
        tools[toolCounter] = tool;
        toolCounter++;
    }
    
    
}
