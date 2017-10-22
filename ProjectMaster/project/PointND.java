import java.util.Iterator;
import java.util.TreeMap;

/**
 * Class to represent the position of sensor as an array of three points (General Values)
 * 
 * @author Zach Schuermann
 * @version 09/07/17
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
       values = new TreeMap<String, GeneralValue>();
    }
    
    public void add(String subFieldName, GeneralValue value)
    {
        values.put(subFieldName, value);
    }
    
    public GeneralValue getValue(String subFieldName)
    {
        return values.get(subFieldName);
    }
    
    public int size()
    {
        return values.size();
    }
    
    public Iterator<String> iterator()
    {
        return values.keySet().iterator();
    }
    
    /**
     * Converts point3D to comma separated string in the format x,y,z
     * 
     * @return String representation of point in 3D space, "x,y,z"
     */
    public String toString()
    {
        return points[0].toString() + "," + points[1].toString() + "," + points[2].toString();
    }
}
