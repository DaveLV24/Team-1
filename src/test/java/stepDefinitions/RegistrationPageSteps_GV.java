package stepDefinitions;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.RegistrationPageObjects_GV;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RegistrationPageSteps_GV {
    private WebDriver driver;
    private static RegistrationPageObjects_GV registrationPage;

    public RegistrationPageSteps_GV() {
        this.driver = Hooks.driver;
        registrationPage = PageFactory.initElements(driver, RegistrationPageObjects_GV.class);
    }

    @Given("I am on Web shop page")
    public void iAmOnWebShopPage() {
        driver.get(registrationPage.getPageUrl());
    }


    @When("^I click register header button$")
    public void iClickRegisterHeaderButton() {
        registrationPage.toRegisterPage();
    }

    @And("^I enter all information:$")
    public void iEnterAllInformation(Map<String, String> info) {
        registrationPage.enterGender(info.get("gender"));
        registrationPage.enterFirstName(info.get("firstname"));
        registrationPage.enterLastName(info.get("lastname"));
        registrationPage.enterEmail(info.get("email"));
        registrationPage.enterPassword(info.get("password"));
        registrationPage.enterPasswordConfirm(info.get("password"));
    }

    @And("^I click registration button$")
    public void iClickRegistrationButton() throws InterruptedException {
        registrationPage.clickRegister();
    }

    @Then("^I check that information is correct:$")
    public void iCheckThatAndIsCorrect(Map<String, String> info) {
        assertEquals(info.get("firstname"), registrationPage.getFirstName());
        assertEquals(info.get("lastname"), registrationPage.getLastName());
        assertEquals(info.get("email"), registrationPage.getEmail());
    }

//    @Then("I should enter in Web shop")
//    public void iShouldEnterInWebShop() {
//        assertTrue(registrationPage.getWarningMessage());
//    }

    @Then("My register shouldnt be performed")
    public void myRegisterShouldntBePerformed() {
        assertEquals("https://demowebshop.tricentis.com/register", driver.getCurrentUrl());
    }

    @When("I click Logout button")
    public void iClickLogoutButton() {
        registrationPage.clickLogout();
    }

    @And("I see email warning message")
    public void iSeeWarningEmailMessage() {
        assertTrue(registrationPage.getWarningMessage());
    }

    @And("I click my Account button")
    public void iClickMyAccountButton() {
        registrationPage.clickMyAccount();
    }

    @And("I see warning message")
    public void iSeeWarningMessage() {
        assertTrue(registrationPage.getWarning());
    }
}
