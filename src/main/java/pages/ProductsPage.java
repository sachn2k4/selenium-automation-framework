package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigReader;

import java.time.Duration;
import java.util.List;

public class ProductsPage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(className = "title")
    private WebElement pageTitle;

    @FindBy(className = "inventory_item")
    private List<WebElement> productList;

    @FindBy(className = "shopping_cart_link")
    private WebElement cartIcon;

    @FindBy(className = "shopping_cart_badge")
    private WebElement cartBadge;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement addToCartButton;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(ConfigReader.getExplicitWait()));
        PageFactory.initElements(driver, this);
    }

    public String getPageTitle() {
        wait.until(ExpectedConditions.visibilityOf(pageTitle));
        return pageTitle.getText();
    }

    public boolean isProductsPageDisplayed() {
        try {
            return pageTitle.isDisplayed() && pageTitle.getText().equals("Products");
        } catch (Exception e) {
            return false;
        }
    }

    public int getProductCount() {
        return productList.size();
    }

    public void addFirstProductToCart() {
        addToCartButton.click();
    }

    public String getCartCount() {
        try {
            return cartBadge.getText();
        } catch (Exception e) {
            return "0";
        }
    }

    public void goToCart() {
        cartIcon.click();
    }
}
