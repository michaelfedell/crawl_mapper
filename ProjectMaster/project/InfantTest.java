import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

/**
 * Class to test the Infant class using data enclosed in testData
 * @author Zach Schuermann
 * @version 10/24/17
 */
public class InfantTest
{
    /**
     * Test infant constructor and valid data split among two files with known statistics
     * @throws IOException in case of IO exception from file loading
     */
    @Test
    public void infantValidDataTest() throws IOException
    {
        // instantiate infant instance using two test files
        Infant testBaby = new Infant("testData", "testValid");
        
        // test X dimension statistics
        Assert.assertEquals("Average left wrist for X", .107335, 
                testBaby.getAverageValue("left_wrist", "x").getDoubleValue(), .000001);
        Assert.assertEquals("Max left wrist for X", .109172, 
                testBaby.getMaxState("left_wrist", "x").getValue("left_wrist", "x").getDoubleValue(), .000001);
        Assert.assertEquals("Min left wrist for X", .104375, 
                testBaby.getMinState("left_wrist", "x").getValue("left_wrist", "x").getDoubleValue(), .000001);
        
        // test Y dimension statistics
        Assert.assertEquals("Average left wrist for Y", .158158, 
                testBaby.getAverageValue("left_wrist", "y").getDoubleValue(), .000001);
        Assert.assertEquals("Max left wrist for Y", .159682, 
                testBaby.getMaxState("left_wrist", "y").getValue("left_wrist", "y").getDoubleValue(), .000001);
        Assert.assertEquals("Min left wrist for Y", .155445, 
                testBaby.getMinState("left_wrist", "y").getValue("left_wrist", "y").getDoubleValue(), .000001);
        
        // test Z dimension statistics
        Assert.assertEquals("Average left wrist for Z", -.214687,
                testBaby.getAverageValue("left_wrist", "z").getDoubleValue(), .000001);
        Assert.assertEquals("Max left wrist for Z", -.213653,
                testBaby.getMaxState("left_wrist", "z").getValue("left_wrist", "z").getDoubleValue(), .000001);
        Assert.assertEquals("Min left wrist for Z", -.216293,
                testBaby.getMinState("left_wrist", "z").getValue("left_wrist", "z").getDoubleValue(), .000001);
        
    }
    
    /**
     * Test infant constructor and invalid data split among a files with known statistics
     * @throws IOException in case of IO exception from file loading
     */
    @Test
    public void infantInvalidDataTest() throws IOException
    {
        // instantiate infant instance using two test files
        Infant testBaby = new Infant("testData", "testNaN");
        
        // test X dimensions
        Assert.assertEquals("Average left wrist for X", .161439,
                testBaby.getAverageValue("left_wrist", "x").getDoubleValue(), .000001);
        Assert.assertEquals("Max left wrist for X", .162172,
                testBaby.getMaxState("left_wrist", "x").getValue("left_wrist", "x").getDoubleValue(), .000001);
        Assert.assertEquals("Min left wrist for X", .160187,
                testBaby.getMinState("left_wrist", "x").getValue("left_wrist", "x").getDoubleValue(), .000001);
        
        // test Y dimension statistics
        Assert.assertEquals("Average left wrist for Y", .316289,
                testBaby.getAverageValue("left_wrist", "y").getDoubleValue(), .000001);
        Assert.assertEquals("Max left wrist for Y", .317149,
                testBaby.getMaxState("left_wrist", "y").getValue("left_wrist", "y").getDoubleValue(), .000001);
        Assert.assertEquals("Min left wrist for Y", .315919,
                testBaby.getMinState("left_wrist", "y").getValue("left_wrist", "y").getDoubleValue(), .000001);
        
        // test Z dimension statistics
        Assert.assertEquals("Average left wrist for Z", -.033168,
                testBaby.getAverageValue("left_wrist", "z").getDoubleValue(), .000001);
        Assert.assertEquals("Max left wrist for Z", -.027961,
                testBaby.getMaxState("left_wrist", "z").getValue("left_wrist", "z").getDoubleValue(), .000001);
        Assert.assertEquals("Min left wrist for Z", -.034253,
                testBaby.getMinState("left_wrist", "z").getValue("left_wrist", "z").getDoubleValue(), .000001);
    }
    
    /**
     * Test getSize method
     * @throws IOException in case of IO exception from file loading
     */
    @Test
    public void infantGetSizeTest() throws IOException
    {
        // instantiate test using two valid data files
        Infant testBaby = new Infant("testData", "testValid");
        
        // get the size and test
        int size = testBaby.getSize();
        Assert.assertEquals("Size of trials in testBaby", 2, size);
    }
    
    /**
     * Test getItem method
     * @throws IOException in case of IO exception from file loading
     */
    @Test
    public void infantGetItemTest() throws IOException
    {
        // instantiate test using two valid data files
        Infant testBaby = new Infant("testData", "testValid");
        
        // get the Trial and test using comparison of the week
        Trial testItem = testBaby.getItem(0);
        Assert.assertEquals("Test week of first trial in testBaby", 1, testItem.getWeek());
    }
    
    /**
     * Test getInfantID method
     * @throws IOException in case of IO exception from file loading
     */
    @Test
    public void infantGetInfantIDTest() throws IOException
    {
        // instantiate test using two valid data files
        Infant testBaby = new Infant("testData", "testValid");
        
        // get the id and test
        String id = testBaby.getInfantID();
        Assert.assertEquals("Infant  in testBaby", "testValid", id);
    }
    
    /**
     * Test multiple item abstract method with 
     * @throws IOException in case of IO exception from file loading
     */
    @Test
    public void multipleItemAbstractInvalidTest() throws IOException
    {
        // instantiate test using two valid data files
        Infant testBaby = new Infant("testData", "testInvalid");
        
        // test multiple item abstracts to return invalid GV
        Assert.assertFalse("Infant loaded from invalid data",
                testBaby.getAverageValue("left_wrist", "x").isValid());
        Assert.assertFalse("Infant loaded from invalid data",
                testBaby.getMaxState("left_wrist", "y").getValue("left_wrist", "y").isValid());
        Assert.assertFalse("Infant loaded from invalid data",
                testBaby.getMinState("left_wrist", "z").getValue("left_wrist", "z").isValid());
    }
    
    /**
     * Test new constructor for infant class using indices.
     * @throws IOException for invalid loading
     */
    @Test
    public void infantIndexingTest() throws IOException
    {
        Infant testBaby = new Infant("testData", "testValid");
        Infant indexedBaby = new Infant(testBaby, new int[] {0, 1, 2, 25});
        
        // Need to also assert that indexedBaby has the proper indexed trials
        Assert.assertEquals("Check Size", 2, indexedBaby.getSize());
        Assert.assertEquals("Check index 0", 1, indexedBaby.getItem(0).getWeek());
        Assert.assertEquals("Check index 1", 2, indexedBaby.getItem(1).getWeek());
    }
    
    /**
     * Iterable test
     * @throws IOException for invalid loading
     */
    @Test
    public void infantIterableTest() throws IOException
    {
        // instantiate testBaby
        Infant testBaby = new Infant("testData", "testValid");
        
        // iterate over testBaby
        for (Trial trial : testBaby)
        {
            // check for trial in infant
            Assert.assertTrue(trial.getInfant().equals(testBaby));
        }
    }
}
