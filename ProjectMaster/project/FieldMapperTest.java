import org.junit.Assert;
import org.junit.Test;
/**
 * 
 * @author Zach Schuermann
 * @version 10/24/17
 * Class to test FieldMapper class for cases missed in other test classes
 */
public class FieldMapperTest
{
    /**
     * String literal of the first row of CSV
     */
    private String firstRow = "time,left_wrist_x,left_wrist_y,left_wrist_z,right_wrist_x,"
                + "right_wrist_y,right_wrist_z,left_elbow_x,left_elbow_y,left_elbow_z,"
                + "right_elbow_x,right_elbow_y,right_elbow_z,left_shoulder_x,left_shoulder_y,"
                + "left_shoulder_z,right_shoulder_x,right_shoulder_y,right_shoulder_z,left_knee_x,"
                + "left_knee_y,left_knee_z,right_knee_x,right_knee_y,right_knee_z,left_ankle_x,"
                + "left_ankle_y,left_ankle_z,right_ankle_x,right_ankle_y,right_ankle_z,left_foot_x,"
                + "left_foot_y,left_foot_z,right_foot_x,right_foot_y,right_foot_z,upper_back_x,upper_back_y,"
                + "upper_back_z,sippc_action,robot_vel_l,robot_vel_r";
    
    private String secondRow = "0,0.164617,0.293503,-0.092803,0.314738,-0.113438,-0.154972,0.140147,0.230248,"
            + "-0.016396,0.259088,-0.16724,-0.088291,0.211352,0.115696,-0.025542,0.243218,-0.081355,0.014899,"
            + "-0.120688,0.040215,-0.025421,-0.113292,-0.10138,-0.045445,-0.249756,-0.004755,0.021516,-0.244225,"
            + "-0.148719,-0.084166,-0.260507,-0.045713,-0.071859,-0.246074,-0.161261,-0.185907,0.227285,0.01717,"
            + "-0.005322,0,-0.010565,-0.026693";
    
    /**
     * Class to test the size of a fieldMapper
     */
    @Test
    public void sizeTest()
    {
        // instantiate fieldmapper using firstRow above and test size
        FieldMapper fm = new FieldMapper(firstRow.split(","));
        Assert.assertEquals("Size test for fieldMapper", 16, fm.size());
    }
    
    /**
     * Class to test contructing a pointND from null
     */
    @Test 
    public void nullPointTest()
    {
        // instantiate fieldmapper using firstRow above and test size
        FieldMapper fm = new FieldMapper(firstRow.split(","));
        PointND testPoint = fm.extractPointND(secondRow.split(","), "bogus");
        Assert.assertNull(testPoint);
    }
    
    
    /**
     * Class to test the field getter
     */
    @Test
    public void getFieldTest()
    {
        // instantiate fieldmapper using firstRow above and test index of a certain field
        FieldMapper fm = new FieldMapper(firstRow.split(","));
        Assert.assertEquals("Getter for field in fieldMapper", 4, (int)fm.getField("right_wrist").getIndex("x"));
    }
}
