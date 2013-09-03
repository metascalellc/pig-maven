package sears.udf;

/**
 * Created with IntelliJ IDEA.
 * User: syermalk
 * Date: 10/24/12
 * Time: 5:42 PM
 * To change this template use File | Settings | File Templates.
 */


import org.apache.pig.data.DefaultTuple;
import org.junit.Test;

import java.io.IOException;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: syermalk
 * Date: 6/7/12
 * Time: 11:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class ConvertDateFormatsTest {

    @Test
    public void testMMDDYYYYtoYYYYDDMM() throws IOException {
        DefaultTuple input = new DefaultTuple();
        input.append("03-23-2007");
        input.append("MM-dd-yyyy");
        input.append("yyyy-dd-MM");
        assertEquals("2007-23-03",new ConvertDateFormats().exec(input));
    }



}