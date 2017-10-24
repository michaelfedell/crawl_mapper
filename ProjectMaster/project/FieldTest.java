import org.junit.Assert;
import org.junit.Test;
/**
 * 
 * @author Zach Schuermann
 * @version 10/24/17
 * Class to test Field class for cases missed in other test classes
 */
public class FieldTest
{
    /**
     * Class to test the size of a Field
     */
    @Test
    public void sizeTest()
    {
        // Instantiate new field
        Field field = new Field();
        
        // add subfields to count
        field.addSubField("sub1", 0);
        field.addSubField("sub2", 1);
        field.addSubField("sub3", 2);
        
        // compare
        Assert.assertEquals(3, field.size());
    }
}
