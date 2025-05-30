package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegisterPageBB {
    @FindBy (how = How.ID, using = "FirstName")
    private WebElement firstNameInput;
    @FindBy (how = How.ID, using = "LastName")
    private WebElement lastNameInput;
    @FindBy (how = How.ID, using = "Email")
    private WebElement emailInput;
    @FindBy (how = How.ID, using = "Password")
    private WebElement passwordInput;
    @FindBy (how = How.ID, using = "ConfirmPassword")
    private WebElement confirmPasswordInput;
    @FindBy (how = How.ID, using = "register-button")
    private WebElement registerButton;
    @FindBy (how = How.CLASS_NAME, using = "field-validation-error")
    private WebElement validationError;
    @FindBy (how = How.CLASS_NAME, using = "field-validation-valid")
    private WebElement validationSuccess;

    @FindBy (how = How.CLASS_NAME, using = "result")
    private WebElement registerSuccess;

    public void enterFirstName(String firstName) {
        firstNameInput.clear();
        firstNameInput.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameInput.clear();
        lastNameInput.sendKeys(lastName);
    }

    public void enterEmail(String email) {
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        confirmPasswordInput.clear();
        confirmPasswordInput.sendKeys(confirmPassword);
    }

    public void clickRegisterBtn() {
        registerButton.click();
    }

    public String getErrorMessage() {
        return validationError.getText();
    }

    public WebElement getValidationSuccess() {
        return validationSuccess;
    }

    public WebElement getRegisterSuccess() {
        return registerSuccess;
    }
}
