package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPageBB {
    @FindBy (how = How.ID, using = "Email")
    private WebElement emailInput;
    @FindBy (how = How.ID, using = "Password")
    private WebElement passwordInput;
    @FindBy (how = How.CLASS_NAME, using = "login-button")
    private WebElement loginButton;
    @FindBy (how = How.CLASS_NAME, using = "validation-summary-errors")
    private WebElement validationError;

    public void enterEmail(String email) {
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void clickLoginBtn() {
        loginButton.click();
    }

    public String getErrorMessage() {
        return validationError.getText();
    }
}
