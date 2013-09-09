package pig;

import org.apache.pig.pigunit.PigTest;
import org.apache.pig.tools.parameters.ParseException;
import org.junit.Test;
import utils.MockPigFeed;

import java.io.IOException;

/**
 * User: MetaScale
 */
public class WordCountMultipleInputsPigTest extends PigTestBase {

    @Test
    public void testWordCount() throws ParseException, IOException {
        PigTest test = super.createDefaultTest(new String[]{},"./src/main/pig/wordcount_multiple_inputs.pig");

        String[] input1 = {
                "hello hello hello",
                "hello hello hello"
        };

        String[] input2 = {
                "world world world",
                "world world world"
        };

        String[] output = {
                "(6,hello)",
                "(6,world)"
        };

        MockPigFeed mockPigFeed = mockPigFeed(test);
        mockPigFeed.mockInputAlias("A1", input1);
        mockPigFeed.mockInputAlias("A2", input2);
        test.assertOutput("D", output);
    }
}
