package finalproj;

//  TimeCounter class implementing the Singleton concept
public class SingletonTimeCounter {
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
