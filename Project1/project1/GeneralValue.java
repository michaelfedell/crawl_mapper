/**
 * Value class
 * 
 * Captures both a double value and whether or not it is valid
 * 
 * @author Zach Schuermann
 * @version 2017-09-03
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
     * @param strg should contain a numeric value of type double, or NaN if invalid 
     */
    public GeneralValue(String strg)
    {
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
     * Indicates validity of GeneralValue
     * @return true if valid, false if invalid
     */
    public boolean isValid()
    {
        return valid;
    }
    
    /**
     * Gives user the numeric data stored in GeneralValue 
     * @return the numeric value stored in GeneralValue as type double.
     */
    public double getDoubleValue()
    {
        return doubleValue;
    }
    
    /**
     * Formats the doubleValue data as a string with three decimal places
     * @return "invalid" string if value is not valid, doubleValue as string if valid
     */
    public String toString()
    {
        String out;
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
