import org.junit.Assert;
import org.junit.Test;

/**
 * This class will test the implementation and functionality of the Point3D Class,
 * a class designed to organize three input values into a vector with x, y, and z-values
 * This class will cover testing for all public methods of the Point3D Class
 * 
 * @author Michael Fedell
 * @version 1.0
 */
public class TestPoint3D
{
    /**
     * Tests the full constructor for a Point3D object
     * This constructor should accept three GeneralValue objects as input and return a single Point3D object
     */
    @Test
    public void testFullConstructor()
    {
        GeneralValue genVal1 = new GeneralValue("-1.8");
        GeneralValue genVal2 = new GeneralValue("NaN");
        GeneralValue genVal3 = new GeneralValue("14.8397");
        Point3D point = new Point3D(genVal1, genVal2, genVal3);
        
        
    }
}