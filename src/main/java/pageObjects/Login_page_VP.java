package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.SecureRandom;
import java.time.Duration;
import java.util.UUID;

import static org.openqa.selenium.By.xpath;

public class Login_page_VP {
    WebDriver driver;
    public Login_page_VP(WebDriver driver) {
        this.driver = driver;
    }

    By loginEmail = xpath("//input[@id='Email']");
    By loginPassword = xpath("//input[@id='Password']");
    By loginButton = By.className("login-button");
    By passwordErrorMessage = By.className("message-error");
    By loggedEmail = By.cssSelector("a.account");
//By.id("Email");

    public void enterEmail(String email) {
        WebElement LoginEmailInput = driver.findElement(loginEmail);
        LoginEmailInput.clear();
        LoginEmailInput.sendKeys(email);
    }

    public void enterPassword(String pwd) {
        WebElement LoginPasswordInput = driver.findElement(loginPassword);
        LoginPasswordInput.clear();
        LoginPasswordInput.sendKeys(pwd);
    }

    public void clickLogIn() {
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
