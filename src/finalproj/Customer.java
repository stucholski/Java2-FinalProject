package finalproj;

/**
 * Used for the functional interfaces examples
 */
public class Customer {
    private String name;
    private int satisfaction;

    public Customer(String name, int satisfaction) {
        this.name = name;
        this.satisfaction = satisfaction;
    }

    public String getName() {
        return name;
    }

    public int getSatisfaction() {
        return satisfaction;
    }

    public void setSatisfaction(int satisfaction) {
        this.satisfaction = satisfaction;
    }
}