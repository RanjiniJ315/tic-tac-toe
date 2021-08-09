# tic-tac-toe unit testing

**Quick start:**

This project has been automated in Junit Framework

**Requirements:**

1. Java 8/11/14
2. Latest maven version.

**Steps to run the tests:**

1. Download the project 
2. Open the Command prompt/Terminal and navigate to project root folder
3. Enter 'mvn verify' to run the unit tests and verify the result in console

To get unit tests report, enter "clean install test surefire-report:report".
The unit tests will execute and will display the test report path at the end of the execution.
Report location: `_Project-root-folder/target/site/surefire-report.html_`

**Verification:** 

All the testable methods have been tested with positive data, negative data and boundary conditions.
The whole game has been tested with mock random data.

**Code Refactor:**

I have refactored code to handle invalid string, special char, numeric inputs which were making program
to throw value error and terminating the program.

**Pre-requisite setup:**

_Installing Java 8_

Go to http://www.oracle.com/technetwork/java/javase/downloads/index.html.
Click on Download link for the JDK for Java 8.
Click on accept license for the development kit.
Click on the download link for the OS you are running.
Click on save file.
When the file finishes downloading, run the file and follow the
on-screen instructions to install Java.

_Installing Maven_

Mac OS:

Install Homebrew
Open Terminal
Type in: ruby -e "$(curl -fsSL
https://raw.githubusercontent.com/Homebrew/install/master/install)"
You will need to enter in your password when prompted
Type in: brew install maven
To verify the installation was successful, type in: mvn -version

Windows OS:

Download the "Binary zip archive" file from
https://maven.apache.org/download.cgi
Follow the instructions located at https://maven.apache.org/install.html