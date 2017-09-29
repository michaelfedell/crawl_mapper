import org.junit.Assert;
import org.junit.Test;

/**
 * This class will test the implementation and functionality of the General Value Class,
 * a class designed to recognize string representations of double values, and determine if
 * a valid point may be created
 * A value is considered valid if the value is a real number (NaN excluded)
 * 
 * @author Michael Fedell and Zach Schuermann
 * @version 09/11/17
 */
public class GeneralValueTest
{
    /**
     * Tests the empty constructor for GeneralValue objects. This test will also cover getters and isValid
     * The empty constructor should contain an empty double value, and a validity ID of FALSE
     */
    @Test
    public void testEmptyConstructor()
    {
        GeneralValue genVal = new GeneralValue();
        Assert.assertEquals("Empty Constructor: doubleValue", 0.0, genVal.getDoubleValue(), 0.00001);
        Assert.assertFalse("Empty Constructor: isValid", genVal.isValid());
    }
    
    /**
     * Tests the standard constructor for GeneralValue objects
     * Should pass in a string representation of a double value 
     * and return a GeneralValue object with both a double value and a validity ID
     */
    @Test
    public void testFullConstructor()
    {
        GeneralValue validGenVal = new GeneralValue("9.23");
        GeneralValue invalidGenVal = new GeneralValue("NaN");
        Assert.assertEquals("Valid Full Constructor: doubleValue", 9.23, 
                validGenVal.getDoubleValue(), 0.00001);
        Assert.assertTrue("Valid Full Constructor: isValid", validGenVal.isValid());
        Assert.assertEquals("Invalid Full Constructor: doubleValue", 0.00, 
                invalidGenVal.getDoubleValue(), 0.00001);
        Assert.assertFalse("Invalid Full Constructor: isValid", invalidGenVal.isValid());
    }
    
    /**
     * Tests the standard constructor for GeneralValue objects
     * Should pass in a string representation of a double value 
     * and return a GeneralValue object with both a double value and a validity ID
     */
    @Test
    public void testDoubleConstructor()
    {
        GeneralValue validGenVal = new GeneralValue(9.23);
        GeneralValue invalidGenVal = new GeneralValue(Double.NaN);
        Assert.assertEquals("Valid Full Constructor: doubleValue", 9.23, 
                validGenVal.getDoubleValue(), 0.00001);
        Assert.assertTrue("Valid Full Constructor: isValid", validGenVal.isValid());
        Assert.assertEquals("Invalid Full Constructor: doubleValue", 0.00, 
                invalidGenVal.getDoubleValue(), 0.00001);
        Assert.assertFalse("Invalid Full Constructor: isValid", invalidGenVal.isValid());
    }
    
    /**
     * Tests the GeneralValue toString method
     * Should return a string representation of the doubleValue, 
     * or a string of "invalid" if no valid value exists
     */
    @Test
    public void testToString()
    {
        GeneralValue validGenVal = new GeneralValue("-634.18");
        GeneralValue invalidGenVal = new GeneralValue("NaN");
        Assert.assertEquals("Valid To String", "-634.180", validGenVal.toString());
        Assert.assertEquals("Valid To String", "invalid", invalidGenVal.toString());
    }

}