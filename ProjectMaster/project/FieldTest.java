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
    public void emptyFieldTest()
    {
        // Instantiate new field
        Field field = new Field();
        
        // compare
        Assert.assertEquals("", field.toString());
    }
    
    /**
     * Class to test the size of a Field
     */
    @Test
    public void multiFieldTest()
    {
        // Instantiate new field
        Field field = new Field();
        
        // add subfields to count
        field.addSubField("sub1", 0);
        field.addSubField("sub2", 1);
        field.addSubField("sub3", 2);
        
        // compare
        Assert.assertEquals("sub1(0); sub2(1); sub3(2); ", field.toString());
    }
    
    /**
     * Class to test null Field
     */
    @Test
    public void nullFieldTest()
    {
        // Instantiate new field
        Field field = new Field();
        
        // compare
        Assert.assertNull(field.getIndex("Bogus"));
    }
    
    
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
