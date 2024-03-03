package finalproj;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Time;
import java.time.LocalTime;
import java.util.Locale;


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

        }while (!"quit".equals(input));

        //at the end of the game the elapsed time is shown to the user
        long elapsedTime = timeCounter.getElapsedTime();
        System.out.println("Elapsed Time: " + elapsedTime + " seconds");
    }

}
