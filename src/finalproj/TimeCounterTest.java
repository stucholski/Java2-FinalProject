package finalproj;
// Test class to test the TimeCounter
public class TimeCounterTest {
    public static void main(String[] args) {
        // Test TimeCounter
        System.out.println("Testing TimeCounter:");
        TimeCounter timeCounter1 = new TimeCounter();
        System.out.println("Elapsed Time 1: " + timeCounter1.getElapsedTime() + " milliseconds");

        // Introduce some delay to simulate time passing
        try {
            Thread.sleep(2000); // Sleep for 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        TimeCounter timeCounter2 = new TimeCounter();
        System.out.println("Elapsed Time 2: " + timeCounter2.getElapsedTime() + " milliseconds");

        System.out.println();

        // Test SingletonTimeCounter
        System.out.println("Testing SingletonTimeCounter:");
        SingletonTimeCounter singletonTimeCounter1 = SingletonTimeCounter.getInstance();
        System.out.println("Elapsed Time 1: " + singletonTimeCounter1.getElapsedTime() + " milliseconds");

        // Introduce some delay to simulate time passing
        try {
            Thread.sleep(2000); // Sleep for 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        SingletonTimeCounter singletonTimeCounter2 = SingletonTimeCounter.getInstance();
        System.out.println("Elapsed Time 2: " + singletonTimeCounter2.getElapsedTime() + " milliseconds");
    }
}
