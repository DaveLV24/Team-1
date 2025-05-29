package stepDefinitions;

import hooks.Hooks;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.AccountPage;
import pageObjects.LoginPage;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AccountSteps {
    private WebDriver driver;
    private static LoginPage loginPage;
    private static AccountPage accountPage;

    private static final String SITE = "https://demowebshop.tricentis.com";

    public AccountSteps(){
        this.driver = Hooks.driver;
        loginPage = PageFactory.initElements(driver, LoginPage.class);
    }

    @Given("I am logged in")
    public void i_am_logged_in() {
        driver.get("https://demowebshop.tricentis.com/login");

        // Wait for login page to load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains("Login"));

        loginPage.enterUsername("ndryev@gmail.com");
        loginPage.enterPassword("password123");
        loginPage.clickLogin();

        // Alternative verification - wait for logout link to appear
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector("a[href='/logout']")
        ));
    }

    @When("I navigate to the Edit Account page")
    public void navigate_to_edit_account() {
        // First go to account page
        driver.get("https://demowebshop.tricentis.com/customer/info");

        accountPage = new AccountPage(driver);
        // Wait for edit account link to be clickable
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(accountPage.editAccountLink));

        accountPage.navigateToEditAccount();
    }
    @When("I update first name to {string}, last name to {string}, and email to {string}")
    public void update_account_info(String firstName, String lastName, String email) {
        accountPage.updateAccountInfo(firstName, lastName, email);
    }

    @When("I click Save")
    public void click_save() {
        accountPage.clickSave();
    }

    @Then("I should see a success message")
    public void verify_success_message() {
        Assert.assertTrue(accountPage.isSuccessDisplayed());
    }

    @Then("the changes should be reflected on the account page")
    public void verify_changes_persisted() {

    }
    @AfterStep
    public void afterStep(Scenario scenario) {
        if (scenario.isFailed()) {
            // Take screenshot on failure
            byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "failure_screenshot");

            // Log current URL and page title
            System.out.println("FAILED STEP DEBUG:");
            System.out.println("Current URL: " + driver.getCurrentUrl());
            System.out.println("Page title: " + driver.getTitle());
        }
    }
}