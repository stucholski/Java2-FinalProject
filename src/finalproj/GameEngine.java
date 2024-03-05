package finalproj;

import org.apache.derby.jdbc.EmbeddedDataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

import static finalproj.Customer.*;
import static finalproj.Customer.upgradeCustomerExperience;

public class GameEngine {

    final Logger log = LogManager.getLogger();

    // Attributes to represent the game's state
    private ArrayList<Room> map;
    private Player player;
    Customer gordon = Customer.createCustomer();

    // 3.1 Example of an unbound wildcard
    private List<?> verbs = new ArrayList<>(Arrays.asList("take", "drop", "cook", "look", "prepare", "make", "spaghetti", "serve", "inventory", "move", "go", "help"));
    private List<?> nouns = new ArrayList<>(Arrays.asList("fork", "spoon", "plate", "noodles", "sauce", "spices", "meat","vegatables","ice"," candle","table","chair"));

    // 3.5 Example of a foreach statement

    /**
     * Using a foreach statement to cycle through the unbound wildcard, output each verb
     * @param list
     */
    public static void Actions(List<?> list){
        for (Object x : list)
            System.out.println(x);
    }

    /**
     * Calls the Actions method and outputs a message
     * This will display if the user enters a 'help' command in the reviewInput method
     * @return
     */
    public String Help(){
        String message = "Use one of these actions if you're stuck. ";
        Actions(verbs);
        return message;
    }
    /**
     * Method to give the employee raise and updates the database with user input
     * Try with resources to close database connection
     */
    private static final Scanner scanner = new Scanner(System.in);

