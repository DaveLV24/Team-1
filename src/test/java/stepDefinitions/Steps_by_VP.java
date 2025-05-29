package stepDefinitions;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObjects.Login_page_VP;
import pageObjects.Registration_page_VP;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Steps_by_VP {

    private WebDriver driver;
    private Registration_page_VP registerPage;
    private String generatedPassword;
    private String generateDifferentConfirmationPassword;
    private Login_page_VP loginPage;


    public Steps_by_VP() {
        this.driver = Hooks.driver;
        this.registerPage = new Registration_page_VP(driver);
        this.loginPage = new Login_page_VP(driver);
    }


    @Given("I am on Demo Web Shops Register page")
    public void I_am_on_Demo_Web_Shops_Register_page() {
        driver.get("https://demowebshop.tricentis.com/register");
        registerPage = new Registration_page_VP(driver);
    }

    @When("I enter first name")
    public void enterFirstName() {
        registerPage.enterFirstName("Test");
    }

    @When("I enter second name")
    public void EnterSecondName() {
        registerPage.enterLastName("User");
    }

    @When("I enter email")
    public void EnterEmail() {
        String email = Registration_page_VP.TestDataGenerator.generateRandomEmail();
        registerPage.enterEmail(email);
    }

    @When("I enter password")
    public void EnterPassword() {
        generatedPassword = Registration_page_VP.TestDataGenerator.generateRandomPassword(6);
        registerPage.enterPassword(generatedPassword);
    }

    @When("I enter the same confirmation password")
    public void EnterSameConfirmationPassword() {
        registerPage.enterConfirmPassword(generatedPassword);
    }

    @When("I click Register")
    public void ClickRegister() {
        registerPage.clickRegister();
    }

    @Then("I am navigated to confirmation page")
    public void iAmOnConfirmationPage() {
        assertEquals("https://demowebshop.tricentis.com/registerresult/1", driver.getCurrentUrl());
        assertTrue("Your registration completed",
                registerPage.isRegistrationSuccessMessageDisplayed());
    }

    @When("I enter a different confirmation password")
    public void enterDifferentConfirmPassword() {
        generateDifferentConfirmationPassword = Registration_page_VP.TestDataGenerator.generateRandomPassword(8);
        registerPage.enterConfirmPassword(generateDifferentConfirmationPassword);
    }

    @Then("I see password mismatch error")
    public void iSeePasswordMismatchError() {
        String actualText = registerPage.getPasswordMismatchErrorText();
        assertEquals("The password and confirmation password do not match.", actualText);
    }

    @Then("I am blocked on the register page")
    public void blockedOnRegisterPage() {
        assertEquals("https://demowebshop.tricentis.com/register", driver.getCurrentUrl());
    }

    @When("I click Log out")
    public void ClickLogOut() {
        registerPage.clickLogOut();
    }

    @Then("I get logged out and redirected to home page")
    public void logOutAndReturnToHomePage() {
        assertEquals("https://demowebshop.tricentis.com/", driver.getCurrentUrl());
        assertTrue("Logout button still present", registerPage.logOutAndReturnToHomePage());
    }

    @When("I click Log in on home page")
    public void ClickLogIn() {
        registerPage.clickLogIn();
    }

    @Then("I am on the login page")
    public void iAmOnLogInPage() {
        assertEquals("https://demowebshop.tricentis.com/login", driver.getCurrentUrl());
    }

    @When("I enter valid login email")
    public void iEnterValidLoginEmail() {
        String email = Registration_page_VP.TestDataGenerator.getLastEmail();
        loginPage.enterEmail(email);
    }

    @When("I enter valid login password")
    public void iEnterValidLoginPassword() {
        String pwd = Registration_page_VP.TestDataGenerator.getLastPassword();
        loginPage.enterPassword(pwd);
    }

    @When("I click Log in button")
    public void ClickLogInButton() {
        loginPage.clickLogIn();
    }

    @Then("I am logged in successfully")
    public void loginSuccess() {
        String expectedEmail = Registration_page_VP.TestDataGenerator.getLastEmail();
        String actualEmail = loginPage.getLoggedEmailValue();
        assertEquals(expectedEmail, actualEmail);
    }

    @When("I enter invalid login password")
    public void iEnterInValidLoginPassword() {
        String pwd = "123456";
        loginPage.enterPassword(pwd);
    }

    @Then("I see incorrect credentials error")
    public void iSeeIncorreectCredentialsError() {
        String actualText = loginPage.getIncorrectCredentialsErrorText();
        assertTrue(actualText.contains("The credentials provided are incorrect"));
    }



    }