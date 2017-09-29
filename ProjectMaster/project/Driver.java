import java.io.IOException;

/**
 * Driver class to construct trial object and print arbitrary state.
 *
 * @author Zach Schuermann
 * @version 09/11/17
 *
 */
public class Driver
{
    public static void main(String[] args) throws IOException
    {
        // Create trial object
        Trial trial = new Trial("data", "k1", 3);
        // Print info about trial
        System.out.println(trial.getState(100));
    }
}
