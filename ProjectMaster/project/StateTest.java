import org.junit.Test;
import org.junit.Assert;
import org.junit.BeforeClass;


/**
 * Unit testing for the State class.
 * 
 * @author Michael Fedell
 * @version 09/29/17
 */
public class StateTest
{
    // Represents single line of mock data as would be pulled from a CSV file by a fileScanner
    private static String testString = "1.52,0.11137,0.157633,-0.217952,0.157488,-0.276909,-0.052427";
    private static State testState;
    private static final double ACCURACY = 0.0000001;
    
    /**
     * Instantiates testState for the testing that follows
     */
    @BeforeClass
    public static void setUpBeforeClass()
    {
        testState = new State(testString);
    }
    
    
    /**
     * Tests the getLeftWrist method by comparing double values stored in the Point for Left Wrist
     * These double values are accessed from the State | Left Wrist | Point 3D | General Value
     */
    @Test
    public void testGetLeftWrist()
    {
        Assert.assertEquals("Get Left Wrist: X", 0.11137, 
                testState.getLeftWrist().getDimValue(0).getDoubleValue(), ACCURACY);
        Assert.assertEquals("Get Left Wrist: Y", 0.157633, 
                testState.getLeftWrist().getDimValue(1).getDoubleValue(), ACCURACY);
        Assert.assertEquals("Get Left Wrist: Z", -0.217952, 
                testState.getLeftWrist().getDimValue(2).getDoubleValue(), ACCURACY);
    }
    
    /**
     * Tests the getRightWrist method by comparing double values stored in the point for Right Wrist
     * These double values are accessed from the State | Right Wrist | Point 3D | General Value
     */
    @Test
    public void testGetRightWrist()
    {
        Assert.assertEquals("Get Right Wrist: X", 0.157488, 
                testState.getRightWrist().getDimValue(0).getDoubleValue(), ACCURACY);
        Assert.assertEquals("Get Right Wrist: Y", -0.276909, 
                testState.getRightWrist().getDimValue(1).getDoubleValue(), ACCURACY);
        Assert.assertEquals("Get Right Wrist: Z", -0.052427, 
                testState.getRightWrist().getDimValue(2).getDoubleValue(), ACCURACY);
    }
    
    /**
     * Tests the getTime method of the State class
     * The time value is read in as the first double value in an input string
     */
    @Test
    public void testGetTime()
    {
        Assert.assertEquals("Get Time", 1.52, testState.getTime(), ACCURACY);
    }
    
    /**
     * Tests the toString method of the State class.
     * This method should return a string formatted as "[time]: left_wrist=[x,y,z], right_wrist=[x,y,z]"
     */
    @Test
    public void testToString()
    {
        String output = "1.52: left_wrist=<0.111,0.158,-0.218>, right_wrist=<0.157,-0.277,-0.052>";
        Assert.assertEquals("To String", output, testState.toString());
    }
    
    /**
     * Tests the getMaxLeftWrist method as implemented by the State Class
     */
    @Test
    public void testGetMaxLeftWrist()
    {
        Assert.assertEquals("Get Max Left Wrist: X", 0.11137, 
                testState.getMaxState(0).getDoubleValue(), ACCURACY);
        Assert.assertEquals("Get Max Left Wrist: Y", 0.157633, 
                testState.getMaxState(1).getDoubleValue(), ACCURACY);
        Assert.assertEquals("Get Max Left Wrist: Z", -0.217952, 
                testState.getMaxState(2).getDoubleValue(), ACCURACY);
    }
        
    /**
     * Tests the getMinLeftWrist method as implemented by the State Class
     */
    @Test
    public void testGetMinLeftWrist()
    {
        Assert.assertEquals("Get Min Left Wrist: X", 0.11137, 
                testState.getMinState(0).getDoubleValue(), ACCURACY);
        Assert.assertEquals("Get Min Left Wrist: Y", 0.157633, 
                testState.getMinState(1).getDoubleValue(), ACCURACY);
        Assert.assertEquals("Get Min Left Wrist: Z", -0.217952, 
                testState.getMinState(2).getDoubleValue(), ACCURACY);
    }
    
    /**
     * Tests the getAverageLeftWrist method as implemented by the State Class
     */
    @Test
    public void testGetAverageLeftWrist()
    {
        Assert.assertEquals("Get Average Left Wrist: X", 0.11137, 
                testState.getAverageValue(0).getDoubleValue(), ACCURACY);
        Assert.assertEquals("Get Average Left Wrist: Y", 0.157633, 
                testState.getAverageValue(1).getDoubleValue(), ACCURACY);
        Assert.assertEquals("Get Average Left Wrist: Z", -0.217952, 
                testState.getAverageValue(2).getDoubleValue(), ACCURACY);
    }
}
