package finalproj;
import org.apache.logging.log4j.*;

public class TestLogger {
    // instantiate logging object
    final static Logger log = LogManager.getLogger();

    public static void main(String[] args){

        log.debug("Hello debugging.");
        log.info("hello info");


    }
}
