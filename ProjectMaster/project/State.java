import java.util.Iterator;
import java.util.TreeMap;

/**
 * Representation of the state of a single time step
 * 
 * @author Andrew H. Fagg modified by Michael Fedell
 * @version 09/29/17
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
        //TODO: Body needed on empty constructor?
    }
       
    /**
     * 
     * @param trial Indicates the trial to which this state belongs
     * @param fieldMapper Informs the constructor how to create fields from the String data
     * @param values Describes all of the values associated with the State (a CSV row)
     */
    public State(Trial trial, FieldMapper fieldMapper, String values)
    {
        this.trial = trial;
        //TODO: Use FieldMapper to map values to this.variables
    }
    
    /**
     * Returns the pointND object for a user-specified field in this state. 
     * 
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
        return variables.get(fieldName).getValue(subFieldName);
    }
        
    /**
     * "Computes" statistical maximum of specified field over a single state.
     * 
     * @param fieldName
     * @param subFieldName
     * @return state containing the maximum value of specified field over a single state (this state)
     */
    public State getMaxState(String fieldName, String subFieldName)
    {
        return this;
    }
    
    /**
     * "Computes" statistical minimum of specified field over a single state.
     * 
     * @param fieldName
     * @param subFieldName
     * @return state containing the minimum value of specified field over a single state (this state)
     */
    public State getMinState(String fieldName, String subFieldName)
    {
        return this;
    }
    
    /**
     * "Computes" and returns the average value for the specified field over a single state
     * 
     * @param fieldName
     * @param subFieldName
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
    }
}
