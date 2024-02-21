package finalproj;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

interface Item {
    String getName();
}

public class Ingredient implements Item {
    private String name;

    public Ingredient(String name) {
        this.name = name;
    }


    @Override
    public String getName() {
        return name;
    }

    public static void main(String[] args) {

        /**
         * added a set of type String to hold available ingredients
         * checks to see if the ingredient is available
         */
        Set<String> availableIngredients = new HashSet<>();
        availableIngredients.add("noodles");
        availableIngredients.add("sauce");
        availableIngredients.add("meat");

// Check if an ingredient is available
        if (availableIngredients.contains("sauce")) {
            System.out.println("Ingredient is available");
        } else {
            System.out.println("Sorry that ingredient is currently not in stock");
        }
        /**
         * added a map of type String, String that holds combinations of ingredients used in common recipies.
         * retreives on of the keys in the map to show the user what that combination creates.
         * if no key is found user is told there is no defined recipe for that combination.
         */
        Map<String, String> playerCooks = new HashMap<>();
        playerCooks.put("noodle_sauce", "spaghetti");
        playerCooks.put("meat_sauce", "meatball");
        String result = playerCooks.get("noodle_sauce");
        if (result != null) {
            System.out.println("Combining noodles and sauce creates " + result);
        } else {
            System.out.println("No recipe is defined with current combination of ingredients");
        }
        result = playerCooks.get("meat_sauce");
        if (result != null) {
            System.out.println("Combining meat and sauce creates " + result);
        } else {
            System.out.println("No recipe is defined with current combination of ingredients");
        }


    }
}
