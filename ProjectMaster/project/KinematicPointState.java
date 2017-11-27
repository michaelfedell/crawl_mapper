import java.awt.Color;

/**
 * Represents a point whose location is defined by a specific field of a State object
 * 
 * @author Michael Fedell
 * @version 11-26-17
 */
public class KinematicPointState extends KinematicPointAbstract
{
    /** The field modeled by this point (e.g. "left_wrist") */
    private String fieldName;
    
    /**
     * Creates a KinematicPointState object
     * This point is defined by a specific field of a State object
     * KinematicPointState objects will change over time and undergo motion as the infant moves
     * 
     * @param color Defines the color of this point
     * @param width Defines the width of drawing line
     * @param fieldName
     */
    public KinematicPointState(Color color, float width, String fieldName)
    {
        // Call super constructor to set color and width
        super(color, width);
        
        // Set fieldName to the field that is to be drawn for this point (e.g. "left_wrist")
        this.fieldName = fieldName;
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
        return state.getValue(fieldName, screenSubfield);
    }

}
