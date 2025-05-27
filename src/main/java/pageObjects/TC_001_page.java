package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.security.SecureRandom;
import java.util.UUID;

import static org.openqa.selenium.By.xpath;

public class TC_001_page {
    WebDriver driver;
    public TC_001_page(WebDriver driver) {
        this.driver = driver;
    }

    By firstName = xpath("//input[@id='FirstName']");
    By lastName = xpath("//input[@id='LastName']");
    By email = xpath("//input[@id='Email']");
    By password = xpath("//input[@id='Password']");
    By confirmPassword = xpath("//input[@id='ConfirmPassword']");
    By register = By.id("register-button");
    //By mismatchError = By.class("The password and confirmation password do not match.");
    By successMessage = By.cssSelector("div.result");


    public void enterFirstName(String fName) {
        WebElement firstNameInput = driver.findElement(firstName);
        firstNameInput.clear();
        firstNameInput.sendKeys(fName);
    }

    public void enterLastName(String lName) {
        WebElement lastNameInput = driver.findElement(lastName);
        lastNameInput.clear();
        lastNameInput.sendKeys(lName);
    }

    public void enterEmail(String mail) {
        WebElement emailInput = driver.findElement(email);
        emailInput.clear();
        emailInput.sendKeys(mail);
    }

    public void enterPassword(String pwd) {
        WebElement pwdInput = driver.findElement(password);
        pwdInput.clear();
        pwdInput.sendKeys(pwd);
    }

    public void enterConfirmPassword(String pwd) {
        WebElement confPwdInput = driver.findElement(confirmPassword);
        confPwdInput.clear();
        confPwdInput.sendKeys(pwd);
    }

    public void clickRegister() {
        driver.findElement(register).click();
    }

    public boolean isRegistrationSuccessMessageDisplayed() {
        return driver.findElement(successMessage).isDisplayed()
                && driver.findElement(successMessage).getText().contains("Your registration completed");
    }


    public static class TestDataGenerator {
        private static final String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
        private static final String CHAR_UPPER = CHAR_LOWER.toUpperCase();
        private static final String DIGITS = "0123456789";
        private static final String PASSWORD_ALLOW = CHAR_LOWER + CHAR_UPPER + DIGITS;
        private static final SecureRandom random = new SecureRandom();

        public static String generateRandomPassword(int length) {
            StringBuilder password = new StringBuilder(length);
            for (int i = 0; i < length; i++) {
                int index = random.nextInt(PASSWORD_ALLOW.length());
                password.append(PASSWORD_ALLOW.charAt(index));
            }
            return password.toString();
        }

        public static String generateRandomEmail() {
            String uuid = UUID.randomUUID().toString().substring(0, 8);
            return "user" + uuid + "@gmail.com";
        }
    }

}
