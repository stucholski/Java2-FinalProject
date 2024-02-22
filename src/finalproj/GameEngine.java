package finalproj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class GameEngine {

    private ArrayList<Room>map;
    private Player1 player;
    List<String> verbs = new ArrayList<>(Arrays.asList("take", "drop", "cook", "look", "cut", "stir", "enter"));
    List<String> nouns = new ArrayList<>(Arrays.asList("knife", "spoon", "sauce", "noodles", "beef", "pan", "plate", "kitchen", "pantry", "freezer", "dining"));

    /**
     * The game method that creates the rooms and the player.
     */
    public GameEngine(){
        this.map = new ArrayList<Room>();
        map.add(new Room("Kitchen", "A brightly-lit room with tools and utensils for cooking.", 1, 0, 0, 0));
        map.add(new Room("Pantry", "A dark room with jars, cans, and boxes of food.", 0, 0, 1, 0));
        map.add(new Room("Freezer", "A cold, dimly-lit room with frozen meet, vegetables, and fruit", 0, 0, 0, 1));
        map.add(new Room("Dining", "A softly-lit room with tables and places set for dining.", 0, 1,0,0));

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

    public int move(Player1 player, Rooms rooms){

        Room r = player.getRoom();
        int exit;

        switch (rooms){
            case Kitchen:
                exit = r.getKitchen();
                break;
            case Pantry:
                exit = r.getPantry();
                break;
            case Dining:
                exit = r.getDining();
                break;
            case Freezer:
                exit = r.getFreezer();
                break;
            default:
                exit = Rooms.NOROOMS;
                break;
        }
        if (exit != Rooms.NOROOMS){
            movePlayerTo(player, map.get(exit));
        }
            return exit;
    }

    public int moveTo(Rooms r){
        return move(player, r);
    }

    private void goKitchen(){
        updateOutput(moveTo(Rooms.Kitchen));
    }
    private void goPantry(){
        updateOutput(moveTo(Rooms.Pantry));
    }
    private void goFreezer(){
        updateOutput(moveTo(Rooms.Freezer));
    }
    private void goDining(){
        updateOutput(moveTo(Rooms.Dining));
    }




    void updateOutput(int roomNumber){
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

    public void displayStart(){

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
    public String ReviewInput(String inputstr){
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
    public List<String> WordList(String input){
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

    //Implement a verb processor method for movement
    // To do

    /**
     * The ParseVerbNoun method is called in the ReviewInput method after input is found and the WordList method
     * splits the input into words. This method checks to make sure the input words are in the list/enum.
     * If there are more than 2 words in the array, it throws an error.
     * Position 0 in the array is the verb, and position 1 is the noun.
     * @param wordlist
     */
    public void ParseVerbNoun(List<String> wordlist){
        String verb;
        String noun;
        String quit;
        /** These arrays should direct to the enums once these are built out**/
        //List<String> verbs = new ArrayList<>(Arrays.asList("take", "drop", "cook", "look", "cut", "stir", "enter"));
        //List<String> nouns = new ArrayList<>(Arrays.asList("knife", "spoon", "sauce", "noodles", "beef", "pan", "plate", "kitchen", "pantry", "freezer", "dining"));
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





}

