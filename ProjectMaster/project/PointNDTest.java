import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit testing for the PointND Class
 * 
 * @author Michael Fedell modified by Zach Schuermann
 * @version 10/24/17
 */
public class PointNDTest
{
    /** GeneralValue to be assigned to the subfield "x" */
    private GeneralValue genValx = new GeneralValue("-1.8");
    
    /** GeneralValue to be assigned to the subfield "y" */
    private GeneralValue genValy = new GeneralValue("0.0");
    
    /** GeneralValue to be assigned to the subfield "z" */
    private GeneralValue genValz = new GeneralValue("14.8397");
    
    /** GeneralValue of invalid value to be used in pointInvalid    */
    private GeneralValue genValNaN = new GeneralValue("NaN");
    
    /** Array of general values used for testing    */
    private GeneralValue[] test = {new GeneralValue("-1.8"), new GeneralValue("0.0"), new GeneralValue("14.8397")};
    
    /** point to be used in testing */
    private PointND point = new PointND();
    
    /** point with an invalid value in the "y" subfield */
    private PointND pointInval = new PointND();
    
    /**
     * Sets up class for tests by adding general values to the pointND object
     */
    @Before
    public void setUpBeforeClass()
    {
        // Add values to PointND object
        point.add("x", genValx);
        point.add("y", genValy);
        point.add("z", genValz);
        
        // Include an invalid value in the PointND object
        pointInval.add("x", genValx);
        pointInval.add("y", genValNaN);
        pointInval.add("z", genValz);
    }
   
    
    /**
     * Tests the getDimValue method for each of the three dimensions of a fully constructed PointND object
     * The full constructor should accept three GeneralValue objects as input and return a single PointND object
     * The doubleValue of each GeneralValue in the PointND object will be compared for the test
     */
    @Test
    public void testGetValue()
    {       
        // Compare the doubleValue of each GeneralValue stored in the Point 3D
        // Comparing the GeneralValue objects will return different objects despite equal contents, 
        //   thus, doubleValues are examined in place 
        Assert.assertEquals("getDimValue: x", test[0].getDoubleValue(), 
                point.getValue("x").getDoubleValue(), 0.0001);
        Assert.assertEquals("getDimValue: y", test[1].getDoubleValue(), 
                point.getValue("y").getDoubleValue(), 0.0001);
        Assert.assertEquals("getDimValue: z", test[2].getDoubleValue(), 
                point.getValue("z").getDoubleValue(), 0.0001);
        
        //Test invalid
        Assert.assertFalse(point.getValue("Bogus").isValid());
        
        // Ensure that access also works for invalid values
        try
        {
            pointInval.getValue("y").getDoubleValue();
            Assert.fail("invalidGenVal not throwing an exception when attempting to reach invalid value");
        }
        catch (InvalidValueException e)
        {
            // Invalid Value was caught as intended
        }
    }
    
    /**
     * Tests the getSize method of PointND class.
     * This method should return an int indicating the size (number of subfields) of a pointND
     */
    @Test
    public void testSize()
    {        
        Assert.assertEquals("Size: ", 3, point.size());
    }
    
    /**
     * Tests to make sure that pointND is indeed Iterable
     */
    @Test
    public void iterableTest()
    {
        // iterate over keys in point
        for (String key : point)
        {
            // test each key is either x,y,z
            Assert.assertTrue(key.equals("x") || key.equals("y") || key.equals("z"));
        }
    }
   
    /**
     * Tests the toString method of the PointND class.
     * This method should return a string representation of each GeneralValue object stored in the PointND object
     * Values will be returned in a string of format "x,y,z" implementing the toString method for each GeneralValue
     */
    @Test
    public void testToString()
    {
        // Create the string against which point will be tested
        String testString = "x = -1.800; y = 0.000; z = 14.840; ";
        // Create the string against which pointInval will be tested
        String testStringInval = "x = -1.800; y = invalid; z = 14.840; ";
        
        Assert.assertEquals("To String", testString, point.toString());
        Assert.assertEquals("To String Invalid", testStringInval, pointInval.toString());       
    }
}