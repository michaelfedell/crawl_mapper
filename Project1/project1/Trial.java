import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Representation of a single trial
 * 
 * @author Andrew H. Fagg
 * @version 2017-09-03
 *
 */
public class Trial
{
    /** Sequence of states.   */
    private ArrayList<State> stateList;
    /** ID for the infant  */
    private String infantID;
    /** Week index.  */
    private int week;
    /** File name that was loaded.  */
    private String fileName;
    
    /**
     * Trial constructor
     * 
     * @param directory String representing the directory containing the data files
     * @param infantID String representing the infant ID
     * @param week int week for the data file.
     * 
     * @throws IOException If there is an error finding or loading the data file.
     */
    public Trial(String directory, String infantID, int week) throws IOException
    {
        this.infantID = infantID;
        this.week = week;
        this.fileName = String.format("%s/subject_%s_w%02d.csv", 
                directory, infantID, week);
        
        
        this.stateList = new ArrayList<State>();
        
        // Open the file
        BufferedReader br = new BufferedReader(new FileReader(this.fileName));
        String strg;
        
        // Throw out header
        strg = br.readLine(); 
        
        // Read first line
        strg = br.readLine();
        
        while(strg != null)
        {
            stateList.add(new State(strg));
            strg = br.readLine();
        }

        br.close();
    }
    
    public String getInfantID()
    {
        return infantID;
    }
    
    public int getSize()
    {
        return stateList.size();
    }
    public State getState(int index)
    {
        return stateList.get(index);
    }
    
    public int getWeek()
    {
        return week;
    }
    
    public String getFileName()
    {
        return fileName;
    }
    
    /**
     * Dimension given as 0=X 1=Y 2=Z
     * @param dimension
     * @return
     */
    public double getMaxLeftWrist(int dimension)
    {
        //NYI
        return 0;
    }

    public double getMinLeftWrist(int dimension)
    {
        //NYI
        return 0;
    }
    
    public double getAverageLeftWrist(int dimension)
    {
        //NYI
        return 0;
    }
}
