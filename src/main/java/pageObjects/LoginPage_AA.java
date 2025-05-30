package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage_AA {
    WebDriver driver;
    WebDriverWait wait;

    By emailInput = By.id("Email");
    By passwordInput = By.id("Password");
    By loginButton = By.cssSelector("input[value='Log in']");
    By loggedEmail = By.cssSelector("a.account");
    By passwordErrorMessage = By.className("message-error");

    public LoginPage_AA(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailInput)).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }
    public String getLoggedEmailValue() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        return driver.findElement(loggedEmail).getText();
    }

    public String getIncorrectCredentialsErrorText() {
        return driver.findElement(passwordErrorMessage).getText();
    }
}