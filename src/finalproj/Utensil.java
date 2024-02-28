package finalproj;

interface Cookware extends Item {
    void use();
}
public class Utensil implements Cookware  {
    private String name;

    public Utensil(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void use() {
        System.out.println(name + " is used for cooking.");
    }
}