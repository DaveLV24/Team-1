package stepDefinitions;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CustomerInfoPage;
import pageObjects.LoginPage;
import pageObjects.MainPage;

import java.util.Map;

import static org.junit.Assert.*;

public class MyAccountSteps {
    private WebDriver driver;
    private static CustomerInfoPage  customerInfoPage;
    private static LoginPage loginPage;
    private static MainPage mainPage;

    public MyAccountSteps() {
        this.driver = Hooks.driver;
        mainPage = PageFactory.initElements(driver, MainPage.class);
        customerInfoPage = PageFactory.initElements(driver, CustomerInfoPage.class);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
    }

    @Given("^I am on Demo Web Shop page$")
    public void iAmOnDemoWebShopPage() {
        driver.get(mainPage.getPageUrl());
    }

    @When("^I click login header button$")
    public void iClickLoginHeaderButton() {
        mainPage.clickLoginHeaderButton();
    }

    @When("^I enter login details:$")
    public void iEnterLoginDetails(Map<String, String> table) {
        loginPage.enterEmail(table.get("email"));
        loginPage.enterPassword(table.get("password"));
    }

    @When("^I click login button$")
    public void iClickLoginBtn() {
        loginPage.clickLoginBtn();
    }

    @When("^I click on my email in the header$")
    public void iClickOnMyEmailInTheHeader() {
        assertTrue("Should be in Demo Web Shop page", driver.getCurrentUrl().contains(mainPage.getPageUrl()));
        mainPage.clickCustomerInfoHeaderButton();
    }

    @When("^I am redirected to My Account page$")
    public void iAmRedirectedToMyAccountPage() {
        assertEquals(customerInfoPage.getPageUrl(), driver.getCurrentUrl());
    }

    @Then("^I see My Account menu label$")
    public void iSeeMyAccountMenuLabel() {
        assertEquals("MY ACCOUNT", customerInfoPage.getMyAccountTitle().getText());
    }

    @Then("^I see Customer info menu label$")
    public void iSeeCustomerInfoMenuLabel() {
        assertEquals("Customer info", customerInfoPage.getCustomerInfoSubMenu().getText());
    }

    @Then("^I see Orders menu label$")
    public void iSeeOrdersMenuLabel() {
        assertEquals("Orders", customerInfoPage.getOrdersSubMenu().getText());
    }

    @Then("^I see Downloadable products menu label$")
    public void iSeeDownloadableProductsMenuLabel() {
        assertEquals("Downloadable products", customerInfoPage.getDownloadableProductsSubMenu().getText());
    }

    @Then("^I see Reward points menu label$")
    public void iSeeRewardPointsMenuLabel() {
        assertEquals("Reward points", customerInfoPage.getRewardPointsSubMenu().getText());
    }

    @Then("^I see Change password menu label$")
    public void iSeeChangePasswordMenuLabel() {
        assertEquals("Change password", customerInfoPage.getChangePasswordSubMenu().getText());
    }
}
