package stepDefinitions;

import hooks.Hooks;
import pageObjects.UserAccountPage_AA;
import pageObjects.LoginPage_AA;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

public class UserAccountSteps {
    WebDriver driver = Hooks.driver;
    LoginPage_AA loginPageAA;
    UserAccountPage_AA userAccountPageAA;

//    @Given("I am logged in")
//    public void i_am_logged_in() {
//        driver.get("https://demowebshop.tricentis.com/login");
//        loginPageAA = new LoginPage_AA(driver);
//        loginPageAA.enterEmail("ndryev@gmail.com");
//        loginPageAA.enterPassword("password123");
//        loginPageAA.clickLogin();
//    }

    @When("I navigate to the Edit Account page")
    public void navigate_to_edit_account() {
        userAccountPageAA = new UserAccountPage_AA(driver);
        userAccountPageAA.navigateToEditAccount();
    }

    @When("I update first name to {string}, last name to {string}, and email to {string}")
    public void update_account_info(String firstName, String lastName, String email) {
        userAccountPageAA.updateAccountInfo(firstName, lastName, email);
    }

    @When("I click Save")
    public void click_save() {
        userAccountPageAA.clickSave();
    }

//    @Then("I should see a success message")
//    public void verify_success_message() {
//        // Verify changes persisted instead
//        driver.navigate().refresh();
//        String currentEmail = driver.findElement(By.id("Email")).getAttribute("value");
//        Assert.assertEquals("ndryev@gmail.com", currentEmail);
//
//        // Log the actual bug
//        System.out.println("WARNING: Success message not displayed - known bug");
//    }

    @Then("the changes should be reflected on the account page")
    public void verify_changes_persisted() {
        // Add verification logic (e.g., check displayed name/email)
    }

    // Close driver after scenario (better handled in Hooks)
}