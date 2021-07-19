# cucumber-selenium
Automation Framework for Web Application tests using Cucumber and Selenium

## Project Description
This project is to implement Page Object Model pattern with Cucumber and Selenium Webdriver for a sample Google search scenario. Project was developed using:
1. Cucumber - 6.10.4 - latest version
2. Selenium - 3.141.59 - latest version
3. Lombok - annotations and clean code

## Design

### Page Object Model Pattern:
1. Page Object Model is a design pattern that creates Object Repository for web UI elements and it reduces code duplication and improves test maintenance.
2. Page Object classes can be found at _src/test/java/com/automation/demo/pages_ package

### Acceptance Tests:
1. Acceptance Test written as Cucumber feature file can be found at _src/test/resources/features/GoogleSearch.feature_
2. This test launches Google home page in Chrome browser, performs a search and retrieves first results detail to print in terminal

### Prerequisites to Run the project
1. Environment Requirements: Maven v3.5.4 or later, Java 1.8 or later, Eclipse or IntelliJ IDE

## Execution Instructions
1. After cloning the project, compile using the IDE Maven plugin or `mvn clean compile`
2. Review the code to understand the flow
3. _src/test/java_ - has the code for Cucumber tests implementation
5. _src/test/resources_ - has the feature file

### Command Line:

`mvn clean test` - This will run the scenarios in Cucumber feature files

### Run Configuration:

Alternative way to run the project is by use of:
TestRunner at _src/test/java/com/automation/demo/TestRunner.java_ or
Using IDE Run configuration, for IntelliJ:

1. Right click project and click Run as
2. Select Maven Build
3. Enter goals - clean test
4. Click Run

### Reports Location:
After execution, reports can be accessible via the link displayed in the maven logs (provided by Cucumber latest version).

When this project is integrated in a Jenkins pipeline, _cucumber.json_ file in _target/cucumber-reports_ can be integrated in the Build using Jenkins Cucumber plugin