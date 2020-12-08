import java.awt.*;
import java.util.Scanner;

public class DungeonGame {
    private DungeonMap map;
    private Player player;
    private Scanner input = new Scanner(System.in);
    private int rows;
    private int columns;
    private final String SELECT_DOOR = "Select a door: [W] up, [A] left, [S] down, [D] right";
    private final String SEPARATOR = "=====================================";
    // constructor
    public DungeonGame(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }
    // play method to run the whole program
    public void play() {
        introText();
        String pClass = input.nextLine();
        while(!pClass.equals("1") && !pClass.equals("2")) {
            System.out.println("Invalid input, please try again");
            pClass = input.nextLine();
        }
        player = new Player();
        player.setPlayerClass(pClass);
        String icon;
        if (player.getPlayerClass().equals("1")) {
            icon = "W ";
        } else {
            icon = "T ";
        }

        map = new DungeonMap(rows, columns);
        boolean checker = true;
        if (player.getPlayerClass().equals("1")) {
            player.setHealth(100);
        } else if (player.getPlayerClass().equals("2")) {
            player.setHealth(70);
        }
        player.setGold(0);
        while (checker) {
            System.out.println(SEPARATOR);
            map.print();
            System.out.println("HP: " + player.getHealth());
            System.out.println("GOLD: " + player.getGold());
            System.out.println(SELECT_DOOR);
            Room currentRoom = map.movement();
            currentRoom.enter(player);
            if(isGoldFull()) {
                checker = false;
                System.out.println("You collected 100 gold! You win!");
            }
            if(isPlayerDead()) {
                checker = false;
                System.out.println("You died. Game over. Play again?");
            }
        }
    }

    // intro text
    private void introText() {
        System.out.println(SEPARATOR);
        System.out.println("You have been locked in a dungeon!");
        System.out.println("In each room, you will find either monsters, healing elixirs, or gold");
        System.out.println("Can you find 100 gold to pay the evil professor to let you out before the monsters kill you?");
        System.out.println("Select your class: \n[1] Warrior \n[2] Thief");
    }
    // check if the gold has reached 100
    public boolean isGoldFull() {
        if (player.getGold() >= 100) {
            return true;
        }
        else{
            return false;
        }
    }
    // check if the health is 0
    public boolean isPlayerDead() {
        if (player.getHealth() <= 0) {
            return true;
        }
        else{
            return false;
        }
    }
}