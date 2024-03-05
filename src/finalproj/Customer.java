package finalproj;

import java.util.function.*;

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

    public Customer() {

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

     /**
     * Provides a customer with initial satisfaction
     */
    static Customer createCustomer() {
        Supplier<Customer> customerSupplier = () -> new Customer("Gordon Ramsey", 85);
        Customer customer = customerSupplier.get();
        System.out.println("You have a very important customer, " + customer.getName() + ", with a " +
                            "satisfaction rating of " + customer.getSatisfaction() + ". Make sure to impress him!") ;
        return customer;
    }

    /**
     * Affects the customer's satisfaction after he is served
     */
    static void serveCustomer(Customer customer) {
        Consumer<Customer> serveCustomer = cust -> {
            cust.setSatisfaction(cust.getSatisfaction() + 15);
            System.out.println("Customer served! Updated Satisfaction: " + cust.getSatisfaction());
        };
        serveCustomer.accept(customer);
    }

    /**
     * Checks if the customer is satisfied
     */
    static void checkSatisfaction(Customer customer) {
        Predicate<Customer> isSatisfiedCustomer = cust -> cust.getSatisfaction() >= 100;
        System.out.println("Customer Satisfied? " + isSatisfiedCustomer.test(customer));
    }

    /**
     * Retrieves the name of the customer
     */
    static void getCustomerName(Customer customer) {
        Function<Customer, String> customerNameExtractor = Customer::getName;
        System.out.println("Customer Name: " + customerNameExtractor.apply(customer));
    }

    /**
     * Increases the customer's experience after the user gives them a bottle of wine
     */
    static Customer upgradeCustomerExperience(Customer customer) {
        UnaryOperator<Customer> upgradeExperience = cust -> {
            cust.setSatisfaction(cust.getSatisfaction() + 20);
            System.out.println("You gave the customer a bottle of wine! Updated Satisfaction: " + cust.getSatisfaction());
            return cust;
        };
        return upgradeExperience.apply(customer);
    }


}