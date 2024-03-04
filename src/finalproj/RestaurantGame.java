package finalproj;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Time;
import java.time.LocalTime;
import java.util.Locale;
import java.util.function.*;


public class RestaurantGame {
    final static Logger log = LogManager.getLogger();
    /**
     * The main method starts the program and accepts user input.
     * After input is received, it is passed to the ReviewInput method.
     * If quit is entered, the program stops.
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        log.info("Game has started....");
        BufferedReader in;
        String input;
        String output;
        GameEngine engine = new GameEngine();

        log.info("Setting up the communications for the game.");
        Locale locale = Locale.getDefault();
        LocalTime localTime = LocalTime.now();
        Communications communications = new Communications(locale, localTime);

        in = new BufferedReader(new InputStreamReader(System.in));

       System.out.println(communications.getIntroMessage());
        //starts the games time counter
        TimeCounter timeCounter = TimeCounter.getInstance();
        engine.displayStart();
        do {
            System.out.print("\n> ");
            input = in.readLine();
            output = engine.reviewInput(input);

            System.out.println(output);
            //testing the performCustomerInteraction method. Maybe this can go after the chef cooks the meal and the customer gets his dish.
            performCustomerInteraction();

        }while (!"quit".equals(input));

        //at the end of the game the elapsed time is shown to the user
        long elapsedTime = timeCounter.getElapsedTime();
        System.out.println("Elapsed Time: " + elapsedTime + " seconds");
    }

    /**
     * 	Use of lambda expressions in at least five scenarios to interact with a customer
     */
    private static void performCustomerInteraction() {
        //  Provides a customer with initial satisfaction
        Supplier<Customer> customerSupplier = () -> new Customer("Gordon Ramsey", 85);
        Customer customer = customerSupplier.get();
        System.out.println("Customer created: " + customer.getName() + ", Satisfaction: " + customer.getSatisfaction());

        //  Affects the customer's satisfaction after he is served
        Consumer<Customer> serveCustomer = cust -> {
            cust.setSatisfaction(cust.getSatisfaction() + 15);
            System.out.println("Customer served! Updated Satisfaction: " + cust.getSatisfaction());
        };
        serveCustomer.accept(customer);

        // Checks if the customer is satisfied
        Predicate<Customer> isSatisfiedCustomer = cust -> cust.getSatisfaction() >= 100;
        System.out.println("Customer Satisfied? " + isSatisfiedCustomer.test(customer));

        //  Retrieves the name of the customer
        Function<Customer, String> customerNameExtractor = Customer::getName;
        System.out.println("Customer Name: " + customerNameExtractor.apply(customer));

        // Increases the customer's experience after user gives them a bottle of wine
        UnaryOperator<Customer> upgradeExperience = cust -> {
            cust.setSatisfaction(cust.getSatisfaction() + 20);
            System.out.println("You gave the customer a bottle of wine! Updated Satisfaction: " + cust.getSatisfaction());
            return cust;
        };
        customer = upgradeExperience.apply(customer);
    }

}
