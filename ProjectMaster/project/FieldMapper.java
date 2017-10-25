import java.util.TreeMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Class to map fields from a given top row of data.
 * @author Zach Schuermann
 * @version 10/22/17
 */
public class FieldMapper implements Iterable<String>
{
    /**
     * Declare the fieldMap to map strings to their respective fields
     */
    private Map<String, Field> fieldMap;
    
    /**
     * Constructs a hashMap of each column name to a specific field
     * Adds subfields to each ("" for no subfields)
     * @param columnNames String array of the names of each column (top row)
     */
    public FieldMapper(String[] columnNames)
    {
        // instantiate treeMap for fieldMap
        fieldMap = new TreeMap<String, Field>();
        int i = 0;
        //loop over all columns
        for (String col : columnNames)
        {
            // test if it has subFields
            if (col.charAt(col.length() - 2) == '_')
            {
                //create field, skip if already created and just need to add subfields
                if (!fieldMap.containsKey(col.substring(0, col.length() - 2)))
                {
                    fieldMap.put(col.substring(0, col.length() - 2), new Field());
                }
                fieldMap.get(col.substring(0, col.length() - 2))
                    .addSubField(col.substring(col.length() - 1, col.length()), i);
            }
            // no subfields
            else
            {
                // add col and new field with empty string subField
                fieldMap.put(col, new Field());
                fieldMap.get(col).addSubField("", i);
            }
            // increment index holder
            i++;
        }
    }
    
    /**
     * Getter for a Field with given fieldName
     * @param fieldName the string key for a field
     * @return Field of given fieldName
     */
    public Field getField(String fieldName)
    {
        return fieldMap.get(fieldName);
    }
    
    /**
     * Method to return a pointND for a given string array of values for a fieldName
     * @param stringValues String array of values in a given field
     * @param fieldName String representing the name of a given field
     * @return point The pointND constructed for a given field
     */
    public PointND extractPointND(String[] stringValues, String fieldName)
    {
        // I think there is an error in here?
        PointND point = new PointND(); 
        for (String subFieldName : fieldMap.get(fieldName))
        {
            int i = fieldMap.get(fieldName).getIndex(subFieldName);     // potential for null i here...? getIndex(inval) returns null so maybe?
            point.add(subFieldName, new GeneralValue(stringValues[i]));
        }
        return point;
    }
    
    /**
     * Getter for the size of the fieldMap
     * @return the size of the fieldMap
     */
    public int size()
    {
        return fieldMap.size();
    }
    
    /**
     * Iterator method to allow the class to implement iterable
     * @return Iterator over the Key set
     */
    public Iterator<String> iterator()
    {
        return fieldMap.keySet().iterator();
    }
}
