import java.util.Iterator;
import java.util.TreeMap;

/**
 * Class to represent the position of sensor as an array of three points (General Values)
 * 
 * @author Zach Schuermann
 * @version 10/22/17
 */
public class PointND
{
    /** Array of general values to describe point location */
    private TreeMap<String, GeneralValue> values;
    
    /**
     * Constructs empty PointND object 
     * (empty treemap)
     *
     */
    public PointND()
    {
       // init empty treemap
       values = new TreeMap<String, GeneralValue>();
    }
    
    /**
     * Add value to the pointND treemap
     * @param subFieldName String to represent the key
     * @param value GeneralValue to represent the value
     */
    public void add(String subFieldName, GeneralValue value)
    {
        // add k, v to treemap
        values.put(subFieldName, value);
    }
    
    /**
     * Get value from pointND for a given subFieldName
     * @param subFieldName the key to retrieve
     * @return the value at a given key
     */
    public GeneralValue getValue(String subFieldName)
    {
        return values.get(subFieldName);
    }
    
    /**
     * Getter for the size of treemap of PointND
     * @return size the size of the array
     */
    public int size()
    {
        return values.size();
    }
    
    /**
     * Create an iterator for the PointND
     * @return an iterator over the keySet of the PointND treemap
     */
    public Iterator<String> iterator()
    {
        return values.keySet().iterator();
    }
    
    /**
     * Converts pointND to comma separated string for each pair
     * 
     * @return String representation of a concatenation of all key, value pairs
     */
    public String toString()
    {
        String out = "";
        for (String key : values.keySet())
        {
            out += key.toUpperCase() + " = " + values.get(key).toString().toUpperCase() + "; ";
        }
        return out;
    }
}
