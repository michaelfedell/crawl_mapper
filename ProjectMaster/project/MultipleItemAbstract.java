/**
 * Abstract class to provide structure to subclasses which will 
 * compute the defined statistical computations over multiple items
 * 
 * @author Michael Fedell modified by Zach Schuermann
 * @version 10/23/17
 */
public abstract class MultipleItemAbstract extends SingleItemAbstract
{
    /**
     * Will be implemented by objects that extend this abstract
     * 
     * @return size of MultipleItem List
     */
    abstract int getSize();
    
    /**
     * Will be implemented by objects that extend this abstract
     * 
     * @param index location of desired SingleItem within MultipleItem list
     * @return SingleItem object at desired index
     */
    abstract SingleItemAbstract getItem(int index);
    
    /**
     * This method will find the maximum value of the entire multiple item list for a specified fieldName and subField.
     * 
     * @param fieldName String to represent the fieldName to calculate Max
     * @param subFieldName String to represent the subFieldName to calc max from
     * @return State The maximum state in the set. (null if invalid)
     */
    public State getMaxState(String fieldName, String subFieldName)
    {
        // Initialize to the smallest possible number.
        double max = Double.NEGATIVE_INFINITY;
        double val = 0;
        State maxState = new State();
        
        // Loop through all trials and test for validity
        for (int i = 0; i < getSize(); i++)
        {
            if (getItem(i).getMaxState(fieldName, subFieldName).getValue(fieldName, subFieldName).isValid())
            {
                val = getItem(i).getMaxState(fieldName, subFieldName)
                        .getValue(fieldName, subFieldName).getDoubleValue();
                if (val > max)
                {
                    max = val;
                    maxState = getItem(i).getMaxState(fieldName, subFieldName);
                }
            }
        }
        
        // Return empty State if no maxState
        return maxState;
    }
    
    /**
     * This method will find the maximum value of the entire multiple item list for a specified fieldName and subField.
     * 
     * @param fieldName String to represent the fieldName to calculate min
     * @param subFieldName String to represent the subFieldName to calc min from
     * @return State The minimum state in the set. (null if invalid)
     */
    public State getMinState(String fieldName, String subFieldName)
    {
        // Initialize to the smallest possible number.
        double min = Double.POSITIVE_INFINITY;
        double val = 0;
        State minState = new State();
        
        // Loop through all trials and test for validity
        for (int i = 0; i < getSize(); i++)
        {
            if (getItem(i).getMinState(fieldName, subFieldName).getValue(fieldName, subFieldName).isValid())
            {
                val = getItem(i).getMinState(fieldName, subFieldName)
                        .getValue(fieldName, subFieldName).getDoubleValue();
                if (val < min)
                {
                    min = val;
                    minState = getItem(i).getMinState(fieldName, subFieldName);
                }
            }
        }
        
        // Return empty State if no minState
        return minState;
    }
    
    /**
     * This method will find the average value of the entire multiple item list for a specified fieldName and subField.
     * 
     * @param fieldName String to represent the fieldName to calculate average
     * @param subFieldName String to represent the subFieldName to calc average from
     * @return GeneralValue The average field/subfield in the set as a GeneralValue. (null if invalid)
     */
    public GeneralValue getAverageValue(String fieldName, String subFieldName)
    {
        // Initialize variables to zero
        double sum = 0;
        double val = 0;
        int validCount = 0;
        
        // Loop through all states and check for validity, use validCount to keep track of number of valid states.
        for (int i = 0; i < getSize(); i++)
        {
            if (getItem(i).getAverageValue(fieldName, subFieldName).isValid())
            {
                val = getItem(i).getAverageValue(fieldName, subFieldName).getDoubleValue();
                validCount++;
                sum += val;
            }
        }
        
        // test for invalid if there is no size or all entries are invalid
        if (validCount == 0)
        {
            return new GeneralValue("NaN");
        }
        else
        {
            // Calculate average by casting validCount as double and dividing.
            return new GeneralValue(sum / (double)validCount);
        }
    }
}
