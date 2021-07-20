package project4;

import java.io.*;
import java.util.Scanner;

public class Project4 {

    private static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {

        Player player = new Player("Eric");
        Island currentIsland = player.getHome();
        currentIsland.addPlayer(player);

        String choice = "";

        while (!choice.equalsIgnoreCase("quit")) {

            int currentX = player.getLocationX();
            int currentY = player.getLocationY();
            Space currentSpace = currentIsland.getSpace(currentX, currentY);

            System.out.println(String.format("%s's island at X: %d Y: %d - %s",
                    currentIsland.getOwnersName(), currentX, currentY, currentSpace.getDescription()));
            choice = optionsMenu();

            if (choice.equalsIgnoreCase("up")) {
                if (currentIsland.isValidLocation(currentX, currentY - 1)) {
                    player.setLocationY(currentY - 1);
                } else {
                    System.out.println("You can't go up from here");
                }
            } else if (choice.equalsIgnoreCase("down")) {
                if (currentIsland.isValidLocation(currentX, currentY + 1)) {
                    player.setLocationY(currentY + 1);
                } else {
                    System.out.println("You can't go down from here");
                }
            } else if (choice.equalsIgnoreCase("right")) {
                if (currentIsland.isValidLocation(currentX + 1, currentY)) {
                    player.setLocationX(currentX + 1);
                } else {
                    System.out.println("You can't go right from here");
                }
            } else if (choice.equalsIgnoreCase("left")) {
                if (currentIsland.isValidLocation(currentX - 1, currentY)) {
                    player.setLocationX(currentX - 1);
                } else {
                    System.out.println("You can't go left from here");
                }
            } else if (choice.equalsIgnoreCase("chop")) {
                if (currentIsland.canChopSpace(player)) {
                    ((ChopableSpace) currentIsland.getSpace(currentX, currentY)).chop(player);
                } else {
                    System.out.println("You can't chop here");
                }
            } else if (choice.equalsIgnoreCase("build")) {
                if (currentIsland.canBuildSpace(player)) {
                    ((BuildableSpace) currentIsland.getSpace(currentX, currentY)).build(player);
                } else {
                    System.out.println("You can't build here");
                }
            } else if (choice.equalsIgnoreCase("dig")) {
                if (currentIsland.canDigSpace(player)) {
                    ((DiggableSpace) currentIsland.getSpace(currentX, currentY)).dig(player);
                } else {
                    System.out.println("You can't dig here");
                }
            } else if (choice.equalsIgnoreCase("list")) {
                System.out.println("Current tools: ");
                for (Tool tool : player.getTools()) {
                    System.out.println(tool);
                }
            } else if (choice.equalsIgnoreCase("add friend")) {
                System.out.println("What's your friends name?");
                String friendName = keyboard.nextLine();
                Player friend = new Player(friendName);
                player.addFriend(friend);
                System.out.println("Added " + friendName + " as a friend");
            } else if (choice.equalsIgnoreCase("visit friend")) {
                System.out.println("What's your friends name?");
                String friendName = keyboard.nextLine();
                for (Player friend : player.getFriends()) {
                    if (friend.getName().equalsIgnoreCase(friendName)) {
                        currentIsland.removePlayer(player);
                        currentIsland = friend.getHome();
                        currentIsland.addPlayer(player);
                        System.out.println("Traveled to "
                                + currentIsland.getOwnersName() + "'s island");
                    }
                }

            } else if (choice.equalsIgnoreCase("go home")) {
                if (currentIsland != player.getHome()) {

                    currentIsland.removePlayer(player);
                    currentIsland = player.getHome();
                    currentIsland.addPlayer(player);
                    System.out.println("Traveled to "
                            + currentIsland.getOwnersName() + "'s island");
                } else {
                    System.out.println("You are already home!");
                }
            } else if (choice.equalsIgnoreCase(
                    "pickup")) {
                if (currentIsland.getSpace(currentX, currentY).hasTool()) {
                    Tool tool = currentIsland.getSpace(currentX, currentY).getTool();
                    player.addTool(tool);
                    currentIsland.getSpace(currentX, currentY).setTool(null);
                    currentIsland.getSpace(currentX, currentY).setDescription("empty space");
                    System.out.println("You pickup the " + tool);
                } else {
                    System.out.println("There is nothing to pickup here");
                }
            } else if (choice.equalsIgnoreCase(
                    "save")) {
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream("savegame.dat");
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                    objectOutputStream.writeObject(player);
                    objectOutputStream.writeObject(currentIsland);
                    objectOutputStream.close();
                    System.out.println("Saved game!");
                } catch (IOException ex) {
                    System.out.println(ex);
                }

            } else if (choice.equalsIgnoreCase(
                    "load")) {
                try {
                    FileInputStream fileInputStream = new FileInputStream("savegame.dat");
                    ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                    player = (Player) objectInputStream.readObject();
                    currentIsland = (Island) objectInputStream.readObject();
                    objectInputStream.close();
                    System.out.println("Loaded game!");
                } catch (IOException | ClassNotFoundException ex) {
                    System.out.println(ex);
                }
            }
        }

        System.out.println(
                "Thanks for playing our animal craft game!");
    }

    private static String optionsMenu() {
        String choice = "";

        while (!choice.equalsIgnoreCase("up")
                && !choice.equalsIgnoreCase("down")
                && !choice.equalsIgnoreCase("left")
                && !choice.equalsIgnoreCase("right")
                && !choice.equalsIgnoreCase("dig")
                && !choice.equalsIgnoreCase("build")
                && !choice.equalsIgnoreCase("chop")
                && !choice.equalsIgnoreCase("pickup")
                && !choice.equalsIgnoreCase("quit")
                && !choice.equalsIgnoreCase("save")
                && !choice.equalsIgnoreCase("load")
                && !choice.equalsIgnoreCase("list")
                && !choice.equalsIgnoreCase("add friend")
                && !choice.equalsIgnoreCase("visit friend")
                && !choice.equalsIgnoreCase("go home")) {

            System.out.println("Do you want to go up, down, left, or right, build, "
                    + "dig, chop, pickup a tool, list, save, load, "
                    + "add friend, visit friend, go home, or quit");
            choice = keyboard.nextLine();
        }

        return choice;
    }

}
