package project4;

public class ChopableSpace extends Space implements isChopable {

    public ChopableSpace(){
        super("this space has a tree");
    }
    
    @Override
    public boolean chop(Player player) {
        if (player.canChop()) {
            setDescription("you cut down the tree in this space");
            return true;
        }
        return false;
    }

}
