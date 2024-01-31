package finalproj;

public enum Item {
    knife("knife", 1),

    chicken("chicken",5),

    salt("salt", .03f),

    plate("plate", .5f),

    sugar("sugar",.3f),

    fryPan("fry pan",3);

    private final float weight;

    private final String name;

    private Item(final String name, final float weight ){
        this.weight = weight;
        this.name = name;
    }

    public float getWeight(){
        return this.weight;
    }

    public String getName(){
        return this.name;
    }



}
