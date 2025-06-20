package stepDefinitions;

import hooks.Hooks;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.MainPageBB;
import pageObjects.RegisterPageBB;

import java.util.Map;

import static org.junit.Assert.*;

public class RegisterPasswordLengthStepsBB {
    private WebDriver driver;
    private static RegisterPageBB registerPage;
    private static MainPageBB mainPage;

    public RegisterPasswordLengthStepsBB() {
        this.driver = Hooks.driver;
        mainPage = PageFactory.initElements(driver, MainPageBB.class);
        registerPage = PageFactory.initElements(driver, RegisterPageBB.class);
    }

    @When("^I open registration page$")
    public void iOpenRegistrationPage() {
        mainPage.clickRegisterHeaderButton();
    }

    @When("^I enter valid first name, last name, and email:$")
    public void iEnterValidFirstNameSecondNameAndEmail(Map<String, String> table) {
        registerPage.enterFirstName(table.get("first_name"));
        registerPage.enterLastName(table.get("last_name"));

        String randomEmail = String.format("%s%s%d@email.com",
                table.get("first_name"), table.get("second_name"), System.currentTimeMillis());
        registerPage.enterEmail(randomEmail);
    }

    @When("^I click register button$")
    public void iClickRegisterButton() {
        registerPage.clickRegisterBtn();
    }

    @Then("^I enter a password on length (\\d+)$")
    public void iEnterAPasswordOnLength(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder password = new StringBuilder();

        if (length == 0) {
            return;
        }

        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * chars.length());
            password.append(chars.charAt(index));
        }
        registerPage.enterPassword(password.toString());
        registerPage.enterConfirmPassword(password.toString());
    }

    @Then("^I see error message: \"([^\"]*)\"$")
    public void iSeeErrorMessage(String errorMessage) {
        assertEquals(registerPage.getErrorMessage(), errorMessage);
    }

    @Then("^I see no error message$")
    public void iSeeNoErrorMessage() {
        assertTrue(registerPage.getValidationSuccess().getText().isEmpty());
    }

    @Then("^I see register confirmation message$")
    public void iSeeRegisterConfirmationMessage() {
        assertTrue(driver.getCurrentUrl().contains("https://demowebshop.tricentis.com/registerresult"));
        assertTrue(registerPage.getRegisterSuccess().isDisplayed());
        assertEquals("Your registration completed", registerPage.getRegisterSuccess().getText());
    }

}