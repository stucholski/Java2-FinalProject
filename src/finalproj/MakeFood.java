package finalproj;
import java.util.*;

/**
 * Represents a recipe with a name and a complexity level.
 */
class Recipe implements Comparable<Recipe> {
    private String name;
    private int complexityLevel;

    /**
     * Constructs a recipe with the given name and complexity level.
     *
     * @param name            The name of the recipe.
     * @param complexityLevel The complexity level of the recipe.
     */
    public Recipe(String name, int complexityLevel) {
        this.name = name;
        this.complexityLevel = complexityLevel;
    }

    /**
     * Gets the name of the recipe.
     *
     * @return The name of the recipe.
     */
    public String getName() {
        return name;
    }
    /**
     * Gets the complexity level of the recipe.
     *
     * @return The complexity level of the recipe.
     */

    public int getComplexityLevel() {
        return complexityLevel;
    }

    /**
     * Compares recipes based on their names.
     *
     * @param other The other recipe to compare.
     * @return A negative integer, zero, or a positive integer as this recipe is less than, equal to, or greater than the other.
     */
    @Override
    public int compareTo(Recipe other) {
        return this.name.compareTo(other.name);
    }

    /**
     * Comparator for comparing recipes based on complexity level.
     */
    public static Comparator<Recipe> ComplexityComparator = Comparator.comparingInt(Recipe::getComplexityLevel);
}

/**
 * Main class to make food.
 */
public class MakeFood {
    public static void main(String[] args) {
        // Using Comparable
        Set<Recipe> recipeSet = new TreeSet<>();
        recipeSet.add(new Recipe("Spaghetti", 2));
        recipeSet.add(new Recipe("Cake", 3));
        recipeSet.add(new Recipe("Salad", 1));

        System.out.println("Recipes (Sorted by Name):");
        for (Recipe recipe : recipeSet) {
            System.out.println(recipe.getName());
        }

        // Using Comparator
        List<Recipe> recipes = new ArrayList<>();
        recipes.add(new Recipe("Pasta", 4));
        recipes.add(new Recipe("Soup", 1));
        recipes.add(new Recipe("Pizza", 3));

        System.out.println("\nRecipes (Sorted by Complexity Level):");
        Collections.sort(recipes, Recipe.ComplexityComparator);
        for (Recipe recipe : recipes) {
            System.out.println(recipe.getName() + " (Complexity: " + recipe.getComplexityLevel() + ")");
        }
    }
}

