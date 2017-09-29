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
        try
        {
            genVal.getDoubleValue();
        }
        catch (InvalidValueException e)
        {
            Assert.assertFalse(genVal.isValid());
        }
    }
    
    /**
     * Tests the standard constructor for GeneralValue objects
     * Should pass in a string representation of a double value 
     * and return a GeneralValue object with both a double value and a validity ID
     */
    @Test
    public void testFullConstructor() throws InvalidValueException
    {
        GeneralValue validGenVal = new GeneralValue("9.23");
        GeneralValue invalidGenVal = new GeneralValue("NaN");
        Assert.assertEquals("Valid Full Constructor: doubleValue", 9.23, 
                validGenVal.getDoubleValue(), 0.00001);
        Assert.assertTrue("Valid Full Constructor: isValid", validGenVal.isValid());
        try
        {
            invalidGenVal.getDoubleValue();
        }
        catch (InvalidValueException e)
        {
            Assert.assertTrue(true);
        }
    }
    
    /**
     * Tests the double value constructor for GeneralValue objects
     * Should pass in a double value 
     * and return a GeneralValue object with both a double value and a validity ID
     */
    @Test
    public void testDoubleConstructor() throws InvalidValueException
    {
        GeneralValue validGenVal = new GeneralValue(9.23);
        GeneralValue invalidGenVal = new GeneralValue(Double.NaN);
        Assert.assertEquals("Valid Full Constructor: doubleValue", 9.23, 
                validGenVal.getDoubleValue(), 0.00001);
        Assert.assertTrue("Valid Full Constructor: isValid", validGenVal.isValid());
        try
        {
            invalidGenVal.getDoubleValue();
        }
        catch (InvalidValueException e)
        {
            Assert.assertTrue(true);
        }
    }
    
    /**
     * 
     */
    @Test
    public void testIsLessThan()
    {
        GeneralValue thisGV = new GeneralValue(5);
        GeneralValue invalid = new GeneralValue(Double.NaN);
        GeneralValue gv1 = new GeneralValue(7);
        GeneralValue gv2 = new GeneralValue(3.2);
        
        Assert.assertTrue("Testing 5 < 7 should return true.", thisGV.isLessThan(gv1));
        Assert.assertFalse("Testing 5 = 5 should return false.", thisGV.isLessThan(thisGV));
        Assert.assertFalse("Testing 5 > 3.2 should return false.", thisGV.isLessThan(gv2));
        Assert.assertTrue("Testing 5 // invalid should return true.", thisGV.isLessThan(invalid));
        Assert.assertFalse("Testing invalid // 3.2 should return false.", invalid.isLessThan(gv2));
        Assert.assertFalse("Testing invalid // invalid should return false.", invalid.isLessThan(invalid));
    }
    
    /**
     * 
     */
    @Test
    public void testIsGreaterThan()
    {
        GeneralValue thisGV = new GeneralValue(5);
        GeneralValue invalid = new GeneralValue(Double.NaN);
        GeneralValue gv1 = new GeneralValue(7);
        GeneralValue gv2 = new GeneralValue(3.2); 
        
        Assert.assertFalse("Testing 5 < 7 should return false.", thisGV.isGreaterThan(gv1));
        Assert.assertFalse("Testing 5 = 5 should return false.", thisGV.isGreaterThan(thisGV));
        Assert.assertTrue("Testing 5 > 3.2 should return false.", thisGV.isGreaterThan(gv2));
        Assert.assertTrue("Testing 5 // invalid should return true.", thisGV.isGreaterThan(invalid));
        Assert.assertFalse("Testing invalid // 3.2 should return false.", invalid.isGreaterThan(gv2));
        Assert.assertFalse("Testing invalid // invalid should return false.", invalid.isGreaterThan(invalid));
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