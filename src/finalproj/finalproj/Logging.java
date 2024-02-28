package finalproj;
import org.apache.logging.log4j.*;
import com.sun.tools.javac.Main;
public class Logging {

    final static Logger Log = LogManager.getLogger(Main.class.getName());

    public static void main(String[] args){
        Log.debug("Debug Message");
        Log.info("Degbug info message");
    }
}
