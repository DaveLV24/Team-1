package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class UserStoryTwoAddressBookPO {
    WebDriver driver;

    private final By accountLink = By.cssSelector("a.account");
    private final By addressesLink = By.cssSelector("a[href='/customer/addresses']");
    private final By addNewAddressBtn = By.cssSelector("input.button-1.add-address-button");
    private final By saveButton = By.cssSelector("input.button-1.save-address-button");
    private final By firstNameError = By.cssSelector("span[for='Address_FirstName']");
    private final By lastNameError = By.cssSelector("span[for='Address_LastName']");
    private final By emailError = By.cssSelector("span[for='Address_Email']");
    private final By countryAsterisk = By.xpath("//label[@for='Address_CountryId']/following-sibling::span[@class='required']");
    private final By cityError = By.cssSelector("span[for='Address_City']");
    private final By address1Error = By.cssSelector("span[for='Address_Address1']");
    private final By zipPostalCodeError = By.cssSelector("span[for='Address_ZipPostalCode']");
    private final By phoneNumberError = By.cssSelector("span[for='Address_PhoneNumber']");
    private final By regionError = By.xpath("//label[@for='Address_StateProvinceId']/following-sibling::span[@class='required']");

    public UserStoryTwoAddressBookPO(WebDriver driver) {
        this.driver = driver;
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void clickAccountLink() {
        driver.findElement(accountLink).click();
    }

    public void clickAddressesLink() {
        driver.findElement(addressesLink).click();
    }

    public void clickAddNewAddressBtn() {
        driver.findElement(addNewAddressBtn).click();
    }

    public void clickSaveButton() {
        driver.findElement(saveButton).click();
    }

    public boolean isDisplayed(By locator) {
        return driver.findElement(locator).isDisplayed();
    }

    public String getText(By locator) {
        return driver.findElement(locator).getText();
    }

    public boolean isRegionAsteriskPresent() {
        try {
            return driver.findElement(regionError).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public By getFirstNameError() { return firstNameError; }
    public By getLastNameError() { return lastNameError; }
    public By getEmailError() { return emailError; }
    public By getCountryError() { return countryAsterisk; }
    public By getCityError() { return cityError; }
    public By getAddress1Error() { return address1Error; }
    public By getZipPostalCodeError() { return zipPostalCodeError; }
    public By getPhoneNumberError() { return phoneNumberError; }
    public By getRegionError() { return regionError; }

    public void fillNewAddressForm(String firstName, String lastName, String email, String country, String city, String address1, String zip, String phone) {
        driver.findElement(By.id("Address_FirstName")).clear();
        driver.findElement(By.id("Address_FirstName")).sendKeys(firstName);

        driver.findElement(By.id("Address_LastName")).clear();
        driver.findElement(By.id("Address_LastName")).sendKeys(lastName);

        driver.findElement(By.id("Address_Email")).clear();
        driver.findElement(By.id("Address_Email")).sendKeys(email);

        WebElement countryDropdown = driver.findElement(By.id("Address_CountryId"));
        new org.openqa.selenium.support.ui.Select(countryDropdown).selectByVisibleText(country);

        driver.findElement(By.id("Address_City")).clear();
        driver.findElement(By.id("Address_City")).sendKeys(city);

        driver.findElement(By.id("Address_Address1")).clear();
        driver.findElement(By.id("Address_Address1")).sendKeys(address1);

        driver.findElement(By.id("Address_ZipPostalCode")).clear();
        driver.findElement(By.id("Address_ZipPostalCode")).sendKeys(zip);

        driver.findElement(By.id("Address_PhoneNumber")).clear();
        driver.findElement(By.id("Address_PhoneNumber")).sendKeys(phone);
    }

    public void clickSaveAddressButton() {
        driver.findElement(By.cssSelector("input.button-1.save-address-button")).click();
    }

    public String getLastAddressBlockText() {
        List<WebElement> addressBlocks = driver.findElements(By.cssSelector("div.address-list div.section"));
        if (addressBlocks.isEmpty()) {
            return "";
        }
        return addressBlocks.get(addressBlocks.size() - 1).getText();
    }

}
