package finalproj;
public class TimeCounter {
    /**
     * Class that creates a singleton time counter to keep track of gameplay seconds
     */
    private static TimeCounter instance;
    private long startTime;

    private TimeCounter() {

        startTime = System.currentTimeMillis();
    }

    public static TimeCounter getInstance() {
        if (instance == null) {
            synchronized (TimeCounter.class) {
                if (instance == null) {
                    instance = new TimeCounter();
                }
            }
        }
        return instance;
    }

    public long getElapsedTime() {
        long elapsedTimeMillis = System.currentTimeMillis() - startTime;
        return elapsedTimeMillis / 1000; // Convert milliseconds to seconds
    }
}

