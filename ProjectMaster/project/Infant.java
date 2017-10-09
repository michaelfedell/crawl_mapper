import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * An Infant object to store all of the trials associated with a particular infant.
 * 
 * @author Zach Schuermann 
 * @version 09/29/17
 *
 */
public class Infant extends MultipleItemAbstract
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
        for (int week = 1; week <= MAX_WEEK; week++)
        {
            try
            {
                trialList.add(new Trial(directory, infantID, week));
            }
            // No more trials to add, or other file reading error
            catch (IOException e)
            {
                throw e;
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
}
