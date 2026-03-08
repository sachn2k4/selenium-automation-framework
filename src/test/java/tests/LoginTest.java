package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;
import utils.BaseTest;
import utils.ConfigReader;
import utils.ScreenshotUtil;

public class LoginTest extends BaseTest {

    // TC_001 — Valid Login
    @Test(priority = 1, description = "Verify user can login with valid credentials")
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);

        loginPage.login(ConfigReader.getValidUsername(), ConfigReader.getValidPassword());

        Assert.assertTrue(productsPage.isProductsPageDisplayed(),
                "Products page should be displayed after valid login");
        System.out.println("✅ TC_001 PASSED — Valid Login");
    }

    // TC_002 — Invalid Username
    @Test(priority = 2, description = "Verify error message for invalid username")
    public void testInvalidUsername() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(ConfigReader.getInvalidUsername(), ConfigReader.getValidPassword());

        Assert.assertTrue(loginPage.isErrorDisplayed(),
                "Error message should be displayed for invalid username");
        Assert.assertTrue(loginPage.getErrorMessage().contains("Username and password do not match"),
                "Error message text should match");
        System.out.println("✅ TC_002 PASSED — Invalid Username");
    }

    // TC_003 — Invalid Password
    @Test(priority = 3, description = "Verify error message for invalid password")
    public void testInvalidPassword() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(ConfigReader.getValidUsername(), ConfigReader.getInvalidPassword());

        Assert.assertTrue(loginPage.isErrorDisplayed(),
                "Error message should be displayed for invalid password");
        System.out.println("✅ TC_003 PASSED — Invalid Password");
    }

    // TC_004 — Empty Username
    @Test(priority = 4, description = "Verify error for empty username")
    public void testEmptyUsername() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("", ConfigReader.getValidPassword());

        Assert.assertTrue(loginPage.isErrorDisplayed(),
                "Error should appear for empty username");
        Assert.assertTrue(loginPage.getErrorMessage().contains("Username is required"),
                "Should show username required error");
        System.out.println("✅ TC_004 PASSED — Empty Username");
    }

    // TC_005 — Empty Password
    @Test(priority = 5, description = "Verify error for empty password")
    public void testEmptyPassword() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(ConfigReader.getValidUsername(), "");

        Assert.assertTrue(loginPage.isErrorDisplayed(),
                "Error should appear for empty password");
        Assert.assertTrue(loginPage.getErrorMessage().contains("Password is required"),
                "Should show password required error");
        System.out.println("✅ TC_005 PASSED — Empty Password");
    }

    // TC_006 — Both Fields Empty
    @Test(priority = 6, description = "Verify error when both fields are empty")
    public void testBothFieldsEmpty() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("", "");

        Assert.assertTrue(loginPage.isErrorDisplayed(),
                "Error should appear when both fields empty");
        System.out.println("✅ TC_006 PASSED — Both Fields Empty");
    }

    // TC_007 — Data Driven Login Test
    @Test(priority = 7, dataProvider = "loginData",
          description = "Data driven login test with multiple credentials")
    public void testLoginDataDriven(String username, String password, String expectedResult) {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = new ProductsPage(driver);

        loginPage.login(username, password);

        if (expectedResult.equals("success")) {
            Assert.assertTrue(productsPage.isProductsPageDisplayed(),
                    "Should reach products page for: " + username);
            System.out.println("✅ TC_007 PASSED — Valid: " + username);
        } else {
            Assert.assertTrue(loginPage.isErrorDisplayed(),
                    "Should show error for: " + username);
            System.out.println("✅ TC_007 PASSED — Invalid: " + username);
        }
    }

    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
        return new Object[][] {
            {"standard_user",  "secret_sauce", "success"},
            {"locked_out_user","secret_sauce", "failure"},
            {"wrong_user",     "secret_sauce", "failure"},
            {"standard_user",  "wrong_pass",   "failure"},
            {"",               "",             "failure"}
        };
    }
}
