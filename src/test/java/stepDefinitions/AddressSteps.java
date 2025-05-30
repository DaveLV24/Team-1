package stepDefinitions;

import hooks.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageObjects.AddressesPage;

import java.util.HashMap;
import java.util.Map;

public class AddressSteps {
    WebDriver driver = Hooks.driver;
    AddressesPage addressesPage;
    Map<String, String> testAddress;

    @When("I navigate to Addresses page")
    public void navigate_to_addresses_page() {
        addressesPage = new AddressesPage(driver);
        addressesPage.navigateToAddressesPage();
    }

    @When("I click Add New button")
    public void click_add_new() {
        addressesPage.clickAddNew();
    }

    @When("I fill in all required address fields")
    public void fill_address_form() {
        testAddress = new HashMap<>();
        testAddress.put("firstName", "Alex");
        testAddress.put("lastName", "Andreyev");
        testAddress.put("email", "ndryev@test.com");
        testAddress.put("company", "Test Company");
        testAddress.put("country", "Latvia");
        testAddress.put("state", "Other (Non US)");
        testAddress.put("city", "Riga");
        testAddress.put("address1", "123 Iela");
        testAddress.put("address2", "Vd 2-k-1");
        testAddress.put("zip", "1084");
        testAddress.put("phone", "123-456-789");
        testAddress.put("fax", "123-456-789");

        addressesPage.fillAddressForm(testAddress);
    }

    @When("I click Save button")
    public void click_save() {
        addressesPage.saveAddress();
    }
}
