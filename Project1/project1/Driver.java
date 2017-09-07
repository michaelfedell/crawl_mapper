import java.io.IOException;

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
