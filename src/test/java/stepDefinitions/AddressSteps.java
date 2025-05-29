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
        testAddress.put("firstName", "John");
        testAddress.put("lastName", "Doe");
        testAddress.put("email", "john.doe@example.com");
        testAddress.put("company", "Test Company");
        testAddress.put("country", "United States");
        testAddress.put("state", "California");
        testAddress.put("city", "San Francisco");
        testAddress.put("address1", "123 Main St");
        testAddress.put("address2", "Apt 4B");
        testAddress.put("zip", "94105");
        testAddress.put("phone", "555-123-4567");
        testAddress.put("fax", "555-987-6543");

        addressesPage.fillAddressForm(testAddress);
    }

    @When("I click Save button")
    public void click_save() {
        addressesPage.saveAddress();
    }
}
