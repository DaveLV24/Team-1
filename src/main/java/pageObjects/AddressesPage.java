package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Map;

public class AddressesPage {
    WebDriver driver;
    WebDriverWait wait;

    // Locators
    By addNewButton = By.xpath("//input[@value='Add new']");
    By firstNameInput = By.id("Address_FirstName");
    By lastNameInput = By.id("Address_LastName");
    By emailInput = By.id("Address_Email");
    By companyInput = By.id("Address_Company");
    By countryDropdown = By.id("Address_CountryId");
    By stateInput = By.id("Address_StateProvinceId");
    By cityInput = By.id("Address_City");
    By address1Input = By.id("Address_Address1");
    By address2Input = By.id("Address_Address2");
    By zipInput = By.id("Address_ZipPostalCode");
    By phoneInput = By.id("Address_PhoneNumber");
    By faxInput = By.id("Address_FaxNumber");
    By saveButton = By.xpath("//input[@value='Save']");
    By successMessage = By.cssSelector("div.bar-notification.success");

    public AddressesPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void navigateToAddressesPage() {
        driver.get("https://demowebshop.tricentis.com/customer/addresses");
    }

    public void clickAddNew() {
        wait.until(ExpectedConditions.elementToBeClickable(addNewButton)).click();
    }

    public void fillAddressForm(Map<String, String> addressData) {
        driver.findElement(firstNameInput).sendKeys(addressData.get("firstName"));
        driver.findElement(lastNameInput).sendKeys(addressData.get("lastName"));
        driver.findElement(emailInput).sendKeys(addressData.get("email"));
        driver.findElement(companyInput).sendKeys(addressData.get("company"));

        new Select(driver.findElement(countryDropdown))
                .selectByVisibleText(addressData.get("country"));

        if (addressData.containsKey("state")) {
            new Select(driver.findElement(stateInput))
                    .selectByVisibleText(addressData.get("state"));
        }

        driver.findElement(cityInput).sendKeys(addressData.get("city"));
        driver.findElement(address1Input).sendKeys(addressData.get("address1"));
        driver.findElement(address2Input).sendKeys(addressData.get("address2"));
        driver.findElement(zipInput).sendKeys(addressData.get("zip"));
        driver.findElement(phoneInput).sendKeys(addressData.get("phone"));
        driver.findElement(faxInput).sendKeys(addressData.get("fax"));
    }

    public void saveAddress() {
        driver.findElement(saveButton).click();
    }

    public boolean isSuccessMessageDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage)).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }
}
