package sears.udf;
import org.apache.pig.pigunit.PigTest;
import org.apache.pig.tools.parameters.ParseException;
import org.junit.Test;

import java.io.IOException;

import static junit.framework.Assert.assertEquals;
/**
 * Created with IntelliJ IDEA.
 * User: syermalk
 * Date: 8/24/12
 * Time: 1:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class TruncateDecimalPigTest {

    @Test
    public void testTruncateDecimalInPigScript() throws IOException, ParseException {
        String[] args = {

        };

        PigTest test = new PigTest("./src/test/java/sears/udf/truncateDecimalTest.pig", args);

        String[] input = {
              "233",
              "88.1199"
        };

        String[] output = {
                "(233.0)",
                "(88.11)"
        };

        test.assertOutput("data", input, "data2", output);
    }
}
