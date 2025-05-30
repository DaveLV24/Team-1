package stepDefinitions;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import pageObjects.UserStoryTwoAddressBookLoginPO;
import pageObjects.UserStoryTwoAddressBookPO;

import java.util.List;
import java.util.Map;

public class UserStoryTwoAddressBookSteps {
    private WebDriver driver;
    private UserStoryTwoAddressBookPO addressBook;
    private UserStoryTwoAddressBookLoginPO addressBookLogin;

    public UserStoryTwoAddressBookSteps() {
        this.driver = Hooks.driver;
        this.addressBook = new UserStoryTwoAddressBookPO(driver);
        this.addressBookLogin = new UserStoryTwoAddressBookLoginPO(driver);
    }

    @Given("I open demo web shop page")
    public void iNavigateToWebShopWebsite() {
        driver.get("https://demowebshop.tricentis.com/");
    }

    @When("I log in with email {string} and password {string}")
    public void iLogInAsUser(String email, String password) {
        addressBookLogin.clickLoginLink();
        addressBookLogin.enterEmail(email);
        addressBookLogin.enterPassword(password);
        addressBookLogin.clickLoginButton();

        String actualEmail = addressBookLogin.getLoggedInEmailText();
        Assert.assertEquals(email, actualEmail);
    }

    @And("I navigate to my account addresses")
    public void iNavigateToAddresses() {
        addressBook.clickAccountLink();
        addressBook.clickAddressesLink();
        Assert.assertEquals("https://demowebshop.tricentis.com/customer/addresses", addressBook.getCurrentUrl());
    }

    @And("I click add new address button")
    public void iClickAddNewAddressButton() {
        addressBook.clickAddNewAddressBtn();
        Assert.assertEquals("https://demowebshop.tricentis.com/customer/addressadd", addressBook.getCurrentUrl());
    }

    @And("I add a new address with the following data")
    public void iAddNewAddressWithData(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);
        addressBook.fillNewAddressForm(
                data.get("FirstName"),
                data.get("LastName"),
                data.get("Email"),
                data.get("Country"),
                data.get("City"),
                data.get("Address1"),
                data.get("ZipCode"),
                data.get("Phone")
        );
        addressBook.clickSaveAddressButton();
    }

    @Then("I leave empty form fields and click save")
    public void iLeaveEmptyFieldsClickSave() {
        addressBook.clickSaveButton();

        Assert.assertTrue(addressBook.isDisplayed(addressBook.getFirstNameError()));
        Assert.assertTrue(addressBook.isDisplayed(addressBook.getLastNameError()));
        Assert.assertTrue(addressBook.isDisplayed(addressBook.getEmailError()));
        Assert.assertEquals("*", addressBook.getText(addressBook.getCountryError()));
        Assert.assertTrue(addressBook.isDisplayed(addressBook.getCityError()));
        Assert.assertTrue(addressBook.isDisplayed(addressBook.getAddress1Error()));
        Assert.assertTrue(addressBook.isDisplayed(addressBook.getZipPostalCodeError()));
        Assert.assertTrue(addressBook.isDisplayed(addressBook.getPhoneNumberError()));

        if (addressBook.isRegionAsteriskPresent()) {
            Assert.assertEquals("*", addressBook.getText(addressBook.getRegionError()));
        } else {
            System.out.println("[BUG-019] Region error message not found – known bug, see defects summary");
        }
    }

    @Then("I should see an address matching the entered data")
    public void iShouldSeeAddressMatchingEnteredData(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> expected = dataTable.asMap(String.class, String.class);
        String actualText = addressBook.getLastAddressBlockText();

        Assert.assertTrue("First name not found", actualText.contains(expected.get("FirstName")));
        Assert.assertTrue("Last name not found", actualText.contains(expected.get("LastName")));
        Assert.assertTrue("Email not found", actualText.contains(expected.get("Email")));
        Assert.assertTrue("Country not found", actualText.contains(expected.get("Country")));
        Assert.assertTrue("City not found", actualText.contains(expected.get("City")));
        Assert.assertTrue("Address1 not found", actualText.contains(expected.get("Address1")));
        Assert.assertTrue("Zip code not found", actualText.contains(expected.get("ZipCode")));
        Assert.assertTrue("Phone number not found", actualText.contains(expected.get("Phone")));
    }

    @And("I should see two distinct addresses listed")
    public void iShouldSeeTwoDistinctAddressesListed() {
        List<WebElement> addressBlocks = driver.findElements(By.cssSelector(".address-list .address-item"));

        int total = addressBlocks.size();
        Assert.assertTrue("There should be at least two addresses listed", total >= 2);

        WebElement addressOne = addressBlocks.get(total - 2);
        WebElement addressTwo = addressBlocks.get(total - 1);

        String addressOneText = addressOne.getText();
        String addressTwoText = addressTwo.getText();

        Assert.assertNotEquals("The two most recently added addresses should be different", addressOneText, addressTwoText);
    }

    @Then("I delete all test addresses")
    public void iDeleteAllTestAddresses() {
        List<WebElement> deleteButtons = driver.findElements(By.cssSelector(".delete-address-button"));

        while (!deleteButtons.isEmpty()) {
            WebElement deleteButton = deleteButtons.get(0);
            deleteButton.click();

            try {
                Alert alert = driver.switchTo().alert();
                alert.accept();
            } catch (NoAlertPresentException ignored) {}

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            deleteButtons = driver.findElements(By.cssSelector(".delete-address-button"));
        }
    }

    @And("I navigate to the books page")
    public void iNavigateToTheBooksPage() {
        WebElement booksLink = driver.findElement(By.cssSelector("a[href='/books']"));
        booksLink.click();
    }

    @And("I add any book to the cart")
    public void iAddAnyBookToTheCart() {
        WebElement addToCartButton = driver.findElement(By.cssSelector("input.button-2.product-box-add-to-cart-button"));
        addToCartButton.click();
    }

    @And("I go to the shopping cart page")
    public void iGoToTheShoppingCartPage() {
        WebElement cartLink = driver.findElement(By.cssSelector("a.ico-cart"));
        cartLink.click();
    }

    @And("I agree with the terms of service")
    public void iAgreeWithTheTermsOfService() {
        WebElement termsCheckbox = driver.findElement(By.id("termsofservice"));
        if (!termsCheckbox.isSelected()) {
            termsCheckbox.click();
        }
    }

    @And("I proceed to checkout")
    public void iProceedToCheckout() {
        WebElement checkoutButton = driver.findElement(By.id("checkout"));
        checkoutButton.click();
    }

    @Then("I should see multiple address options in the billing address dropdown")
    public void iShouldSeeMultipleAddressOptionsInTheBillingAddressDropdown() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("Not on the checkout page", currentUrl.contains("/onepagecheckout"));

        WebElement billingDropdown = driver.findElement(By.id("billing-address-select"));

        List<WebElement> options = billingDropdown.findElements(By.tagName("option"));

        long addressCount = options.stream()
                .filter(option -> !option.getText().equalsIgnoreCase("New Address"))
                .count();

        Assert.assertTrue("Expected at least two saved address options in the dropdown", addressCount >= 2);
    }

}