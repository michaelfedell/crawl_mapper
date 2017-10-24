import java.util.Iterator;
import java.util.TreeMap;

/**
 * Representation of the state of a single time step
 * 
 * @author Andrew H. Fagg modified by Michael Fedell, Zach Schuermann
 * @version 10/23/17
 *
 */
public class State extends SingleItemAbstract implements Iterable<String>
{
    /** holds the Trial that a State belongs to */
    private Trial trial;
    /** holds the map of points in a state      */
    private TreeMap<String, PointND> variables;
    
    /**
     * Default Constructor - creates an empty State object
     */
    public State()
    {
        // init empty TreeMap
        variables = new TreeMap<String, PointND>();
    }
       
    /**
     * Full constructor takes a Trial, FieldMapper, and String as arguments.
     * The Trial is passed so that each State may be able to identify the Trial to which it belongs
     * The FieldMapper is used to map values from the CSV string to the appropriate field names
     * The String of values is pulled from a CSV file and contains data for each of the fields contained in the trial 
     * 
     * @param trial Indicates the trial to which this state belongs
     * @param fieldMapper Informs the constructor how to create fields from the String data
     * @param values Describes all of the values associated with the State (a CSV row)
     */
    public State(Trial trial, FieldMapper fieldMapper, String values)
    {
        variables = new TreeMap<String, PointND>();
        this.trial = trial;
        for (String fieldName : fieldMapper)
        {
            //Use FieldMapper to map values to this.variables
            variables.put(fieldName, fieldMapper.extractPointND(values.split(","), fieldName));
        }
    }
    
    /**
     * Getter for the trial the state belongs to
     * 
     * @return Trial the trial the state belongs to
     */
    public Trial getTrial()
    {
        return trial;
    }
    
    /**
     * Returns the pointND object for a user-specified field in this state. 
     * @param fieldName String for the given field
     * @return PointND object of specified field at current state.
     */
    public PointND getPoint(String fieldName)
    {
        return variables.get(fieldName);
    }
    
    /**
     * Returns the value of a specific field and subfield for this state.
     * If a desired field is without subfields, such as time, an empty String can be passed in as subFieldName
     * 
     * @param fieldName Specifies the desired field such as "Left_Wrist"
     * @param subFieldName Specifies the desired subfield such as "z"
     * @return A GeneralValue object representing the value of specified field and subfield in its current State
     */
    public GeneralValue getValue(String fieldName, String subFieldName)
    {
        if (variables.containsKey(fieldName))
        {
            return variables.get(fieldName).getValue(subFieldName);
        }
        else
        {
            return new GeneralValue("NaN");
        }
    }
        
    /**
     * "Computes" statistical maximum of specified field over a single state.
     * 
     * @param fieldName String to represent the fieldname 
     * @param subFieldName String to represent the subFieldName
     * @return state containing the maximum value of specified field over a single state (this state)
     */
    public State getMaxState(String fieldName, String subFieldName)
    {
        return this;
    }
    
    /**
     * "Computes" statistical minimum of specified field over a single state.
     * 
     * @param fieldName String to represent the fieldname 
     * @param subFieldName String to represent the subFieldName
     * @return state containing the minimum value of specified field over a single state (this state)
     */
    public State getMinState(String fieldName, String subFieldName)
    {
        return this;
    }
    
    /**
     * "Computes" and returns the average value for the specified field over a single state
     * 
     * @param fieldName String to represent the fieldname 
     * @param subFieldName String to represent the subFieldName
     * @return the average value of specified field over a single state
     */
    public GeneralValue getAverageValue(String fieldName, String subFieldName)
    {
        return variables.get(fieldName).getValue(subFieldName);
    }
    
    /**
     * Returns a string iterator for the keySet of this state
     * required by the iterable interface
     * 
     * @return A string iterator for the keys in this state
     */
    public Iterator<String> iterator()
    {
        return variables.keySet().iterator();
    }
    
    /**
     * Returns a multi-line string representation of this state taking the following format:
     * "FIELDNAME(POINTND)\n"
     * 
     * @return Multi-line string representing the PointND objects of each field in this state
     */
    public String toString()
    {
        String out = "";
        for (String key : variables.keySet())
        {
            out += key + "(" + variables.get(key).toString() + ")\n";
        }
        return out;
    }
}
