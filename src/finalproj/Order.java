package finalproj;

import java.util.Optional;

/**
 * Use of custom functional interface
 */
@FunctionalInterface
public interface Order {

    Optional<String> cook();

}
