/**
 * Class to represent the position of sensor as an array of three points (General Values)
 * 
 * @author Zach Schuermann
 * @version 09/07/17
 */
public class Point3D
{
    /** Array of general values to describe point location */
    private GeneralValue[] point3d = new GeneralValue[3];
    
    /**
     * Constructs Point3D object specifically from X,Y,Z
     * @param x GeneralValue of x-dimension
     * @param y GeneralValue of y-dimension
     * @param z GeneralValue of z-dimension
     */
    public Point3D(GeneralValue x, GeneralValue y, GeneralValue z)
    {
        point3d[0] = x;
        point3d[1] = y;
        point3d[2] = z;
    }
    
    /**
     * Returns GeneralValue of a single dimension given by index. 
     * @param index 0=X, 1=Y, 2=Z
     * @return point3D's dimension at x, y, or z
     */
    public GeneralValue getDimValue(int index)
    {
        return point3d[index];
    }

    /**
     * Getter which returns the GeneralValue array which stores the Point3D
     * @return GeneralValue array in form of [x,y,z]
     */
    public GeneralValue[] getValues()
    {
        return point3d;
    }
    
    /**
     * Converts point3D to comma separated string in the format x,y,z
     */
    public String toString()
    {
        return point3d[0].toString() + "," + point3d[1].toString() + "," + point3d[2].toString();
    }
}
