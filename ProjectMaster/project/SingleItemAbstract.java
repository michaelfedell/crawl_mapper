/**
 * Abstract class to provide structure to subclasses which will 
 * compute the defined statistical computations over a single item
 * 
 * @author Michael Fedell
 * @version 09/29/17
 */
public abstract class SingleItemAbstract
{
    /**
     * Computes statistical maximum of a given field/subfield
     *  
     * @param fieldName String to represent the field
     * @param subFieldName String for the given subField
     * @return maximum State
     */
    abstract State getMaxState(String fieldName, String subFieldName);
    
    /**
     * Computes statistical minimum of a given field/subfield
     *  
     * @param fieldName String to represent the field
     * @param subFieldName String for the given subField
     * @return minimum State
     */
    abstract State getMinState(String fieldName, String subFieldName);
    
    /**
     * Computes statistical average of a given field/subfield
     *  
     * @param fieldName String to represent the field
     * @param subFieldName String for the given subField
     * @return average Generalvalue
     */
    abstract GeneralValue getAverageValue(String fieldName, String subFieldName);
}
