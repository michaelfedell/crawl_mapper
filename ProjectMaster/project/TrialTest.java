import org.junit.Test;
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
     * Tests trial with all valid input. Getters and calculation methods tested.
     * 
     * @throws IOException Catch IO Exception in case file is not present.
     */
    @Test
    public void testVaildData() throws IOException
    {
        // Construct trial instance with all valid data
        Trial testTrial = new Trial("testData", "testValid", 0);
        
        // Test getters
        Assert.assertEquals("InfantID test", "testValid", testTrial.getInfantID());
        Assert.assertEquals("Filename from testData", "testData/subject_testValid_w00.csv", testTrial.getFileName());
        Assert.assertEquals("Getsize for trial", 48, testTrial.getSize());
        Assert.assertEquals("Getweek for trial", 00, testTrial.getWeek());
        
        // Test calculation methods and toString
        // Average, max, min etc. calculated and given in testData_info.rtf in testData package
        Assert.assertEquals("getMaxLeftWrist for valid data", .109172, 
                testTrial.getMaxState(0).getDoubleValue(), ACCURACY);
        Assert.assertEquals("getMinLeftWrist for valid data", .104375, 
                testTrial.getMinState(0).getDoubleValue(), ACCURACY);
        Assert.assertEquals("getAverageLeftWrist for valid data", .106955438, 
                testTrial.getAverageValue(0).getDoubleValue(), ACCURACY);
        Assert.assertEquals("getState for valid data", 
                new State("0,0.105938,0.156901,-0.214572,0.157862,-0.273852,-0.055263").toString(), 
                testTrial.getItem(0).toString());
    }
    
    /**
     * Tests trial constructor with NaN input in .csv file. Getters and calculation methods tested.
     * 
     * @throws IOException Catch IO Exception in case file is not present.
     */
    @Test
    public void testInvaildData() throws IOException
    {
        // Construct trial instance with invalid data
        Trial testTrial = new Trial("testData", "testNaN", 0);
        
        // Test getters
        Assert.assertEquals("InfantID test", "testNaN", testTrial.getInfantID());
        Assert.assertEquals("Filename from testData", "testData/subject_testNaN_w00.csv", testTrial.getFileName());
        Assert.assertEquals("Getsize for trial", 24, testTrial.getSize());
        Assert.assertEquals("Getweek for trial", 00, testTrial.getWeek());
        
        // Test calculation methods and toString
        // Average, max, min etc. calculated and given in testData_info.rtf in testData package
        Assert.assertEquals("getMaxLeftWrist for NaN data", .162172, 
                testTrial.getMaxState(0).getDoubleValue(), ACCURACY);
        Assert.assertEquals("getMinLeftWrist for NaN data", .315919, 
                testTrial.getMinState(1).getDoubleValue(), ACCURACY);
        Assert.assertEquals("getAverageLeftWrist for NaN data", -.033168091, 
                testTrial.getAverageValue(2).getDoubleValue(), ACCURACY);
        Assert.assertEquals("getState for NaN data",
                new State("0.22,NaN,NaN,NaN,0.117181,-0.310722,-0.066776").toString(), 
                testTrial.getItem(11).toString());
    }

}
