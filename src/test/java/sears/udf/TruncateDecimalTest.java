package sears.udf;

import org.apache.pig.data.Tuple;
import org.apache.pig.data.TupleFactory;
import org.junit.Test;

import java.io.IOException;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: syermalk
 * Date: 8/23/12
 * Time: 1:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class TruncateDecimalTest {

    @Test
    public void testTruncate1() throws IOException {
        Tuple tuple = TupleFactory.getInstance().newTuple();
        tuple.append(2.333333f);
        tuple.append(2);
        assertEquals(2.33f, new TruncateDecimal().exec(tuple));
    }

    @Test
    public void testTruncate2() throws IOException {
        Tuple tuple = TupleFactory.getInstance().newTuple();
        tuple.append(2.99000001f);
        tuple.append(3);
        assertEquals(2.990f, new TruncateDecimal().exec(tuple));
    }

    @Test
    public void testTruncate3() throws IOException {
        Tuple tuple = TupleFactory.getInstance().newTuple();
        tuple.append(11.6935f);
        tuple.append(2);
        assertEquals(11.69f, new TruncateDecimal().exec(tuple));
    }

    @Test
    public void testTruncate5() throws IOException {
        Tuple tuple = TupleFactory.getInstance().newTuple();
        tuple.append(11.6995f);
        tuple.append(2);
        assertEquals(11.69f, new TruncateDecimal().exec(tuple));
    }


    @Test
    public void testTruncateNoDecimal() throws IOException {
        Tuple tuple = TupleFactory.getInstance().newTuple();
        tuple.append(5f);
        tuple.append(2);
        assertEquals(5f, new TruncateDecimal().exec(tuple));
    }
    @Test
    public void testTruncate4() throws IOException {
        Tuple tuple = TupleFactory.getInstance().newTuple();
        tuple.append(0.3990001f);
        tuple.append(2);
        assertEquals(0.39f, new TruncateDecimal().exec(tuple));
    }
}
