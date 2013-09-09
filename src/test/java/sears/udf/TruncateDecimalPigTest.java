package sears.udf;
import org.apache.pig.pigunit.PigTest;
import org.apache.pig.tools.parameters.ParseException;
import org.junit.Test;
import pig.*;

import java.io.IOException;

import static junit.framework.Assert.assertEquals;
/**
 * User: MetaScale
*/
public class TruncateDecimalPigTest extends PigTestBase {

    @Test
    public void testTruncateDecimalInPigScript() throws IOException, ParseException {

        PigTest test = new PigTest("./src/test/java/sears/udf/truncateDecimalTest.pig", new String[]{});

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
