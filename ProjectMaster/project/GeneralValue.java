/**
 * GeneralValue class
 * Captures both a double value and whether or not it is valid
 * 
 * @author Zach Schuermann
 * @version 09/29/17
 *
 */
public class GeneralValue
{
    /** Is the value valid? */
    private boolean valid;
    /** Double value stored.  */
    private double doubleValue;

    /**
     * Empty constructor initializes a GeneralValue object of empty doubleValue and invalid type
     */
    public GeneralValue()
    {
        valid = false;
    }
    
    /**
     * Default Constructor - creates a GeneralValue object and determines validity based on value passed
     * (value of NaN results in an invalid GeneralValue object)
     * 
     * @param strg should contain a numeric value of type double, or NaN if invalid 
     */
    public GeneralValue(String strg)
    {
        // test if equals NaN and return value if not
        if (strg.equals("NaN"))
        {
            valid = false;
        }
        else 
        {
            valid = true;
            doubleValue = Double.parseDouble(strg);
        }
    }
    
    /**
     * Double Constructor - creates a GeneralValue object and determines validity based on value passed
     * (value of NaN results in an invalid GeneralValue object)
     * 
     * @param doubleValue double should contain a numeric value of type double, or NaN if invalid 
     */
    public GeneralValue(double doubleValue)
    {
        // check double value and assign validity
        if (Double.isNaN(doubleValue))
        {
            valid = false;
        }
        else 
        {
            valid = true;
            this.doubleValue = doubleValue;
        }
    }
    
    /**
     * Indicates validity of GeneralValue
     * 
     * @return true if valid, false if invalid
     */
    public boolean isValid()
    {
        return valid;
    }
    
    /**
     * Gives user the numeric data stored in GeneralValue 
     * 
     * @return the numeric value stored in GeneralValue as type double.
     * @throws InvalidValueException when 
     */
    public double getDoubleValue() throws InvalidValueException
    {
        // If GV is valid, return the double
        if (valid)
        {
            return doubleValue;
        }
        // otherwise, throw exception
        else
        {
            throw new InvalidValueException("Message?");
        }
    }
    
    /**
     * Compares two GeneralValue objects as required by the comparable interface
     * 
     * @param v The GeneralValue to which this object will be compared
     * @return True if this is less than v, false otherwise.
     *          comparing this (valid) to an invalid value will yield true
     */
    public boolean isLessThan(GeneralValue v)
    {
        double vDouble = 0.0;
        // Must check for validity within a try-catch block
        try
        {
            vDouble = v.getDoubleValue();
        }
        catch (InvalidValueException e)
        {
            // Any valid value will be considered less than an invalid one
            return this.valid;
        }
        // if valid return true
        return this.valid && this.doubleValue < vDouble;
    }
    
    /**
     * Compares two GeneralValue objects as required by the comparable interface
     * 
     * @param v The GeneralValue to which this object will be compared
     * @return True if this is greater than v, false otherwise.
     *          comparing this (valid) to an invalid value will yield true
     */
    public boolean isGreaterThan(GeneralValue v)
    {
        double vDouble = 0.0;
        
        // Must check for validity within a try-catch block
        try
        {
            vDouble = v.getDoubleValue();
        }
        catch (InvalidValueException e)
        {
            // Any valid value will be considered greater than an invalid one
            return this.valid;
        }
        
        // test validity
        return this.valid && this.doubleValue > vDouble;
    }
    
    /**
     * Formats the doubleValue data as a string with three decimal places
     * 
     * @return "invalid" string if value is not valid, doubleValue as string if valid
     */
    public String toString()
    {
        String out;
        // return invalid if not valid
        if (!valid)
        {
            out = "invalid";
        }
        else
        {
            out = String.format("%.3f", doubleValue);
        }
        return out;
    }
}
