package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class HomePage_AA {
    private final WebDriver driver;
    private final WebDriverWait wait;

    // Locators
    private final By loginLink = By.cssSelector("a.ico-login");
    private final By registerLink = By.cssSelector("a.ico-register");
    private final By logoutLink = By.cssSelector("a.ico-logout");
    private final By accountLink = By.cssSelector("a.ico-account");
    private final By searchField = By.id("small-searchterms");
    private final By searchButton = By.cssSelector("input[value='Search']");
    private final By featuredProducts = By.cssSelector("div.product-item");

    public HomePage_AA(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Page Actions
    public void navigateToHomePage() {
        driver.get("https://demowebshop.tricentis.com/");
        wait.until(ExpectedConditions.titleContains("Demo Web Shop"));
    }

    public void clickLoginLink() {
        wait.until(ExpectedConditions.elementToBeClickable(loginLink)).click();
    }

    public void clickRegisterLink() {
        wait.until(ExpectedConditions.elementToBeClickable(registerLink)).click();
    }

    public boolean isLogoutLinkVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(logoutLink)).isDisplayed();
    }

    public void clickAccountLink() {
        wait.until(ExpectedConditions.elementToBeClickable(accountLink)).click();
    }

    public void searchForProduct(String productName) {
        driver.findElement(searchField).sendKeys(productName);
        driver.findElement(searchButton).click();
    }

    public List<WebElement> getFeaturedProducts() {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(featuredProducts));
    }

    public int getFeaturedProductsCount() {
        return getFeaturedProducts().size();
    }

    public void addProductToCart(String productName) {
        By productAddToCartButton = By.xpath(
                String.format("//h2[@class='product-title']/a[text()='%s']/ancestor::div[@class='details']//input[@value='Add to cart']",
                        productName));
        wait.until(ExpectedConditions.elementToBeClickable(productAddToCartButton)).click();
    }

    // Verification Methods
    public boolean isUserLoggedIn() {
        try {
            return isLogoutLinkVisible() && driver.findElement(accountLink).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}