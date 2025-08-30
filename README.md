#  🚀 AutomationExercise Test Automation Project

This repository contains an automated testing framework for the [AutomationExercise website](https://www.automationexercise.com/). The project is designed to validate various functionalities of the e-commerce platform, including user registration, login, logout, product interactions, and contact form submissions. It leverages industry-standard tools and practices to ensure robust and reliable test execution.

##  🌐	Website home page
![homepage](https://user-images.githubusercontent.com/124753072/235929032-4471bd18-9133-46ae-84da-931f0d94bb35.jpg)

## 📝	Table of Contents
- [Technologies Used](#technologies-used)
- [Project Structure](#project-structure)
- [Test Cases Analysis](#test-cases-analysis)
    - [User Authentication Test Cases](#user-authentication-test-cases)
    - [Contact Us Test Case](#contact-us-test-case)
    - [Product and Cart Test Cases](#product-and-cart-test-cases)
- [How to Run Tests](#how-to-run-tests)
- [Reporting](#reporting)

## 💻	 Technologies Used

This project is built using the following key technologies and libraries:

*   **Java**: The primary programming language for developing test scripts.
*   **Selenium WebDriver**: For browser automation and interaction with web elements.
*   **TestNG**: A powerful testing framework for Java, used for test organization, execution, and reporting.
*   **Maven**: A build automation tool used for project management, dependency management, and building the project.
*   **ExtentReports**: For generating comprehensive and visually appealing test execution reports.

## 📦	 Project Structure

The project follows a standard Maven project structure, with key directories organized as follows:

```
AutomationExcercise/
├── src/
│   ├── main/
│   │   └── java/                 # Main application code (if any, typically not for test automation)
│   │       └── Pages/            # Page Object Model (POM) classes for web pages
│   │           ├── HomePage.java
│   │           ├── SignInPage.java
│   │           ├── SignUpPage.java
│   │           └── ...
│   └── test/
│       └── java/                 # Test classes and test data
│           └── testCases/        # TestNG test classes
│               ├── BaseTest.java
│               ├── CheckoutTest.java
│               ├── ContactUsTest.java
│               ├── EndToEnd.java
│               ├── Logout.java
│               ├── ProductCartTest.java
│               ├── SignIn.java
│               └── SignUp.java
│           └── utilities/        # Utility classes for common functionalities
│               ├── commonHelper/
│               ├── config/
│               ├── datareaders/
│               ├── driverManger/
│               └── extentReport/
│       └── resources/            # Test data files (e.g., Signupdata.json, Signupdata.csv, Signupdata.xlsx)
├── test-output/                  # Generated test reports (ExtentReports)
├── pom.xml                       # Maven Project Object Model file
├── all-tests.xml                 # TestNG suite XML file for running all tests
└── test1.xml                     # TestNG suite XML file for specific tests
```

## 🧪 Test Cases Analysis

This section provides an overview of the automated test cases implemented in this project. Each test case is designed to validate a specific functionality of the AutomationExercise website.

### 🔒 User Authentication Test Cases

These test cases cover the user registration, login, and logout functionalities.

#### ✅  SignUp Test Case

**Description**: This test case validates the user registration process, including entering personal details, address information, and account creation. It also includes a data-driven test using various data sources (JSON, CSV, Excel).

| Test Case ID | Test Case Title | Prerequisites/Preconditions | Test Steps | Expected Results | Actual Results | Test Status | Priority |
|---|---|---|---|---|---|---|---|
| AE_TC_001 | User Registration with Valid Data | - Navigate to the AutomationExercise website. | 1. Click on 'Signup / Login' button. <br> 2. Enter Name and Email Address in the Signup section. <br> 3. Click 'Signup' button. <br> 4. Fill in account information (Title, Password, Date of Birth). <br> 5. Select 'Newsletter' and 'Receive special offers' checkboxes. <br> 6. Fill in address information (First Name, Last Name, Company, Address, Country, State, City, Zipcode, Mobile Number). <br> 7. Click 'Create Account' button. | Account Created! message is displayed. <br> User is redirected to the account created page. | | | High |
| AE_TC_002 | Data-Driven User Registration | - Navigate to the AutomationExercise website. <br> - Test data available in `Signupdata.json`, `Signupdata.csv`, or `Signupdata.xlsx`. | 1. Click on 'Signup / Login' button. <br> 2. Enter Name and Email Address in the Signup section. <br> 3. Click 'Signup' button. <br> 4. Fill in account information using data from data provider. <br> 5. Select 'Newsletter' and 'Receive special offers' checkboxes. <br> 6. Fill in address information using data from data provider. <br> 7. Click 'Create Account' button. | Account Created! message is displayed. <br> User is redirected to the account created page. | | | High |

#### ✅  SignIn Test Case

**Description**: This test case verifies the user login functionality with valid credentials.

| Test Case ID | Test Case Title | Prerequisites/Preconditions | Test Steps | Expected Results | Actual Results | Test Status | Priority |
|---|---|---|---|---|---|---|---|
| AE_TC_003 | User Login with Valid Credentials | - Navigate to the AutomationExercise website. <br> - A registered user account exists. | 1. Click on 'Signup / Login' button. <br> 2. Enter valid Email Address and Password in the Login section. <br> 3. Click 'Login' button. | User is successfully logged in and redirected to the home page. <br> 'Logged in as username' is displayed. | | | High |

#### ✅  Logout Test Case

**Description**: This test case validates the user logout functionality after successful login.

| Test Case ID | Test Case Title | Prerequisites/Preconditions | Test Steps | Expected Results | Actual Results | Test Status | Priority |
|---|---|---|---|---|---|---|---|
| AE_TC_004 | User Logout | - Navigate to the AutomationExercise website. <br> - User is logged in. | 1. Perform user registration and login (as per AE_TC_001/AE_TC_003). <br> 2. Click on 'Logout' button. | User is successfully logged out. <br> User is redirected to the login page. | | | Medium |

### 📬 Contact Us Test Case

This test case covers the functionality of submitting the contact us form.

#### 📬 Submit Contact Form Test Case

**Description**: This test case verifies the successful submission of the contact us form.

| Test Case ID | Test Case Title | Prerequisites/Preconditions | Test Steps | Expected Results | Actual Results | Test Status | Priority |
|---|---|---|---|---|---|---|---|
| AE_TC_005 | Submit Contact Us Form | - Navigate to the AutomationExercise website. | 1. Click on 'Contact Us' button. <br> 2. Fill in 'Name', 'Email', 'Subject', and 'Message' fields. <br> 3. Click 'Submit' button. | Success message is displayed. | | | Medium |

### 📦 Product and Cart Test Cases

These test cases cover adding products to the cart and the checkout process.

#### Product Cart Test Case

**Description**: This test case validates adding products to the cart and viewing the cart.

| Test Case ID | Test Case Title | Prerequisites/Preconditions | Test Steps | Expected Results | Actual Results | Test Status | Priority |
|---|---|---|---|---|---|---|---|
| AE_TC_006 | Add Product to Cart | - Navigate to the AutomationExercise website. | 1. Navigate to a product page or home page with products. <br> 2. Add a product to the cart. <br> 3. View the cart. | Product is successfully added to the cart. <br> Product details are correctly displayed in the cart. | | | High |

#### Checkout Test Case

**Description**: This test case validates the end-to-end checkout process.

| Test Case ID | Test Case Title | Prerequisites/Preconditions | Test Steps | Expected Results | Actual Results | Test Status | Priority |
|---|---|---|---|---|---|---|---|
| AE_TC_007 | End-to-End Checkout Process | - Navigate to the AutomationExercise website. <br> - User is logged in. <br> - Products are in the cart. | 1. Perform user login (AE_TC_003). <br> 2. Add products to the cart (AE_TC_006). <br> 3. Proceed to checkout. <br> 4. Complete the payment process. | Order is successfully placed. <br> Confirmation message is displayed. | | | High |

## ❓ How to Run Tests

To run the automated tests, follow these steps:

1.  **Prerequisites**:
    *   Java Development Kit (JDK) 8 or higher installed.
    *   Maven installed.
    *   Google Chrome browser installed (as the tests are configured to run on Chrome by default).

2.  **Clone the Repository**:
    ```bash
    git clone https://github.com/MoamenAhmed0/AutomationExcercise.git
    cd AutomationExcercise
    ```

3.  **Update WebDriver (if necessary)**:
    The project uses WebDriverManager to automatically handle browser driver binaries. However, if you encounter issues, ensure your Chrome browser is up to date, or manually update the WebDriver if needed.

4.  **Run Tests via Maven**:
    You can run all tests using Maven:
    ```bash
    mvn clean install
    mvn test
    ```
    To run specific test suites, you can use the TestNG XML files:
    ```bash
    mvn test -Dsurefire.suiteXmlFiles=all-tests.xml
    # Or for a specific suite:
    mvn test -Dsurefire.suiteXmlFiles=test1.xml
    ```

5.  **Run Tests via IDE (e.g., IntelliJ IDEA, Eclipse)**:
    *   Import the project as a Maven project.
    *   Navigate to the `src/test/java/testCases` directory.
    *   Right-click on individual test classes (e.g., `SignUp.java`, `SignIn.java`) and select 'Run 'SignUp'' or 'Run 'SignIn''.
    *   Alternatively, right-click on `all-tests.xml` or `test1.xml` in the project root and select 'Run 'all-tests.xml''.

## 📄 Reporting

Test execution reports are generated using **ExtentReports**. After running the tests, you can find the detailed HTML reports in the `test-output/` directory. The main report file is typically named `ExtentReport.html` or `ExtentReport_<timestamp>.html`.

To view the report, open the `ExtentReport.html` file in your web browser.

---

🙋 **Author**: Moamen Ahmed

📢**Date**: October 2025




