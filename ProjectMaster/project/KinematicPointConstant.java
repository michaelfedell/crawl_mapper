import java.awt.Color;

/**
 * 
 * 
 * @author Michael Fedell
 * @version 11-24-17
 */
public class KinematicPointConstant extends KinematicPointAbstract
{
    /** The point in the model which does not change with state */
    private PointND point;
    
    /**
     * Creates a KinematicPointConstant object
     * This point is fixed in place and does not move with respect to state
     * This point may be considered the "root" of the kinematic tree
     * The lower back will be used as the root for this particular model
     * 
     * @param color Defines the color of this point
     * @param width Defines the width of drawing line
     * @param x The x-coordinate of this constant point
     * @param y The y-coordinate of this constant point
     * @param z The z-coordinate of this constant point
     */
    public KinematicPointConstant(Color color, float width, double x, double y, double z)
    {
        // Call super constructor to set color and width
        super(color, width);
        
        // Create a new PointND object that will define this Kinematic Point 
        this.point = new PointND();
        
        // Add values to that point for each dimension to be represented
        point.add("x", new GeneralValue(x));
        point.add("y", new GeneralValue(y));
        point.add("z", new GeneralValue(z));
    }
    
    /**
     * Accesses the current screen coordinate of a specified subfield
     * 
     * @param state The state which should be currently rendered
     * @param screenSubfield The subfield specifying dimension on-screen (e.g. "x" or "y")
     * @return A GeneralValue object defining the current screen coordinate of the specified subfield
     */
    public GeneralValue getScreenCoordinate(State state, String screenSubfield)
    {
        return point.getValue(screenSubfield);
    }
}
