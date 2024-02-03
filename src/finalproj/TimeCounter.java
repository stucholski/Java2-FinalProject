package finalproj;

// Simple class for a time counter
public class TimeCounter {
    private long startTime;

    // Constructor initializes the start time
    public TimeCounter() {
        startTime = System.currentTimeMillis();
    }

    // Method to get the elapsed time since the creation of the object
    public long getElapsedTime() {
        return System.currentTimeMillis() - startTime;
    }
}
