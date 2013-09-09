A1 = load 'input1' using PigStorage() as (a:chararray);
A2 = load 'input2' using PigStorage() as (a:chararray);
A = union A1,A2;
B = foreach A generate flatten(TOKENIZE((a))) as word:chararray;
C = group B by word;
D = foreach C generate COUNT(B), group;
store D into 'output/wordcount' using PigStorage();


