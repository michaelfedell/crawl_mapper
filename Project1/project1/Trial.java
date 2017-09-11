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
    
    /**
     * Getter for infantID
     * @return infantID
     */
    public String getInfantID()
    {
        return infantID;
    }
    
    /**
     * Getter for the size of the trial.
     * @return Number of trials.
     */
    public int getSize()
    {
        return stateList.size();
    }
    
    /**
     * Getter for a specific state in the trial.
     * @param index Number of  state to retrieve.
     * @return State at the given index.
     */
    public State getState(int index)
    {
        return stateList.get(index);
    }
    
    /**
     * Getter for the week of the trial.
     * @return Week of trial (int).
     */
    public int getWeek()
    {
        return week;
    }
    
    /**
     * Getter for the filename retrieved.
     * @return Filename of trial data.
     */
    public String getFileName()
    {
        return fileName;
    }
    
    /**
     * This method will find the maximum value of the entire trial for a specified dimension.
     * @param dimension int with dimension given as 0=X 1=Y 2=Z.
     * @return double of the maximum value of the trial for the dimension.
     */
    public double getMaxLeftWrist(int dimension)
    {
        // Initialize to the smallest possible number.
        double maxLeft = Double.NEGATIVE_INFINITY;
        double leftWrist = 0;
        
        // Loop through all trials and test for validity
        for (int i = 0; i < stateList.size(); i++)
        {
            if (stateList.get(i).getLeftWrist().getDimValue(dimension).isValid())
            {
                leftWrist = stateList.get(i).getLeftWrist().getDimValue(dimension).getDoubleValue();
            }
            if (leftWrist > maxLeft)
            {
                maxLeft = leftWrist;
            }
        }
        return maxLeft;
    }
    
    /**
     * This method will find the minimum value of the entire trial for a specified dimension.
     * @param dimension int with dimension given as 0=X 1=Y 2=Z.
     * @return double of the minimum value of the trial for the dimension.
     */
    public double getMinLeftWrist(int dimension)
    {
        // Initialize to the largest possible number.
        double minLeft = Double.POSITIVE_INFINITY;
        double leftWrist = 0;
        
        // Loop through all trials and test for validity
        for (int i = 0; i < stateList.size(); i++)
        {
            if (stateList.get(i).getLeftWrist().getDimValue(dimension).isValid())
            {
                leftWrist = stateList.get(i).getLeftWrist().getDimValue(dimension).getDoubleValue();
            }
            if (leftWrist < minLeft)
            {
                minLeft = leftWrist;
            }
        }
        return minLeft;
    }
    
    /**
     * This method will find the average value of the entire trial for a specified dimension.
     * @param dimension int with dimension given as 0=X 1=Y 2=Z.
     * @return double of the average value of the trial for the dimension.
     */
    public double getAverageLeftWrist(int dimension)
    {
        // Initialize variables to zero
        double sum = 0;
        double leftWrist = 0;
        int validCount = 0;
        
        // Loop through all states and check for validity, use validCount to keep track of number of valid states.
        for (int i = 0; i < stateList.size(); i++)
        {
            if (stateList.get(i).getLeftWrist().getDimValue(dimension).isValid())
            {
                leftWrist = stateList.get(i).getLeftWrist().getDimValue(dimension).getDoubleValue();
                validCount++;
                sum += leftWrist;
            }
        }
        
        // Calculate average by casting validCount as double and dividing.
        return sum/(double)validCount;
    }
}
