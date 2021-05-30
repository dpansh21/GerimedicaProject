# GerimedicaProject
What is this repository for? Selenium Cucumber-Junit Test Framework

Behavior Driven Development Cucumber Junit Automation Framework including Cucumber Pretty reports with screenshot and integration with CI/CD pipeline from CircleCI on every commit

Setup Guidelines: User should have Java (JDK) and Maven installed. Clone the repository using "git clone https://github.com/dpansh21/GerimedicaProject.git"

Dependencies Cucumber Dependencies: io.cucumber cucumber-java 6.10.1 io.cucumber cucumber-jvm-deps 1.0.6 provided io.cucumbercucumber-junit6.10.1test

Junit Dependencies: junit junit 4.13.2 test
Selenium Dependencies: selenium-java 4.0.0-beta-3 selenium-chrome-driver 4.0.0-beta-3

How to run tests Maven: Run "mvn clean install" to get complete reporting ( Pretty Cucumber Reporting) Junit: Run As Junit Test After Selecting the runner class (TestRunIT.java) Cucumber: Run "mvn clean install -Dcucumber.options="–tags @SearchFullRegression"" to get complete reporting (Pretty Cucumber Reporting)

CI/CD Integration using CircleCI .cicleci: contains Config.yml file which exeucted full Search regression on each commit into master brach and upload test result into Artifacts
