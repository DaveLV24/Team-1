package stepDefinitions;

import hooks.Hooks;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObjects.AddressesPage_AA;

import java.util.HashMap;
import java.util.Map;

public class AddressSteps_AA {
    WebDriver driver = Hooks.driver;
    AddressesPage_AA addressesPageAA;
    Map<String, String> testAddress;

    @When("I navigate to Addresses page")
    public void navigate_to_addresses_page() {
        addressesPageAA = new AddressesPage_AA(driver);
        addressesPageAA.navigateToAddressesPage();
    }

    @When("I click Add New button")
    public void click_add_new() {
        addressesPageAA.clickAddNew();
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

        addressesPageAA.fillAddressForm(testAddress);
    }

    @When("I click Save button")
    public void click_save() {
        addressesPageAA.saveAddress();
    }
}
