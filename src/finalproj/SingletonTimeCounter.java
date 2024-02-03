package finalproj;

// Modified TimeCounter class implementing the Singleton pattern
public class SingletonTimeCounter {
    private static SingletonTimeCounter instance;
    private long startTime;

    // Private constructor to prevent instantiation from outside the class
    private SingletonTimeCounter() {
        startTime = System.currentTimeMillis();
    }

    // Method to get the instance of SingletonTimeCounter
    public static SingletonTimeCounter getInstance() {
        if (instance == null) {
            instance = new SingletonTimeCounter();
        }
        return instance;
    }

    // Method to get the elapsed time since the creation of the object
    public long getElapsedTime() {
        return System.currentTimeMillis() - startTime;
    }
}
