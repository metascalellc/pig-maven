package utils;

/**
 * User: MetaScale
 */

import org.apache.hadoop.fs.Path;
import org.apache.pig.data.DataType;
import org.apache.pig.impl.logicalLayer.schema.Schema;
import org.apache.pig.pigunit.Cluster;
import org.apache.pig.pigunit.PigTest;
import org.apache.pig.pigunit.pig.PigServer;
import org.apache.pig.tools.parameters.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MockPigFeed {

        protected PigTest test;
        protected PigServer pigServer;
        protected Cluster cluster;
        protected List<String> overrideFiles;

        public MockPigFeed(PigTest test, PigServer pigServer, Cluster cluster) {
            this.test = test;
            this.pigServer = pigServer;
            this.cluster = cluster;
            this.overrideFiles = new ArrayList<String>();
        }

        public void mockInputAlias(String alias, String[] input) throws IOException, ParseException {
            test.runScript();
        	

            StringBuilder sb = new StringBuilder();
            Schema.stringifySchema(sb, pigServer.dumpSchema(alias), DataType.TUPLE);

            String destination = alias + "-pigunit-input-overridden.txt";
            overrideFiles.add(destination);

            cluster.copyFromLocalFile(input, destination, true);
            test.override(alias,
                    String.format("%s = LOAD '%s' AS %s;", alias, destination, sb.toString()));
        }

        public void cleanup() throws Exception {
            for (String overrideFile: overrideFiles) {
                cluster.delete(new Path(overrideFile));
            }
        }
    }


