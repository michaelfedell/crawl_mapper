import org.junit.Test;

import java.io.IOException;

import org.junit.Assert;
import org.junit.BeforeClass;


/**
 * Unit testing for the State class.
 * 
 * @author Michael Fedell
 * @version 10/24/17
 */
public class StateTest
{
    /** Represents the line of headers pulled from a CSV file   */
    private static String header;
    
    /** Represents single line of mock data as would be pulled from a CSV file  */
    private static String testString;
    
    /** A State object created for testing  */
    private static State testState;
    
    /** A Trial object created for testing  */
    private static Trial testTrial;
    
    /** An Infant object created for testing*/
    private static Infant testInfant;
    
    /** The accuracy at which double value comparisons should be made */
    private static final double ACCURACY = 0.0000001;
    
    /**
     * Instantiates testState for the testing that follows
     * 
     * @throws  IOException as required by Infant Class
     */
    @BeforeClass
    public static void setUpBeforeClass() throws IOException
    {
        // Create a new Infant from the testData files
        testInfant = new Infant("testData", "testValid");
        // Assign the second trial for testing (subject_testValid_w01.csv)
        testTrial = testInfant.getItem(1);
        // Assign the fourth state (fifth row) for testing
        testState = testTrial.getItem(4);
    }
    
    
    /**
     * Tests the getTrial method
     */
    @Test
    public void testGetTrial()
    {
        Assert.assertEquals("Get Trial", testTrial, 
                testState.getTrial());
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
