package finalproj;
// Test class to test the TimeCounter

class SingletonTimeCounter {
    private static  volatile SingletonTimeCounter instance;
    private long startTime;


    // Private constructor to prevent instantiation from outside the class
    private SingletonTimeCounter() {
        startTime = System.currentTimeMillis();
    }

    // Method to get the instance of SingletonTimeCounter using double checked locking
    public static  SingletonTimeCounter getInstance() {
        if (instance == null) {
            synchronized(SingletonTimeCounter.class){
                if(instance ==null){
                    instance = new SingletonTimeCounter();
                }
            }

        }
        return instance;
    }

    // Method to get the elapsed time since the creation of the object
    public long getElapsedTime() {
        return System.currentTimeMillis() - startTime;
    }

}
class TimeCounter{
        private long startTime;

        // Constructor initializes the start time
        public TimeCounter() {
            startTime = System.currentTimeMillis();
        }

        // Method to get the elapsed time since the creation of object
        public long getElapsedTime() {
            return System.currentTimeMillis() - startTime;
        }

        public class TimeCounterTest {

        }
    }


public class TimeCounterTest {
    public static void main(String[] args) {
        // Test TimeCounter
        System.out.println("Testing TimeCounter:");
        TimeCounter timeCounter1 = new TimeCounter();
        System.out.println("Elapsed Time 1: " + timeCounter1.getElapsedTime() + " milliseconds");

        // delay to simulate time passing
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

        // delay to simulate time passing
        try {
            Thread.sleep(2000); // Sleep for 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        SingletonTimeCounter singletonTimeCounter2 = SingletonTimeCounter.getInstance();
        System.out.println("Elapsed Time 2: " + singletonTimeCounter2.getElapsedTime() + " milliseconds");
    }
}
