package project4;

import java.io.Serializable;
import java.util.ArrayList;

public class Player implements Serializable{

    private String name;
    private Island home;
    private ArrayList<Tool> tools;
    private ArrayList<Player> friends;
    private int locationX;
    private int locationY;

    public Player(String name) {
        this.name = name;
        home = new Island(this);
        tools = new ArrayList<>();
        friends = new ArrayList<>();
        locationX = 0;
        locationY = 0;
    }

    public int getLocationX() {
        return locationX;
    }

    public void setLocationX(int locationX) {
        this.locationX = locationX;
    }
    
    public int getLocationY() {
        return locationY;
    }

    public void setLocationY(int locationY) {
        this.locationY = locationY;
    }

    public String getName() {
        return name;
    }

    public Island getHome() {
        return home;
    }

    // be careful with returning a reference type
    public ArrayList<Tool> getTools() {
        return tools;
    }
    
    public void addTool(Tool tool){
        tools.add(tool);
    }

    // be careful with returning a reference type
    public ArrayList<Player> getFriends() {
        return friends;
    }

    public void addFriend(Player friend) {
        friends.add(friend);
    }

    public boolean isFriendOf(Player friend) {
        return friends.contains(friend);
        /*  once we have the equals method, we don't need to do this the hard way
        for ( Player currentFriend : friends ){
            if ( currentFriend.getName().equalsIgnoreCase(friend.getName())){
                return true;
            }
        }
        return false;
         */
    }

    public boolean canDig() {
        for (Tool tool : tools) {
            if (tool.getName().equalsIgnoreCase(Tool.SHOVEL)) {
                return true;
            }
        }
        return false;
    }

    public boolean canChop() {
        for (Tool tool : tools) {
            if (tool.getName().equalsIgnoreCase(Tool.AXE)) {
                return true;
            }
        }
        return false;
    }

    public boolean canBuild() {
        for (Tool tool : tools) {
            if (tool.getName().equalsIgnoreCase(Tool.HAMMER)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object other) {
        if (other.getClass() != getClass()) {
            return false;
        }
        Player otherPlayer = (Player) other;

        return otherPlayer.getName().equals(getName());
    }
}
