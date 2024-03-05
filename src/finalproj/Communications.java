package finalproj;
import java.time.LocalTime;
import java.util.Locale;
import java.util.Objects;

/**
 * This is the class that will be handling all the communication in the game. This is an immutable object
 */
public final class Communications {

    private final String introMessage;

    /**
     * Returns the game introduction message based on time of day and language
     * @param locale the default locale of the user
     * @param localTime the default time of the user
     */
    public Communications(Locale locale, LocalTime localTime) {
        this.introMessage = buildIntroMessage(locale, localTime);
    }

    /**
     * Returns the game introduction message.
     */
    public String getIntroMessage() {
        return introMessage;
    }

    /**
     * Builds the game introduction message based on time of day and language.
     * @param locale the default locale of the user
     * @param localTime the default time of the user
     * @return the game introduction message
     */
    private String buildIntroMessage(Locale locale, LocalTime localTime) {
        String country = locale.getCountry();
        String language = locale.getLanguage();

        String message;
        if (language.equals("es")) {
            message = "Bievenido al juego Aventura en el Restaurant. \n"
                    + getTimeOfDayGreeting(locale, localTime) + "Este es tu nuevo restaurante. Este lugar esta "
                    + "en sus comiensos. \nPor favor toma tiempo para buscar lo que necesitas "
                    + "para entregar \nla mejor comida a nuestros clientes. ";
        } else {
            message = "Welcome to the restaurant adventure game. \n"
                    + getTimeOfDayGreeting(locale, localTime) + "This is your new restaurant. This place is  "
                    + "in its very beginning stages. \nPlease take your time to find what you need "
                    + "to deliver \nthe best food to our customers. ";
        }

        return message;
    }

    public void askPlayerName(Locale locale){

        String language = locale.getLanguage();

        if (language.equals("es")) {
            System.out.print("\nAntes the empezar esta aventura, por favor, cual es tu nombre? ");
        }else{
            System.out.println("\nBefore we start this adventure, please tell us your name. ");
        }

    }

    /**
     * Returns the specific greeting based on time of day.
     * This is to be used with the game introduction message.
     * @param locale the default locale of the user
     * @param localTime the default time of the user
     * @return the specific time of day message
     */
    private String getTimeOfDayGreeting(Locale locale, LocalTime localTime) {
        String message = "";

        if(locale.getLanguage().equals("es")){
            if(localTime.isBefore(LocalTime.parse("06:01"))){
                message = "Buena Madrugada! ";
            }else if(localTime.isBefore(LocalTime.parse("12:00"))){
                message = "Buenos Dias! ";
            }else if(localTime.isBefore(LocalTime.parse("13:00"))){
                message = " Hola, Wao! Ya es mediodia! ";
            }else if(localTime.isBefore(LocalTime.parse("21:00"))){
                message = "Buenas tardes Chef! ";
            }else if(localTime.isAfter(LocalTime.parse("20:59"))){
                message = " Muy buenas noches Chef! ";
            }
        }else{
            if(localTime.isBefore(LocalTime.parse("06:01"))){
                message = "Good Early Morning! ";
            }else if(localTime.isBefore(LocalTime.parse("12:00"))){
                message = "Good Morning! ";
            }else if(localTime.isBefore(LocalTime.parse("13:00"))){
                message = " Hello, WoW! is already Noon! ";
            }else if(localTime.isBefore(LocalTime.parse("21:00"))){
                message = "Good Afternoon Chef. ";
            }else if(localTime.isAfter(LocalTime.parse("20:59"))){
                message = " Good Evening Chef. ";
            }
        }

        return message;
    }

    /**
     * equals method to use object comparison
     * @param obj
     * @return
     */
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Communications that = (Communications) obj;
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash();
    }

}
