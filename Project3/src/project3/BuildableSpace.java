package project3;

public class BuildableSpace extends Space implements isBuildable {

    public BuildableSpace(){
        super("this is an empty space with a place to build");
    }
    
    @Override
    public boolean build(Player player) {
        if (player.canBuild()) {
            setDescription("you built a fort here");
            return true;
        }
        return false;

    }

}
