/**
 * Representation of the state of a single time step
 * 
 * @author Andrew H. Fagg
 * @version 2017-09-03
 *
 */
public class State
{
    /** Position of the left Wrist */
    private Point3D leftWrist;
    /** Position of the right Wrist */
    private Point3D rightWrist;
    /** Timestamp of the current sample.  */
    private double time;
    
    /**
     * Default Constructor - parses the input string into appropriate fields to store data from single line
     * @param strg should contain input data formatted as comma-separated values. 
     */
    public State(String strg)
    {
        // Parse string and assign to line
        String[] line = strg.split(",");
        
        // Assign time to the first entry (after parsing as double)
        time = Double.parseDouble(line[0]);
        
        // Construct Point3D for leftWrist and rightWrist from line array
        leftWrist = new Point3D(new GeneralValue(line[1]), new GeneralValue(line[2]), new GeneralValue(line[3]));
        rightWrist = new Point3D(new GeneralValue(line[4]), new GeneralValue(line[5]), new GeneralValue(line[6]));
    }
    
    /**
     * Left Wrist represented as Point3D object of current location.
     * @return object representing current state of Left Wrist.
     */
    public Point3D getLeftWrist()
    {
        return leftWrist;
    }
    
    /**
     * Right Wrist represented as Point3D object of current location.
     * @return object representing current state of Right Wrist.
     */
    public Point3D getRightWrist()
    {
        return rightWrist;
    }
    /**
     * Time is in seconds
     * @return time of current state as type double
     */
    public double getTime()
    {
        return time;
    }
    /**
     * Returns relevant information about State object as a string representation for printing
     * @return All information about current state, including time and location of each wrist.
     */
    public String toString()
    {
        String out = String.format("%.2f", time) + ": left_wrist=<" + leftWrist.getDimValue(0) + "," 
                + leftWrist.getDimValue(1) + "," + leftWrist.getDimValue(2) + ">, right_wrist=<" 
                + rightWrist.getDimValue(0) + "," + rightWrist.getDimValue(1) + "," 
                + rightWrist.getDimValue(2) + ">";
        return out;
    }

}
