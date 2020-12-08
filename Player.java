import java.util.Random;

public class Player {
    private int health;
    private int gold;
    private int damage;
    private String playerClass;
    private final int WARRIOR_MAX_HEALTH = 100;
    private final int THIEF_MAX_HEALTH = 70;

    // accessor and mutator methods
    Monster m = new Monster();
    public int getDamage() {
        return damage;
    }
    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public int getGold() {
        return gold;
    }
    public void setGold(int gold) {
        this.gold = gold;
    }
    public String getPlayerClass() {
        return playerClass;
    }
    public void setPlayerClass(String playerClass) {
        this.playerClass = playerClass;
    }

    // sets the damage depending on the player
    public void attack(Monster target) {
        if(playerClass.equals("1")) {
            damage = 15;
        }
        else if(playerClass.equals("2")) {
            damage = 10;
        }
    }

    // takes away health
    public void onHit(int damage) {

        if(getHealth() <= 0) {
            System.out.println("You died. Game over.");
            System.exit(0);
        }
        else{
            health -= damage;
        }
    }

    // heals the player on an amount based on the healing potion found
    public void onHeal(int amountHealed) {
        if(playerClass.equals("1")) {
            if(health + amountHealed > WARRIOR_MAX_HEALTH) {
                health = WARRIOR_MAX_HEALTH;
                System.out.println("You were healed to full HP!");
            }
            else {
                health += amountHealed;
                System.out.println("You were healed by " + amountHealed + " HP!");
            }
        }
        else if(playerClass.equals("2")) {
            if(health + amountHealed > THIEF_MAX_HEALTH) {
                health = THIEF_MAX_HEALTH;
                System.out.println("You were healed to full HP!");
            }
            else {
                health += amountHealed;
                System.out.println("You were healed by " + amountHealed + " HP!");
            }
        }
    }

    // gives the player gold base on the looted gold
    public void onLoot(int lootedGold) {
        System.out.println("You found " + lootedGold + " gold!");

        if(playerClass.equals("1")) {
            gold += lootedGold;

        }
        else if(playerClass.equals("2")) {
            gold += 1.2*lootedGold;

        }
    }

}