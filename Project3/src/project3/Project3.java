package project3;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Project3 {

    private static ArrayList<ArrayList<Space>> gridSpace;
    private static Space space;
    private static Space space1;
    private static Space space2;
    private static Space space3;
    private static int i;
    private static int j;
    private static Player player;

    public static void main(String[] args) {
        i = 5;
        j = 0;
        player = new Player();
        game();

    }

    public static void game() {
        Island island = new Island();
        System.out.println(island);
        gridSpace = island.getGrid();
        direction();

    }

    public static void direction() {
        System.out.println("You are now at: ");
        System.out.println("X = " + i + "     Y = " + j);
        if (i >= 1) {
            space = gridSpace.get(i - 1).get(j);
            System.out.println("Above you is " + space);
        }
        if (j <= 10) {
            space1 = gridSpace.get(i).get(j + 1);
            System.out.println("To the right of you is " + space1);
        }
        if (i <= 8) {
            space2 = gridSpace.get(i + 1).get(j);
            System.out.println("Below you is " + space2);
        }
        if (j >= 1) {
            space3 = gridSpace.get(i).get(j - 1);
            System.out.println("To the left of you is " + space3);
        }

        System.out.println("What direction do you want to go to?");
        Scanner keyboard = new Scanner(System.in);
        String keyboardString = keyboard.nextLine();
        if (keyboardString.equalsIgnoreCase("Above")) {
            if (i >= 1) {
            i--;
            spaceAction(space);
            } else {
                System.out.println("You cannot do that!");
                direction();
            }
        } else if (keyboardString.equalsIgnoreCase("Below")) {
            if (j <= 10) {
            i++;
            spaceAction(space2);
            } else {
                System.out.println("You cannot do that!");
                direction();
            }
        } else if (keyboardString.equalsIgnoreCase("Right")) {
            if (i <= 8) {
            j++;
            spaceAction(space1);
            } else {
                System.out.println("You cannot do that!");
                direction();
            }
        } else if (keyboardString.equalsIgnoreCase("Left")) {
            if (j >= 1) {
            j--;
            spaceAction(space3);
            } else {
                System.out.println("You cannot do that!");
                direction();
            }
        }
    }

    public static void spaceAction(Space designatedSpace) {
        boolean temp;
        if (designatedSpace.getDescription().equalsIgnoreCase("Woodland")) {
            System.out.println("Do you want to chop, build, or go somewhere else?");
            Scanner keyboard = new Scanner(System.in);
            switch (keyboard.nextLine()) {
                case "chop":
                    temp = designatedSpace.chop(player);
                    if (!temp) {
                        System.out.println("You dont have to right tool!");
                        spaceAction(designatedSpace);
                    } else {
                        System.out.println(designatedSpace.getDescription());
                        direction();
                    }
                    break;
                case "build":
                    temp = designatedSpace.build(player);
                    if (!temp) {
                        System.out.println("You dont have to right tool!");
                        spaceAction(designatedSpace);
                    } else {
                        System.out.println(designatedSpace.getDescription());
                        direction();
                    }

                    break;
                default:
                    direction();
            }
//            if (keyboard.nextLine().equalsIgnoreCase("chop")) {
//                temp = designatedSpace.chop(player);
////                ChoppableSpace choppableSpace = new ChoppableSpace();
////                choppableSpace.chop(player);
////                System.out.println(designatedSpace.getDescription());
//                if (!temp) {
//                    System.out.println("You dont have to right tool!");
//                    spaceAction(designatedSpace);
//                } else {
//                    System.out.println(designatedSpace.getDescription());
//                    direction();
//                }
//            }
//            if (keyboard.nextLine().equalsIgnoreCase("build")) {
////                BuildableSpace buildableSpace = new BuildableSpace();
////                buildableSpace.build(player);
////                 System.out.println(designatedSpace.getDescription());
//                temp = designatedSpace.build(player);
//                if (!temp) {
//                    System.out.println("You dont have to right tool!");
//                    spaceAction(designatedSpace);
//                } else {
//                    System.out.println(designatedSpace.getDescription());
//                    direction();
//                }
//            } else {
//                direction();
//            }
        } else if (designatedSpace.getDescription().equalsIgnoreCase("Empty")) {
            System.out.println("Do you want to dig, build, or go somewhere else?");
            Scanner keyboard = new Scanner(System.in);
            switch (keyboard.nextLine()) {
                case "dig":
                    temp = designatedSpace.dig(player);
                    if (!temp) {
                        System.out.println("You dont have to right tool!");
                        spaceAction(designatedSpace);
                    } else {
                        System.out.println(designatedSpace.getDescription());
                        direction();
                    }

                    break;
                case "build":
                    temp = designatedSpace.build(player);
                    if (!temp) {
                        System.out.println("You dont have to right tool!");
                        spaceAction(designatedSpace);
                    } else {
                        System.out.println(designatedSpace.getDescription());
                        direction();
                    }
                    break;
                default:
                    direction();
            }
//            if (keyboard.nextLine().equalsIgnoreCase("dig")) {
//                temp = designatedSpace.dig(player);
//                if (!temp) {
//                    System.out.println("You dont have to right tool!");
//                    spaceAction(designatedSpace);
//                } else {
//                    System.out.println(designatedSpace.getDescription());
//                    direction();
//                }
//            }
//            if (keyboard.nextLine().equalsIgnoreCase("build")) {
////                BuildableSpace buildableSpace = new BuildableSpace();
////                buildableSpace.build(player);
//                temp = designatedSpace.build(player);
//                if (!temp) {
//                    System.out.println("You dont have to right tool!");
//                    spaceAction(designatedSpace);
//                } else {
//                    System.out.println(designatedSpace.getDescription());
//                    direction();
//                }
//            } else {
//                direction();
//            }
        } else if (designatedSpace.getDescription().equalsIgnoreCase("Hidden")) {
            Random rand = new Random();
            int randInt2 = rand.nextInt(9);
            if (randInt2 <= 3) {
                player.setCanChop(true);
                System.out.println("You picked up an Axe!");
                ///pickup axe
            } else if (randInt2 <= 6) {
                player.setCanDig(true);
                System.out.println("You picked up a Shovel!");
                ///pickup shovel
            } else {
                player.setCanBuild(true);
                System.out.println("You picked up a Hammer!");
                //pickup hammer
            }
            System.out.println("");
            designatedSpace.setDescription("Empty");
            direction();
        } else {
            direction();
        }
    }
}
