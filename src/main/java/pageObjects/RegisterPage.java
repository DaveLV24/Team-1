package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.openqa.selenium.By.xpath;

public class RegisterPage {
    WebDriver driver;
    public RegisterPage(WebDriver driver){
        this.driver = driver;
    }

    By firstName = xpath("//input[@id='FirstName']");
    By lastName = xpath("//input[@id='LastName']");
    By email = xpath("//input[@id='Email']");
    By password = xpath("//input[@id='Password']");
    By confirmPassword = xpath("//input[@id='ConfirmPassword']");
    By register = By.id("register-button");
    By passwordMismatchError = By.cssSelector("span.field-validation-error[data-valmsg-for='ConfirmPassword'] > span");
    By successMessage = By.cssSelector("div.result");
    By logOut = By.className("ico-logout");
    By logIn  = By.className("ico-login");

    public void registerButton(){
        driver.findElement(register).click();

    }

}
