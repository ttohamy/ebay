# eBay Test Automation Framework

A Selenium WebDriver based test automation framework for testing eBay's web application, built with Java, TestNG, and Allure reporting.

## 🚀 Features

- **Page Object Model (POM) Design Pattern** for better maintainability
- **Allure Reporting** for detailed and interactive test reports
- **Configuration Management** using JSON configuration files
- **Cross-browser Testing** support (Chrome, Firefox, etc.)
- **Logging** with custom logger helper
- **Screenshots** on test failure
- **Data-Driven Testing** support

## 🛠️ Prerequisites

- Java JDK 11 or higher
- Maven 3.6.0 or higher
- Chrome/Firefox browser installed
- Allure Commandline (for report generation)

## 🚀 Getting Started

### 1. Clone the Repository
```bash
git clone <repository-url>
cd ebay-test-automation
```

### 2. Install Dependencies
```bash
mvn clean install
```

### 3. Configuration
Update the `data.json` file with your test configurations:
```json
{
  "URL": "https://www.ebay.com/",
  "SEARCH_TEXT": "mazda mx-5"
}
```

### 4. Running Tests

#### Run all tests:
```bash
mvn clean test
```

#### Run specific test class:
```bash
mvn test -Dtest=SearchTest
```

### 5. Generate Allure Report
```bash
mvn allure:serve
```
This will automatically open the Allure report in your default browser.

## 📂 Project Structure

```
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── base/           # Base classes (DriverManager, TestBase)
│   │   │   ├── pages/          # Page Object classes
│   │   │   ├── utils/          # Utility classes (ConfigReader, LoggerHelper)
│   │   │   └── helper/         # Helper classes
│   │   └── resources/          # Resource files
│   └── test/
│       └── java/
│           └── tests/          # Test classes
├── data.json                   # Configuration file
├── pom.xml                    # Maven configuration
└── README.md                  # Project documentation
```

## 📊 Test Reports

Test reports are generated in the `allure-results` directory after test execution. To view the reports:

1. Generate the report:
   ```bash
   mvn allure:report
   ```

2. Serve the report:
   ```bash
   mvn allure:serve
   ```

## 🛠️ Dependencies

- Selenium WebDriver
- TestNG
- Allure TestNG
- Jackson Databind (for JSON processing)
- WebDriverManager
- Log4j (for logging)

## 🤝 Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📝 License

This project is licensed under the MIT License - see the LICENSE file for details.

## 👨‍💻 Author

Mohamed Eltohamy- mohamed.eltohamy.ahmed@gmail.com
