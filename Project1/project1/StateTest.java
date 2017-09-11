import org.junit.Test;
import org.junit.Assert;


/**
 * Unit testing for the State class.
 * 
 * @author Michael Fedell
 * @version 09/11/17
 */
public class StateTest
{
    // Represents single line of mock data as would be pulled from a CSV file by a fileScanner
    private String testString = "1.52,0.11137,0.157633,-0.217952,0.157488,-0.276909,-0.052427";

    /**
     * Tests the getLeftWrist method by comparing double values stored in the Point for Left Wrist
     * These double values are accessed from the State -> Left Wrist -> Point 3D -> General Value
     */
    @Test
    public void testGetLeftWrist()
    {
        State state = new State(testString);
        Assert.assertEquals("Get Left Wrist: X", 0.11137, state.getLeftWrist().getDimValue(0).getDoubleValue(), 0.0001);
        Assert.assertEquals("Get Left Wrist: Y", 0.157633, state.getLeftWrist().getDimValue(1).getDoubleValue(), 0.0001);
        Assert.assertEquals("Get Left Wrist: Z", -0.217952, state.getLeftWrist().getDimValue(2).getDoubleValue(), 0.0001);
    }
    
    /**
     * Tests the getRightWrist method by comparing double values stored in the point for Right Wrist
     * These double values are accessed from the State -> Right Wrist -> Point 3D -> General Value
     */
    @Test
    public void testGetRightWrist()
    {
        State state = new State(testString);
        Assert.assertEquals("Get Right Wrist: X", 0.157488, state.getRightWrist().getDimValue(0).getDoubleValue(), 0.0001);
        Assert.assertEquals("Get Right Wrist: Y", -0.276909, state.getRightWrist().getDimValue(1).getDoubleValue(), 0.0001);
        Assert.assertEquals("Get Right Wrist: Z", -0.052427, state.getRightWrist().getDimValue(2).getDoubleValue(), 0.0001);
    }
    
    /**
     * Tests the getTime method of the State class
     * The time value is read in as the first double value in an input string
     */
    @Test
    public void testGetTime()
    {
        State state = new State(testString);
        Assert.assertEquals("Get Time", 1.52, state.getTime(), 0.0001);
    }
    
    /**
     * Tests the toString method of the State class.
     * This method should return a string formatted as "<time>: left_wrist=<x,y,z>, right_wrist=<x,y,z>"
     */
    @Test
    public void testToString()
    {
        State state = new State(testString);
        String output = "1.52: left_wrist=<0.111,0.158,-0.218>, right_wrist=<0.157,-0.277,-0.052>";
        Assert.assertEquals("To String", output, state.toString());
    }

}
