package finalproj;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * A welcome page that outputs messages based on the time of day and user's locale.
 */
public class WelcomePage {

    /**
     * Outputs a message based on the current time and user's locale.
     *
     * @param currentTime The current time in 24-hour format (HH:mm).
     * @param userLocale  The user's locale (e.g., "en" for English, "es" for Spanish).
     */
    public static void displayMessage(String currentTime, String userLocale) {
        Locale locale = new Locale(userLocale);
        ResourceBundle bundle = ResourceBundle.getBundle("resources.messages", locale);


        int hour = Integer.parseInt(currentTime.split(":")[0]);

        String message;
        if (hour >= 0 && hour < 6) {
            message = bundle.getString("earlyMorning");
        } else if (hour >= 6 && hour < 12) {
            message = bundle.getString("morning");
        } else if (hour == 12) {
            message = bundle.getString("noon");
        } else if (hour > 12 && hour < 21) {
            message = bundle.getString("afternoon");
        } else {
            message = bundle.getString("evening");
        }

        System.out.println(message);
    }

    /**
     * Test method to check different messages based on the current time and user's locale.
     *
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        // Test with different times and locales
        testMessage("05:30", "en"); // Early Morning (English)
        testMessage("10:45", "es"); // Morning (Spanish)
        testMessage("12:30", "en"); // Noon (English)
        testMessage("18:45", "es"); // Afternoon (Spanish)
        testMessage("22:15", "en"); // Evening (English)
    }

    /**
     * Helper method to test the displayMessage function.
     *
     * @param currentTime The current time in 24-hour format (HH:mm).
     * @param userLocale  The user's locale (e.g., "en" for English, "es" for Spanish).
     */
    private static void testMessage(String currentTime, String userLocale) {
        System.out.println("Current Time: " + currentTime);
        System.out.println("User Locale: " + userLocale);
        displayMessage(currentTime, userLocale);
        System.out.println("---------------------");
    }
}

