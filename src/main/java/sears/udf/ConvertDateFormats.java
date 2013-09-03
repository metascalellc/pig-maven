package sears.udf;

/**
 * Created with IntelliJ IDEA.
 * User: syermalk
 * Date: 10/24/12
 * Time: 5:43 PM
 * To change this template use File | Settings | File Templates.
 */

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.apache.pig.EvalFunc;
import org.apache.pig.data.Tuple;

import org.apache.pig.backend.executionengine.ExecException;
import org.apache.pig.data.DataType;
import org.apache.pig.impl.logicalLayer.FrontendException;
import org.apache.pig.impl.util.*;

public class ConvertDateFormats extends EvalFunc<String>{
    public String exec(Tuple input) throws IOException {
        //string containing date in one format
        String strDate;
        String input_format;
        int argsSize = input.size();

        if (input == null || argsSize == 0) {
            return null;
        }

        strDate = (String)input.get(0);
        if (argsSize == 1 || argsSize == 2 || strDate == null) {
            return strDate;
        }

        if(strDate.matches("^\\s*$")) {
            return strDate;
        }

        input_format = (String)input.get(1);
        try {
            String output_format = (String)input.get(2);
            SimpleDateFormat sdfSource = new SimpleDateFormat(input_format);
            Date date = sdfSource.parse(strDate);
            SimpleDateFormat sdfDestination = new SimpleDateFormat(output_format);
            strDate = sdfDestination.format(date);
            return strDate;
        } catch(ParseException pe) {
            System.out.println("Parse Exception : " + pe);
        }
        return strDate;
    }
}


