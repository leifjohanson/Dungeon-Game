import java.util.Scanner;

public class DungeonMap {
    private Room[][] rooms;
    private final String EMPTY_POSITION = "  ";
    private int xPlayer;
    private int yPlayer;

    public DungeonMap(int rows, int columns){
        xPlayer = 1;
        yPlayer = 1;
        rooms = new Room[rows][columns];

        for(int i = 0; i < rooms.length; i++) {
            for( int j = 0; j < rooms[i].length; j++) {
                rooms[i][j] = new Room();
            }
        }
        rooms[0][0] = new Room(true);
    }

    public void print() {
        // go through each room in the 2D array and prints out the corresponding object
        for(int i = 0; i < rooms.length; i++) {
            for(int j = 0; j < rooms[i].length; j++) {

                if(j == 0) {
                    System.out.print("* ");
                }
                else if(j == rooms.length - 1) {
                    System.out.print(" *");
                }
                else if(i == 0) {
                    System.out.print("* ");
                }
                else if(i == rooms[0].length - 1) {
                    System.out.print(" *" );
                }
                else if(i==xPlayer && j == yPlayer) {
                    System.out.print("P ");
                }
                else if(rooms[i][j].getVisited()) {
                    System.out.print("- ");
                }
                else {
                    System.out.print(EMPTY_POSITION);
                }
            }
            System.out.print("\n");
        }
    }
    // controls the player movement based on WASD input
    public Room movement() {
        Scanner s = new Scanner(System.in);
        String wasd = s.nextLine().toUpperCase();

        if(wasd.equals("W")){
            if(xPlayer == 1){
                System.out.println("There is a wall in the way!");
            }
            else{
                xPlayer -= 1;
                System.out.println("You entered a room...");
            }

        }
        else if(wasd.equals("A")){
            if(yPlayer == 1) {
                System.out.println("There is a wall in the way!");
            }
            else{
                yPlayer -= 1;
                System.out.println("You entered a room...");
            }

        }
        else if(wasd.equals("S")){
            if(xPlayer == rooms[0].length - 2){
                System.out.println("There is a wall in the way");
            }
            else{
                xPlayer += 1;
                System.out.println("You entered a room...");
            }

        }
        else if(wasd.equals("D")){
            if(yPlayer == rooms.length - 2){
                System.out.println("There is a wall in the way!");
            }
            else{
                yPlayer += 1;
                System.out.println("You entered a room...");
            }
        }
        else{
            System.out.println("Input in invalid. Please try again!");
        }

        return rooms[xPlayer][yPlayer];

    }
}