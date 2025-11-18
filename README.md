🛒 Amazon Web Automation (Selenium + Java)

This project automates core user flows on the Amazon web application using Selenium WebDriver, Java, TestNG, and Maven.
It follows Page Object Model (POM) architecture with reusable utilities, custom listeners, reporting, waits, and clean test structure suitable for real-time automation frameworks.

🚀 Features Automated

Login flow

Product search

Applying filters

Opening product details

Add to Cart

Proceed to Checkout

Validations at each step

Screenshot on failure

End-to-end user journey

🧱 Tech Stack

Java

Selenium WebDriver

TestNG

Maven

Page Object Model (POM)

Extent Reports / Allure (based on your setup)

ThreadLocal WebDriver

JavaScript Executor

WebDriverWait & ExpectedConditions

📂 Project Structure
amazon-selenium-automation
│
├── src/test/java
│   ├── tests/          # Test classes
│   ├── pages/          # POM page classes
│   ├── utilities/      # Helper classes (wait, driver, config)
│   ├── listeners/      # TestNG listeners for reports, screenshots
│   └── base/           # BaseTest & Driver management
│
├── src/main/resources
│   ├── config.properties
│
├── reports/            # Test reports
├── screenshots/        # Screenshots captured on failure
├── pom.xml             # Maven dependencies
└── README.md

🔧 How to Run the Tests
1. Clone the repo
git clone https://github.com/your-username/amazon-selenium-automation.git

2. Install dependencies
mvn clean install

3. Run the test suite
mvn clean test

📸 Reporting & Screenshots

Automatic screenshot capture on test failure

Detailed HTML reports

Test logs for each run

Each test runs in isolation using ThreadLocal WebDriver

🎯 Highlights

Real-time automation coding practices

Clean POM structure

Reusable functions

Config-driven framework

Easy to scale and maintain

Suitable for interview and portfolio demonstration

👤 Author

Madhan Kumar
Automation Tester — Java | Selenium | API | Jenkins
