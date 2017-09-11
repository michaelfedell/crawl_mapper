import org.junit.Assert;
import org.junit.Test;

/**
 * This class will test the implementation and functionality of the Point3D Class,
 * a class designed to organize three input values into a vector with x, y, and z-values
 * This class will cover testing for all public methods of the Point3D Class
 * 
 * @author Michael Fedell
 * @version 09/11/17
 */
public class Point3DTest
{
    /**
     * Tests the getDimValue method for each of the three dimensions of a fully constructed Point3D object
     * The full constructor should accept three GeneralValue objects as input and return a single Point3D object
     * The doubleValue of each GeneralValue in the Point3D object will be compared for the test
     */
    @Test
    public void testGetDimValue()
    {
        // Create general value objects to pass into the Point3D constructor
        GeneralValue genVal1 = new GeneralValue("-1.8");
        GeneralValue genVal2 = new GeneralValue("NaN");
        GeneralValue genVal3 = new GeneralValue("14.8397");
        
        // Create an array of general values against which the Point3D object will be tested
        GeneralValue[] test = {new GeneralValue("-1.8"), new GeneralValue("NaN"), new GeneralValue("14.8397")};
        
        // Create the Point3D object for testing
        Point3D point = new Point3D(genVal1, genVal2, genVal3);
        
        // Compare the doubleValue of each GeneralValue stored in the Point 3D
        // Comparing the GeneralValue objects will return different objects despite equal contents, 
        //   thus, doubleValues are examined in place 
        Assert.assertEquals("getDimValue: X", test[0].getDoubleValue(), point.getDimValue(0).getDoubleValue(), 0.0001);
        Assert.assertEquals("getDimValue: Y", test[1].getDoubleValue(), point.getDimValue(1).getDoubleValue(), 0.0001);
        Assert.assertEquals("getDimValue: Z", test[2].getDoubleValue(), point.getDimValue(2).getDoubleValue(), 0.0001);
    }
    
    /**
     * Tests the getValues method of Point3D class.
     * This method should return an array of GeneralValue objects from a Point3D object
     * The doubleValues of each GeneralValue object will be tested in the array returned by getValues()
     */
    @Test
    public void testGetValues()
    {
        // Create general value objects to pass into the Point3D constructor
        GeneralValue genVal1 = new GeneralValue("23.98");
        GeneralValue genVal2 = new GeneralValue("NaN");
        GeneralValue genVal3 = new GeneralValue("-99999");
        
        // Create an array of general values against which the Point3D object will be tested
        GeneralValue[] test = {new GeneralValue("23.98"), new GeneralValue("NaN"), new GeneralValue("-99999")};
        
        // Create the Point3D object for testing
        Point3D point = new Point3D(genVal1, genVal2, genVal3);
        
        Assert.assertEquals("Get Values: X", test[0].getDoubleValue(), point.getValues()[0].getDoubleValue(), 0.0001);
        Assert.assertEquals("Get Values: Y", test[1].getDoubleValue(), point.getValues()[1].getDoubleValue(), 0.0001);
        Assert.assertEquals("Get Values: Z", test[2].getDoubleValue(), point.getValues()[2].getDoubleValue(), 0.0001);
    }
    
    /**
     * Tests the toString method of the Point3D class.
     * This method should return a string representation of each GeneralValue object stored in the Point3D object
     * Values will be returned in a string of format "x,y,z" implementing the toString method for each GeneralValue
     */
    @Test
    public void testToString()
    {
        // Create general value objects to pass into the Point3D constructor
        GeneralValue genVal1 = new GeneralValue("0.123");
        GeneralValue genVal2 = new GeneralValue("-42.814");
        GeneralValue genVal3 = new GeneralValue("NaN");
        
        // Create the Point3D object for testing
        Point3D point = new Point3D(genVal1, genVal2, genVal3);
        
        // Create the string against which Point3D will be tested
        String testString = "0.123,-42.814,invalid";
        
        Assert.assertEquals("To String", testString, point.toString());
    }
    
}