package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AccountPage {
    WebDriver driver;

    public By editAccountLink = By.linkText("My account");
    By firstNameInput = By.id("FirstName");
    By lastNameInput = By.id("LastName");
    By emailInput = By.cssSelector("input[type='email']");
    By saveButton = By.xpath("//button[contains(text(),'Save')]");
    By successBanner = By.className("alert-success");

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToEditAccount() {
        driver.findElement(editAccountLink).click();
    }

    public void updateAccountInfo(String firstName, String lastName, String email) {
        driver.findElement(firstNameInput).clear();
        driver.findElement(firstNameInput).sendKeys(firstName);

        driver.findElement(lastNameInput).clear();
        driver.findElement(lastNameInput).sendKeys(lastName);

        driver.findElement(emailInput).clear();
        driver.findElement(emailInput).sendKeys(email);
    }

    public String getPageUrl() {
        return "https://demowebshop.tricentis.com/customer/info";
    }

    public void clickSave() {
        driver.findElement(saveButton).click();
    }

    public boolean isSuccessDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successBanner)).isDisplayed();
    }
}