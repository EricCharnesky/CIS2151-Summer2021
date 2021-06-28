
package project3;

public class ChoppableSpace extends Space implements isChoppable {

    @Override
    public boolean chop(Player player) {
        if (player.canChop()) {
            setDescription("you chopped a tree down in this space");
            return true;
        }
        return false;

    }

}