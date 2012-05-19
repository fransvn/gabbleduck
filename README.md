gabbleduck
==========BUILD PROJECT

To build the project you require maven installed and java JDK 1.5 or newer.


Execute below statement in same folder as pom.xml

  mvn install



RUN PROJECT

To run project you can use text file provided or supply your own.


1) Execute below to use file provided. (To use this method java must be in 

  mvn exec:exec

  
2) To run against your own file you can execute the below.

  java -jar gabbleduck-0.1-SNAPSHOT.jar <FILE_NAME> <LINES_TO_GENERATE>

Explanation of parameters (all manditory).

1) <FILE_NAME> = text file used to build markov chain
2) <LINES_TO_GENERATE> = number of lines to generate 
  
