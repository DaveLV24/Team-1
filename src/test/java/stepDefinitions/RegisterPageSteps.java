package stepDefinitions;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;


public class RegisterPageSteps {

    private WebDriver driver;

    public RegisterPageSteps(){
        this.driver = Hooks.driver;
    }


    @When("open register page")
    public void openRegisterPage() {
        driver.get("https://demowebshop.tricentis.com/register");
    }

    @Then("ensure that first name, last name, email and password are displayed on page")
    public void ensureThatFirstNameLastNameEmailAndPasswordAreDisplayedOnPage() {
        String firstName = driver.findElement(By.cssSelector("label[for='FirstName']")).getText();
        assertEquals("First name:", firstName);

        String lastName = driver.findElement(By.cssSelector("label[for='LastName']")).getText();
        assertEquals("Last name:", lastName);

        String eMail = driver.findElement(By.cssSelector("label[for='Email']")).getText();
        assertEquals("Email:", eMail);

        String passWord = driver.findElement(By.cssSelector("label[for='Password']")).getText();
        assertEquals("Password:", passWord);

        String confirmPassWord = driver.findElement(By.cssSelector("label[for='ConfirmPassword']")).getText();
        assertEquals("Confirm password:", confirmPassWord);



    }

    @And("press register button")
    public void pressRegisterButton() {
        driver.findElement(By.id("register-button")).click();
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Then("ensure error messages")
    public void ensureErrorMessages() {
        assertEquals("First name is required.", driver.findElement(By.cssSelector("span[for='FirstName']")).getText());
        assertEquals("Last name is required.", driver.findElement(By.cssSelector("span[for='LastName']")).getText());
        assertEquals("Email is required.", driver.findElement(By.cssSelector("span[for='Email']")).getText());
        assertEquals("Password is required.", driver.findElement(By.cssSelector("span[for='Password']")).getText());
        assertEquals("Password is required.", driver.findElement(By.cssSelector("span[for='ConfirmPassword']")).getText());
    }


    @And("enter wrong {string} format")
    public void enterWrongFormat(String email) {
        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(email);
    }

    @Then("error message is displayed")
    public void errorMessageIsDisplayed() {
        assertEquals("Wrong email", driver.findElement(By.cssSelector("span[for='Email']")).getText());

    }
}
