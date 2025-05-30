package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class OrdersPage_AA {
    private WebDriver driver;
    private WebDriverWait wait;

    private By ordersTable = By.cssSelector("table.account-order-list");
    private By orderRows = By.cssSelector("table.account-order-list tr");
    private By orderDetailsLinks = By.cssSelector("a[href*='/order/details/']");
    private By noOrdersMessage = By.cssSelector("div.no-data");
    private By orderNumberElement = By.cssSelector(".order-number");
    private By orderTotalElement = By.cssSelector(".order-total");
    private By orderStatusElement = By.cssSelector(".order-status");

    public OrdersPage_AA(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    public void clickFirstOrderDetails() {
        wait.until(ExpectedConditions.elementToBeClickable(orderDetailsLinks)).click();
    }

    public boolean isOrderDetailsDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(orderNumberElement)).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public String getOrderNumber() {
        return driver.findElement(orderNumberElement).getText();
    }

    public String getOrderTotal() {
        return driver.findElement(orderTotalElement).getText();
    }

    public String getOrderStatus() {
        return driver.findElement(orderStatusElement).getText();
    }

    public void navigateToOrdersPage() {
        driver.get("https://demowebshop.tricentis.com/customer/orders");
    }

    public boolean isNoOrdersMessageDisplayed() {
        try {
            return driver.findElement(By.xpath("//*[contains(., 'No orders')]"))
                    .isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public boolean isDetailsButtonVisible() {
        try {
            return driver.findElement(By.cssSelector("input[value='Details']"))
                    .isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isOrdersTableDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(ordersTable)).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public int getOrderCount() {
        try {
            return driver.findElements(By.cssSelector("table.my-orders tr.order-item")).size();
        } catch (NoSuchElementException e) {
            return 0;
        }
    }
}
