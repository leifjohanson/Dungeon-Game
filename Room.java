import java.util.Random;
import java.util.Scanner;

public class Room {
    private boolean visited = false;

    public boolean getVisited() {
        return visited;
    }

    public Room()  {}
    // to check that the first room isnt visited
    public Room(boolean check) {
        if(check) {
            visited = true;
        }
    }

    // enter method to be called when a room is entered
    public void enter(Player player) {
        Random r = new Random();
        Scanner s = new Scanner(System.in);

        if (visited) {
            System.out.println("This room has been visited");
        }

        while (!visited) {
            int number = r.nextInt(3);;

            if (number == 0) {
                // monster
                Monster m = new Monster();
                m.generateMonster();
                System.out.println("A " + m.getMonsterType() + " appears!");
                while (m.getMonsterHealth() > 0) {
                    System.out.println("What will you do? \n[1] Attack\n[2] Run");
                    String input = s.nextLine();
                    // attack choice
                    if (input.equals("1")) {
                        m.attack(player);
                        player.onHit(m.getDamage());
                        player.attack(m);
                        m.onHit(player.getDamage());
                        System.out.println("The " + m.getMonsterType() + " hits you for " + m.getDamage() + " damage!");
                        System.out.println("You attack the " + m.getMonsterType() + " for " + player.getDamage() + " health!");
                        if (m.getMonsterHealth() > 0) {
                            System.out.println("The " + m.getMonsterType() + " has " + m.getMonsterHealth() + " health remaining!");
                            //break;
                        } else {
                            System.out.println("The " + m.getMonsterType() + " has " + 0 + " health remaining!");
                        }

                        if (m.getMonsterHealth() <= 0) {
                            System.out.println("You defeated the monster!");
                        }
                    }
                    //run choice
                    else if (input.equals("2")) {
                        m.attack(player);
                        player.onHit(m.getDamage());
                        System.out.println("The " + m.getMonsterType() + " hits you for " + m.getDamage() + " damage!");
                        System.out.println("You ran away successfully!");
                        break;
                    }
                }
            }
            else if (number == 1) {
                /* gold */
                int lootedGold = r.nextInt(20) + 1;
                player.onLoot(lootedGold);
            }
            else if (number == 2) {
                /* heal */
                int healAmount = r.nextInt(7) + 1;
                player.onHeal(healAmount);
            }
            visited = true;

        }
    }
}