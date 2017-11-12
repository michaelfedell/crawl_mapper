import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.junit.Assert;
import org.junit.BeforeClass;

/**
 * Unit testing for the Trial class.
 * All tests reference the 'subject_testFields_w01.csv' file with mock data generated for testing
 * in particular, the second state (time = 0.02) of this trial will be used for State tests
 * when a particular point or value needs to be accessed, the left elbow will be used for testing
 * 
 * @author Zach Schuermann modified by Michael Fedell
 * @version 10/24/17
 */
public class TrialTest
{
    /** A Trial object created for testing  */
    private static Trial testTrial;
    
    /** An Infant object created for testing    */
    private static Infant testInfant;
    
    /** The accuracy at which double value comparisons should be made */
    private static final double ACCURACY = 0.0000001;
    
    /**
     * Instantiates testTrial for the testing that follows
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
    }
    
    /**
     * Tests the getters for trial metadata including: infantID, size, week, and file name
     * @throws IOException for file load error
     */
    @Test
    public void testGetMetaData() throws IOException
    {
        Assert.assertEquals("Get Infant ID", "testFields", testTrial.getInfantID());
        Assert.assertEquals("Get Size", 26, testTrial.getSize());
        Assert.assertEquals("Get Week", 1, testTrial.getWeek());
        Assert.assertEquals("Get File Name", "testData/subject_testFields_w01.csv", testTrial.getFileName());
        // Test get fieldMapper for project 4 addition
        // Create fieldMapper to test against
        // Open the file
        BufferedReader br = new BufferedReader(new FileReader("testData/subject_testFields_w01.csv"));
        String strg = br.readLine();
        FieldMapper fieldMapTest = new FieldMapper(strg.split(","));
        Assert.assertEquals("Get FieldMapper", fieldMapTest.size(), testTrial.getFieldMapper().size());
        Assert.assertEquals("Get FieldMapper", fieldMapTest.getField("left_wrist_z"), 
                testTrial.getFieldMapper().getField("left_wrist_z"));
    }
    
    /**
     * Tests the value-related methods for a Trial object such as getItem and statistical methods
     */
    @Test
    public void testValues()
    {
        Assert.assertEquals("Get Item: 1", 0.140007, 
                testTrial.getItem(1).getValue("left_elbow", "x").getDoubleValue(), ACCURACY);
        // Max value for trial calculated in testFields-Stats xlsx file
        Assert.assertEquals("Get Max State: left_elbow_x", 0.140147, 
                testTrial.getMaxState("left_elbow", "x").getValue("left_elbow", "x").getDoubleValue(), ACCURACY);
        // Min value for trial calculated in testFields-Stats xlsx file
        Assert.assertEquals("Get Min State: left_elbow_y", 0.230102, 
                testTrial.getMinState("left_elbow", "y").getValue("left_elbow", "y").getDoubleValue(), ACCURACY);
        // Average value for trial calculated in testFields-Stats xlsx file
        Assert.assertEquals("Get Average Value: left_elbow_z", -0.017478538, 
                testTrial.getAverageValue("left_elbow", "z").getDoubleValue(), ACCURACY);
    }
    
    /**
     * Test the addition of toString for project 4
     */
    @Test
    public void testToString()
    {
        Assert.assertEquals("toString failed", "Week 01", testTrial.toString());
    }
}
