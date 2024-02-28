package finalproj;
import java.time.LocalTime;
import java.util.Locale;

/**
 * This is the class that will be handling all the communication in the game.
 */
public class Communications {

    /**
     * Returns the game introduction message based on time of day and language
     * @param locale the default locale of the user
     * @param localTime the default time of the user
     */
    public void getIntroMessage(Locale locale, LocalTime localTime){

        String country = locale.getCountry();
        String language = locale.getLanguage();

        String message;
        if (language.equals("es")) {
            message = getTimeOfDayGreeting(locale, localTime) + ". Este es tu nuevo restaurante. Este lugar esta "
                    + "en sus comiensos. \nPor favor toma tiempo para buscar lo que necesitas "
                    + "para entregar \nla mejor comida a nuestros clientes. Por favor ve a la cocina.  ";
        } else {
            message = getTimeOfDayGreeting(locale, localTime) + ". This is your new restaurant. This place is  "
                    + "in its very beginning stages. \nPlease take your time to find what you need "
                    + "to deliver \nthe best food to our customers. Please go to the kitchen ";
        }

        System.out.println(message);

    }

    /**
     * Returns the specific greeting based on time of day.
     * This is to be used with the game introduction message.
     * @param locale the default locale of the user
     * @param localTime the default time of the user
     * @return the specific time of day message
     */
    private String getTimeOfDayGreeting(Locale locale, LocalTime localTime){
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

}
