/**
 * Abstract class to provide structure to subclasses which will 
 * compute the defined statistical computations over multiple items
 * 
 * @author Michael Fedell
 * @version 09/29/17
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
     * This method will find the maximum value of the entire multiple item list for a specified dimension.
     * 
     * @param dim int with dimension given as 0=X 1=Y 2=Z.
     * @return State The maximum state in the set.
     */
    public State getMaxState(String fieldName, String subFieldName)
    {
        // Initialize to the smallest possible number.
        double max = Double.NEGATIVE_INFINITY;
        double val = 0;
        int maxindex = 0;
        
        // Loop through all trials and test for validity
        for (int i = 0; i < getSize(); i++)
        {
            if (getItem(i).getMaxState(fieldName, subFieldName).getValue(fieldName, subFieldName).isValid())
            {
                val = getItem(i).getMaxState(fieldName, subFieldName).getValue(fieldName, subFieldName).getDoubleValue();
                if (val > max)
                {
                    max = val;
                    maxindex = i;
                }
            }
        }
        
        return (State)getItem(maxindex);
        
        // TODO
        // test for invalid if there is no size or all entries are invalid
//        if (max == Double.NEGATIVE_INFINITY)
//        {
//            //return new State("NaN");
//        }
//        else
//        {
//            //return new State(max);
//        }
    }
    
    /**
     * This method will find the minimum value of the entire multiple item list for a specified dimension.
     * 
     * @param dim int with dimension given as 0=X 1=Y 2=Z.
     * @return GeneralValue representing minimum value for the given dimension over the multiple item list.
     */
    public GeneralValue getMinState(int dim)
    {
        // Initialize to the smallest possible number.
        double minLeft = Double.POSITIVE_INFINITY;
        double leftWrist = 0;
        
        // Loop through all trials and test for validity
        for (int i = 0; i < getSize(); i++)
        {
            if (getItem(i).getMinState(dim).isValid())
            {
                leftWrist = getItem(i).getMinState(dim).getDoubleValue();
                if (leftWrist < minLeft)
                {
                    minLeft = leftWrist;
                }
            }
        }
        
        // test for invalid if there is no size or all entries are invalid
        if (minLeft == Double.POSITIVE_INFINITY)
        {
            return new GeneralValue("NaN");
        }
        else
        {
            return new GeneralValue(minLeft);
        }
    }
    
    /**
     * This method will find the average value of the entire multiple item list for a specified dimension.
     * 
     * @param dim int with dimension given as 0=X 1=Y 2=Z.
     * @return GeneralValue representing average value for the given dimension over the multiple item list.
     */
    public GeneralValue getAverageValue(int dim)
    {
        // Initialize variables to zero
        double sum = 0;
        double leftWrist = 0;
        int validCount = 0;
        
        // Loop through all states and check for validity, use validCount to keep track of number of valid states.
        for (int i = 0; i < getSize(); i++)
        {
            if (getItem(i).getAverageValue(dim).isValid())
            {
                leftWrist = getItem(i).getAverageValue(dim).getDoubleValue();
                validCount++;
                sum += leftWrist;
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
