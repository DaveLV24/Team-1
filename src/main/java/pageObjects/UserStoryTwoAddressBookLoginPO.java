package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserStoryTwoAddressBookLoginPO {
    WebDriver driver;

    private final By loginLink = By.className("ico-login");
    private final By emailInput = By.id("Email");
    private final By passwordInput = By.id("Password");
    private final By loginButton = By.cssSelector("input.button-1.login-button");
    private final By accountEmail = By.cssSelector("a.account");

    public UserStoryTwoAddressBookLoginPO(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLoginLink() {
        driver.findElement(loginLink).click();
    }

    public void enterEmail(String email) {
        WebElement emailField = driver.findElement(emailInput);
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        WebElement passwordField = driver.findElement(passwordInput);
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public String getLoggedInEmailText() {
        return driver.findElement(accountEmail).getText();
    }
}
