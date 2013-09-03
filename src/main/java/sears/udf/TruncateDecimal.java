package sears.udf;

import org.apache.pig.EvalFunc;
import org.apache.pig.FuncSpec;
import org.apache.pig.data.DataType;
import org.apache.pig.data.Tuple;
import org.apache.pig.data.TupleFactory;
import org.apache.pig.impl.logicalLayer.FrontendException;
import org.apache.pig.impl.logicalLayer.schema.Schema;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class TruncateDecimal extends EvalFunc<Float>
{

    public Float exec(Tuple input) throws IOException {
        if (input == null)
        {
            return null;
        }

        Float source = (Float)input.get(0);
        Integer numberOfDecimals = (Integer)input.get(1);


        if(source==null)
        {
            return null;
        }
        String[] tokens = String.valueOf(source).split("\\.");

        return tokens.length == 1?
                Float.valueOf(tokens[0]):
                Float.valueOf(tokens[0]+"."+((tokens[1].length()<=numberOfDecimals)?
                                             tokens[1]:tokens[1].substring(0, numberOfDecimals)));
    }

    @Override
    public Schema outputSchema(Schema input) {
        return new Schema(new Schema.FieldSchema(null, DataType.FLOAT));
    }

    /* (non-oJavadoc)
     * @see org.apache.pig.EvalFunc#getArgToFuncMapping()
     */
    @Override
    public List<FuncSpec> getArgToFuncMapping() throws FrontendException {
        List<FuncSpec> funcList = new ArrayList<FuncSpec>();
        Schema s = new Schema();
        s.add(new Schema.FieldSchema(null, DataType.FLOAT));
        s.add(new Schema.FieldSchema(null, DataType.INTEGER));
        funcList.add(new FuncSpec(this.getClass().getName(), s));
        return funcList;
    }

}
