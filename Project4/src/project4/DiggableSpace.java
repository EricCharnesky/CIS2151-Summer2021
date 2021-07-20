package project4;

public class DiggableSpace extends Space implements isDiggable {

    public DiggableSpace(){
        super("this is an empty space with a place to dig");
    }
    
    @Override
    public boolean dig(Player player) {
        if (player.canDig()) {
            setDescription("you dug a hole in this space");
            return true;
        }
        return false;

    }

}
