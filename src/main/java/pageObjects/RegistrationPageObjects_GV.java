package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPageObjects_GV {
    WebDriver driver;

    By firstName = By.id("FirstName");
    By lastName = By.id("LastName");
    By email =  By.id("Email");
    By password = By.id("Password");
    By passwordConfirm = By.id("ConfirmPassword");
    By registerButton = By.id("register-button");
    By warningEmail = By.cssSelector("span.field-validation-error[data-valmsg-for='Email'] > span");
    By warning = By.xpath("//div[contains(@class, 'validation-summary-errors')]//li[contains(text(), 'email already exists')]");
    By myAccountButton = By.cssSelector("a.account[href='/customer/info']");
    By registerHeader = By.className("ico-register");
    By logoutHeader = By.className("ico-logout");

    public RegistrationPageObjects_GV(WebDriver driver){
        this.driver = driver;
    }

    public String getPageUrl() {
        return "https://demowebshop.tricentis.com/";
    }

    public void toRegisterPage() {
        driver.findElement(registerHeader).click();
    }

    public void enterGender(String gender) {
        driver.findElement(By.id(String.format("gender-%s", gender))).click();
    }

    public void enterFirstName(String name) {
        driver.findElement(firstName).clear();
        driver.findElement(firstName).sendKeys(name);
    }

    public void enterLastName(String lastname) {
        driver.findElement(lastName).clear();
        driver.findElement(lastName).sendKeys(lastname);
    }

    public void enterEmail(String mail) {
        driver.findElement(email).clear();
        driver.findElement(email).sendKeys(mail);
    }

    public void enterPassword (String pass) {
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(pass);
    }

    public void enterPasswordConfirm (String pass) {
        driver.findElement(passwordConfirm).clear();
        driver.findElement(passwordConfirm).sendKeys(pass);
    }

    public void clickLogout() {
        driver.findElement(logoutHeader).click();
    }

    public void clickRegister() throws InterruptedException {
        driver.findElement(registerButton).click();
        Thread.sleep(2000);
    }

    public void clickMyAccount () {
        driver.findElement(myAccountButton).click();
    }


    public boolean getWarningMessage() {
        return driver.findElement(warningEmail).isDisplayed();
    }

    public boolean getWarning() { return driver.findElement(warning).isDisplayed(); }

    public String getFirstName() {
        return driver.findElement(firstName).getAttribute("value");
    }

    public String getLastName() {
        return driver.findElement(lastName).getAttribute("value");
    }

    public String getEmail() {
        return driver.findElement(email).getAttribute("value");
    }

}

