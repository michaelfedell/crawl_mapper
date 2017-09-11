import org.junit.Test;
import java.io.IOException;
import org.junit.Assert;

/**
 * Class to test Trial class.
 * 
 * @author Zach Schuermann
 * @version 09/11/17
 */
public class TestTrial
{
    /**
     * Tests trial with all valid input. Getters and calculation methods tested.
     * @throws IOException Catch IO Exception in case file is not present.
     */
    @Test
    public void testVaildData() throws IOException
    {
        // Construct trial instance with all valid data
        Trial testTrial = new Trial("testData", "testValid", 0);
        
        // Test getters
        Assert.assertEquals("testValid", testTrial.getInfantID());
        Assert.assertEquals("testData/subject_testValid_w00.csv", testTrial.getFileName());
        Assert.assertEquals(48, testTrial.getSize());
        Assert.assertEquals(00, testTrial.getWeek());
        
        // Test calculation methods and toString
        // Average, max, min etc. calculated and given in testData_info.rtf in testData package
        Assert.assertEquals(.109172, testTrial.getMaxLeftWrist(0), .000001);
        Assert.assertEquals(.104375, testTrial.getMinLeftWrist(0), .000001);
        Assert.assertEquals(.106955438, testTrial.getAverageLeftWrist(0), .000000001);
        Assert.assertEquals(new State("0,0.105938,0.156901,-0.214572,0.157862,-0.273852,-0.055263").toString(), 
                testTrial.getState(0).toString());
    }
    
    /**
     * Tests trial constructor with NaN input in .csv file. Getters and calculation methods tested.
     * @throws IOException Catch IO Exception in case file is not present.
     */
    @Test
    public void testInvaildData() throws IOException
    {
        // Construct trial instance with invalid data
        Trial testTrial = new Trial("testData", "testNaN", 0);
        
        // Test getters
        Assert.assertEquals("testNaN", testTrial.getInfantID());
        Assert.assertEquals("testData/subject_testNaN_w00.csv", testTrial.getFileName());
        Assert.assertEquals(24, testTrial.getSize());
        Assert.assertEquals(00, testTrial.getWeek());
        
        // Test calculation methods and toString
        // Average, max, min etc. calculated and given in testData_info.rtf in testData package
        Assert.assertEquals(.162172, testTrial.getMaxLeftWrist(0), .000001);
        Assert.assertEquals(.315919, testTrial.getMinLeftWrist(1), .000001);
        Assert.assertEquals(-.033168091, testTrial.getAverageLeftWrist(2), .000000001);
        Assert.assertEquals(new State("0.22,NaN,NaN,NaN,0.117181,-0.310722,-0.066776").toString(), 
                testTrial.getState(11).toString());
        
    }

}
