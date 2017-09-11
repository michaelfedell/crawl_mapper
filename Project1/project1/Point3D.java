/**
 * 
 * @author Zach Schuermann
 * @version 09/07/17
 */
public class Point3D
{
    private GeneralValue[] point3d = new GeneralValue[3];
    
    /**
     * Constructs Point3D object specifically from X,Y,Z
     * @param x
     * @param y
     * @param z
     */
    public Point3D(GeneralValue x, GeneralValue y, GeneralValue z)
    {
        point3d[0] = x;
        point3d[1] = y;
        point3d[2] = z;
    }
    
    /**
     * Index 0=X, 1=Y, 2=Z
     * @param index
     * @return
     */
    public GeneralValue getDimValue(int index)
    {
        return point3d[index];
    }
    
    public GeneralValue[] getValues()
    {
        return point3d;
    }
    
    public String toString()
    {
        return point3d[0].toString() + "," + point3d[1].toString() + "," + point3d[2].toString();
    }
}
