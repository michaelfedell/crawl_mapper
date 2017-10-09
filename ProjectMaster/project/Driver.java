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
        // Instantiate infant object
        Infant infant = new Infant("data", "c1");
        
        // Print info about trial for all three dimensions X,Y,Z
        for (int i = 0; i < 3; i++)
        {
            System.out.println("Dimension: " + i); 
            System.out.println("Average Left Wrist: " + infant.getAverageLeftWrist(i)); 
            System.out.println("Max Left Wrist: " + infant.getMaxLeftWrist(i));
            System.out.println("Min Left Wrist: " + infant.getMinLeftWrist(i));
        }
    }
}