
# Test Automation Framework

This is a Java-based test automation framework.

The framework leverages various libraries and tool to facilitate data-driven testing, logging, reporting and integration with cloud-based testing platform like lambdatest.
## 🚀 About Me
Hi, My Name is Gaurao Kharate and I have 3 years of experience in Automation Testing. I have also led efforts to enhance our test automation framework using Selenium WebDriver and TestNG. My hands-on experience with tools such as Jenkins, Jira, and Cucumber has equipped me to handle complex testing workflows and collaborate across cross-functional teams.





## Author

- [@code-by-gaurao](https://github.com/code-by-gaurao)

-EmailAddress: gauraokharate1997@gmail.com
## 🔗 Links
[![portfolio](https://img.shields.io/badge/my_portfolio-000?style=for-the-badge&logo=ko-fi&logoColor=white)](https://github.com/code-by-gaurao)

[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/gaurao-kharate-606b9530a/)



## Prerequisites

Before using this framework, make sure you have the following installed:

- **Java 11** - Make sure Java is installed and the JAVA_HOME  environment variable is set.
- **Maven** - Ensure Maven is installed and added to the system path.
- Download Link: https://maven.apache.org/download.cgi


## Features

- **Data-Driven Testing**: The framework supports data-driven testing, allowing you to execute tests with multiple sets of input data from CSV, Excel, or JSON files.

- **Cross-Browser Testing**: The framework enables cross-browser testing across multiple browsers like Chrome, Firefox, and Edge, ensuring compatibility across different environments.

- **Headless Mode**: The framework supports headless execution, allowing tests to run without a UI for faster and more efficient execution, especially in CI/CD environments.

- **Cloud Testing**: The framework integrates with LambdaTest, allowing tests to be run on the cloud for cross-browser and cross-platform testing without requiring local infrastructure.

- **Logging**: The framework uses Log4J to capture detailed logs during test execution, providing valuable insights for debugging and analysis.

- **Reporting**: ExtentReports is used to generate detailed, customizable HTML reports that summarize test execution results, including pass/fail status, execution time, and logs.

## Technologies Used

- Java 11 
- TestNG 
- Maven 
- OpenCSV
- Gson 
- Apache POI 
- Faker 
- LambdaTest
- Log4J 
- ExtentReports 




## Setup Instructions

**Clone the Repository:**

```bash
  git clone https://github.com/code-by-gaurao/Test-Automation-Framework.git
  cd Test-Automation-Framework
```

**Running tests on LambdaTest:**

```bash
 mvn test -Dbrowser=chrome -DisLambdaTest=true -DisHeadless=false -X
```


**Running tests on chrome browser on Local Macine in Headless Mode:**

```bash
 mvn test -Dbrowser=chrome -DisLambdaTest=true -DisHeadless=true -X
```

## Reports & Logs

- **Reports:** After execution, a detailed HTML report will be generated at /report.html.
                        The report contains information on test cases executed, passed, failed, and skipped, along with screenshots for failed tests.

- **Logs:** Logs are created during the test execution and stored in the logs/ directory.

## Integrated the project Github Actions

This automation framework is integrated with github actions. The tests will be executed at 11:30PM IST every single day.

The reports will be archieved in gh-pages branch

You can view the html reports at : https://github.com/code-by-gaurao/Test-Automation-Framework/tree/gh-pages
