package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class UserAccountPage {
    WebDriver driver;

    By firstNameInput = By.id("FirstName");
    By lastNameInput = By.id("LastName");
    By emailInput = By.id("Email");
    By saveButton = By.cssSelector("input[name='save-info-button']");
    By successBanner = By.cssSelector("div.bar-notification.success");

    public UserAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToEditAccount() {
        driver.get("https://demowebshop.tricentis.com/customer/info");
    }

    public void updateAccountInfo(String firstName, String lastName, String email) {
        driver.findElement(firstNameInput).clear();
        driver.findElement(firstNameInput).sendKeys(firstName);

        driver.findElement(lastNameInput).clear();
        driver.findElement(lastNameInput).sendKeys(lastName);

        driver.findElement(emailInput).clear();
        driver.findElement(emailInput).sendKeys(email);
    }

    public void clickSave() {
        driver.findElement(saveButton).click();
    }

    public boolean isSuccessDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            return wait.until(ExpectedConditions.visibilityOfElementLocated(successBanner)).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    public String getSuccessMessageText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successBanner)).getText();
    }
}