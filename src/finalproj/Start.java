package finalproj;
import java.time.LocalTime;
import java.util.Locale;
import java.util.Scanner;

public class Start {

    public static void main(String[] args){

        // ***********************************
        // Configurations
        Communications communications = new Communications();
        Locale locale = Locale.getDefault();
        LocalTime localTime = LocalTime.now();
        String playerName;
        int DISHES_TO_COMPLETE = 3;
        int dishesCompleted = 0;
        int DISHES_TO_FAIL = 3;
        int dishesFailed = 0;
        Scanner in = new Scanner((System.in));
        String playerCommand;

        // **********************************
        // Set up the help assistance
        Help help = new Help();


        // ***********************************
        // Instantiate rooms
        Room kitchen = new Room("Kitchen", "pantry", "doorToLobby", "freezer", "stove");
        Room diningRoom = new Room("Dining Room", "nothing","exitDoor","nothing","doorToLobby");
        Room pantry = new Room("Pantry","","","","");
        Room mainLobby = new Room("Main Lobby","doorToKitchen","exitDoor","doorToDiningRoom","nothing");


        // ************************************
        // Display a welcome message to player
        // Uses locale and localtime to base the time greeting and language
        // of the message.
        // communications.getIntroMessage( new Locale("es", "MX" ), localTime ); // Test Spanish Message
        communications.getIntroMessage(locale, localTime);


        // ************************************
        // Get the username
        // We need validation for the name
        System.out.println("\nOh! before you leave to the kitchen, what is your name? ");
        playerName = in.nextLine().trim();


        // *************************************
        // Instantiate player
        Player player = new Player(playerName, mainLobby);


        System.out.println(playerName +  " what do you do now? Feel free to look around " +
                            "or type help if you get lost.");

        playerCommand = in.nextLine().trim().toLowerCase();

        System.out.println("You typed " + playerCommand);
        if(playerCommand.equals("help")){
            help.showCommandList();
        }




        // ***************************
        // ENTERING GAME LOOP
        // Stay in the loop until you complete three dishes or fail three dishes
        while ( dishesCompleted < DISHES_TO_COMPLETE || dishesFailed < DISHES_TO_FAIL ){

            // we have to think about what logic we need here


            System.out.println("I am in the game loop asking questions and checking for results");
            break;
            // Test if user loses or wins

        }


        // Did the user lose

        // Did the user won

        System.out.println("Game is over");

    }
}