    public void giveEmployeeRaise(int employeeId) {
        try {
            EmbeddedDataSource ds = new EmbeddedDataSource();
            ds.setDatabaseName("restaurant_database");

            try (Connection connection = ds.getConnection()) {
                // Ask the user for the raise amount
                System.out.print("Enter the raise amount for employee " + employeeId + ": ");

                // Validate and read the double input
                double raiseAmount = getValidDoubleInput();

                // Use a prepared statement to safely handle user input in the SQL query
                String sql = "UPDATE Employees SET salary = salary + ? WHERE id = ?";
                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                    // Set parameters for the prepared statement
                    preparedStatement.setDouble(1, raiseAmount);
                    preparedStatement.setInt(2, employeeId);

                    // Execute the update
                    int rowsAffected = preparedStatement.executeUpdate();

                    if (rowsAffected > 0) {
                        System.out.println("Raise successfully applied to employee " + employeeId);
                    } else {
                        System.out.println("Employee not found.");
                    }
                }
            }
        } catch (SQLException e) {
            log.error("Error giving employee a raise: " + e.getMessage(), e);
        }
    }//*/

    // Helper method to get valid double input from the user
    private double getValidDoubleInput() {
        while (!scanner.hasNextDouble()) {
            System.out.print("Invalid input. Please enter a valid number: ");
            scanner.next();
        }
        return scanner.nextDouble();
    }


    public GameEngine(String chefName){
        try{
            log.info("Creating rooms.");
            this.map = new ArrayList<Room>();

            Room kitchen = new Room("Kitchen", "A brightly-lit room with tools and utensils for cooking.", 1, 0, 0, 0);
            kitchen.addItem("spoon");
            kitchen.addItem("fork");
            kitchen.addItem("plate");
            map.add(kitchen);

            Room pantry = new Room("Pantry", "A dark room with jars, cans, and boxes of food.", 0, 0, 1, 0);
            pantry.addItem("noodles");
            pantry.addItem("sauce");
            pantry.addItem("spices");
            map.add(pantry);

            Room freezer = new Room("Freezer", "A cold, dimly-lit room with frozen meet, vegetables, and fruit", 0, 0, 0, 1);
            freezer.addItem("meat");
            freezer.addItem("vegetables");
            freezer.addItem("ice");
            map.add(freezer);

            Room dining = new Room("Dining", "A softly-lit room with tables and places set for dining.", 0, 1,0,0);
            dining.addItem("candle");
            dining.addItem("table");
            dining.addItem("chair");

            map.add(dining);



            player = new Player(chefName, map.get(0));

        }catch (Exception ex){
            log.error("There was an error setting up the world.");
        }
    }



    //Made updates so that the players room is set to each room instead of all to kitchen.
    public Player getPlayer() {
        return player;
    }

    private String goKitchen() {
        Room kitchen = map.get(0);
        player.setRoom(kitchen);
        return lookAround();
    }

    private String goPantry() {
        Room pantry = map.get(1);
        player.setRoom(pantry);
        return lookAround();
    }

    private String goFreezer() {
        Room freezer = map.get(2);
        player.setRoom(freezer);
        return lookAround();
    }

    private String goDining() {
        Room dining = map.get(3);
        player.setRoom(dining);
        return lookAround();
    }

    public String movePlayer(String roomName) {
        String moveToRoom = roomName.toLowerCase();
        switch (moveToRoom) {
            case "kitchen":
                return goKitchen();
            case "pantry":
                return goPantry();
            case "freezer":
                return goFreezer();
            case "dining":
                return goDining();
            default:
                return "You can't go there.";
        }
    }

    private String lookAround() {
        Room currentRoom = player.getRoom();
        String description = currentRoom.getDescription();
        List<String> items = currentRoom.getItems();
        //if user looks into the dinning room is asked to ender a raise for rick
        if (currentRoom.getName().equalsIgnoreCase("Dining")) {
            System.out.print("You see Rick the waiter working very hard and you decide he deserves a raise. ");
            giveEmployeeRaise(1); // Ask for a raise for Rick
        }


        if (!items.isEmpty()) {
            String itemsDescription = String.join(", ", items);
            description += " You also see: " + itemsDescription;
        } else {
            description += " The room is empty.";
        }
        return description;
    }

 /*   public int moveTo(Rooms r){
        return move(player, r);
    }
 */

    // Example methods for moving to specific rooms
    //private void goKitchen() { updateOutput(moveTo(Rooms.Kitchen));}
    //private void goPantry() { updateOutput(moveTo(Rooms.Pantry)); }
    //private void goFreezer() { updateOutput(moveTo(Rooms.Freezer)); }
    //private void goDining() { updateOutput(moveTo(Rooms.Dining)); }

    /**
     * Updates the game output based on the player's location.
     */
 /*   void updateOutput(int roomNumber) {
        String s;
        if(roomNumber == Rooms.NOROOMS){
            s = "No room to enter.";
        } else {
            Room r = getPlayer().getRoom();
            s = "You have entered "
                    + r.getName() + ". " + r.getDescription();
        }
        System.out.println(s);
    }
*/
    public void displayStart() {
        String introMessage = """        
        You are the head chef at Sarah's Diner. As the Head Chef your goal is to prepare a dish that can save the diner from closure.
        But first, you must collect four essential ingredients hidden in various locations of your restaurant. The customer ordered a plate
        of spaghetti, Take a look around and see if you can serve the dish.
        
        Available commands:
        - 'look': to look around in the current room.
        - 'move [room]': to move to a different room. For example, 'move kitchen'.
        - 'move to [room]': to move to a different room. For example, 'move kitchen'.
        - 'take [item]': to collect an item in the room.
        - 'drop [item]': to drop an item in the room.
        - 'inventory': to check what items you have collected.
        - 'cook [item]': to cook or prepare the dish with required items
        - 'prepare [item]': to cook or prepare the dish with required items 
        - 'serve': to try to serve the collected items as a dish to the patron.
        - 'quit': to end the game.
        
        Good luck, Chef!
        """;
        System.out.println(introMessage);
    }
    /**
     * When the win condition is found in the checkforWin method, it calls this method to display a message to the player and close the game.
     */
    public void displayEnd(){
        String exitMessage = """
                Congratulations %s!
                You successfully served a dish of spaghetti to the patron.
                See you next time.
        """.formatted(player.getName());


        // Supplier<String> msgDisplay = () -> exitMessage;
        System.out.println(exitMessage);


        System.exit(0);
    }

    /**
     * method to serveDish to the customer/critic
     */
    public void serveDish(){
        System.out.println("The food critic is ready for his meal! Lets find out who it is.");
        getCustomerName(gordon);
        serveCustomer(gordon);
        checkSatisfaction(gordon);
        gordon = upgradeCustomerExperience(gordon);
        serveCustomer(gordon);

    }
    public String takeItem(String itemName) {
        Room currentRoom = player.getRoom();
        if (currentRoom.getItems().contains(itemName)) {
            currentRoom.removeItem(itemName);
            player.addToInventory(itemName);
            return "You took the " + itemName + ".";
        } else {
            return "There's no " + itemName + " here.";
        }
    }
    /**
     * Method to drop an item from the inventory and into the room
     * The itemName comes from the player input from the ReviewInput method
     * @param itemName
     * @return
     */
    public String dropItem(String itemName){
        Room currentRoom = player.getRoom();
        List<String> inventory = player.getInventory();
        if (inventory.isEmpty()){
            return "Your inventory is empty.";
        }else if(player.getInventory().contains(itemName)) {
            player.removeFromInventory(itemName);
            currentRoom.addItem(itemName);
            return "You have removed "+ itemName +" from your inventory.";
        }
        return "There's no "+ itemName +" in your inventory.";
    }

    public String checkInventory() {
        List<String> inventory = player.getInventory();
        if (inventory.isEmpty()) {
            return "Your inventory is empty.";
        } else {
            String items = String.join(", ", inventory);
            return "You have the following items in your inventory: " + items;
        }
    }

    /**
     * This method is called by the user when they input 'cook', 'prepare' or 'make'
     * This checks the inventory for sauce, meat, noodles, and a plate.
     * If these items exist in the player inventory, then the player cooks spaghetti.
     * @return
     */
    public String cookDish(){
        List<String> winItems = new ArrayList<>(Arrays.asList("sauce", "noodles", "plate", "meat"));
        List<String> inventory = player.getInventory();
        String invItems = inventory.toString();
        List<String> items = InvList(invItems);
        FoodOrders foodOrders = new FoodOrders();

        if( player.getRoom().getName().equalsIgnoreCase("dining") )
            return "You are not going to cook here. This is not the right room to be cooking." ;

        if(items.isEmpty()){
            return "You should collect the required items to make the dish.";
        }else if (items.size() < 4){
            return "You don't have enough items to make the dish. Find the correct items.";
        }else if (items.size() > 4){
            return "You have too many items. Only add the ingredients you need to your inventory.";
        }if (foodOrders.cookSpaghetti(player.getInventory()).get().equalsIgnoreCase("spaghetti")){
            // Cook Dish
            player.addToInventory("spaghetti");
            player.removeFromInventory("sauce");
            player.removeFromInventory("noodles");
            player.removeFromInventory("plate");
            player.removeFromInventory("meat");

            return "Awesome! You made the best spaghetti I've ever tried. Congrats. Your dish is ready for the customer. ";
        }

        return "You don't have the right items to make the dish. Keep tyring!";

    }

    /**
     * This method is called by the user when they input 'serve'
     * This checks the inventoru for spaghetti.
     * If the item exist in the player inventory, then the player wins the game.
     * @return
     */
    public String checkForWin(){
        final String WINNING_DISH = "spaghetti";
        List<String> inventory = player.getInventory();
        String invItems = inventory.toString();
        List<String> items = InvList(invItems);

        // Check if spaghetti is in inventory
        if (player.getInventory().contains(WINNING_DISH)){
            displayEnd();
            return "";
        }
        return "You haven't cooked that dish. Make sure you gather all ingredients and cook the dish. Keep tyring!";

    }

    /**
     * Method to deliminate the inventory list
     * This is called in the checkForWin method
     * @param input
     * @return
     */
    public List<String> InvList(String input) {
        String delims = " ";
        List<String> stringList = new ArrayList<>();
        StringTokenizer word = new StringTokenizer(input, delims);
        String w;

        while (word.hasMoreTokens()){
            w = word.nextToken();
            stringList.add(w);
        }
        return stringList;
    }

    /**
     * Reviews player input and provides feedback.
     * This is the next method after the user enters input.
     * It checks to make sure something was entered, otherwise it sends a message to the user.
     * If something was entered, the WorldList method is called and splits the input into individual words.
     * Then these words are passed into the ParseVerbNoun method to check if the words are in the lists/enums.
     * After these methods run, this method asks the user for the next input and the process runs again.
     * @param //inputstr
     * @return
     */

    public String reviewInput(String inputStr) {
        try {
            log.info("Reviewing info.");

            List<String> words = WordList(inputStr); // Assuming WordList splits the input into words

            if (words.isEmpty()) {
                return "You didn't type anything.";
            }

            String verb = words.get(0);
            if (verb.equalsIgnoreCase("look")) {
                return lookAround();
            } else if (verb.equalsIgnoreCase("take")) {
                if (words.size() < 2) {
                    return "What do you want to take?";
                }
                return takeItem(words.get(1));
            } else if (verb.equalsIgnoreCase("drop")) {
                if (words.size() < 2) {
                    return "What do you want to drop?";
                }
                return dropItem(words.get(1));
            } else if (verb.equalsIgnoreCase("help")) {
                return Help();
            } else if (verb.equalsIgnoreCase("cook") || verb.equalsIgnoreCase("prepare") || verb.equalsIgnoreCase("make")) {
                if (words.size() < 2) return "What do you want to cook? Please be specific.";

                if (words.get(1).equalsIgnoreCase("spaghetti")) {
                    return cookDish();
                }

                /**
                 * Maybe the serve dish method can be incorporated here.
                 */
            } else if (verb.equalsIgnoreCase("serve")) {
                return checkForWin();
            } else if (verb.equalsIgnoreCase("inventory")) {
                return checkInventory();
            } else if (verb.equalsIgnoreCase("move") || verb.equalsIgnoreCase("go")) {
                if (words.size() < 2) {
                    return "Where do you want to go?";
                }

                if (words.get(1).equalsIgnoreCase("to")) {
                    return movePlayer(words.get(2));
                } else {
                    return movePlayer(words.get(1));
                }

            }
            return "I don't understand what you want to do.";
        } catch (Exception ex) {
            log.error("Error trying to review input: " + ex.toString());
            return "error";
        }
    }

    /**
     * Splits player input into words for processing.
     * This method takes the user's input and deliminates the words by spaces.
     * It then puts the individual words in an array.
     * This utilizes the string tokenizer import to identify the words as they are deliminated by the spaces.
     * @param input
     * @return
     */
    public List<String> WordList(String input) {
        String delims = " ";
        List<String> stringList = new ArrayList<>();
        StringTokenizer word = new StringTokenizer(input, delims);
        String w;

        while (word.hasMoreTokens()){
            w = word.nextToken();
            stringList.add(w);
        }
        return stringList;
    }

    /**
     * Processes action based on verb input.
     */
    public String ProcessAction(List<String> wordlist) {
        String verb;
        String action = "";
        verb = wordlist.get(0);
        if(!verbs.contains(verb)){
            action = "Sorry, " + verb + " is not a known verb.";
        }else {
            switch (verb) {
                case "look":
                    action = lookAround();
                    break;
                case "kitchen":
                    goKitchen();
                    break;
                case "dining":
                    goDining();
                    break;
                case "pantry":
                    goPantry();
                    break;
                case "freezer":
                    goFreezer();
                    break;
                default:
                    action = "You have entered " + verb;
            }
        }
        return action;
    }

    /**
     * Parses entry for verb-noun commands.
     */
    public String ParseEntry(List<String> wordlist) {
        String message;
        if(wordlist.size() == 1){
            message = ProcessAction(wordlist);
        }else if (wordlist.size() == 2){
            message = ParseVerbNoun(wordlist);
        }else {
            message = "Please only enter 2 word commands.";
        }
        return message;
    }

    /**
     * Parses verb-noun method after input is found and processed.
     * * The ParseVerbNoun method is called in the ReviewInput method after input is found and the WordList method
     * splits the input into words. This method checks to make sure the input words are in the list/enum.
     * If there are more than 2 words in the array, it throws an error.
     * Position 0 in the array is the verb, and position 1 is the noun.
     * @param wordlist
     */
    public String ParseVerbNoun(List<String> wordlist) {
        String verb;
        String noun;
        String message = "";

        verb = wordlist.get(0);
        noun = wordlist.get(1);

        //To do: build out actions based on verb+noun combination
        //for example - add to inventory if taken, remove from inventory if dropped, etc.
        //Can add noun and verb to a map (dictionary)
        if(!verbs.contains(verb)){
            message = "Sorry, "+verb+" is not a known verb.";
        }
        if (!nouns.contains(noun)){
            message += (noun + " is not a known noun.");
        }else{
            switch (noun){

            }

        }
        return message;
    }
}