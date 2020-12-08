import java.util.Random;

public class Monster {
    private int health;
    private int damage;
    private String monsterType;
    private final int DENEKE_DAMAGE = 5;
    private final int GOBLIN_DAMAGE = 10;
    private final int ZOMBIE_DAMAGE = 15;
    private final int ORC_DAMAGE = 20;
    private final int DENEKE_HEALTH = 55;
    private final int ORC_HEALTH = 18;
    private final int ZOMBIE_HEALTH = 12;
    private final int GOBLIN_HEALTH = 6;

    public String getMonsterType() {
        return monsterType;
    }
    public int getMonsterHealth() {
        return health;
    }
    public int getDamage() {
        return damage;
    }

    // generates a random monster
    public String generateMonster() {
        Random r = new Random();
        int number = r.nextInt(4);
        if(number == 0) {
            monsterType = "deneke";
            health = DENEKE_HEALTH;
        }
        else if(number == 1) {
            monsterType = "goblin";
            health = GOBLIN_HEALTH;

        }
        else if(number == 2) {
            monsterType = "zombie";
            health = ZOMBIE_HEALTH;
        }
        else if(number == 3) {
            monsterType = "orc";
            health = ORC_HEALTH;
        }

        return monsterType;
    }

    // sets the damage to a random amount between 1-max
    public void attack(Player target) {
        Random r = new Random();
        if(monsterType.equals("deneke")){
            damage = r.nextInt(DENEKE_DAMAGE) + 1;
        }
        if(monsterType.equals("goblin")){
            damage = r.nextInt(GOBLIN_DAMAGE) + 1;
        }
        if(monsterType.equals("zombie")){
            damage = r.nextInt(ZOMBIE_DAMAGE) + 1;
        }
        if(monsterType.equals("orc")){
            damage = r.nextInt(ORC_DAMAGE) + 1;
        }

    }

    // takes away the damage from total monster health
    public void onHit(int damage) {
        health -= damage;
    }
}