import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Representation of a single trial
 * 
 * @author Andrew H. Fagg modified by Michael Fedell
 * @version 09/29/17
 *
 */
public class Trial extends MultipleItemAbstract
{
    /** Sequence of states.   */
    private ArrayList<State> stateList;
    /** ID for the infant  */
    private Infant infant;
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
    public Trial(Infant infant, String directory, String infantID, int week) throws IOException
    {
        this.infant = infant;
        this.week = week;
        this.fileName = String.format("%s/subject_%s_w%02d.csv", 
                directory, infantID, week);
        
        
        this.stateList = new ArrayList<State>();
        
        FieldMapper fieldMap; 
        
        // Open the file
        BufferedReader br = new BufferedReader(new FileReader(this.fileName));
        String strg;
        
        // Add header to make fieldMap
        strg = br.readLine(); 
        fieldMap = new FieldMapper(strg.split(","));
        
        // Read first line
        strg = br.readLine();
        
        while (strg != null)
        {
            stateList.add(new State(this, fieldMap, strg));
            strg = br.readLine();
        }

        br.close();
    }
    
    /**
     * Getter for infantID
     * 
     * @return infantID
     */
    public Infant getInfant()
    {
        return infant;
    }
    
    /**
     * Getter for the size of the trial.
     * 
     * @return Number of trials.
     */
    public int getSize()
    {
        return stateList.size();
    }
    
    /**
     * Getter for a specific state in the trial.
     * 
     * @param index Number of  state to retrieve.
     * @return State at the given index.
     */
    public State getItem(int index)
    {
        return stateList.get(index);
    }
    
    /**
     * Getter for the week of the trial.
     * 
     * @return Week of trial (int).
     */
    public int getWeek()
    {
        return week;
    }
    
    /**
     * Getter for the filename retrieved.
     * 
     * @return Filename of trial data.
     */
    public String getFileName()
    {
        return fileName;
    }
}
