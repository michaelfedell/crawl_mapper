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

    public GeneralValue()
    {
        valid = false;
    }
    
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
    
    public boolean isValid()
    {
        return valid;
    }
    
    public double getDoubleValue()
    {
        return doubleValue;
    }
    
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
