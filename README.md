# Selenium Test Framework: SauceDemo WebAutomation

## Project Overview
This is a Selenium-based Test Automation Framework for testing the **SauceDemo** e-commerce website. The framework is built using Java, Selenium WebDriver, TestNG, and Maven, following the Page Object Model (POM) design pattern for maintainability and reusability.

## Project Structure
```
WebAutomation_SauceDemo/
│
├── .idea/                    # IntelliJ IDEA project settings
├── .mvn/                    # Maven wrapper files
│
├── src/main/java/
│   ├── PageClasses/         # Page Object Model classes
│   │   ├── CheckoutPageOne
│   │   ├── CheckoutPageTwo
│   │   ├── CompleteCheckoutPage
│   │   ├── LoginPage
│   │   ├── ProductsPage
│   │   └── ShopCartPage
│   │
│   └── Utilities/           # Reusable utility classes
│       ├── ExcellUtility    # Excel file handling
│       └── ExtentReportManager  # Report generation
│
├── src/test/java/
│   ├── TestCases/           # Test case classes
│   │   └── TestSuite_eCommerceTest
│   │
│   └── TestUtilities/       # Test-level utilities
│       ├── ConfigUtil       # Configuration management
│       ├── DataProviders    # TestNG data providers
│       └── HelperMethods    # Reusable test helper methods
│
├── target/                  # Compiled classes and test output
│
├── Test Reports/            # Generated test reports
│   └── MyTestReport.html    # Extent Reports output
│
├── ExtentReport.xml         # Extent Reports configuration
├── pom.xml                  # Maven dependencies and build configuration
└── TestNGXML.xml            # TestNG test suite configuration
```

## Key Features
- **Page Object Model (POM)** – Separate page classes for better maintenance
- **TestNG Integration** – Supports parallel execution, data-driven testing, and detailed reporting
- **Extent Reporting** – Rich HTML reports with screenshots and logs
- **Maven Build Tool** – Dependency management and build automation
- **Modular Utilities** – Reusable methods for reporting, configuration, and data handling

## Prerequisites
- Java JDK 8+ (JDK-17 recommended)
- Maven
- Chrome/Firefox browser

## How to Run Tests
1. **Using Maven:**
   ```bash
   mvn clean test
   ```

2. **Using TestNG XML:**
   - Run `TestNGXML.xml` directly from IDE or command line.

3. **Generate Extent Report:**
   - Reports are automatically generated in `Test Reports/MyTestReport.html` after test execution.

## Configuration
- Update `ExtentReport.xml` to customize report settings.
- Modify `TestNGXML.xml` to adjust test suites, groups, or parallel execution.
- Use `ConfigUtil` for centralized configuration (e.g., URLs, timeouts).

## Reporting
- Extent Reports provide detailed test execution summaries.
