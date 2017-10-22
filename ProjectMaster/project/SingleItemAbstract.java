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
     * Computes statistical maximum of left wrist over a single item.
     *  
     * @param dim 0=X, 1=Y, 2=Z 
     * @return maximum GeneralValue of leftWrist
     */
    abstract GeneralValue getMaxState(int dim);
    
    /**
     * Computes statistical minimum of left wrist over a single item.
     *  
     * @param dim 0=X, 1=Y, 2=Z 
     * @return minimum GeneralValue of leftWrist
     */
    abstract GeneralValue getMinState(int dim);
    
    /**
     * Computes statistical average of left wrist over a single item.
     *  
     * @param dim 0=X, 1=Y, 2=Z 
     * @return average GeneralValue of leftWrist
     */
    abstract GeneralValue getAverageValue(int dim);
}
