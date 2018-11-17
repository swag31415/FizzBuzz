import java.util.TimerTask;
import java.util.Timer;

/**
 * Hosts the Main method for the FizzBuzz project
 * 
 * @author Swag31415
 */
public class FizzBuzz {

    /**
     * The main, in here goes the code that gets run
     * 
     * @param args No one knows what this means
     */
    public static void main(String[] args) {
        // Initializing val, the variable that holds the count
        int val = Constants.INIT_VAL;
        // Recording the time of initialization
        long initTime = System.currentTimeMillis();
        // Creating a thread that counts at the specified frequency
        Counter counter = new Counter(Constants.HZ, Constants.INIT_VAL, Constants.INCREMENT);
        // Starting the thread
        counter.startCounting();

        // The main loop that does all the counting and printing
        while (true) {
            // Getting the counts elapsed as an average of the system's own timer and the
            // one we started in a thread earlier
            int countsElapsed = (getCountsElapsed(initTime, Constants.HZ, Constants.INIT_VAL, Constants.INCREMENT)
                    + counter.getVal()) / 2;
            // Runs if the value needs to be updated
            if (val != countsElapsed) {
                // Updates the value
                val = countsElapsed;

                // Checks if the value is a multiple of both multipliers
                if ((val % (Constants.MULT_1 * Constants.MULT_2)) == 0) {
                    // Prints out both strings and moves to the next line
                    System.out.println("(" + val + "): " + Constants.STRING_1 + Constants.STRING_2);

                    // Checks to see if the value is a multiple of the first multiplier
                } else if ((val % Constants.MULT_1) == 0) {
                    // Prints out the first string and moves to the next line
                    System.out.println("(" + val + "): " + Constants.STRING_1);

                    // Checks to see if the value is a multiple of the second multiplier
                } else if ((val % Constants.MULT_2) == 0) {
                    // Prints out the second string and moves to the next line
                    System.out.println("(" + val + "): " + Constants.STRING_2);
                }
            }
        }
    }

    /**
     * Gets the counts elapsed based on the system's own clock
     * 
     * @param initTime  When it started counting
     * @param hz        The frequency at which it counts
     * @param initVal   Where it starts counting
     * @param increment By how much it counts
     * @return The Counts elapsed is returned as an int
     */
    public static int getCountsElapsed(long initTime, int hz, int initVal, int increment) {
        // Does some math to convert system time in millis into counts elapsed
        return (int) (initVal + (((System.currentTimeMillis() - initTime) / (1000 / hz)) * increment));
    }
}