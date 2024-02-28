package finalproj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RestaurantGame {

    /**
     * The main method starts the program and accepts user input.
     * After input is received, it is passed to the ReviewInput method.
     * If quit is entered, the program stops.
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader in;
        String input;
        String output;
        GameEngine engine = new GameEngine();

        Communications communications = new Communications();
        Locale locale = Locale.getDefault();
        LocalTime localTime = LocalTime.now();

        in = new BufferedReader(new InputStreamReader(System.in));

        communications.getIntroMessage(locale, localTime);
        engine.displayStart();
        do {
            System.out.println("> ");
            input = in.readLine();
            output = engine.reviewInput(input);

            System.out.println(output);

        }while (!"quit".equals(input));
    }
}
