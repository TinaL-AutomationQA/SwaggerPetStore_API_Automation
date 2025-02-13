# SwaggerPetStore Rest Assured API Automation Automation Framework 

## Overview

This project is an automated testing framework for the **Swagger Pet Store API** using **RestAssured, TestNG, and Maven**. It supports **data-driven testing**, reporting, and reusable API endpoint structures.

## Project Structure
```bash
SwaggerPetStore_API_Automation/
│-- src/test/java
│   ├── api.endpoints        # API endpoint definitions
│   │   ├── Routes.java
│   │   ├── UserEndPoints.java
│   │   ├── UserEndPoints2_UsePropertiesFile.java
│   ├── api.payload          # POJO classes for request/response body
│   │   ├── User.java
│   ├── api.test             # Test classes for functional and regression testing
│   ├── api.utilities        # Utility classes for common functions
│   │   ├── DataProviders.java
│   │   ├── ExtentReportManager.java
│   │   ├── XLUtility.java
│-- src/test/resources       # Test data and configuration files
│   ├── config.properties
│   ├── log4j2.xml
│-- JRE System Library [JavaSE-1.8]
│-- Maven Dependencies
│-- logs                     # Log files
│-- reports                  # Test execution reports
│-- testData                 # Data files for Data-Driven Testing
│-- pom.xml                  # Maven dependencies
│-- testng.xml               # TestNG test suite configuration
│-- test-output              # TestNG-generated reports
```

## How to Use

- Clone the Repository
```bash  
git clone https://github.com/TinaL-AutomationQA/SwaggerPetStore_API_Automation.git
```
- Install Java JDK 1.8+.
- Install Maven (mvn -version to check)
- Install an IDE like IntelliJ IDEA or Eclipse
- Navigate to the project folder:
 ```bash 
cd SwaggerPetStore_API_Automation
```
- Run the desired TestNG.XML file.

## Technologies Used

- Programming Language: Java
- Automation Tool: RestAssured
- Test Management: TestNG
- Reporting: ExtentReports
- Data Handling: Apache POI (Excel)
- Build Tool: Maven
- Logging: Log4j


## Test Reports
The framework generates detailed HTML reports using ExtentReports. Reports include:

Test execution status (Pass/Fail/Skip).
Failure details with screenshots.
Logs for debugging.
Sample report:
[![Report Screenshot](https://github.com/TinaL-AutomationQA/OpencartAutomation/blob/master/report%20screenshot/Report_with_screenshot1.png)
[![Report Screenshot](https://github.com/TinaL-AutomationQA/OpencartAutomation/blob/master/report%20screenshot/Report_with_screenshot2.png)
[![Report Screenshot](https://github.com/TinaL-AutomationQA/OpencartAutomation/blob/master/report%20screenshot/Report_with_screenshot3.png)

## API Endpoints Used
- POST  /user Create a new user
- GET  /user/{username} Retrieve user info
- PUT  /user/{username} Update user info
- DELETE /user/{username} Delete user


- Integrate with CI/CD tools like Jenkins.
## Future Enhancements

- Integrate with CI/CD tools like Jenkins.


## Contact

If you have any questions or suggestions about this framework, feel free to reach out!
Email: [liut44194@gmail.com]
GitHub Profile: https://github.com/TinaL-AutomationQA
