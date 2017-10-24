import org.junit.Test;
import java.io.IOException;
import org.junit.Assert;
import org.junit.BeforeClass;


/**
 * Unit testing for the State class.
 * All tests reference the 'subject_testFields_w01.csv' file with mock data generated for testing
 * in particular, the second state (time = 0.02) of this trial will be used for State tests
 * when a particular point or value needs to be accessed, the left elbow will be used for testing
 * 
 * @author Michael Fedell
 * @version 10/24/17
 */
public class StateTest
{
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
        // Assign the first (and only) trial for testing (subject_testValid_w01.csv)
        testTrial = testInfant.getItem(0);
        // Assign the second state (third row) for testing
        testState = testTrial.getItem(1);
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
        Assert.assertEquals("Get Point: left_elbow", "X = 0.140; Y = 0.230; Z = -0.017; ", 
                testState.getPoint("left_elbow").toString());
    }
    
    /**
     * Tests the getValue method across each subfield available
     */
    @Test
    public void testGetValue()
    {
        // Compare the double values of each GeneralValue for equality
        Assert.assertEquals("GetValue: left_elbow_x", 0.140007, 
                testState.getValue("left_elbow", "x").getDoubleValue(), ACCURACY);
        Assert.assertEquals("GetValue: left_elbow_y", 0.230226, 
                testState.getValue("left_elbow", "y").getDoubleValue(), ACCURACY);
        Assert.assertEquals("GetValue: left_elbow_z", -0.01652, 
                testState.getValue("left_elbow", "z").getDoubleValue(), ACCURACY);
    }
    
    /**
     * Tests the toString method of the State class.
     * This method should return a multi-line string detailing the pointND object at each field
     * formatted as follows "FIELDNAME(POINTND)\n"
     */
    @Test
    public void testToString()
    {
        // Manually construct a full string of testState with values from each field/subfield
        String output = "left_ankle(X = -0.250; Y = -0.005; Z = 0.022; )\n"
                + "left_elbow(X = 0.140; Y = 0.230; Z = -0.017; )\n"
                + "left_foot(X = -0.260; Y = -0.046; Z = -0.072; )\n"
                + "left_knee(X = -0.121; Y = 0.040; Z = -0.025; )\n"
                + "left_shoulder(X = 0.211; Y = 0.116; Z = -0.026; )\n"
                + "left_wrist(X = 0.164; Y = 0.293; Z = -0.093; )\n"
                + "right_ankle(X = -0.244; Y = -0.149; Z = -0.083; )\n"
                + "right_elbow(X = 0.259; Y = -0.167; Z = -0.088; )\n"
                + "right_foot(X = -0.246; Y = -0.162; Z = -0.185; )\n"
                + "right_knee(X = -0.113; Y = -0.102; Z = -0.045; )\n"
                + "right_shoulder(X = 0.243; Y = -0.081; Z = 0.015; )\n"
                + "right_wrist(X = 0.315; Y = -0.113; Z = -0.155; )\n"
                + "robot_vel(L = -0.011; R = -0.027; )\n"
                + "sippc_action( = 0.000; )\n"
                + "time( = 0.020; )\n"
                + "upper_back(X = 0.227; Y = 0.017; Z = -0.005; )\n";
        
        Assert.assertEquals("To String", output, testState.toString());
    }
    
    /**
     * Tests the getMaxLeftWrist method as implemented by the State Class
     */
    @Test
    public void testGetMaxState()
    {
        Assert.assertEquals("Get Max State", testState, testState.getMaxState("left_elbow", "x"));
    }
        
    /**
     * Tests the getMinLeftWrist method as implemented by the State Class
     */
    @Test
    public void testGetMinState()
    {
        Assert.assertEquals("Get Min State", testState, testState.getMinState("left_elbow", "x"));
    }
    
    /**
     * Tests the getAverageLeftWrist method as implemented by the State Class
     */
    @Test
    public void testGetAverageValue()
    {
        Assert.assertEquals("Get Average Value: left_wrist_x", 0.140007, 
                testState.getAverageValue("left_elbow", "x").getDoubleValue(), ACCURACY);
        Assert.assertEquals("Get Average Value: left_wrist_y", 0.230226, 
                testState.getAverageValue("left_elbow", "y").getDoubleValue(), ACCURACY);
        Assert.assertEquals("Get Average Value: left_wrist_z", -0.01652, 
                testState.getAverageValue("left_elbow", "z").getDoubleValue(), ACCURACY);
    }
    
    /**
     * Tests to make sure that State is indeed Iterable
     */
    @Test
    public void iterableTest()
    {
        int i = 0;
        // iterate over keys in point
        for (@SuppressWarnings("unused") String key : testState)
        {
            // test each key is either x,y,z
            i++;
        }
        Assert.assertEquals(16, i);
    }
}
