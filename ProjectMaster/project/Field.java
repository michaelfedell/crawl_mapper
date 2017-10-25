import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Class to store a field for a given index in a CSV
 * Holds Map from subfields to columnIndex's
 * @author Zach Schuermann
 * @version 10/22/17
 *
 */
public class Field implements Iterable<String>
{
    /**
     * Declare the map from subfields to column index's
     */
    private Map<String, Integer> subFields;
    
    /**
     * Constructor creates empty instance of a hashMap
     */
    public Field()
    {
        subFields = new TreeMap<String, Integer>();
    }
    
    /**
     * Method to add subfields to the subFields Map
     * @param subFieldName String to identify the name of the subfield
     * @param columnIndex int of the column in the CSV
     */
    public void addSubField(String subFieldName, int columnIndex)
    {
        subFields.put(subFieldName, columnIndex);
    }
    
    /**
     * Getter for the index of a given field
     * @param subFieldName String the name that represents a given subfield
     * @return int the index of the subfield
     */
    public Integer getIndex(String subFieldName)
    {
        if (subFields.containsKey(subFieldName))
        {
            return subFields.get(subFieldName);
        }
        else
        {
            return null;
        }
    }
    
    /**
     * Getter for the size of the subFields map
     * @return the number of subfields for a field
     */
    public int size()
    {
        return subFields.size();
    }
    
    /**
     * Iterator method to allow this class to implement iterable
     * @return iterator over the KeySet
     */
    public Iterator<String> iterator()
    {
        return subFields.keySet().iterator();
    }
    
    /**
     * 
     */
    public String toString()
    {
        String out = "";
        for (String key : subFields.keySet()) 
        {
            out += key + "(" + subFields.get(key) + "); ";
        }
        return out;
    }
}
