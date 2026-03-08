# ⚙️ Selenium Automation Framework

A professional test automation framework built with **Selenium WebDriver + Java + TestNG** following **Page Object Model (POM)** design pattern.

---

## 🛠️ Tech Stack

| Tool | Purpose |
|------|---------|
| Java 11 | Programming Language |
| Selenium WebDriver 4.x | Browser Automation |
| TestNG | Test Framework |
| Maven | Build & Dependency Management |
| WebDriverManager | Auto Driver Setup |
| Page Object Model | Design Pattern |
| ExtentReports | Test Reporting |
| Postman | API Testing |

---

## 📁 Project Structure

```
selenium-automation-framework/
│
├── src/
│   ├── main/java/
│   │   ├── pages/
│   │   │   ├── LoginPage.java        # Login page elements & actions
│   │   │   ├── ProductsPage.java     # Products page elements & actions
│   │   │   └── CartPage.java         # Cart page elements & actions
│   │   └── utils/
│   │       ├── BaseTest.java         # Driver setup & teardown
│   │       ├── ConfigReader.java     # Read config.properties
│   │       └── ScreenshotUtil.java   # Screenshot on failure
│   │
│   └── test/java/
│       └── tests/
│           ├── LoginTest.java        # 7 Login test cases
│           └── CartTest.java         # 4 Cart test cases
│
├── config.properties                 # Browser, URL, credentials config
├── testng.xml                        # Test suite configuration
├── pom.xml                           # Maven dependencies
└── .gitignore
```

---

## ✅ Test Cases Covered

### Login Module — 7 Test Cases
| TC ID | Test Case | Type |
|-------|-----------|------|
| TC_001 | Valid login with correct credentials | Positive |
| TC_002 | Invalid username | Negative |
| TC_003 | Invalid password | Negative |
| TC_004 | Empty username field | Negative |
| TC_005 | Empty password field | Negative |
| TC_006 | Both fields empty | Negative |
| TC_007 | Data driven login (5 datasets) | Data Driven |

### Cart Module — 4 Test Cases
| TC ID | Test Case | Type |
|-------|-----------|------|
| TC_008 | Products page loads after login | Functional |
| TC_009 | Add product to cart | Functional |
| TC_010 | Cart page displays correct items | Functional |
| TC_011 | Checkout navigation works | Functional |

---

## 🚀 How to Run

### Prerequisites
- Java 11+
- Maven 3.8+
- Chrome Browser

### Clone & Run
```bash
# Clone the repo
git clone https://github.com/sachn2k4/selenium-automation-framework.git

# Navigate to project
cd selenium-automation-framework

# Run all tests
mvn test

# Run specific test class
mvn test -Dtest=LoginTest

# Run with TestNG XML
mvn test -DsuiteXmlFile=testng.xml
```

---

## 🔧 Configuration

Edit `config.properties` to change settings:

```properties
base.url=https://www.saucedemo.com
browser=chrome          # chrome or firefox
implicit.wait=10
explicit.wait=15
```

---

## 📊 Framework Features

- ✅ **Page Object Model** — Separation of page elements and test logic
- ✅ **Config Driven** — No hardcoded values, all in properties file
- ✅ **Data Driven Testing** — TestNG @DataProvider for multiple datasets
- ✅ **Explicit Waits** — WebDriverWait for dynamic elements
- ✅ **BaseTest Architecture** — Common setup/teardown for all tests
- ✅ **Screenshot on Failure** — Auto capture when test fails
- ✅ **Cross Browser** — Chrome and Firefox support
- ✅ **Maven Integration** — Easy build and dependency management

---

## 👨‍💻 Author

**Sachin Maurya**
- 📧 officialsachin2k4@gmail.com
- 💼 [LinkedIn](https://linkedin.com/in/sachin-mourya)
- 🐙 [GitHub](https://github.com/sachn2k4)

---

## 📄 License
This project is open source and available under the [MIT License](LICENSE).
