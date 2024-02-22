package finalproj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class GameEngine {

    private ArrayList<Room>map;
    private Player1 player;
    List<String> actions = new ArrayList<>(Arrays.asList("take", "drop", "cook", "look", "cut", "stir", "enter"));
    List<String> items = new ArrayList<>(Arrays.asList("knife", "spoon", "sauce", "noodles", "beef", "pan", "plate", "kitchen", "pantry", "freezer", "dining"));

    /**
     * The game method that creates the rooms and the player.
     */
    public GameEngine(){
        this.map = new ArrayList<Room>();
        map.add(new Room("Kitchen", "A brightly-lit room with tools and utensils for cooking."));
        map.add(new Room("Pantry", "A dark room with jars, cans, and boxes of food."));
        map.add(new Room("Freezer", "A cold, dimly-lit room with frozen meet, vegetables, and fruit"));
        map.add(new Room("Dining", "A softly-lit room with tables and places set for dining."));

        player = new Player1("Chef", map.get(0));
    }

    ArrayList getMap(){
        return map;
    }
    void setMap(ArrayList map){
        map = map;
    }
    public Player1 getPlayer(){
        return player;
    }
    public void setPlayer(Player1 player){
        player = player;
    }

    public void movePlayerTo(Player1 p, Room r){
        p.setRoom(r);
    }

    public Room move(Player1 player, Rooms rooms){

        Room move;

        switch (rooms){
            case Kitchen:
                move = map.get(0);
                break;
            case Pantry:
                move = map.get(1);
                break;
            case Dining:
                move = map.get(3);
                break;
            case Freezer:
                move = map.get(2);
                break;
            default:
                move = map.get(0);
        }
            return move;
    }


    /**
     * The main method starts the program and accepts user input.
     * After input is received, it is passed to the ReviewInput method.
     * If quit is entered, the program stops.
     * @param args
     * @throws IOException
     */
    //Begins the game and calls the class to review player input
    public static void main(String[] args) throws IOException {
        /**Scanner in = new Scanner(System.in);**/
        BufferedReader in;
        String input;
        String output;

        System.out.println("Welcome to the text-based adventure game. You are a chef at an Italian restaurant. A customer ordered a plate of spaghetti. ");
        System.out.println("The ingredients for this dish are noodles, sauce, and meat. You are in the kitchen, and you may enter the pantry, dining room, or freezer. ");
        System.out.println("What do you do?");

        /**String a = in.nextLine();**/
        in = new BufferedReader(new InputStreamReader(System.in));

        do {
            System.out.println("> ");
            input = in.readLine();
            output = ReviewInput(input);

            System.out.println(output);
            ReviewCommand(input.toString());
        }while (!"quit".equals(input));

    }

    /**
     * This is the next method after the user enters input.
     * It checks to make sure something was entered, otherwise it sends a message to the user.
     * If something was entered, the WorldList method is called and splits the input into individual words.
     * Then these words are passed into the ParseVerbNoun method to check if the words are in the lists/enums.
     * After these methods run, this method asks the user for the next input and the process runs again.
     * @param inputstr
     * @return
     */
    public static String ReviewInput(String inputstr){
        List<String> wordlist;
        String next = "What do you do next?";
        String lowstr = inputstr.trim().toLowerCase();

        if (lowstr.equals("")) {
            next = "You must enter a command";

        }else {
            wordlist = WordList(lowstr);

            ParseVerbNoun(wordlist);
        }
        return next;
    }

    /**
     * This method takes the user's input and deliminates the words by spaces.
     * It then puts the individual words in an array.
     * This utilizes the string tokenizer import to identify the words as they are deliminated by the spaces.
     * @param input
     * @return
     */
    public static List<String> WordList(String input){
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
     * The ParseVerbNoun method is called in the ReviewInput method after input is found and the WordList method
     * splits the input into words. This method checks to make sure the input words are in the list/enum.
     * If there are more than 2 words in the array, it throws an error.
     * Position 0 in the array is the verb, and position 1 is the noun.
     * @param wordlist
     */
    public static void ParseVerbNoun(List<String> wordlist){
        String verb;
        String noun;
        String quit;
        /** These arrays should direct to the enums once these are built out**/
        List<String> verbs = new ArrayList<>(Arrays.asList("take", "drop", "cook", "look", "cut", "stir", "enter"));
        List<String> nouns = new ArrayList<>(Arrays.asList("knife", "spoon", "sauce", "noodles", "beef", "pan", "plate", "kitchen", "pantry", "freezer", "dining"));
        if(wordlist.size() > 2){
            System.out.println("Please enter a 2 word command.");
        }else {
            verb = wordlist.get(0);
            if (verb.equals("quit")){
                System.out.println("Goodbye.");

            }else {

                if (!verbs.contains(verb)){
                    System.out.println("Sorry, "+verb + " is not a known verb.");
                }else {
                    noun = wordlist.get(1);
                    if(!nouns.contains(noun)){
                        System.out.println("Sorry, "+noun + " is not a known noun.");

                    }else {
                        System.out.println("You selected: " + verb + " " + noun + ".");
                        /**System.out.println("What do you do next?");**/
                    }
                }
            }
        }
    }

    public static void ReviewCommand(String input){

        switch (input){
            case "enter dining":
                //assign player location to dining
                //display room desc in console
                break;
            case "enter kitchen":
                //assign player location to kitchen
                //display room description in console
                break;
            case "enter pantry":
                //assign player location to pantry
                //display room description in console
                break;
            case "enter freezer":
                //assign player location to freezer
                //display room description in console
                break;
            case "take noodles":
                //add to inventory
                break;
            case "take sauce":
                //add to inventory
                break;
            case "take meat":
                //add to inventory
                break;
            case "take plate":
                //add to inventory
                break;

        }
    }



}

