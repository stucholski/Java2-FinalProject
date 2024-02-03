package finalproj;

public class Ingredient implements Item {
    private String name;

    public Ingredient(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}