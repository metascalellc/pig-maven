A = load 'input.txt' using PigStorage() as (a:chararray);
B = foreach A generate flatten(TOKENIZE((a))) as word:chararray;
C = group B by word;
D = foreach C generate COUNT(B), group;
store D into 'output/wordcount' using PigStorage();


