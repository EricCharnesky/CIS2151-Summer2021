package project3;

import java.util.Random;
import java.util.Scanner;

public class Space {

    private String description;
    private Random rand;

    public Space() {
//        this("");
        rand = new Random();
        int randInt = rand.nextInt(41);
        if (randInt <= 7) {
            description = "Hidden";
            //is diggable && buildable
        } else if (randInt <= 24) {
            description = "Woodland";
            //is choppable && buildable

        } else {
            description = "Empty";

            // is diggable && buildable
        }
        
    }

    public Space(String nonsense) {
        if (description.equalsIgnoreCase("Woodland")) {
            //is choppable && buildable
        } else if (description.equalsIgnoreCase("Empty")) {
            // is diggable && buildable
        } else if (description.equalsIgnoreCase("Hidden")) {
            hidden();
            System.out.println("Do you want to dig, build, or go somewhere else?");
        }
    }
    
    public void action(String desc) {
        Scanner keyboard = new Scanner(System.in);
        String input;
        if (desc.equalsIgnoreCase("Woodland")) {
            input = keyboard.nextLine();
            if (input.equalsIgnoreCase("chop")) {
                
            }
        }
    }

    public void hidden() {
//        rand = new Random();
//        Player player = new Player();
//        int randInt2 = rand.nextInt(9);
//        if (randInt2 <= 3) {
//            player.setTools("axe");
//            System.out.println("You picked up an Axe!");
//            ///pickup axe
//        } else if (randInt2 <= 6) {
//            player.setTools("shovel");
//            System.out.println("You picked up a Shovel!");
//            ///pickup shovel
//        } else {
//            player.setTools("hammer");
//            System.out.println("You picked up a Hammer!");
//            //pickup hammer
//        }
//        description = "Empty";
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
    
     @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
//                builder.append("Description: ");
                builder.append(description);
                builder.append("\n");
        

        return builder.toString();

    }
   
    public boolean dig(Player player) {
        if (player.canDig()) {
            setDescription("you dug a hole in this space");
            return true;
        }
        return false;
    }
    

    public boolean chop(Player player) {
        if (player.canChop()) {
            setDescription("you chopped a tree down in this space");
            return true;
        }
        return false;
    }
    

    public boolean build(Player player) {
        if (player.canBuild()) {
            setDescription("you built a structure in this space");
            return true;
        }
        return false;

    }

    ///   dig
}
