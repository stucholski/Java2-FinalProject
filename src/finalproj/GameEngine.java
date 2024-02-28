package finalproj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class GameEngine {

    // Attributes to represent the game's state
    private ArrayList<Room> map;
    private Player player;
    private List<String> verbs = new ArrayList<>(Arrays.asList("take", "drop", "cook", "look", "cut", "stir", "kitchen", "pantry", "freezer", "dining"));
    private List<String> nouns = new ArrayList<>(Arrays.asList("spoon", "fork", "plate", "noodles", "sauce", "spices", "meat","vegetables","ice","candle","table","chair"," "," "," "));


    public GameEngine(){
        this.map = new ArrayList<Room>();

        Room kitchen = new Room("Kitchen", "A brightly-lit room with tools and utensils for cooking. ", 1, 0, 0, 0);
        kitchen.addItem("spoon");
        kitchen.addItem("fork");
        kitchen.addItem("plate");
        map.add(kitchen);

        Room pantry = new Room("Pantry", "A dark room with jars, cans, and boxes of food. ", 0, 0, 1, 0);
        pantry.addItem("noodles");
        pantry.addItem("sauce");
        pantry.addItem("spices");
        map.add(pantry);

        Room freezer = new Room("Freezer", "A cold, dimly-lit room. ", 0, 0, 0, 1);
        freezer.addItem("meat");
        freezer.addItem("vegetables");
        freezer.addItem("ice");
        map.add(freezer);

        Room dining = new Room("Dining", "A softly-lit room with places set for dining. ", 0, 1,0,0);
        dining.addItem("candle");
        dining.addItem("table");
        dining.addItem("chair");
        map.add(dining);

        player = new Player("Chef", map.get(0));
    }

    public Player getPlayer() {
        return player;
    }

    private String goKitchen() {
        Room kitchen = map.get(0);
        player.setRoom(kitchen);
        return lookAround();
    }

    private String goPantry() {
        Room kitchen = map.get(1);
        player.setRoom(kitchen);
        return lookAround();
    }

    private String goFreezer() {
        Room kitchen = map.get(2);
        player.setRoom(kitchen);
        return lookAround();
    }

    private String goDining() {
        Room kitchen = map.get(3);
        player.setRoom(kitchen);
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

    // Standard getters and setters
/*    public ArrayList<Room> getMap() {
        return map;
    }

    public void setMap(ArrayList<Room> map) {
        this.map = map;
    }
   public void setPlayer(Player1 player) {
        this.player = player;
    }

    public void movePlayerTo(Player1 p, Room r){
        p.setRoom(r);
    }
*/
    private String lookAround() {
        Room currentRoom = player.getRoom();
        String description = currentRoom.getDescription();
        List<String> items = currentRoom.getItems();

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
    /**
     * Displays the start message and instructions for the game.
     * Method to display at start - called by RestaurantGame class
     *Could be an intro to the game and introducing the player as the head chef
     *Lay out ground rules and clues
     */

    public void displayStart() {
        String introMessage = """
        Welcome to the restaurant adventure game.
        You are the head chef at Sarah's Diner. As the Head Chef your goal is to prepare a dish that can save the diner from closure.
        But first, you must collect three essential ingredients hidden in various locations of your restaurant. Start by using the "Kitchen"
        
        Available commands:
        - 'look': to look around in the current room.
        - 'move [room]': to move to a different room. For example, 'move kitchen'.
        - 'take [item]': to collect an item in the room.
        - 'inventory': to check what items you have collected.
        - 'quit': to end the game.
        
        Good luck, Chef!
        """;
        System.out.println(introMessage);
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
        } else if (verb.equalsIgnoreCase("inventory")) {
            return checkInventory();
        } else if (verb.equalsIgnoreCase("move") || verb.equalsIgnoreCase("go")) {
            if (words.size() < 2) {
                return "Where do you want to go?";
            }
            return movePlayer(words.get(1));
        }
        return "I don't understand what you want to do.";
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