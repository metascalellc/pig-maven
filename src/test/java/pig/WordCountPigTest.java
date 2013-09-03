package pig;

import org.apache.pig.pigunit.PigTest;
import org.apache.pig.tools.parameters.ParseException;
import org.junit.Test;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: syermalk
 * Date: 10/24/12
 * Time: 9:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class WordCountPigTest {

    @Test
    public void testWordCount() throws IOException, ParseException {
        String[] args = {

        };

        PigTest test = new PigTest("./src/main/pig/wordcount.pig", args);

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
