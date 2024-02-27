package finalproj;

public enum Item {
    Knife("knife", 1, "utensil"),

    Chicken("chicken",5, "ingredient"),

    Salt("salt", .03f, "utensil"),

    Plate("plate", .5f, "utensil"),

    Sugar("sugar",.3f, "ingredient"),

    FryPan("fry pan",3, "utensil");

    private final float weight;

    private final String name;

    private final String type;

    private Item(String name, float weight, String type){
        this.weight = weight;
        this.name = name;
        this.type = type;
    }

    public float getWeight(){
        return this.weight;
    }

    public String getName(){
        return this.name;
    }



}
