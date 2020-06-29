# Prova Finale di Ingegneria del Software - a.a. 2019-2020
Project's aim is to develop an online distributed version of the table game Santorini from Cranio Creations, the software is developed using the Distributed MVC pattern with java programming language. The final result we obtained is the result "Complete Rules + CLI + GUI + Socket + 2 AF".

### Software requirements
The first thing to do to install Santorini software is to install java 14 version, it is downloadable from oracle website (https://www.oracle.com/java/technologies/javase-jdk14-downloads.html), no other software is needed to run the application.
The project uses maven to deploy, build and test with JUnit, this is the reason why these two components for java must be installed in your computer before deploying or testing the application.

### Documentation
Documentation for this software comes with this file readme and two different UML file that can be found in the following unordered list, one of this UML files is a general representation about the structure of the program and the other is the definitive UML containing every elements of the application (apart some utility objects used by a lot of class of the software, them are not present because it would generate disorder with a huge number of arrows).
- [General UML](https://github.com/marcoPetriPolimi/ing-sw-2020-petri-piccirillo-restifo/blob/master/deliveries/UML/UML_Generic.pdf)
- [Detailed UML](https://github.com/marcoPetriPolimi/ing-sw-2020-petri-piccirillo-restifo/blob/master/deliveries/UML/UML_Final.pdf)
#### Compiling the application using maven
This software is developed with Maven, which has to be used to deploy the application too. To compile the application run this command:
```
mvn clean package
```
The "clean" command deletes any precedent build, while the "package" command actually creates the new .jar packages.<br/>
**Note that** to correctly deploy jars you need to deploy the application using the right operating system, this means that if you deploy the application using windows you can't use the generated jars on Linux. To deploy jars for Linux and MacOs you need to deploy jars from these operating systems.

### Running the application
#### Launching the server
Server is deployed with java archive, server hasn't a graphical user interface and for this reason it can only be started using the command line of your operating system, once you've deployed the application as showed in previous steps of the documentation you can find the server jar file on target folder. Using java you only need the instruction to launch the server and no options are needed, so write the following command:
```
java -jar server.jar
```

#### Launching the CLI
CLI version of the game is identical to the server for the start, it can only be started directly from the command line of your operating system, to run client CLI you must write the following command:
```
java -jar client_cli.jar
```

#### Launching the GUI
GUI version of the game is slightly different from the other ones, it can be started both from the command line of your operating system and can be started also from your operating system graphical interface. If you want to start the GUI client using the command line you can use the same command you used for the previous versions of the readme (server and cli client) with the following command:
```
java -jar client_gui.jar
```
By the way you can also start gui like every other program with a graphical user interface on your computer, you can go to the java archive folder for the GUI client and double click its icon and wait till it starts.

### Functionalities
We developed every asked functionalities to arrive to the last row of the evaluation grid, we developed as previously said "Complete Rules + CLI + GUI + Socket + 2 AF", precisely we developed "Multiple Matches" and "Undo" advanced functionalities, so this is the result obtained:
* Complete rules
* CLI Client
* GUI Client
* Socket
* 2 Advanced functionalities

### Tests
Here there are the results obtained from the tests that habe been done on our project using JUnit. An important note should be done about the gods tests, all significant methods are tested with a 98/100% of coverage, the problem is that god's classes are short and getters haven't been tested, this is the reason why tests are under 90% of coverage.

![alt text](https://github.com/marcoPetriPolimi/ing-sw-2020-petri-piccirillo-restifo/blob/master/deliveries/Tests/tests_1.PNG)
![alt text](https://github.com/marcoPetriPolimi/ing-sw-2020-petri-piccirillo-restifo/blob/master/deliveries/Tests/tests_2.PNG)
![alt text](https://github.com/marcoPetriPolimi/ing-sw-2020-petri-piccirillo-restifo/blob/master/deliveries/Tests/tests_3.PNG)

