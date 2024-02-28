package finalproj;

public class KitchenAdventureTest {
    public static void main(String[] args) {
        // instances of Utensil and Ingredient
        Utensil spatula = new Utensil("Spatula");
        Ingredient onion = new Ingredient("Onion");

        // instance of Chef with the Utensil and Ingredient
        Chef chefRicky = new Chef("Chef Ricky", spatula, onion);

        // Test the Chef's cooking method
        chefRicky.cook();
    }
}
