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
        // Intsantiate infant object
        Infant infant = new Infant("data", "c1");
        // Print info about trial
        System.out.println(Infant.getItem(1)); 
    }
}
