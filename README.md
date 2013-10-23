pig-maven
=========

This example is related to the following blog about PigUnit: http://www.metascale.com/resources/blogs/196-better-faster-and-simpler-pig-development-using-pigunit

A sample maven-enabled pig project complete with example of unit tests on UDF using junit and pig scripts using pigunit. 

Use standard maven commands to build and test.

If this is the first time: Perform an install (skipping the tests) before you run tests like this -

mvn install -DskipTests

A dist directory will be created with required udf jar. 

Run the following command to run tests:

mvn test

Run the following command to run tests while telling surefire to generate a nice report:

mvn surefire:surefire-report

Then open the target/site/surefire-report.html to look at the results.

There are 3 kinds of unit tests exemplified in this project:

1. Pig script test using pigunit (src/test/java/pig/WordCountPigTest.java)
2. A test of UDF via a test pig script using pigunit. (src/test/java/sears/udf/TruncateDecimalPigTest.java)
3. Plain java junit test for a UDFn (src/test/java/sears/udf/TruncateDecimalTest.java)

 

  	
