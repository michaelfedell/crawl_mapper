import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 
 * @author Zach Schuermann 
 * @version 09/29/17
 *
 */
public class Infant extends MultipleItemAbstract
{
    private ArrayList<Trial> trialList;
    private String infantID;
    private static final int MAX_WEEK = 16;
    
    public Infant(String directory, String infantID) throws IOException
    {
        for (int week = 1; week <= MAX_WEEK; week++)
        {
            try
            {
                trialList.add(new Trial(directory, infantID, week));
            }
            catch (IOException e)
            {
                throw e;
            }
        }
    }
    
    public Trial getItem(int index)
    {
        return trialList.get(index);
    }
    
    public int getSize()
    {
        return trialList.size();
    }
    
    public String getInfantID()
    {
        return infantID;
    }
}
