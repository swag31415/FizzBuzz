import java.util.TimerTask;
import java.util.Timer;

/**
 * A timer that Counts from a provided initial value at a specified frequency by
 * predetermined increments
 * 
 * @author Swag31415
 */
public class Counter {

    // Declaring variables used to keep time and count
    int initVal;
    int val;
    int increment;
    long millis;

    // Declaring threads and tasks
    Timer countTimer;
    TimerTask countTask;

    /**
     * Creates a counter that counts
     * 
     * @param hz        The frequency at which to count
     * @param initVal   Where to start counting
     * @param increment How much to count by
     */
    public Counter(int hz, int initVal, int increment) {
        // Passing-in variables
        this.initVal = initVal;
        val = initVal;
        this.increment = increment;
        // Converting hz to Millisecond intervals
        millis = 1000 / hz;

        // Creating a timer
        countTimer = new Timer();
        // Creating a timer task
        countTask = new TimerTask() {
            /**
             * Counts up
             */
            @Override
            public void run() {
                increment();
            }
        };
    }

    /**
     * Increases val by the increment
     */
    public void increment() {
        val += increment;
    }

    /**
     * Returns Val
     * 
     * @return the value stored in val
     */
    public int getVal() {
        return val;
    }

    /**
     * Resets val to Inital val
     */
    public void resetVal() {
        val = initVal;
    }

    /**
     * Starts the timer task
     */
    public void startCounting() {
        countTimer.schedule(countTask, 0, millis);
    }

    /**
     * Permanently stops the timer task
     */
    public void stopCounting() {
        countTimer.wait();
    }
}