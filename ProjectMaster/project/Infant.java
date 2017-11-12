import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * An Infant object to store all of the trials associated with a particular infant.
 * 
 * @author Zach Schuermann 
 * @version 10/23/17
 *
 */
public class Infant extends MultipleItemAbstract implements Iterable<Trial>
{
    /** Stores the list of trials that pertain to a particular infant */
    private ArrayList<Trial> trialList;
    /** Stores the ID identifying a particular infant */
    private String infantID;
    /** Limits the maximum number of weeks that an infant object may hold */
    private static final int MAX_WEEK = 16;
    
    /**
     * Default constructor sets up an Infant object storing trials for a particular infants
     * 
     * @param directory indicates the location of set of data for infant
     * @param infantID identifies the desired infant by ID number
     * @throws IOException if file breaks
     */
    public Infant(String directory, String infantID) throws IOException
    {
        // instantiate trialList
        trialList = new ArrayList<Trial>();
        
        // assign infantID
        this.infantID = infantID;
        
        // loop over all possible weeks for trials and try to add it to trialList
        for (int week = 1; week <= MAX_WEEK; week++)
        {
            try
            {
                trialList.add(new Trial(this, directory, infantID, week));
            }
            // No more trials to add, or other file reading error
            catch (FileNotFoundException e)
            {
                continue;
            }
        }
    }
    
    /**
     * Secondary constructor creating an infant from a reference infant but with a specified list of trials
     * 
     * @param infant
     * @param indices
     */
    public Infant(Infant infant, int[] indices)
    {
        // use same infantID
        this.infantID = infant.getInfantID();
        
        // instantiate trialList
        trialList = new ArrayList<Trial>();
        
        //  trialList
        for (int index : indices)
        {
            //try catch for invalid indices
            try 
            {
                trialList.add(infant.trialList.get(index));
            }
            catch (IndexOutOfBoundsException e) 
            {
                continue;
            }
        }
    }
    
    /**
     * Allows user to access a particular trial for this infant
     * 
     * @param index The zero-indexed trial desired from ArrayList
     * @return The trial of specified index
     */
    public Trial getItem(int index)
    {
        return trialList.get(index);
    }
    
    /**
     * Size of trialList determined by number of trials added to ArrayList
     * 
     * @return The size of trialList, indicating the number of trials stored
     */
    public int getSize()
    {
        return trialList.size();
    }
    
    /**
     * Allows user to access the ID of this infant
     * 
     * @return ID of infant
     */
    public String getInfantID()
    {
        return infantID;
    }
    
    /**
     * Iterator over the trials in the infant
     *
     */
    @Override
    public Iterator<Trial> iterator()
    {
        return trialList.iterator();
    }
}
