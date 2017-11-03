import java.io.IOException;

/**
 * Driver class to construct trial object and print arbitrary state.
 *
 * @author Zach Schuermann
 * @version 10/23/17
 *
 */
public class Driver
{
    public static void main(String[] args) throws IOException
    {
        
        InfantFrame frame = new InfantFrame();
        
        /*
        // Instantiate infant object
        // c1, k1, or k2
        Infant infant = new Infant("data", "k2");
        
        String dims = "xyz";
        
        //Print info about trial for all three dimensions X,Y,Z
        for (int i = 0; i < 3; i++)
        {
            System.out.println("Dimension: " + dims.substring(i, i + 1)); 
            System.out.println("");
            System.out.println("Average Left Wrist: " + infant.getAverageValue("left_wrist", dims.substring(i, i + 1))); 
            System.out.println("");
            System.out.println("Max Left Wrist: \n" + infant.getMaxState("left_wrist", dims.substring(i, i + 1)));
            System.out.println("Min Left Wrist: \n" + infant.getMinState("left_wrist", dims.substring(i, i + 1)));
            System.out.println(infant.getItem(0).getItem(1).getValue("left_wrist", "q"));
        }*/
    }
}