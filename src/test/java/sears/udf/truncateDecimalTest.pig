Register ./dist/pig-udfs.jar

define TRUNCATE_DECIMAL sears.udf.TruncateDecimal();
--define LPAD com.shc.custom.pig.udf.LPAD();

data = LOAD 'input' as (price:float);

--data2 = FOREACH data GENERATE LPAD(price, '0', '8', 'TRIM');

data2 = FOREACH data GENERATE TRUNCATE_DECIMAL(price,2);


STORE data2 into 'output' USING PigStorage();


