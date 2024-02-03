package finalproj;

public class KitchenAdventure implements KitchenActions{
    private String playerName;

    // Constructor
    public KitchenAdventure(String playerName) {
        this.playerName = playerName;
    }

    @Override
    public void enterKitchen() {
        System.out.println(playerName + " enters the kitchen.");
    }

    @Override
    public void exploreKitchen() {
        System.out.println(playerName + " explores the kitchen, looking for interesting things.");
    }

    @Override
    public void interactWithObjects() {
        System.out.println(playerName + " interacts with various objects in the kitchen.");
    }

    @Override
    public void prepareMeal() {
        System.out.println(playerName + " decides to prepare a delicious meal in the kitchen.");
    }

    // Example: getName method
    public String getPlayerName() {
        return playerName;
    }

    public static void main(String[] args) {
        // Example usage
        KitchenAdventure playerOne = new KitchenAdventure("Alice");
        playerOne.enterKitchen();
        playerOne.exploreKitchen();
        playerOne.interactWithObjects();
        playerOne.prepareMeal();

    }
}
