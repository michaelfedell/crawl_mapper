/**
 * Abstract class to provide structure to subclasses which will 
 * compute the defined statistical computations over multiple items
 * 
 * @author Michael Fedell
 * @version 09/29/17
 */
public abstract class MultipleItemAbstract extends SingleItemAbstract
{
    abstract int getSize();
    abstract SingleItemAbstract getItem(int index);
    
    /**
     * This method will find the maximum value of the entire multiple item list for a specified dimension.
     * 
     * @param dim int with dimension given as 0=X 1=Y 2=Z.
     * @return GeneralValue representing maximum value for the given dimension over the multiple item list.
     */
    public GeneralValue getMaxLeftWrist(int dim)
    {
        // Initialize to the smallest possible number.
        double maxLeft = Double.NEGATIVE_INFINITY;
        double leftWrist = 0;
        
        // Loop through all trials and test for validity
        for (int i = 0; i < getSize(); i++)
        {
            if (getItem(i).getMaxLeftWrist(dim).isValid())
            {
                leftWrist = getItem(i).getMaxLeftWrist(dim).getDoubleValue();
            }
            if (leftWrist > maxLeft)
            {
                maxLeft = leftWrist;
            }
        }
        return new GeneralValue(maxLeft);
    }
    
    /**
     * This method will find the minimum value of the entire multiple item list for a specified dimension.
     * 
     * @param dim int with dimension given as 0=X 1=Y 2=Z.
     * @return GeneralValue representing minimum value for the given dimension over the multiple item list.
     */
    public GeneralValue getMinLeftWrist(int dim)
    {
     // Initialize to the smallest possible number.
        double minLeft = Double.POSITIVE_INFINITY;
        double leftWrist = 0;
        
        // Loop through all trials and test for validity
        for (int i = 0; i < getSize(); i++)
        {
            if (getItem(i).getMinLeftWrist(dim).isValid())
            {
                leftWrist = getItem(i).getMinLeftWrist(dim).getDoubleValue();
            }
            if (leftWrist < minLeft)
            {
                minLeft = leftWrist;
            }
        }
        return new GeneralValue(minLeft);
    }
    
    /**
     * This method will find the average value of the entire multiple item list for a specified dimension.
     * 
     * @param dim int with dimension given as 0=X 1=Y 2=Z.
     * @return GeneralValue representing average value for the given dimension over the multiple item list.
     */
    public GeneralValue getAverageLeftWrist(int dim)
    {
     // Initialize variables to zero
        double sum = 0;
        double leftWrist = 0;
        int validCount = 0;
        
        // Loop through all states and check for validity, use validCount to keep track of number of valid states.
        for (int i = 0; i < getSize(); i++)
        {
            if (getItem(i).getAverageLeftWrist(dim).isValid())
            {
                leftWrist = getItem(i).getAverageLeftWrist(dim).getDoubleValue();
                validCount++;
                sum += leftWrist;
            }
        }
        
        // Calculate average by casting validCount as double and dividing.
        return new GeneralValue(sum / (double)validCount);
        }
}
