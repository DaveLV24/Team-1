package stepDefinitions;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.CustomerInfoPageBB;
import pageObjects.LoginPageBB;
import pageObjects.MainPageBB;

import java.util.Map;

import static org.junit.Assert.*;

public class MyAccountStepsBB {
    private WebDriver driver;
    private static CustomerInfoPageBB customerInfoPage;
    private static LoginPageBB loginPage;
    private static MainPageBB mainPage;

    public MyAccountStepsBB() {
        this.driver = Hooks.driver;
        mainPage = PageFactory.initElements(driver, MainPageBB.class);
        customerInfoPage = PageFactory.initElements(driver, CustomerInfoPageBB.class);
        loginPage = PageFactory.initElements(driver, LoginPageBB.class);
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

    @Then("^I see Wishlist option in the header$")
    public void iSeeWishlistOptionInTheHeader() {
        assertTrue(mainPage.getWishlistHeaderButton().isDisplayed());
        assertTrue(mainPage.getWishlistHeaderButton().getText().contains("Wishlist"));
    }

    @Then("^I see Log out option in the header$")
    public void iSeeLogOutOptionInTheHeader() {
        assertTrue(mainPage.getLogoutHeaderButton().isDisplayed());
        assertEquals("Log out", mainPage.getLogoutHeaderButton().getText());
    }

    @Then("^I see News and Blog options in the footer$")
    public void iSeeNewsAndBlogOptionsInTheFooter() {
        assertTrue(mainPage.getNewsFooterButton().isDisplayed());
        assertEquals("News", mainPage.getNewsFooterButton().getText());
        assertTrue(mainPage.getBlogFooterButton().isDisplayed());
        assertEquals("Blog", mainPage.getBlogFooterButton().getText());
    }

    @When("^I click on Customers info menu option$")
    public void iClickOnCustomersInfoMenuOption() {
        customerInfoPage.clickCustomerInfoSubMenu();
    }

    @Then("^I can see \"([^\"]*)\" displayed in first name input field$")
    public void iCanSeeFirstNameDisplayedInInputField(String firstName) {
        assertTrue(customerInfoPage.getFirstNameInput().isDisplayed());
        assertFalse(customerInfoPage.getFirstNameInput().getDomAttribute("value").isEmpty());
        assertEquals(firstName, customerInfoPage.getFirstNameInput().getDomAttribute("value"));
    }

    @Then("^I can see \"([^\"]*)\" displayed in last name input field$")
    public void iCanSeeLastNameDisplayedInInputField(String lastName) {
        assertTrue(customerInfoPage.getLastNameInput().isDisplayed());
        assertFalse(customerInfoPage.getLastNameInput().getDomAttribute("value").isEmpty());
        assertEquals(lastName, customerInfoPage.getLastNameInput().getDomAttribute("value"));
    }

    @Then("^I can see \"([^\"]*)\" displayed in email input field$")
    public void iCanSeeEmailDisplayedInInputField(String email) {
        assertTrue(customerInfoPage.getEmailInput().isDisplayed());
        assertFalse(customerInfoPage.getEmailInput().getDomAttribute("value").isEmpty());
        assertEquals(email, customerInfoPage.getEmailInput().getDomAttribute("value"));
    }

    @Then("^I see error login error message: \"([^\"]*)\"$")
    public void iSeeErrorLoginErrorMessage(String errorMessage) {
        String actualMessage = loginPage.getErrorMessage().replaceAll("\\s+", " ").trim();
        String expectedMessage = errorMessage.replaceAll("\\s+", " ").trim();
        assertEquals(expectedMessage, actualMessage);
    }
}
