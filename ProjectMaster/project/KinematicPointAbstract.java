import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 * 
 * 
 * @author Michael Fedell
 * @version 11-24-17
 */
public abstract class KinematicPointAbstract
{
    /** List of child points to define tree */
    private ArrayList<KinematicPointAbstract> children;
    
    /** Defines the color to be used for drawing line segments from point to child */
    private Color color;
    
    /** Defines the stroke to be used for drawing line segments from point to child */
    private BasicStroke stroke;
    
    /** Defines the relationship between meters (infant coordinates) and screen pixel size */
    private static double scale;
    
    /**
     * Default constructor for objects that extend this abstract class
     * Assigns color to this.color and width to this.
     * 
     * @param color
     * @param width
     */
    public KinematicPointAbstract(Color color, float width)
    {
        //TODO: Implement constructor
        
    }
    
    /**
     * This method adds a child to the current node in the kinematic tree
     * 
     * @param child
     */
    public void addChild(KinematicPointAbstract child)
    {
        // Add child to list of children
        this.children.add(child);
    }
    
    /**
     * This method draws the kinematic model of the infant with defined subfields mapped to x and y coordinates
     * 
     * @param g The Graphics2D object that will draw the components
     * @param state The state which should be currently rendered
     * @param screenXSubfield Denotes the subfield that will be mapped to the x-coordinate on screen
     * @param screenYSubfield Denotes the subfield that will be mapped to the y-coordinate on screen
     */
    public void draw(Graphics2D g, State state, String screenXSubfield, String screenYSubfield)
    {
        //TODO: Implement method
        
    }
    
    /**
     * Allows program to define the relationship between meters (infant coordinates) and screen pixel size
     * 
     * @param scale The ratio of real-life meters to on-screen pixels
     */
    public static void setScale(double scale)
    {
        // Set the scale for all KinematicPointAbstract Objects
        KinematicPointAbstract.scale = scale;
    }
    
    /**
     * Accesses the current screen coordinate of a specified subfield
     * 
     * @param state
     * @param screenSubfield
     * @return A GeneralValue object defining the current screen coordinate of the specified subfield
     */
    public abstract GeneralValue getScreenCoordinate(State state, String screenSubfield);
}
