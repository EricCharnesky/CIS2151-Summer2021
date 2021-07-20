package project4;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Island implements Serializable {

    ArrayList<ArrayList<Space>> grid;
    ArrayList<Player> players;
    Player owner;

    public Island(Player owner) {

        this.owner = owner;

        players = new ArrayList<>();
        grid = new ArrayList<ArrayList<Space>>();
        Random random = new Random();

        for (int rowIndex = 0; rowIndex < 10; rowIndex++) {
            grid.add(new ArrayList<Space>());
            for (int columnIndex = 0; columnIndex < 12; columnIndex++) {

                int randomNumber = random.nextInt(10);

                Space newSpace = new Space("empty space");

                if (randomNumber == 4) {
                    newSpace = new BuildableSpace();
                } else if (randomNumber == 5) {
                    newSpace = new ChopableSpace();
                } else if (randomNumber == 6) {
                    newSpace = new DiggableSpace();
                } else if (randomNumber == 7) {
                    newSpace = new Space("space with a hammer");
                    newSpace.setTool(new Tool(Tool.HAMMER));
                } else if (randomNumber == 8) {
                    newSpace = new Space("space with an axe");
                    newSpace.setTool(new Tool(Tool.AXE));
                } else if (randomNumber == 9) {
                    newSpace = new Space("space with a shovel");
                    newSpace.setTool(new Tool(Tool.SHOVEL));
                }

                grid.get(rowIndex).add(newSpace);

            }
        }
    }
    
    public String getOwnersName(){
        return owner.getName();
    }

    public Tool pickupTool(Player player) {

        Space space = grid.get(player.getLocationX()).get(player.getLocationY());
        Tool tool = null;
        if (space.hasTool() && (player.equals(owner) || owner.getFriends().contains(player))) {
            tool = space.getTool();
            space.setTool(null);
            space.setDescription("empty space");
        }

        return tool;

    }

    public boolean canDigSpace(Player player) {
        return player.canDig()
                && isDiggable.class.isAssignableFrom(
                        grid.get(player.getLocationX()).get(player.getLocationY()).getClass())
                && (player.equals(owner) || owner.getFriends().contains(player));

    }

    public boolean canChopSpace(Player player) {
        return player.canChop()
                && isChopable.class.isAssignableFrom(
                        grid.get(player.getLocationX()).get(player.getLocationY()).getClass())
                && (player.equals(owner) || owner.getFriends().contains(player));

    }

    public boolean canBuildSpace(Player player) {
        return player.canBuild()
                && isBuildable.class.isAssignableFrom(
                        grid.get(player.getLocationX()).get(player.getLocationY()).getClass())
                && (player.equals(owner) || owner.getFriends().contains(player));

    }
    
    public boolean isValidLocation(int rowIndex, int columnIndex){
        return 0 <= rowIndex && rowIndex < grid.size() && 
                0 <= columnIndex && columnIndex < grid.get(rowIndex).size();
    }

    public Space getSpace(int rowIndex, int columnIndex) {
        return grid.get(rowIndex).get(columnIndex);
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public boolean removePlayer(Player player) {
        return players.remove(player);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int rowIndex = 0; rowIndex < grid.size(); rowIndex++) {
            for (int columnIndex = 0; columnIndex < grid.get(rowIndex).size(); columnIndex++) {
                builder.append("Row: ");
                builder.append(rowIndex);
                builder.append(" Column: ");
                builder.append(columnIndex);
                builder.append(": ");
                builder.append(grid.get(rowIndex).get(columnIndex).getDescription());
                builder.append("\n");
            }
        }

        return builder.toString();

    }
}
