package finalproj;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

/**
 * Represents a non player character
 * Constructs an NPC with a name and health.
 * Gets and sets the name and health
 */
class NPC {
    private String name;
    private int health;

    public NPC(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}

/**
 * Example showing how to use functional interfaces in NPC interaction.
 */

public class NPCInteractionExample {

    /**
     * Main method to run the NPC interaction.
     */

    public static void main(String[] args) {
        // 1. Supplier: Provides an NPC with initial health
        Supplier<NPC> npcSupplier = () -> new NPC("Waiter", 80);
        NPC waiter = npcSupplier.get();
        System.out.println("NPC created: " + waiter.getName() + ", Health: " + waiter.getHealth());

        // 2. Consumer: Attacks the NPC, reducing its health
        Consumer<NPC> attackNPC = npc -> {
            npc.setHealth(npc.getHealth() - 15);
            System.out.println("NPC attacked! Updated Health: " + npc.getHealth());
        };
        attackNPC.accept(waiter);

        // 3. Predicate: Checks if the NPC is defeated
        Predicate<NPC> isDefeatedNPC = npc -> npc.getHealth() <= 0;
        System.out.println("NPC Defeated? " + isDefeatedNPC.test(waiter));

        // 4. Function: Retrieves the name of the NPC
        Function<NPC, String> npcNameExtractor = NPC::getName;
        System.out.println("NPC Name: " + npcNameExtractor.apply(waiter));

        // 5. UnaryOperator: Heals the NPC and prints the updated health
        UnaryOperator<NPC> healNPC = npc -> {
            npc.setHealth(npc.getHealth() + 20);
            System.out.println("NPC healed! Updated Health: " + npc.getHealth());
            return npc;
        };
        waiter = healNPC.apply(waiter);
    }
}
