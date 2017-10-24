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
    
    /** A PointND object created for testing - left_elbow in CSV data   */
    private static PointND testPoint;

    /** A State object created for testing  */
    private static State testState;
    
    /** A Trial object created for testing  */
    private static Trial testTrial;
    
    /** An Infant object created for testing    */
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
        testInfant = new Infant("testData", "testFields");
        // Assign the second trial for testing (subject_testValid_w10.csv)
        testTrial = testInfant.getItem(10);
        // Assign the second state (third row) for testing
        testState = testTrial.getItem(2);
        // Create a PointND to represent the left_elbow from testFields CSV in it's second state (time=0.02)
        testPoint = new PointND();
        testPoint.add("x", new GeneralValue(0.140007));
        testPoint.add("y", new GeneralValue(0.230226));
        testPoint.add("z", new GeneralValue(-0.01652));
        
    }
    
    /**
     * Tests the getTrial method
     */
    @Test
    public void testGetTrial()
    {
        Assert.assertEquals("Get Trial", testTrial, testState.getTrial());
    }
    
    /**
     * Tests the getPoint method across each subfield available
     */
    @Test
    public void testGetPoint()
    {
        Assert.assertEquals("Get Point: left_elbow", testPoint , testState.getPoint("left_elbow"));
        //TODO: Add more points for testing
        
    }
    
    /**
     * Tests the getValue method across each subfield available
     */
    @Test
    public void testGetValue()
    {
        //TODO: Write tests
    }
    
    /**
     * Tests the toString method of the State class.
     * This method should return a string formatted as "[time]: left_wrist=[x,y,z], right_wrist=[x,y,z]"
     */
    @Test
    public void testToString()
    {
        //TODO: UPDATE
        String output = "1.52: left_wrist=<0.111,0.158,-0.218>, right_wrist=<0.157,-0.277,-0.052>";
        Assert.assertEquals("To String", output, testState.toString());
    }
    
    /**
     * Tests the getMaxLeftWrist method as implemented by the State Class
     */
    @Test
    public void testGetMaxState()
    {
        //TODO: Finish
        Assert.assertEquals("Get Max State", testState, testState.getMaxState("left_elbow", "x"));
    }
        
    /**
     * Tests the getMinLeftWrist method as implemented by the State Class
     */
    @Test
    public void testGetMinState()
    {
        //TODO: Finish
        Assert.assertEquals("Get Min State", testState, testState.getMinState("left_elbow", "x"));
    }
    
    /**
     * Tests the getAverageLeftWrist method as implemented by the State Class
     */
    @Test
    public void testGetAverageValue()
    {
        //TODO: Update all of this
        Assert.assertEquals("Get Average Left Wrist: X", 0.11137, 
                testState.getAverageValue(0).getDoubleValue(), ACCURACY);
        Assert.assertEquals("Get Average Left Wrist: Y", 0.157633, 
                testState.getAverageValue(1).getDoubleValue(), ACCURACY);
        Assert.assertEquals("Get Average Left Wrist: Z", -0.217952, 
                testState.getAverageValue(2).getDoubleValue(), ACCURACY);
    }
}
