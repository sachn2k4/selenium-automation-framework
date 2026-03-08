package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;
import utils.BaseTest;
import utils.ConfigReader;

public class CartTest extends BaseTest {

    // Helper — login karo pehle
    private ProductsPage doLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(ConfigReader.getValidUsername(), ConfigReader.getValidPassword());
        return new ProductsPage(driver);
    }

    // TC_008 — Products Page Load
    @Test(priority = 1, description = "Verify products page loads after login")
    public void testProductsPageLoads() {
        ProductsPage productsPage = doLogin();

        Assert.assertTrue(productsPage.isProductsPageDisplayed(),
                "Products page should be visible");
        Assert.assertTrue(productsPage.getProductCount() > 0,
                "At least one product should be visible");
        System.out.println("✅ TC_008 PASSED — Products loaded: " + productsPage.getProductCount());
    }

    // TC_009 — Add to Cart
    @Test(priority = 2, description = "Verify product can be added to cart")
    public void testAddToCart() {
        ProductsPage productsPage = doLogin();

        productsPage.addFirstProductToCart();

        Assert.assertEquals(productsPage.getCartCount(), "1",
                "Cart count should be 1 after adding product");
        System.out.println("✅ TC_009 PASSED — Product added to cart");
    }

    // TC_010 — Cart Page Opens
    @Test(priority = 3, description = "Verify cart page opens correctly")
    public void testCartPageOpens() {
        ProductsPage productsPage = doLogin();
        productsPage.addFirstProductToCart();
        productsPage.goToCart();

        CartPage cartPage = new CartPage(driver);

        Assert.assertTrue(cartPage.isCartPageDisplayed(),
                "Cart page should be displayed");
        Assert.assertEquals(cartPage.getCartItemCount(), 1,
                "Cart should have 1 item");
        System.out.println("✅ TC_010 PASSED — Cart page verified");
    }

    // TC_011 — Checkout Button Works
    @Test(priority = 4, description = "Verify checkout button navigates correctly")
    public void testCheckoutNavigation() {
        ProductsPage productsPage = doLogin();
        productsPage.addFirstProductToCart();
        productsPage.goToCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.clickCheckout();

        Assert.assertTrue(driver.getCurrentUrl().contains("checkout"),
                "Should navigate to checkout page");
        System.out.println("✅ TC_011 PASSED — Checkout navigation works");
    }
}
