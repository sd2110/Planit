# Planit Technical Assessment

# Overview
This repository contains the automation of test cases that were mentioned in the Planit technical assessment sheet.
The tests are performed on the url http://jupiter.cloud.planittesting.com and written with the testNG framework using selenium and JAVA.

# Pre-requisites
1. JAVA
2. Maven
3. Jenkins (optional)
4. Check the chrome and edge driver installed on your machine. The versions used in this repo are chrome (111.0.5563.65) and edge (111.0.1661.51).

# Guidelines
The following methods can be used to run the tests:
1. Cloning the repository
   1. Clone the repository on your local machine
   2. Open the project using an IDE of your choice
   3. The project dependencies will start downloading with maven
   4. Run testng.xml file to run the tests
   5. AutomationReport.html gets generated under the reports folder
2. Running in the pipeline
   1. Open Jenkins
   2. Create a new item > pipeline
   3. Under Definition, select "Pipeline script from SCM"
   4. Enter the github repository url "https://github.com/sd2110/Planit.git"
   5. Select branch specifier as "./main" and Script path as "Jenkinsfile"
   6. Click Save and Apply
   7. Click on Build Now and the tests will start running

# Support
Please contact at sagar2110@gmail.com for any query or support.
