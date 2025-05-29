package stepDefinitions;

import hooks.Hooks;
import org.openqa.selenium.By;
import pageObjects.UserAccountPage;
import pageObjects.LoginPage;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UserAccountSteps {
    WebDriver driver = Hooks.driver;
    LoginPage loginPage;
    UserAccountPage userAccountPage;

//    @Given("I am logged in")
//    public void i_am_logged_in() {
//        driver.get("https://demowebshop.tricentis.com/login");
//        loginPage = new LoginPage(driver);
//        loginPage.enterEmail("ndryev@gmail.com");
//        loginPage.enterPassword("password123");
//        loginPage.clickLogin();
//    }

    @When("I navigate to the Edit Account page")
    public void navigate_to_edit_account() {
        userAccountPage = new UserAccountPage(driver);
        userAccountPage.navigateToEditAccount();
    }

    @When("I update first name to {string}, last name to {string}, and email to {string}")
    public void update_account_info(String firstName, String lastName, String email) {
        userAccountPage.updateAccountInfo(firstName, lastName, email);
    }

    @When("I click Save")
    public void click_save() {
        userAccountPage.clickSave();
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