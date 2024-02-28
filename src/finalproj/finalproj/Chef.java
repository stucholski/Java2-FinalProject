package finalproj;

public class Chef {
    private String chefName;
    private Cookware tool;
    private Item ingredient;

    public Chef(String chefName, Cookware tool, Item ingredient) {
        this.chefName = chefName;
        this.tool = tool;
        this.ingredient = ingredient;
    }

    public void cook() {
        System.out.println(chefName + " is cooking with " + tool.getName() + " using " + ingredient.getName() + ".");
        tool.use();
    }
}