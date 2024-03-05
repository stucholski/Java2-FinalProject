package finalproj;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

public class FoodOrders {
    public Optional<String> cookSpaghetti(List<String> ingredients){
        Order order = () -> Optional.of(new HashSet<>(ingredients).containsAll(Arrays.asList("sauce", "noodles", "plate", "meat")) ? "spaghetti" : "wrong ingredients");

        return order.cook();
    }

}
