package pig;

import org.apache.pig.pigunit.PigTest;
import org.apache.pig.tools.parameters.ParseException;
import org.junit.Test;

import java.io.IOException;

/**
 * User: MetaScale
 */
public class WordCountPigTest {

    @Test
    public void testWordCount() throws IOException, ParseException {
        PigTest test = new PigTest("./src/main/pig/wordcount.pig", new String[]{});
        String[] input = {
                "hello hello hello",
                "hello hello hello"
        };
        String[] output = {
                "(6,hello)"
        };
        test.assertOutput("A", input, "D", output);
    }
}
