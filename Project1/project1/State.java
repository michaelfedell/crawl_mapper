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
    
    public Point3D getLeftWrist()
    {
        return leftWrist;
    }
    
    public Point3D getRightWrist()
    {
        return rightWrist;
    }
    
    public double getTime()
    {
        return time;
    }
    
    public String toString()
    {
        return "NYI";
    }

}
