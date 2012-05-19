# gabbleduck
## Build Project
Maven is used as build tool. In addition to maven JDK 1.5+ is required. To build the project run the following command in the root folder.

    mvn install

##Usage
The project can be run against the text file bundled with project or with any other text file.
### Bundled text file
Execute below to use bundled text file. Please note that java must be in path. 

    mvn exec:exec
 
### Any other text file
To run against another text file below can be used.

    java -jar gabbleduck-0.1-SNAPSHOT.jar <FILE_NAME> <LINES_TO_GENERATE>

Explanation of parameters (all manditory).
* FILE_NAME = Text file used to build markov chain
* LINES_TO_GENERATE = Number of lines to generate 
  
