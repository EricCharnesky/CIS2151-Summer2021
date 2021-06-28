
package project3;

public class BuildableSpace extends Space implements isBuildable {

    @Override
    public boolean build(Player player) {
        if (player.canBuild()) {
            setDescription("you built a structure in this space");
            return true;
        }
        return false;

    }

}