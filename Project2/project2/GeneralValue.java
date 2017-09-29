/**
 * Value class
 * 
 * Captures both a double value and whether or not it is valid
 * 
 * @author Andrew H. Fagg
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
     * Empty constructor: invalid value
     */
    public GeneralValue()
    {
        valid = false;
    }

    /**
     * Non-empty constructor
     * 
     * @param strg A String containing a double value or "NaN"
     */
    public GeneralValue(String strg)
    {
        // Is it valid?
        if (strg.equals("NaN")) 
        {
            // No
            valid = false;
        }
        else
        {
            // Yes: store the value
            doubleValue = Double.parseDouble(strg);
            valid = true;
        }

    }

    /**
     * Reports whether a value is valid
     * 
     * @return True if valid; false if invalid
     */
    public boolean isValid()
    {
        return valid;
    }

    /**
     * Reports the double value that is stored
     * 
     * @return The stored double value
     */
    public double getDoubleValue()
    {
        return doubleValue;
    }

    /**
     * Return a String representation of the GeneralValue
     * 
     * @return * "invalid" if the value is not valid; 
     * String representation of the value (truncated to 3 decimal points)
     *  
     */
    public String toString()
    {
        // Is the value valid?
        if (valid) 
        {
            // Yes: report the double
            return String.format("%.3f", doubleValue);
        }
        else
        {
            // No
            return "invalid";
        }
    }
}