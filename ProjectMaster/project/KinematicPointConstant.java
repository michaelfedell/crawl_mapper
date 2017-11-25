import java.awt.Color;

/**
 * 
 * 
 * @author Michael Fedell
 * @version 11-24-17
 */
public class KinematicPointConstant
{
    /** The point in the model which does not change with state */
    private PointND point;
    
    /**
     * Creates a KinematicPointConstant object
     * This point is fixed in place and does not move with respect to state
     * 
     * @param color Defines the color of this point
     * @param width Defines the width of drawing line
     * @param x The x-coordinate of this constant point
     * @param y The y-coordinate of this constant point
     * @param z The z-coordinate of this constant point
     */
    public KinematicPointConstant(Color color, float width, double x, double y, double z)
    {
        //TODO: Implement constructor
        this.point = new PointND();
        point.add("x", new GeneralValue(x));
        point.add("y", new GeneralValue(y));
        point.add("z", new GeneralValue(z));
    }
    
    /**
     * 
     * 
     * @param state
     * @param screenSubfield
     * @return
     */
    public GeneralValue getScreenCoordinate(State state, String screenSubfield)
    {
        //TODO: Implement method
        return point.getValue(screenSubfield);
    }
}
