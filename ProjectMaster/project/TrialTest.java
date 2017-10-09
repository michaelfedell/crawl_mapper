import org.junit.Test;
import java.io.IOException;
import org.junit.Assert;

/**
 * Class to test Trial class.
 * 
 * @author Zach Schuermann modified by Michael Fedell
 * @version 09/29/17
 */
public class TrialTest
{
    private static final double ACCURACY = 0.0000001;
    
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
                testTrial.getMaxLeftWrist(0).getDoubleValue(), ACCURACY);
        Assert.assertEquals("getMinLeftWrist for valid data", .104375, 
                testTrial.getMinLeftWrist(0).getDoubleValue(), ACCURACY);
        Assert.assertEquals("getAverageLeftWrist for valid data", .106955438, 
                testTrial.getAverageLeftWrist(0).getDoubleValue(), ACCURACY);
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
                testTrial.getMaxLeftWrist(0).getDoubleValue(), ACCURACY);
        Assert.assertEquals("getMinLeftWrist for NaN data", .315919, 
                testTrial.getMinLeftWrist(1).getDoubleValue(), ACCURACY);
        Assert.assertEquals("getAverageLeftWrist for NaN data", -.033168091, 
                testTrial.getAverageLeftWrist(2).getDoubleValue(), ACCURACY);
        Assert.assertEquals("getState for NaN data",
                new State("0.22,NaN,NaN,NaN,0.117181,-0.310722,-0.066776").toString(), 
                testTrial.getItem(11).toString());
    }

}
